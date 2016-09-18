package neu.ccs.edu.cs5004.seattle.assignment8.glassbox;

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

/**
 * @author joshuaveden
 *
 */
public class MyProcessorTest {
  Path doesNotExist;
  Path invalidFileType;
  MyProcessor mp;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    this.doesNotExist = Paths.get("doesNotExists.txt");

    this.invalidFileType = Paths.get("invalidFileType.doc");
    Files.createFile(this.invalidFileType);

    this.mp = MyProcessor.getInstance();
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
    this.mp.toHtml(this.invalidFileType);
  }

  @Test(expected = FileNotFoundException.class)
  public void fileNotFoundToHtmlTest()
      throws InvalidFileTypeException, FileNotFoundException, IOException {
    this.mp.toHtml(this.doesNotExist);
  }

  @Test
  public void toHtmlTest() {
    // TODO: Implement me
    // Assert.fail("Not yet implemented");
  }

  @Test
  public void equalsTest() {
    // Duplicate MyProcessores
    MyProcessor mp1 = MyProcessor.getInstance();
    MyProcessor mp2 = MyProcessor.getInstance();
    MyProcessor mp3 = MyProcessor.getInstance();
    MyProcessor mp4 = mp3;

    // Reflexive
    Assert.assertTrue(mp1.equals(mp1));
    // Symmetric
    Assert.assertTrue(mp1.equals(mp2) && mp2.equals(mp1));
    // Transitive
    Assert.assertTrue(mp1.equals(mp2) && mp2.equals(mp3) && mp1.equals(mp3));
    // Consistent
    Assert.assertTrue(mp1.equals(mp2) && mp1.equals(mp2));

    // Null equality
    Assert.assertFalse(mp1.equals(null));
    // Same reference
    Assert.assertTrue(mp4.equals(mp3));
    // Different class
    Assert.assertFalse(mp1.equals("foo"));
  }

  @Test
  public void hashCodeTest() {
    MyProcessor mp1 = MyProcessor.getInstance();
    MyProcessor mp2 = MyProcessor.getInstance();
    // Consistent
    Assert.assertEquals(mp1.hashCode(), mp1.hashCode());
    // Equals corollary
    Assert.assertTrue(mp1.equals(mp2) && (mp1.hashCode() == mp2.hashCode()));
  }

}
