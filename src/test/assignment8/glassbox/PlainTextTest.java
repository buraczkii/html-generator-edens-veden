/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.glassbox;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.PlainText;

/**
 * @author joshuaveden
 *
 */
public class PlainTextTest {

  PlainText ct;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    this.ct = new PlainText("plain text");
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {}

  @Test
  public void getValTest() {
    Assert.assertEquals("plain text", this.ct.getVal());
  }

  @Test
  public void equalsTest() {
    // Duplicate PlainTextes
    PlainText pt1 = new PlainText("plain text");
    PlainText pt2 = new PlainText("plain text");
    PlainText pt3 = new PlainText("plain text");
    PlainText pt4 = pt3;
    PlainText nullPlainText = new PlainText(null);
    PlainText anotherNullPlainText = new PlainText(null);

    // Reflexive
    Assert.assertTrue(pt1.equals(pt1));
    // Symmetric
    Assert.assertTrue(pt1.equals(pt2) && pt2.equals(pt1));
    // Transitive
    Assert.assertTrue(pt1.equals(pt2) && pt2.equals(pt3) && pt1.equals(pt3));
    // Consistent
    Assert.assertTrue(pt1.equals(pt2) && pt1.equals(pt2));

    // Null equality
    Assert.assertFalse(pt1.equals(null));
    // Null Address Test
    Assert.assertFalse(pt1.equals(nullPlainText));
    Assert.assertFalse(nullPlainText.equals(pt1));
    Assert.assertTrue(nullPlainText.equals(anotherNullPlainText));
    // Same reference
    Assert.assertTrue(pt4.equals(pt3));
    // Different class
    Assert.assertFalse(pt1.equals("foo"));
  }

  @Test
  public void hashCodeTest() {
    PlainText pt1 = new PlainText("plain text");
    PlainText pt2 = new PlainText("plain text");
    PlainText pt3 = new PlainText(null);
    // Consistent
    Assert.assertEquals(pt1.hashCode(), pt1.hashCode());
    Assert.assertEquals(pt3.hashCode(), pt3.hashCode());
    // Equals corollary
    Assert.assertTrue(pt1.equals(pt2) && (pt1.hashCode() == pt2.hashCode()));
  }
}
