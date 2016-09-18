/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.BuilderStuff;


import java.util.LinkedList;
import java.util.ListIterator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import neu.ccs.edu.cs5004.seattle.assignment8.contents.Paragraph;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.EmphasizedText;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.EmptyLine;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Line;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.NonEmptyLine;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.PlainText;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Text;

/**
 * @author susannaedens
 *
 */
public class BuildParagraphTest {
  BuildParagraph b1, b2, b3;
  LinkedList<Line> l1, l2, l3;
  LinkedList<NonEmptyLine> nl1, nl2, nl3;
  LinkedList<Text> tl1, tl2, tl3;
  ListIterator<Line> i1, i2, i3;
  NonEmptyLine n1, n2, n3;
  Text t1, t2, t3, t4;
  Paragraph p1, p2, p3;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    this.tl1 = new LinkedList<Text>();
    this.tl2 = new LinkedList<Text>();
    this.tl3 = new LinkedList<Text>();

    this.l1 = new LinkedList<Line>();
    this.l2 = new LinkedList<Line>();
    this.l3 = new LinkedList<Line>();

    this.nl1 = new LinkedList<NonEmptyLine>();
    this.nl2 = new LinkedList<NonEmptyLine>();
    this.nl3 = new LinkedList<NonEmptyLine>();

    this.t1 = new PlainText("this is text");
    this.t2 = new PlainText("this is also");
    this.t3 = new EmphasizedText("this is emphasized text");
    this.t4 = new EmphasizedText("this is also emphasized text");

    this.tl1.add(this.t1);
    this.tl2.add(this.t2);
    this.tl2.add(this.t4);
    this.tl3.add(this.t1);
    this.tl3.add(this.t2);
    this.tl3.add(this.t3);
    this.tl3.add(this.t4);

    this.n1 = new NonEmptyLine("abc", this.tl1);
    this.n2 = new NonEmptyLine("abc", this.tl2);
    this.n3 = new NonEmptyLine("abc", this.tl3);

    this.nl1.add(this.n1);
    this.nl2.add(this.n1);
    this.nl2.add(this.n2);
    this.nl3.add(this.n1);
    this.nl3.add(this.n2);
    this.nl3.add(this.n3);

    this.l1.addAll(this.nl1);
    this.l2.addAll(this.nl2);
    this.l3.addAll(this.nl3);
    this.l1.add(EmptyLine.getInstance());
    this.l2.add(EmptyLine.getInstance());
    this.l3.add(EmptyLine.getInstance());

    this.p1 = new Paragraph(this.nl1);
    this.p2 = new Paragraph(this.nl2);
    this.p3 = new Paragraph(this.nl3);

    this.i1 = this.l1.listIterator();
    this.i2 = this.l2.listIterator();
    this.i3 = this.l3.listIterator();

    this.b1 = new BuildParagraph(this.i1);
    this.b2 = new BuildParagraph(this.i2);
    this.b3 = new BuildParagraph(this.i3);

  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {}

  @Test
  public void testBuild() {
    Assert.assertEquals(this.b1.build(), this.p1);
    Assert.assertEquals(this.b2.build(), this.p2);
    Assert.assertEquals(this.b3.build(), this.p3);
    Assert.assertFalse(this.b2.build().equals(this.p1));
    Assert.assertFalse(this.b3.build().equals(this.p2));
  }

}
