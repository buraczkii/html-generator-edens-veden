/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.blackbox;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import neu.ccs.edu.cs5004.seattle.assignment8.InvalidFileTypeException;
import neu.ccs.edu.cs5004.seattle.assignment8.MyProcessor;
import neu.ccs.edu.cs5004.seattle.assignment8.TextProcessor;

/**
 * @author joshuaveden
 *
 */
public class TextProcessorTest {

  Path doesNotExist;
  Path invalidFileType;
  TextProcessor tp;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    this.doesNotExist = Paths.get("doesNotExists.txt");

    this.invalidFileType = Paths.get("invalidFileType.doc");
    Files.createFile(this.invalidFileType);

    this.tp = MyProcessor.getInstance();
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
    Files.delete(this.invalidFileType);
  }

  @Test
  public void formatTest() {
    // TODO: Implement me
    // Assert.fail("Not yet implemented");
  }

  @Test(expected = InvalidFileTypeException.class)
  public void invalidFileTypeToHtmlTest()
      throws InvalidFileTypeException, FileNotFoundException, IOException {
    this.tp.toHtml(this.invalidFileType);
  }

  @Test(expected = FileNotFoundException.class)
  public void fileNotFoundToHtmlTest()
      throws InvalidFileTypeException, FileNotFoundException, IOException {
    this.tp.toHtml(this.doesNotExist);
  }

  @Test
  public void toHtmlTest() {
    // TODO: Implement me
    // Assert.fail("Not yet implemented");
  }

  @Test
  public void equalsTest() {
    // Duplicate TextProcessores
    TextProcessor tp1 = MyProcessor.getInstance();
    TextProcessor tp2 = MyProcessor.getInstance();
    TextProcessor tp3 = MyProcessor.getInstance();
    TextProcessor tp4 = tp3;

    // Reflexive
    Assert.assertTrue(tp1.equals(tp1));
    // Symmetric
    Assert.assertTrue(tp1.equals(tp2) && tp2.equals(tp1));
    // Transitive
    Assert.assertTrue(tp1.equals(tp2) && tp2.equals(tp3) && tp1.equals(tp3));
    // Consistent
    Assert.assertTrue(tp1.equals(tp2) && tp1.equals(tp2));

    // Null equality
    Assert.assertFalse(tp1.equals(null));
    // Same reference
    Assert.assertTrue(tp4.equals(tp3));
    // Different class
    Assert.assertFalse(tp1.equals("foo"));
  }

  @Test
  public void hashCodeTest() {
    TextProcessor tp1 = MyProcessor.getInstance();
    TextProcessor tp2 = MyProcessor.getInstance();
    // Consistent
    Assert.assertEquals(tp1.hashCode(), tp1.hashCode());
    // Equals corollary
    Assert.assertTrue(tp1.equals(tp2) && (tp1.hashCode() == tp2.hashCode()));
  }

}
