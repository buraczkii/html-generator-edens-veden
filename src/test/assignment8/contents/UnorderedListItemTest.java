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

public class UnorderedListItemTest {

  Line line1;
  List<Text> tokens;
  Text pt;

  @Before
  public void setUp() throws Exception {
    this.pt = new PlainText("plain text");

    this.tokens = new LinkedList<>();
    this.tokens.add(this.pt);
    this.tokens.add(this.pt);

    this.line1 = new NonEmptyLine("*", this.tokens);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void getLineTest() {
    UnorderedListItem uoli1 = new UnorderedListItem(this.line1);
    Assert.assertEquals(this.line1, uoli1.getLine());
  }

  @Test
  public void equalsTest() {
    // Duplicate UnorderedListItemes
    UnorderedListItem uoli1 = new UnorderedListItem(this.line1);
    UnorderedListItem uoli2 = new UnorderedListItem(this.line1);
    UnorderedListItem uoli3 = new UnorderedListItem(this.line1);
    UnorderedListItem uoli4 = uoli3;
    UnorderedListItem nullUnorderedListItem = new UnorderedListItem(null);
    UnorderedListItem anotherNullUnorderedListItem = new UnorderedListItem(null);

    // Reflexive
    Assert.assertTrue(uoli1.equals(uoli1));
    // Symmetric
    Assert.assertTrue(uoli1.equals(uoli2) && uoli2.equals(uoli1));
    // Transitive
    Assert.assertTrue(uoli1.equals(uoli2) && uoli2.equals(uoli3) && uoli1.equals(uoli3));
    // Consistent
    Assert.assertTrue(uoli1.equals(uoli2) && uoli1.equals(uoli2));

    // Null equality
    Assert.assertFalse(uoli1.equals(null));
    // Null Address Test
    Assert.assertFalse(uoli1.equals(nullUnorderedListItem));
    Assert.assertFalse(nullUnorderedListItem.equals(uoli1));
    Assert.assertTrue(nullUnorderedListItem.equals(anotherNullUnorderedListItem));
    // Same reference
    Assert.assertTrue(uoli4.equals(uoli3));
    // Different class
    Assert.assertFalse(uoli1.equals("foo"));
  }

  @Test
  public void hashCodeTest() {
    UnorderedListItem uoli1 = new UnorderedListItem(this.line1);
    UnorderedListItem uoli2 = new UnorderedListItem(this.line1);
    UnorderedListItem uoli3 = new UnorderedListItem(null);
    // Consistent
    Assert.assertEquals(uoli1.hashCode(), uoli1.hashCode());
    Assert.assertEquals(uoli3.hashCode(), uoli3.hashCode());
    // Equals corollary
    Assert.assertTrue(uoli1.equals(uoli2) && (uoli1.hashCode() == uoli2.hashCode()));
  }

}
