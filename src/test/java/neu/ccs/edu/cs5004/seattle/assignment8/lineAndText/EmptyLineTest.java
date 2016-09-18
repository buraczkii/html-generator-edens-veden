/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.lineAndText;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author joshuaveden
 *
 */
public class EmptyLineTest {

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {}

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {}

  @Test
  public void toStringTest() {
    EmptyLine nel1 = EmptyLine.getInstance();
    Assert.assertEquals("\n", nel1.toString());
  }

  @Test
  public void getMarkTest() {
    EmptyLine nel1 = EmptyLine.getInstance();
    Assert.assertEquals("", nel1.getMark());
  }

  @Test
  public void getTokenTest() {
    EmptyLine nel1 = EmptyLine.getInstance();
    Assert.assertEquals(new LinkedList<Text>(), nel1.getTokens());
  }

  @Test
  public void equalsTest() {
    // Duplicate EmptyLinees
    EmptyLine nel1 = EmptyLine.getInstance();
    EmptyLine nel2 = EmptyLine.getInstance();
    EmptyLine nel3 = EmptyLine.getInstance();
    EmptyLine nel4 = nel3;

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
    // Same reference
    Assert.assertTrue(nel4.equals(nel3));
    // Different class
    Assert.assertFalse(nel1.equals("foo"));
  }

  @Test
  public void hashCodeTest() {
    EmptyLine nel1 = EmptyLine.getInstance();
    EmptyLine nel2 = EmptyLine.getInstance();
    // Consistent
    Assert.assertEquals(nel1.hashCode(), nel1.hashCode());
    // Equals corollary
    Assert.assertTrue(nel1.equals(nel2) && (nel1.hashCode() == nel2.hashCode()));
  }
}
