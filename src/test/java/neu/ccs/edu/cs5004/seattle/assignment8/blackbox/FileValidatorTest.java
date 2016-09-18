package neu.ccs.edu.cs5004.seattle.assignment8.blackbox;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import neu.ccs.edu.cs5004.seattle.assignment8.FileValidator;
import neu.ccs.edu.cs5004.seattle.assignment8.MyValidator;

/**
 * @author joshuaveden
 *
 */
public class FileValidatorTest {
  FileValidator fv;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    this.fv = MyValidator.getInstance();
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {}

  @Test
  public void equalsTest() {
    // Duplicate FileValidatores
    FileValidator fv1 = MyValidator.getInstance();
    FileValidator fv2 = MyValidator.getInstance();
    FileValidator fv3 = MyValidator.getInstance();
    FileValidator fv4 = fv3;

    // Reflexive
    Assert.assertTrue(fv1.equals(fv1));
    // Symmetric
    Assert.assertTrue(fv1.equals(fv2) && fv2.equals(fv1));
    // Transitive
    Assert.assertTrue(fv1.equals(fv2) && fv2.equals(fv3) && fv1.equals(fv3));
    // Consistent
    Assert.assertTrue(fv1.equals(fv2) && fv1.equals(fv2));

    // Null equality
    Assert.assertFalse(fv1.equals(null));
    // Same reference
    Assert.assertTrue(fv4.equals(fv3));
    // Different class
    Assert.assertFalse(fv1.equals("foo"));
  }

  @Test
  public void hashCodeTest() {
    FileValidator fv1 = MyValidator.getInstance();
    FileValidator fv2 = MyValidator.getInstance();
    // Consistent
    Assert.assertEquals(fv1.hashCode(), fv1.hashCode());
    // Equals corollary
    Assert.assertTrue(fv1.equals(fv2) && (fv1.hashCode() == fv2.hashCode()));
  }

  @Test
  public void fileExistsTest() throws IOException {
    // Current working directory test
    Path file = Paths.get("foo.txt");
    Assert.assertFalse(this.fv.fileExists(file));
    Files.createFile(file);
    Assert.assertTrue(this.fv.fileExists(file));
    Files.delete(file);

    // Relative path tests
    Path dir = Paths.get("foo");
    file = Paths.get("foo/bar.txt");
    Assert.assertFalse(this.fv.fileExists(file));
    Files.createDirectories(dir);
    Files.createFile(file);
    Assert.assertTrue(this.fv.fileExists(file));
    Files.delete(file);
    Files.delete(dir);
  }

  @Test
  public void validFileTypeTest() {
    // Current working directory test
    Path validFile = Paths.get("foo.txt");
    Path invalidFile = Paths.get("foo.doc");

    Assert.assertFalse(this.fv.validFileType(invalidFile));
    Assert.assertTrue(this.fv.validFileType(validFile));

    // Relative path tests
    validFile = Paths.get("foo/bar.txt");
    invalidFile = Paths.get("foo/bar.doc");

    Assert.assertFalse(this.fv.validFileType(invalidFile));
    Assert.assertTrue(this.fv.validFileType(validFile));

    // Absolute path tests
    validFile = Paths.get("/foo/bar.txt");
    invalidFile = Paths.get("/foo/bar.doc");

    Assert.assertFalse(this.fv.validFileType(invalidFile));
    Assert.assertTrue(this.fv.validFileType(validFile));
  }

}
