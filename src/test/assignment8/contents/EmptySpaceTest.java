package neu.ccs.edu.cs5004.seattle.assignment8.contents;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.EmptyLine;

public class EmptySpaceTest {
  EmptyLine el;
  List<EmptyLine> els;

  @Before
  public void setUp() throws Exception {
    this.el = EmptyLine.getInstance();
    this.els = new LinkedList<>();
    this.els.add(this.el);
    this.els.add(this.el);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void getLinesTest() {
    EmptySpace es1 = new EmptySpace(this.els);
    Assert.assertEquals(this.els, es1.getLines());
  }

  @Test
  public void equalsTest() {
    // Duplicate EmptySpacees
    EmptySpace es1 = new EmptySpace(this.els);
    EmptySpace es2 = new EmptySpace(this.els);
    EmptySpace es3 = new EmptySpace(this.els);
    EmptySpace es4 = es3;
    EmptySpace nullEmptySpace = new EmptySpace(null);
    EmptySpace anotherNullEmptySpace = new EmptySpace(null);

    // Reflexive
    Assert.assertTrue(es1.equals(es1));
    // Symmetric
    Assert.assertTrue(es1.equals(es2) && es2.equals(es1));
    // Transitive
    Assert.assertTrue(es1.equals(es2) && es2.equals(es3) && es1.equals(es3));
    // Consistent
    Assert.assertTrue(es1.equals(es2) && es1.equals(es2));

    // Null equality
    Assert.assertFalse(es1.equals(null));
    // Null Address Test
    Assert.assertFalse(es1.equals(nullEmptySpace));
    Assert.assertFalse(nullEmptySpace.equals(es1));
    Assert.assertTrue(nullEmptySpace.equals(anotherNullEmptySpace));
    // Same reference
    Assert.assertTrue(es4.equals(es3));
    // Different class
    Assert.assertFalse(es1.equals("foo"));
  }

  @Test
  public void hashCodeTest() {
    EmptySpace es1 = new EmptySpace(this.els);
    EmptySpace es2 = new EmptySpace(this.els);
    EmptySpace es3 = new EmptySpace(null);
    // Consistent
    Assert.assertEquals(es1.hashCode(), es1.hashCode());
    Assert.assertEquals(es3.hashCode(), es3.hashCode());
    // Equals corollary
    Assert.assertTrue(es1.equals(es2) && (es1.hashCode() == es2.hashCode()));
  }
}
