/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.BuilderStuff;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import neu.ccs.edu.cs5004.seattle.assignment8.MyDocument;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.Content;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.DocuList;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.EmptySpace;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.Header;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.ListTuple;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.OrderedDocuList;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.OrderedListItem;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.Paragraph;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.UnorderedDocuList;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.UnorderedListItem;
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
public class BuildDocumentTest {

  BuildDocument b1, b2, b3;
  MyDocument d1, d2, d3;

  List<Text> lx1, lx2, lx3, lx4, lx5, lx6, lx7, lx8, lx9, lx10, lx11;
  NonEmptyLine l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;

  List<Line> ll1, ll2, ll3;
  List<NonEmptyLine> ln1, ln2, ln3, ln4, ln5, ln6, ln7;
  List<EmptyLine> le1, le2, le3;
  List<Content> lc1, lc2, lc3;
  List<ListTuple> lt1, lt2, lt3, lt4, lt5, lt6, lt7;

  Paragraph p1, p2, p3, p4;
  Header h1, h2, h3, h4;
  EmptySpace e1, e2, e3;

  OrderedListItem o1, o2;
  UnorderedListItem u1, u2;
  ListTuple t1, t2, t3, t4, t5, t6;
  OrderedDocuList od1, od2;
  UnorderedDocuList ud1, ud2;
  DocuList dl1;



  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    // initializing all lists
    this.lx1 = new LinkedList<Text>();
    this.lx2 = new LinkedList<Text>();
    this.lx3 = new LinkedList<Text>();
    this.lx4 = new LinkedList<Text>();
    this.lx5 = new LinkedList<Text>();
    this.lx6 = new LinkedList<Text>();
    this.lx7 = new LinkedList<Text>();
    this.lx8 = new LinkedList<Text>();
    this.lx9 = new LinkedList<Text>();
    this.lx10 = new LinkedList<Text>();
    this.lx11 = new LinkedList<Text>();

    this.ll1 = new LinkedList<Line>();
    this.ll2 = new LinkedList<Line>();
    this.ll3 = new LinkedList<Line>();

    this.ln1 = new LinkedList<NonEmptyLine>();
    this.ln2 = new LinkedList<NonEmptyLine>();
    this.ln3 = new LinkedList<NonEmptyLine>();
    this.ln4 = new LinkedList<NonEmptyLine>();
    this.ln5 = new LinkedList<NonEmptyLine>();
    this.ln6 = new LinkedList<NonEmptyLine>();
    this.ln7 = new LinkedList<NonEmptyLine>();

    this.le1 = new LinkedList<EmptyLine>();
    this.le2 = new LinkedList<EmptyLine>();
    this.le3 = new LinkedList<EmptyLine>();

    this.lc1 = new LinkedList<Content>();
    this.lc2 = new LinkedList<Content>();
    this.lc3 = new LinkedList<Content>();

    this.lt1 = new LinkedList<ListTuple>();
    this.lt2 = new LinkedList<ListTuple>();
    this.lt3 = new LinkedList<ListTuple>();
    this.lt4 = new LinkedList<ListTuple>();
    this.lt5 = new LinkedList<ListTuple>();
    this.lt6 = new LinkedList<ListTuple>();
    this.lt7 = new LinkedList<ListTuple>();


    // SET UP FOR TESTWOLISTS.TXT
    /* the first emptyspace */
    this.le1.add(EmptyLine.getInstance());
    this.e1 = new EmptySpace(this.le1);
    /* the first paragraph */
    this.lx1.add(new PlainText("Hello, I am a pretty little document"));
    this.l1 = new NonEmptyLine("abc", this.lx1);
    this.lx2.add(new PlainText("I am part of a "));
    this.lx2.add(new EmphasizedText("pretty paragraph"));
    this.l2 = new NonEmptyLine("abc", this.lx2);
    this.ln1.add(this.l1);
    this.ln1.add(this.l2);
    this.p1 = new Paragraph(this.ln1);
    /* the first header */
    this.lx3.add(new PlainText("Here comes a level 1 header"));
    this.l3 = new NonEmptyLine("# ", this.lx3);
    this.h1 = new Header(this.l3);
    /* the second header */
    this.lx4.add(new PlainText("woah, level 2 header"));
    this.l4 = new NonEmptyLine("## ", this.lx4);
    this.h2 = new Header(this.l4);
    /* the second paragraph */
    this.lx5.add(new PlainText("I am a baby paragraph."));
    this.l5 = new NonEmptyLine("abc", this.lx5);
    this.ln2.add(this.l5);
    this.p2 = new Paragraph(this.ln2);
    /* the third header */
    this.lx6.add(new PlainText("uhoh, did you know you could skip levels?"));
    this.l6 = new NonEmptyLine("#### ", this.lx6);
    this.h3 = new Header(this.l6);
    /* the second emptyspace */
    this.le2.add(EmptyLine.getInstance());
    this.le2.add(EmptyLine.getInstance());
    this.e2 = new EmptySpace(this.le2);
    /* the fourth header */
    this.lx7.add(new PlainText("Second level 1 header "));
    this.lx7.add(new EmphasizedText("don't bold me"));
    this.lx7.add(new PlainText(" for assignment9"));
    this.l7 = new NonEmptyLine("# ", this.lx7);
    this.h4 = new Header(this.l7);
    /* Line list generated is ll1 */
    this.ll1.add(EmptyLine.getInstance());
    this.ll1.add(this.l1);
    this.ll1.add(this.l2);
    this.ll1.add(this.l3);
    this.ll1.add(this.l4);
    this.ll1.add(this.l5);
    this.ll1.add(this.l6);
    this.ll1.add(EmptyLine.getInstance());
    this.ll1.add(EmptyLine.getInstance());
    this.ll1.add(this.l7);
    /* Content list generated is lc1 */
    this.lc1.add(this.e1);
    this.lc1.add(this.p1);
    this.lc1.add(this.h1);
    this.lc1.add(this.h2);
    this.lc1.add(this.p2);
    this.lc1.add(this.h3);
    this.lc1.add(this.e2);
    this.lc1.add(this.h4);
    /* Builder for this document */
    this.b1 = new BuildDocument(Paths.get("testWOlists.txt"));
    this.d1 = new MyDocument(this.lc1);


