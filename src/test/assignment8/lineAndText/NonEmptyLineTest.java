package neu.ccs.edu.cs5004.seattle.assignment8.lineAndText;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class NonEmptyLineTest {
  List<Text> text;
  String mark;

  @Before
  public void setUp() throws Exception {
    this.text = new ArrayList<Text>();
    this.text.add(new PlainText("plain text"));
    this.mark = "";
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void getMarkTest() {
    NonEmptyLine nel1 = new NonEmptyLine(this.mark, this.text);
    Assert.assertEquals(this.mark, nel1.getMark());
  }

  @Test
  public void getTokensTest() {
    NonEmptyLine nel1 = new NonEmptyLine(this.mark, this.text);
    Assert.assertEquals(this.text, nel1.getTokens());
  }

  @Test
  public void equalsTest() {
    // Duplicate NonEmptyLinees
    NonEmptyLine nel1 = new NonEmptyLine(this.mark, this.text);
    NonEmptyLine nel2 = new NonEmptyLine(this.mark, this.text);
    NonEmptyLine nel3 = new NonEmptyLine(this.mark, this.text);
    NonEmptyLine nel4 = nel3;
    NonEmptyLine nullNonEmptyLine = new NonEmptyLine(null, null);
    NonEmptyLine anotherNullNonEmptyLine = new NonEmptyLine(null, null);

    // Reflexive
    Assert.assertTrue(nel1.equals(nel1));
    // Symmetric
    Assert.assertTrue(nel1.equals(nel2) && nel2.equals(nel1));
    // Transitive
    Assert.assertTrue(nel1.equals(nel2) && nel2.equals(nel3) && nel1.equals(nel3));
    // Consistent
    Assert.assertTrue(nel1.equals(nel2) && nel1.equals(nel2));

    // Null equality
    Assert.assertFalse(nel1.equals(null));
    // Null Address Test
    Assert.assertFalse(nel1.equals(nullNonEmptyLine));
    Assert.assertFalse(nullNonEmptyLine.equals(nel1));
    Assert.assertTrue(nullNonEmptyLine.equals(anotherNullNonEmptyLine));
    // Same reference
    Assert.assertTrue(nel4.equals(nel3));
    // Different class
    Assert.assertFalse(nel1.equals("foo"));
  }

  @Test
  public void hashCodeTest() {
    NonEmptyLine nel1 = new NonEmptyLine(this.mark, this.text);
    NonEmptyLine nel2 = new NonEmptyLine(this.mark, this.text);
    NonEmptyLine nel3 = new NonEmptyLine(null, null);
    // Consistent
    Assert.assertEquals(nel1.hashCode(), nel1.hashCode());
    Assert.assertEquals(nel3.hashCode(), nel3.hashCode());
    // Equals corollary
    Assert.assertTrue(nel1.equals(nel2) && (nel1.hashCode() == nel2.hashCode()));
  }
}
