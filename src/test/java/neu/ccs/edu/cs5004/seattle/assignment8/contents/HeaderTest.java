package neu.ccs.edu.cs5004.seattle.assignment8.contents;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.EmphasizedText;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Line;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.NonEmptyLine;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.PlainText;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Text;

public class HeaderTest {
  List<Text> tokens;
  Line headerLine;

  @Before
  public void setUp() throws Exception {
    this.tokens = new LinkedList<>();
    this.tokens.add(new PlainText("plain text"));
    this.tokens.add(new EmphasizedText("bold text"));

    this.headerLine = new NonEmptyLine("## ", this.tokens);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void getLineTest() {
    Header h1 = new Header(this.headerLine);
    Assert.assertEquals(this.headerLine, h1.getLine());
  }

  @Test
  public void equalsTest() {
    // Duplicate Headers
    Header h1 = new Header(this.headerLine);
    Header h2 = new Header(this.headerLine);
    Header h3 = new Header(this.headerLine);
    Header h4 = h3;
    Header nullHeader = new Header(null);
    Header anotherNullHeader = new Header(null);

    // Reflexive
    Assert.assertTrue(h1.equals(h1));
    // Symmetric
    Assert.assertTrue(h1.equals(h2) && h2.equals(h1));
    // Transitive
    Assert.assertTrue(h1.equals(h2) && h2.equals(h3) && h1.equals(h3));
    // Consistent
    Assert.assertTrue(h1.equals(h2) && h1.equals(h2));

    // Null equality
    Assert.assertFalse(h1.equals(null));
    // Null Address Test
    Assert.assertFalse(h1.equals(nullHeader));
    Assert.assertFalse(nullHeader.equals(h1));
    Assert.assertTrue(nullHeader.equals(anotherNullHeader));
    // Same reference
    Assert.assertTrue(h4.equals(h3));
    // Different class
    Assert.assertFalse(h1.equals("foo"));
  }

  @Test
  public void hashCodeTest() {
    Header h1 = new Header(this.headerLine);
    Header h2 = new Header(this.headerLine);
    Header h3 = new Header(null);
    // Consistent
    Assert.assertEquals(h1.hashCode(), h1.hashCode());
    Assert.assertEquals(h3.hashCode(), h3.hashCode());
    // Equals corollary
    Assert.assertTrue(h1.equals(h2) && (h1.hashCode() == h2.hashCode()));
  }
}