    // SET UP FOR TESTONLYLISTS.TXT
    /* Lines in the list */
    this.lx8.add(new PlainText("Unordered level 1"));
    this.lx9.add(new PlainText("Ordered level 2"));
    this.lx10.add(new PlainText("Unordered level 3"));
    this.lx11.add(new PlainText("Ordered level 3"));
    this.l8 = new NonEmptyLine("  * ", this.lx8);
    this.l9 = new NonEmptyLine("  1. ", this.lx9);
    this.l10 = new NonEmptyLine("      * ", this.lx10);
    this.l11 = new NonEmptyLine("    1. ", this.lx11);
    this.u1 = new UnorderedListItem(this.l8);
    this.u2 = new UnorderedListItem(this.l10);
    this.o1 = new OrderedListItem(this.l9);
    this.o2 = new OrderedListItem(this.l11);
    /* Line List */
    this.ll2.add(this.l8);
    this.ll2.add(this.l8);
    this.ll2.add(this.l9);
    this.ll2.add(this.l10);
    this.ll2.add(this.l10);
    this.ll2.add(this.l9);
    this.ll2.add(this.l11);
    this.ll2.add(this.l8);
    /* built list for testing */
    this.dl1 = new OrderedDocuList(new LinkedList<ListTuple>());
    this.t1 = new ListTuple(this.u2, this.dl1);
    this.lt1.add(this.t1);
    this.lt1.add(this.t1);
    this.ud1 = new UnorderedDocuList(this.lt1);
    this.t2 = new ListTuple(this.o2, this.dl1);
    this.lt2.add(this.t2);
    this.od1 = new OrderedDocuList(this.lt2);
    this.t3 = new ListTuple(this.o1, this.ud1);
    this.t4 = new ListTuple(this.o1, this.od1);
    this.lt3.add(this.t3);
    this.lt3.add(this.t4);
    this.od2 = new OrderedDocuList(this.lt3);
    this.t5 = new ListTuple(this.u1, this.od2);
    this.t6 = new ListTuple(this.u1, this.dl1);
    this.lt4.add(this.t6);
    this.lt4.add(this.t5);
    this.lt4.add(this.t6);
    this.ud2 = new UnorderedDocuList(this.lt4);
    this.lc2.add(this.ud2);
    /* Builder for this Document */
    this.b2 = new BuildDocument(Paths.get("testONLYlists.txt"));
    this.d2 = new MyDocument(this.lc2);

    // SET UP FOR TESTALL.TXT
    /* List of Lines */
    this.ll3.add(EmptyLine.getInstance());
    this.ll3.add(EmptyLine.getInstance());
    this.ll3.add(this.l3);
    this.ll3.add(EmptyLine.getInstance());
    this.ll3.add(this.l1);
    this.ll3.add(this.l2);
    this.ll3.add(this.l6);
    this.ll3.add(this.l4);
    this.ll3.add(this.l8);
    this.ll3.add(this.l8);
    this.ll3.add(this.l9);
    this.ll3.add(this.l10);
    this.ll3.add(this.l10);
    this.ll3.add(this.l9);
    this.ll3.add(this.l11);
    this.ll3.add(this.l8);
    this.ll3.add(this.l7);
    this.ll3.add(EmptyLine.getInstance());
    this.ll3.add(this.l5);
    /* List of Content */
    this.lc3.add(this.e2);
    this.lc3.add(this.h1);
    this.lc3.add(this.e1);
    this.lc3.add(this.p1);
    this.lc3.add(this.h3);
    this.lc3.add(this.h2);
    this.lc3.add(this.ud2);
    this.lc3.add(this.h4);
    this.lc3.add(this.e1);
    this.lc3.add(this.p2);
    /* the final document builder */
    this.b3 = new BuildDocument(Paths.get("testAll.txt"));
    this.d3 = new MyDocument(this.lc3);

  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {}

  @Test
  public void testGenerateLineList() throws IOException {
    // for generating line list from a path
    /* First Document */
    Assert.assertEquals(this.b1.generateLineList(), this.ll1);
    this.ll1.remove(this.l1);
    Assert.assertNotEquals(this.b1.generateLineList(), this.ll1);
    /* Second Document */
    Assert.assertEquals(this.b2.generateLineList(), this.ll2);
    this.ll2.remove(this.l8);
    Assert.assertNotEquals(this.b2.generateLineList(), this.ll2);
    /* Final Document */
    Assert.assertEquals(this.b3.generateLineList(), this.ll3);
    this.ll3.remove(this.l8);
    Assert.assertNotEquals(this.b3.generateLineList(), this.ll3);
  }

  @Test
  public void testBuildContentList() {
    // for building a list of content!
    /* First Document */
    Assert.assertEquals(this.b1.buildContentList(this.ll1), this.lc1);
    /* Second Document */
    Assert.assertEquals(this.b2.buildContentList(this.ll2), this.lc2);
    /* Final Document */
    Assert.assertEquals(this.b3.buildContentList(this.ll3), this.lc3);
  }

  @Test
  public void testBuild() throws IOException {
    // for building document
    Assert.assertEquals(this.b1.build(), this.d1);
    Assert.assertEquals(this.b2.build(), this.d2);
    Assert.assertEquals(this.b3.build(), this.d3);
  }

}
