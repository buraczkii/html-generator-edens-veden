/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.BuilderStuff;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.EmphasizedText;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.NonEmptyLine;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.PlainText;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Text;


/**
 * @author susannaedens
 *
 */
public class BuildNonEmptyLineTest {

  BuildNonEmptyLine b1, b2, b3;
  String s1, s2, s3;
  LinkedList<Text> l1, l2, l3, l4, l5, l6;
  NonEmptyLine n1, n2, n3;

  @Before
  public void setUp() throws Exception {

    this.s1 =
        new String("## This is just a plain line that should be captured as one piece of text");
    this.s2 = new String("  1. this line should be split up *here* and *for this phrase*");
    this.s3 = new String("  * this is just *one break* of a string");

    this.b1 = new BuildNonEmptyLine(
        "## This is just a plain line that should be captured as one piece of text");
    this.b2 = new BuildNonEmptyLine(this.s2);
    this.b3 = new BuildNonEmptyLine(this.s3);

    this.l1 = new LinkedList<Text>();
    this.l2 = new LinkedList<Text>();
    this.l3 = new LinkedList<Text>();
    this.l4 = new LinkedList<Text>();
    this.l5 = new LinkedList<Text>();
    this.l6 = new LinkedList<Text>();

    this.l1.add(
        new PlainText("## This is just a plain line that should be captured as one piece of text"));

    this.l2.add(new PlainText("  1. this line should be split up "));
    this.l2.add(new EmphasizedText("here"));
    this.l2.add(new PlainText(" and "));
    this.l2.add(new EmphasizedText("for this phrase"));

    this.l3.add(new PlainText("  * this is just "));
    this.l3.add(new EmphasizedText("one break"));
    this.l3.add(new PlainText(" of a string"));

    this.l4.add(
        new PlainText("This is just a plain line that should be captured as one piece of text"));

    this.l5.add(new PlainText("this line should be split up "));
    this.l5.add(new EmphasizedText("here"));
    this.l5.add(new PlainText(" and "));
    this.l5.add(new EmphasizedText("for this phrase"));

    this.l6.add(new PlainText("this is just "));
    this.l6.add(new EmphasizedText("one break"));
    this.l6.add(new PlainText(" of a string"));

    this.n1 = new NonEmptyLine("## ", this.l4);
    this.n2 = new NonEmptyLine("  1. ", this.l5);
    this.n3 = new NonEmptyLine("  * ", this.l6);
  }


  @After
  public void tearDown() throws Exception {}

  @Test
  public void testGetMarkIndex() {
    Assert.assertTrue(this.b1.getMarkIndex().equals(3));
    Assert.assertTrue(this.b2.getMarkIndex().equals(5));
    Assert.assertTrue(this.b3.getMarkIndex().equals(4));
  }

  @Test
  public void testRemoveInlineMarks() {
    Assert.assertEquals(this.b1.removeInlineMarks("*remove my stars*"), "remove my stars");
    Assert.assertEquals(this.b2.removeInlineMarks("*t*"), "t");
  }

  @Test
  public void testBreakDownLine() {
    Assert.assertEquals(this.b1.breakDownLine(this.s1), this.l1);
    Assert.assertEquals(this.b2.breakDownLine(this.s2), this.l2);
    Assert.assertEquals(this.b3.breakDownLine(this.s3), this.l3);
  }

  @Test
  public void testBuild() {
    Assert.assertEquals(this.b1.build(), this.n1);
    Assert.assertEquals(this.b2.build(), this.n2);
    Assert.assertEquals(this.b3.build(), this.n3);
  }
}
