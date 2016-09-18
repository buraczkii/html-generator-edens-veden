package neu.ccs.edu.cs5004.seattle.assignment8.contents;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.NonEmptyLine;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.PlainText;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Text;

public class ParagraphTest {
  List<NonEmptyLine> lines;
  List<Text> line1;
  List<Text> line2;
  Text pt;

  @Before
  public void setUp() throws Exception {
    this.pt = new PlainText("plain text");

    this.line1 = new LinkedList<>();
    this.line1.add(this.pt);
    this.line1.add(this.pt);
    this.line2 = new LinkedList<>();
    this.line2.add(this.pt);
    this.line2.add(this.pt);

    this.lines = new LinkedList<>();
    this.lines.add(new NonEmptyLine("", this.line1));
    this.lines.add(new NonEmptyLine("", this.line2));
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void getLinesTest() {
    Paragraph p1 = new Paragraph(this.lines);
    Assert.assertEquals(this.lines, p1.getLines());
  }

  @Test
  public void equalsTest() {
    // Duplicate Paragraphes
    Paragraph p1 = new Paragraph(this.lines);
    Paragraph p2 = new Paragraph(this.lines);
    Paragraph p3 = new Paragraph(this.lines);
    Paragraph p4 = p3;
    Paragraph nullParagraph = new Paragraph(null);
    Paragraph anotherNullParagraph = new Paragraph(null);

    // Reflexive
    Assert.assertTrue(p1.equals(p1));
    // Symmetric
    Assert.assertTrue(p1.equals(p2) && p2.equals(p1));
    // Transitive
    Assert.assertTrue(p1.equals(p2) && p2.equals(p3) && p1.equals(p3));
    // Consistent
    Assert.assertTrue(p1.equals(p2) && p1.equals(p2));

    // Null equality
    Assert.assertFalse(p1.equals(null));
    // Null Address Test
    Assert.assertFalse(p1.equals(nullParagraph));
    Assert.assertFalse(nullParagraph.equals(p1));
    Assert.assertTrue(nullParagraph.equals(anotherNullParagraph));
    // Same reference
    Assert.assertTrue(p4.equals(p3));
    // Different class
    Assert.assertFalse(p1.equals("foo"));
  }

  @Test
  public void hashCodeTest() {
    Paragraph p1 = new Paragraph(this.lines);
    Paragraph p2 = new Paragraph(this.lines);
    Paragraph p3 = new Paragraph(null);
    // Consistent
    Assert.assertEquals(p1.hashCode(), p1.hashCode());
    Assert.assertEquals(p3.hashCode(), p3.hashCode());
    // Equals corollary
    Assert.assertTrue(p1.equals(p2) && (p1.hashCode() == p2.hashCode()));
  }

}
