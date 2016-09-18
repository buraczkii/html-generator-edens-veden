/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.glassbox;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import neu.ccs.edu.cs5004.seattle.assignment8.MyValidator;

/**
 * @author joshuaveden
 *
 */
public class MyValidatorTest {

  MyValidator mv;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    this.mv = MyValidator.getInstance();
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {}

  @Test
  public void equalsTest() {
    // Duplicate MyValidatores
    MyValidator mv1 = MyValidator.getInstance();
    MyValidator mv2 = MyValidator.getInstance();
    MyValidator mv3 = MyValidator.getInstance();
    MyValidator mv4 = mv3;

    // Reflexive
    Assert.assertTrue(mv1.equals(mv1));
    // Symmetric
    Assert.assertTrue(mv1.equals(mv2) && mv2.equals(mv1));
    // Transitive
    Assert.assertTrue(mv1.equals(mv2) && mv2.equals(mv3) && mv1.equals(mv3));
    // Consistent
    Assert.assertTrue(mv1.equals(mv2) && mv1.equals(mv2));

    // Null equality
    Assert.assertFalse(mv1.equals(null));
    // Same reference
    Assert.assertTrue(mv4.equals(mv3));
    // Different class
    Assert.assertFalse(mv1.equals("foo"));
  }

  @Test
  public void hashCodeTest() {
    MyValidator mv1 = MyValidator.getInstance();
    MyValidator mv2 = MyValidator.getInstance();
    // Consistent
    Assert.assertEquals(mv1.hashCode(), mv1.hashCode());
    // Equals corollary
    Assert.assertTrue(mv1.equals(mv2) && (mv1.hashCode() == mv2.hashCode()));
  }

  @Test
  public void fileExistsTest() throws IOException {
    // Current working directory test
    Path file = Paths.get("foo.txt");
    Assert.assertFalse(this.mv.fileExists(file));
    Files.createFile(file);
    Assert.assertTrue(this.mv.fileExists(file));
    Files.delete(file);

    // Relative path tests
    Path dir = Paths.get("foo");
    file = Paths.get("foo/bar.txt");
    Assert.assertFalse(this.mv.fileExists(file));
    Files.createDirectories(dir);
    Files.createFile(file);
    Assert.assertTrue(this.mv.fileExists(file));
    Files.delete(file);
    Files.delete(dir);
  }

  @Test
  public void validFileTypeTest() {
    // Current working directory test
    Path validFile = Paths.get("foo.txt");
    Path invalidFile = Paths.get("foo.doc");

    Assert.assertFalse(this.mv.validFileType(invalidFile));
    Assert.assertTrue(this.mv.validFileType(validFile));

    // Relative path tests
    validFile = Paths.get("foo/bar.txt");
    invalidFile = Paths.get("foo/bar.doc");

    Assert.assertFalse(this.mv.validFileType(invalidFile));
    Assert.assertTrue(this.mv.validFileType(validFile));

    // Absolute path tests
    validFile = Paths.get("/foo/bar.txt");
    invalidFile = Paths.get("/foo/bar.doc");

    Assert.assertFalse(this.mv.validFileType(invalidFile));
    Assert.assertTrue(this.mv.validFileType(validFile));
  }

}
