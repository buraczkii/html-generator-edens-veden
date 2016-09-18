/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.BuilderStuff;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import neu.ccs.edu.cs5004.seattle.assignment8.contents.Header;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.EmphasizedText;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.NonEmptyLine;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.PlainText;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Text;

/**
 * @author susannaedens
 *
 */
public class BuildHeaderTest {

  BuildHeader b1, b2, b3;
  NonEmptyLine n1, n2, n3;
  LinkedList<Text> l1, l2, l3;
  Text t1, t2, t3, t4;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    this.t1 = new PlainText("this is text");
    this.t2 = new PlainText("this is also");
    this.t3 = new EmphasizedText("this is emphasized text");
    this.t4 = new EmphasizedText("this is also emphasized text");

    this.l1 = new LinkedList<Text>();
    this.l2 = new LinkedList<Text>();
    this.l3 = new LinkedList<Text>();

    this.l1.add(this.t1);
    this.l2.add(this.t2);
    this.l2.add(this.t4);
    this.l3.add(this.t1);
    this.l3.add(this.t2);
    this.l3.add(this.t3);
    this.l3.add(this.t4);

    this.n1 = new NonEmptyLine("# ", this.l1);
    this.n2 = new NonEmptyLine("## ", this.l2);
    this.n3 = new NonEmptyLine("### ", this.l3);

    this.b1 = new BuildHeader(this.n1);
    this.b2 = new BuildHeader(this.n2);
    this.b3 = new BuildHeader(this.n3);
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {}


  @Test
  public void testBuild() {
    Assert.assertEquals(this.b1.build(), new Header(this.n1));
    Assert.assertEquals(this.b2.build(), new Header(this.n2));
    Assert.assertEquals(this.b3.build(), new Header(this.n3));

    Assert.assertFalse(this.b2.build().equals(new Header(this.n3)));
    Assert.assertFalse(this.b3.build().equals(new Header(this.n1)));
  }

}
