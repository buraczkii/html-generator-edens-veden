package neu.ccs.edu.cs5004.seattle.assignment8;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import neu.ccs.edu.cs5004.seattle.assignment8.contents.EmptySpace;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.Header;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.OrderedDocuList;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.Paragraph;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.UnorderedDocuList;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.PlainText;

public class HtmlFormatterTest {

  HtmlFormatter formatter;
  Paragraph paragraph;
  Header header;
  Header header7;
  EmptySpace emptySpace;
  PlainText plainText;
  UnorderedDocuList uol;
  OrderedDocuList odl;

  @Before
  public void setUp() throws Exception {
    this.formatter = new HtmlFormatter();
    this.paragraph = TestHarness.createPlainTextParagraph();
    this.header = TestHarness.createHeader(1);
    this.header7 = TestHarness.createHeader(7);
    this.emptySpace = TestHarness.createEmptySpace(2);
    this.plainText = TestHarness.createPlainText();
    this.uol = TestHarness.createUnorderedList();
    this.odl = TestHarness.createOrderedLIst();
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void visitParagraphTest() {
    List<String> lineAcc = new LinkedList<>();
    this.formatter.visit(this.paragraph, lineAcc);
    Assert.assertTrue(lineAcc.size() == 4);
  }

  @Test
  public void visitHeaderTest() {
    List<String> lineAcc = new LinkedList<>();
    this.formatter.visit(this.header, lineAcc);
    Assert.assertTrue(lineAcc.size() == 1);
  }

  @Test
  public void vistEmptySpaceTest() {
    List<String> lineAcc = new LinkedList<>();
    this.formatter.visit(this.emptySpace, lineAcc);
    Assert.assertTrue(lineAcc.size() == 2);
  }

  @Test
  public void visitPlainTextTest() {
    List<String> lineAcc = new LinkedList<>();
    this.formatter.visit(this.plainText, lineAcc);
    Assert.assertTrue(lineAcc.size() == 1);
  }

  @Test
  public void visitUnorderDocuLisTest() {
    List<String> lineAcc = new LinkedList<>();
    this.formatter.visit(this.uol, lineAcc);
    Assert.assertTrue(lineAcc.size() == 5);
  }

  @Test
  public void visitOrderDocuLisTest() {
    List<String> lineAcc = new LinkedList<>();
    this.formatter.visit(this.odl, lineAcc);
    Assert.assertTrue(lineAcc.size() == 5);
  }
}
