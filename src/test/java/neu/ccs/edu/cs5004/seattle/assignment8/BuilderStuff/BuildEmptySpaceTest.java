/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.BuilderStuff;

import java.util.LinkedList;
import java.util.ListIterator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import neu.ccs.edu.cs5004.seattle.assignment8.contents.EmptySpace;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.EmptyLine;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Line;

/**
 * @author susannaedens
 *
 */
public class BuildEmptySpaceTest {
  BuildEmptySpace b1, b2, b3;
  LinkedList<Line> l1, l2, l3;
  LinkedList<EmptyLine> el1, el2, el3;
  EmptySpace e1, e2, e3;
  ListIterator<Line> i1, i2, i3;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    this.l1 = new LinkedList<Line>();
    this.l2 = new LinkedList<Line>();
    this.l3 = new LinkedList<Line>();
    this.el1 = new LinkedList<EmptyLine>();
    this.el2 = new LinkedList<EmptyLine>();
    this.el3 = new LinkedList<EmptyLine>();

    this.el1.add(EmptyLine.getInstance());
    this.el1.add(EmptyLine.getInstance());
    this.el2.add(EmptyLine.getInstance());
    this.el2.add(EmptyLine.getInstance());
    this.el2.add(EmptyLine.getInstance());
    this.el3.add(EmptyLine.getInstance());
    this.el3.add(EmptyLine.getInstance());
    this.el3.add(EmptyLine.getInstance());
    this.el3.add(EmptyLine.getInstance());

    this.l1.addAll(this.el1);
    this.l2.addAll(this.el2);
    this.l3.addAll(this.el3);

    this.i1 = this.l1.listIterator();
    this.i2 = this.l2.listIterator();
    this.i3 = this.l3.listIterator();

    this.b1 = new BuildEmptySpace(this.i1);
    this.b2 = new BuildEmptySpace(this.i2);
    this.b3 = new BuildEmptySpace(this.i3);
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {}

  @Test
  public void testBuild() {
    Assert.assertEquals(this.b1.build(), new EmptySpace(this.el1));
    Assert.assertEquals(this.b2.build(), new EmptySpace(this.el2));
    Assert.assertEquals(this.b3.build(), new EmptySpace(this.el3));

    Assert.assertFalse(this.b2.build().equals(new EmptySpace(this.el1)));
    Assert.assertFalse(this.b3.build().equals(new EmptySpace(this.el2)));
  }

}
