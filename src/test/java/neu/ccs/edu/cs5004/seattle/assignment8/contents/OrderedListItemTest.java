package neu.ccs.edu.cs5004.seattle.assignment8.contents;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Line;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.NonEmptyLine;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.PlainText;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Text;

public class OrderedListItemTest {
  Line line1;
  List<Text> tokens;
  Text pt;

  @Before
  public void setUp() throws Exception {
    this.pt = new PlainText("plain text");

    this.tokens = new LinkedList<>();
    this.tokens.add(this.pt);
    this.tokens.add(this.pt);

    this.line1 = new NonEmptyLine("1.", this.tokens);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void getLineTest() {
    OrderedListItem oli1 = new OrderedListItem(this.line1);
    Assert.assertEquals(this.line1, oli1.getLine());
  }

  @Test
  public void equalsTest() {
    // Duplicate OrderedListItemes
    OrderedListItem oli1 = new OrderedListItem(this.line1);
    OrderedListItem oli2 = new OrderedListItem(this.line1);
    OrderedListItem oli3 = new OrderedListItem(this.line1);
    OrderedListItem oli4 = oli3;
    OrderedListItem nullOrderedListItem = new OrderedListItem(null);
    OrderedListItem anotherNullOrderedListItem = new OrderedListItem(null);

    // Reflexive
    Assert.assertTrue(oli1.equals(oli1));
    // Symmetric
    Assert.assertTrue(oli1.equals(oli2) && oli2.equals(oli1));
    // Transitive
    Assert.assertTrue(oli1.equals(oli2) && oli2.equals(oli3) && oli1.equals(oli3));
    // Consistent
    Assert.assertTrue(oli1.equals(oli2) && oli1.equals(oli2));

    // Null equality
    Assert.assertFalse(oli1.equals(null));
    // Null Address Test
    Assert.assertFalse(oli1.equals(nullOrderedListItem));
    Assert.assertFalse(nullOrderedListItem.equals(oli1));
    Assert.assertTrue(nullOrderedListItem.equals(anotherNullOrderedListItem));
    // Same reference
    Assert.assertTrue(oli4.equals(oli3));
    // Different class
    Assert.assertFalse(oli1.equals("foo"));
  }

  @Test
  public void hashCodeTest() {
    OrderedListItem oli1 = new OrderedListItem(this.line1);
    OrderedListItem oli2 = new OrderedListItem(this.line1);
    OrderedListItem oli3 = new OrderedListItem(null);
    // Consistent
    Assert.assertEquals(oli1.hashCode(), oli1.hashCode());
    Assert.assertEquals(oli3.hashCode(), oli3.hashCode());
    // Equals corollary
    Assert.assertTrue(oli1.equals(oli2) && (oli1.hashCode() == oli2.hashCode()));
  }

}
