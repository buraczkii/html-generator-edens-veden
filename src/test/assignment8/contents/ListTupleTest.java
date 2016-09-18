package neu.ccs.edu.cs5004.seattle.assignment8.contents;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Line;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.NonEmptyLine;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.PlainText;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Text;

public class ListTupleTest {
  AListItem listItem;
  Line listItemLine;
  List<Text> tokens;
  DocuList sublist;

  @Before
  public void setUp() throws Exception {
    this.tokens = new ArrayList<>();
    this.tokens.add(new PlainText("plain text"));
    this.listItemLine = new NonEmptyLine("1.", this.tokens);
    this.listItem = new OrderedListItem(this.listItemLine);

  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void getItemTest() {
    ListTuple lt1 = new ListTuple(this.listItem, null);
    Assert.assertEquals(this.listItem, lt1.getItem());
  }

  @Test
  public void getSublistTest() {
    ListTuple lt1 = new ListTuple(this.listItem, null);
    Assert.assertEquals(null, lt1.getSublist());
  }

  @Test
  public void equalsTest() {
    // Duplicate ListTuplees
    ListTuple lt1 = new ListTuple(this.listItem, null);
    ListTuple lt2 = new ListTuple(this.listItem, null);
    ListTuple lt3 = new ListTuple(this.listItem, null);
    ListTuple lt4 = lt3;
    ListTuple nullListTuple = new ListTuple(null, null);
    ListTuple anotherNullListTuple = new ListTuple(null, null);

    // Reflexive
    Assert.assertTrue(lt1.equals(lt1));
    // Symmetric
    Assert.assertTrue(lt1.equals(lt2) && lt2.equals(lt1));
    // Transitive
    Assert.assertTrue(lt1.equals(lt2) && lt2.equals(lt3) && lt1.equals(lt3));
    // Consistent
    Assert.assertTrue(lt1.equals(lt2) && lt1.equals(lt2));

    // Null equality
    Assert.assertFalse(lt1.equals(null));
    // Null Address Test
    Assert.assertFalse(lt1.equals(nullListTuple));
    Assert.assertFalse(nullListTuple.equals(lt1));
    Assert.assertTrue(nullListTuple.equals(anotherNullListTuple));
    // Same reference
    Assert.assertTrue(lt4.equals(lt3));
    // Different class
    Assert.assertFalse(lt1.equals("foo"));
  }

  @Test
  public void hashCodeTest() {
    ListTuple lt1 = new ListTuple(this.listItem, null);
    ListTuple lt2 = new ListTuple(this.listItem, null);
    ListTuple lt3 = new ListTuple(null, null);
    // Consistent
    Assert.assertEquals(lt1.hashCode(), lt1.hashCode());
    Assert.assertEquals(lt3.hashCode(), lt3.hashCode());
    // Equals corollary
    Assert.assertTrue(lt1.equals(lt2) && (lt1.hashCode() == lt2.hashCode()));
  }

}
