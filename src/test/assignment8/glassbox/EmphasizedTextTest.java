/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.glassbox;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.EmphasizedText;

/**
 * @author joshuaveden
 *
 */
public class EmphasizedTextTest {

  EmphasizedText et;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    this.et = new EmphasizedText("emphasized text");
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {}

  @Test
  public void getValTest() {
    Assert.assertEquals("emphasized text", this.et.getVal());
  }

  @Test
  public void equalsTest() {
    // Duplicate EmphasizedTextes
    EmphasizedText et1 = new EmphasizedText("emphasized text");
    EmphasizedText et2 = new EmphasizedText("emphasized text");
    EmphasizedText et3 = new EmphasizedText("emphasized text");
    EmphasizedText et4 = et3;
    EmphasizedText nullEmphasizedText = new EmphasizedText(null);
    EmphasizedText anotherNullEmphasizedText = new EmphasizedText(null);

    // Reflexive
    Assert.assertTrue(et1.equals(et1));
    // Symmetric
    Assert.assertTrue(et1.equals(et2) && et2.equals(et1));
    // Transitive
    Assert.assertTrue(et1.equals(et2) && et2.equals(et3) && et1.equals(et3));
    // Consistent
    Assert.assertTrue(et1.equals(et2) && et1.equals(et2));

    // Null equality
    Assert.assertFalse(et1.equals(null));
    // Null Address Test
    Assert.assertFalse(et1.equals(nullEmphasizedText));
    Assert.assertFalse(nullEmphasizedText.equals(et1));
    Assert.assertTrue(nullEmphasizedText.equals(anotherNullEmphasizedText));
    // Same reference
    Assert.assertTrue(et4.equals(et3));
    // Different class
    Assert.assertFalse(et1.equals("foo"));
  }

  @Test
  public void hashCodeTest() {
    EmphasizedText et1 = new EmphasizedText("emphasized text");
    EmphasizedText et2 = new EmphasizedText("emphasized text");
    EmphasizedText et3 = new EmphasizedText(null);
    // Consistent
    Assert.assertEquals(et1.hashCode(), et1.hashCode());
    Assert.assertEquals(et3.hashCode(), et3.hashCode());
    // Equals corollary
    Assert.assertTrue(et1.equals(et2) && (et1.hashCode() == et2.hashCode()));
  }

}
