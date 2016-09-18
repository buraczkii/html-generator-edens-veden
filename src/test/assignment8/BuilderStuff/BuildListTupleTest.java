/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.BuilderStuff;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import neu.ccs.edu.cs5004.seattle.assignment8.contents.AListItem;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.DocuList;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.ListTuple;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.OrderedDocuList;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.OrderedListItem;
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
public class BuildListTupleTest {
  BuildListTuple b1, b2, b3, b4, b5;
  ListIterator<Line> i1, i2, i3, i4, i5;
  Line nl1, nl2, nl3, nl4, nl5, nl6;
  AListItem a1, a2, a3, a4, a5, a6;
  LinkedList<Line> l1, l2, l3, l4, l5;
  LinkedList<Text> tl1, tl2, tl3;
  Text t1, t2, t3, t4;
  ListTuple lt1, lt2, lt3, lt4, lt5, lt6, lt7, lt8, lt9, lt10, lt11, lt12;
  List<ListTuple> ll1, ll2, ll3, ll4, ll5, ll6, ll7;
  DocuList d1, d2, d3, d4, d5, d6, d7;


  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    // creating list of text for lines
    this.tl1 = new LinkedList<Text>();
    this.tl2 = new LinkedList<Text>();
    this.tl3 = new LinkedList<Text>();
    // creating list of lines for iterator
    this.l1 = new LinkedList<Line>();
    this.l2 = new LinkedList<Line>();
    this.l3 = new LinkedList<Line>();
    this.l4 = new LinkedList<Line>();
    this.l5 = new LinkedList<Line>();
    // creating Text for the list of text
    this.t1 = new PlainText("this is text");
    this.t2 = new PlainText("this is also");
    this.t3 = new EmphasizedText("this is emphasized text");
    this.t4 = new EmphasizedText("this is also emphasized text");
    // adding Text to the list of Text
    this.tl1.add(this.t1);
    this.tl2.add(this.t2);
    this.tl2.add(this.t4);
    this.tl3.add(this.t1);
    this.tl3.add(this.t2);
    this.tl3.add(this.t3);
    this.tl3.add(this.t4);
    // creating non empty lines to represent list items
    this.nl1 = new NonEmptyLine("1. ", this.tl1);
    this.nl2 = new NonEmptyLine("  1. ", this.tl2);
    this.nl3 = new NonEmptyLine("    1. ", this.tl3);
    this.nl4 = new NonEmptyLine("    * ", this.tl2);
    this.nl5 = new NonEmptyLine("  * ", this.tl2);
    this.nl6 = new NonEmptyLine("        * ", this.tl1);
    // creating list items for the List Tuple
    this.a1 = new OrderedListItem(this.nl1);
    this.a2 = new OrderedListItem(this.nl2);
    this.a3 = new OrderedListItem(this.nl3);
    this.a4 = new UnorderedListItem(this.nl4);
    this.a5 = new UnorderedListItem(this.nl5);
    this.a6 = new UnorderedListItem(this.nl6);
    // creating lists of lines for the iterator
    this.l1.add(this.nl1);
    this.l1.add(this.nl6);
    this.l2.add(this.nl2);
    this.l2.add(this.nl3);
    this.l2.add(EmptyLine.getInstance());
    this.l3.add(this.nl4);
    this.l3.add(this.nl4);
    this.l3.add(this.nl4);
    this.l3.add(EmptyLine.getInstance());
    this.l4.add(this.nl6);
    this.l4.add(this.nl6);
    this.l4.add(this.nl6);
    this.l4.add(this.nl6);
    this.l4.add(this.nl1);
    this.l5.add(this.nl4);
    this.l5.add(this.nl4);
    this.l5.add(this.nl3);
    this.l5.add(this.nl1);
    // creating iterators for the lists
    this.i1 = this.l1.listIterator();
    this.i2 = this.l2.listIterator();
    this.i3 = this.l3.listIterator();
    this.i4 = this.l4.listIterator();
    this.i5 = this.l5.listIterator();
    // creating builders for ListTuple
    this.b1 = new BuildListTuple(this.a1, this.i1, 1);
    this.b2 = new BuildListTuple(this.a1, this.i2, 1);
    this.b3 = new BuildListTuple(this.a5, this.i3, 1);
    this.b4 = new BuildListTuple(this.a2, this.i4, 2);
    this.b5 = new BuildListTuple(this.a1, this.i5, 1);
    // creating List<ListTuple> for DocuList
    this.ll1 = new LinkedList<ListTuple>();
    this.ll2 = new LinkedList<ListTuple>();
    this.ll3 = new LinkedList<ListTuple>();
    this.ll4 = new LinkedList<ListTuple>();
    this.ll5 = new LinkedList<ListTuple>();
    this.ll6 = new LinkedList<ListTuple>();
    this.ll7 = new LinkedList<ListTuple>();
    // creating DocuList for ListTuples
    this.d1 = new OrderedDocuList(this.ll1);
    // creating ListTuple for builder1
    this.lt1 = new ListTuple(this.a1, this.d1);
    // creating ListTuple for builder2
    this.lt2 = new ListTuple(this.a3, this.d1);
    this.ll2.add(this.lt2);
    this.d2 = new OrderedDocuList(this.ll2);
    this.lt3 = new ListTuple(this.a2, this.d2);
    this.ll3.add(this.lt3);
    this.d3 = new OrderedDocuList(this.ll3);
    this.lt11 = new ListTuple(this.a1, this.d3);
    // creating ListTuple for builder3
    this.lt4 = new ListTuple(this.a4, this.d1);
    this.ll4.add(this.lt4);
    this.ll4.add(this.lt4);
    this.ll4.add(this.lt4);
    this.d4 = new UnorderedDocuList(this.ll4);
    this.lt12 = new ListTuple(this.a5, this.d4);
    // creating ListTuple for builder4
    this.lt5 = new ListTuple(this.a6, this.d1);
    this.ll5.add(this.lt5);
    this.ll5.add(this.lt5);
    this.ll5.add(this.lt5);
    this.ll5.add(this.lt5);
    this.d5 = new UnorderedDocuList(this.ll5);
    this.lt6 = new ListTuple(this.a2, this.d5);
    // creating ListTuple for builder5
    this.lt7 = new ListTuple(this.a3, this.d1);
    this.ll6.add(this.lt7);
    this.d6 = new OrderedDocuList(this.ll6);
    this.lt8 = new ListTuple(this.a4, this.d6);
    this.lt9 = new ListTuple(this.a4, this.d1);
    this.ll7.add(this.lt9);
    this.ll7.add(this.lt8);
    this.d7 = new UnorderedDocuList(this.ll7);
    this.lt10 = new ListTuple(this.a1, this.d7);
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {}


  @Test
  public void testBuild() {
    Assert.assertEquals(this.b1.build(), this.lt1);
    Assert.assertEquals(this.b2.build(), this.lt11);
    Assert.assertFalse(this.b2.build().equals(this.lt2));
    Assert.assertEquals(this.b3.build(), this.lt12);
    Assert.assertEquals(this.b4.build(), this.lt6);
    Assert.assertEquals(this.b5.build(), this.lt10);
  }


}
