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
public class BuildOrderedListTest {
  // initializing objects for creating lines & listItems
  Line nl1, nl2, nl3, nl4, nl5, nl6;
  AListItem a1, a2, a3, a4, a5, a6;
  LinkedList<Text> tl1, tl2, tl3;
  Text t1, t2, t3;
  // builder, list, & list iterator
  BuildOrderedList b1, b2, b3, b4, bu3, b5;
  LinkedList<Line> l1, l2, l3, l4, l5;
  ListIterator<Line> i1, i2, i3, i4, i5;
  // listTuple, list of listTuple, and doculist
  ListTuple lt1, lt2, lt3, lt4, lt5, lt6, lt7, lt8, lt9, lt10;
  List<ListTuple> ll1, ll2, ll3, ll4, ll5, ll6, ll7, ll8;
  DocuList d1, d2, d3, d4, d5, d6, d7, d8, d9;

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
    // adding Text to the list of Text
    this.tl1.add(this.t1);
    this.tl2.add(this.t2);
    this.tl3.add(this.t1);
    this.tl3.add(this.t2);
    this.tl3.add(this.t3);
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
    this.l1.add(this.nl2);
    this.l1.add(this.nl1);
    this.l1.add(this.nl4);
    this.l1.add(this.nl4);
    this.l1.add(EmptyLine.getInstance());
    this.l2.add(this.nl1);
    this.l2.add(this.nl1);
    this.l2.add(this.nl1);
    this.l2.add(this.nl1);
    this.l2.add(EmptyLine.getInstance());
    this.l3.add(EmptyLine.getInstance());
    this.l4.add(this.nl3);
    this.l4.add(EmptyLine.getInstance());
    this.l5.add(this.nl6);
    this.l5.add(this.nl3);
    this.l5.add(this.nl6);
    this.l5.add(EmptyLine.getInstance());
    // creating iterators for the lists
    this.i1 = this.l1.listIterator();
    this.i2 = this.l2.listIterator();
    this.i3 = this.l3.listIterator();
    this.i4 = this.l4.listIterator();
    this.i5 = this.l5.listIterator();
    // creating builders for ListTuple
    this.b1 = new BuildOrderedList(this.nl1, this.i1);
    this.b2 = new BuildOrderedList(this.nl1, this.i2);
    this.bu3 = new BuildOrderedList(this.nl1, this.i3);
    this.b4 = new BuildOrderedList(this.nl3, this.i4);
    this.b5 = new BuildOrderedList(this.nl3, this.i5);
    // creating List<ListTuple> for DocuList
    this.ll1 = new LinkedList<ListTuple>();
    this.ll2 = new LinkedList<ListTuple>();
    this.ll3 = new LinkedList<ListTuple>();
    this.ll4 = new LinkedList<ListTuple>();
    this.ll5 = new LinkedList<ListTuple>();
    this.ll6 = new LinkedList<ListTuple>();
    this.ll7 = new LinkedList<ListTuple>();
    this.ll8 = new LinkedList<ListTuple>();
    // creating empty DocuList for ListTuples
    this.d1 = new OrderedDocuList(new LinkedList<ListTuple>());
    // creating ListTuple for builder1
    this.lt1 = new ListTuple(this.a4, this.d1);
    this.ll1.add(this.lt1);
    this.ll1.add(this.lt1);
    this.d2 = new UnorderedDocuList(this.ll1);
    this.lt2 = new ListTuple(this.a1, this.d2);
    this.lt3 = new ListTuple(this.a2, this.d1);
    this.ll2.add(this.lt3);
    this.d3 = new OrderedDocuList(this.ll2);
    this.lt4 = new ListTuple(this.a1, this.d3);
    this.ll3.add(this.lt4);
    this.ll3.add(this.lt2);
    this.d4 = new OrderedDocuList(this.ll3);
    // creating ListTuples for builder2
    this.lt5 = new ListTuple(this.a1, this.d1);
    this.ll4.add(this.lt5);
    this.ll4.add(this.lt5);
    this.ll4.add(this.lt5);
    this.ll4.add(this.lt5);
    this.ll4.add(this.lt5);
    this.d5 = new OrderedDocuList(this.ll4);
    // creating for builder3
    this.ll5.add(this.lt5);
    this.d6 = new OrderedDocuList(this.ll5);
    // creating for builder4
    this.lt6 = new ListTuple(this.a3, this.d1);
    this.ll6.add(this.lt6);
    this.ll6.add(this.lt6);
    this.d7 = new OrderedDocuList(this.ll6);
    // creating for builder5
    this.lt7 = new ListTuple(this.a6, this.d1);
    this.ll7.add(this.lt7);
    this.d8 = new UnorderedDocuList(this.ll7);
    this.lt8 = new ListTuple(this.a3, this.d8);
    this.ll8.add(this.lt8);
    this.ll8.add(this.lt8);
    this.d9 = new OrderedDocuList(this.ll8);
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {}

  @Test
  public void testBuild() {
    Assert.assertEquals(this.bu3.build(), this.d6);
    Assert.assertEquals(this.b1.build(), this.d4);
    Assert.assertEquals(this.b2.build(), this.d5);
    Assert.assertEquals(this.b4.build(), this.d7);
    Assert.assertEquals(this.b5.build(), this.d9);
  }

}
