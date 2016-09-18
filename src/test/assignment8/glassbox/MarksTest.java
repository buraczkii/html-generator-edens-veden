/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.glassbox;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Marks;

/**
 * @author susannaedens
 *
 */
public class MarksTest {

  @Before
  public void setUp() throws Exception {}

  @After
  public void tearDown() throws Exception {}

  @Test
  public void testGetEmptyLineMarks() {
    Assert.assertEquals(Marks.getEmptyLineMark(), "^\\s*$");
    String elMarks1 = Marks.getEmptyLineMark();
    String elMarks2 = Marks.getEmptyLineMark();
    Assert.assertEquals(elMarks1, elMarks2);
  }

  @Test
  public void testGetParagraphMarks() {
    Assert.assertEquals(Marks.getParagraphMark(), "^[^#1*].*");
    String paMarks1 = Marks.getParagraphMark();
    String paMarks2 = Marks.getParagraphMark();
    Assert.assertEquals(paMarks1, paMarks2);
  }

  @Test
  public void testGetHeaderMarks() {
    Assert.assertEquals(Marks.getHeaderMark(1), "^[#]{1,1}[\" \"*].*");
    Assert.assertEquals(Marks.getHeaderMark(), "^[#]+[\" \"*].*");
    String heMarks1 = Marks.getHeaderMark(2);
    String heMarks2 = Marks.getHeaderMark(2);
    String heMarks3 = Marks.getHeaderMark(3);
    Assert.assertTrue(heMarks1.equals(heMarks2));
    Assert.assertFalse(heMarks1.equals(heMarks3));
    Assert.assertEquals(Marks.getHeaderMark(), "^[#]+[\" \"*].*");
    Assert.assertEquals(Marks.getHeaderMark(), Marks.getHeaderMark());
  }


  @Test
  public void testGetEmphasizedMark() {
    Assert.assertEquals(Marks.getEmphasizedMark(), "[*][^\\s].*?[^\\s][*]");
    String elMarks1 = Marks.getEmphasizedMark();
    String elMarks2 = Marks.getEmphasizedMark();
    Assert.assertEquals(elMarks1, elMarks2);
  }

  @Test
  public void testGetOrderedListMarks() {
    Assert.assertEquals(Marks.getOrderedListMark(1), "^[\" \"]{0,2}[1][\\.][\\s].*");
    String liMarks1 = Marks.getOrderedListMark(2);
    String liMarks2 = Marks.getOrderedListMark(2);
    String liMarks3 = Marks.getOrderedListMark(3);
    Assert.assertTrue(liMarks1.equals(liMarks2));
    Assert.assertFalse(liMarks1.equals(liMarks3));
    Assert.assertEquals(Marks.getOrderedListMark(), "^([\\s]{2})*[1][\\.][\\s].*");
    Assert.assertEquals(Marks.getOrderedListMark(), Marks.getOrderedListMark());
  }

  @Test
  public void testGetUnorderedUnorderedListMarks() {
    Assert.assertEquals(Marks.getUnorderedListMark(1), "^([\\s]{2}){1,1}[*].*");
    Assert.assertEquals(Marks.getUnorderedListMark(2), "^([\\s]{2}){1,2}[*].*");
    String liMarks1 = Marks.getUnorderedListMark(2);
    String liMarks2 = Marks.getUnorderedListMark(2);
    String liMarks3 = Marks.getUnorderedListMark(3);
    Assert.assertTrue(liMarks1.equals(liMarks2));
    Assert.assertFalse(liMarks1.equals(liMarks3));
    Assert.assertEquals(Marks.getUnorderedListMark(), "^([\\s]{2})+[*][\\s].*");
    Assert.assertEquals(Marks.getUnorderedListMark(), Marks.getUnorderedListMark());

  }



  @Test
  public void testGetHeaderLevel() {
    Assert.assertTrue(Marks.getHeaderLevel("### ").equals(3));
    Assert.assertTrue(Marks.getHeaderLevel("# ").equals(1));
    Assert.assertTrue(Marks.getHeaderLevel("##### ").equals(5));
    Assert.assertTrue(Marks.getHeaderLevel("rando string").equals(0));
    Assert.assertTrue(Marks.getHeaderLevel("  1.").equals(0));
    Assert.assertTrue(Marks.getHeaderLevel("    *").equals(0));
  }

  @Test
  public void testGetOrderedListLevel() {
    Assert.assertTrue(Marks.getOrderedListLevel("    1. ").equals(3));
    Assert.assertTrue(Marks.getOrderedListLevel("1.").equals(1));
    Assert.assertTrue(Marks.getOrderedListLevel("        1.").equals(5));
    Assert.assertTrue(Marks.getOrderedListLevel("       1.").equals(4));
    Assert.assertTrue(Marks.getOrderedListLevel("rando string").equals(0));
    Assert.assertTrue(Marks.getOrderedListLevel("## ").equals(0));
    Assert.assertTrue(Marks.getOrderedListLevel("  *").equals(0));
  }

  @Test
  public void testGetUnorderedListLevel() {
    Assert.assertTrue(Marks.getUnorderedListLevel("    * ").equals(2));
    Assert.assertTrue(Marks.getUnorderedListLevel("  * ").equals(1));
    System.out.println(Marks.getUnorderedListLevel("* "));
    Assert.assertTrue(Marks.getUnorderedListLevel("* ").equals(0));
    Assert.assertTrue(Marks.getUnorderedListLevel("        * ").equals(4));
    Assert.assertTrue(Marks.getUnorderedListLevel("       * ").equals(3));
    Assert.assertTrue(Marks.getUnorderedListLevel("       *").equals(0));
    Assert.assertTrue(Marks.getUnorderedListLevel("rando string").equals(0));
    Assert.assertTrue(Marks.getUnorderedListLevel("## ").equals(0));
    Assert.assertTrue(Marks.getUnorderedListLevel("  1.").equals(0));
  }



}
