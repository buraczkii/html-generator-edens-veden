/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.lineAndText;

import java.util.List;

import neu.ccs.edu.cs5004.seattle.assignment8.Visitor;

/**
 * @author joshuaveden
 *
 */
public class PlainText extends Text {

  /**
   * Creates an instance of PlainText
   *
   * @param val the value of the plain text instance
   */
  public PlainText(String val) {
    super(val);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void accept(Visitor formatter, List<String> acc) {
    formatter.visit(this, acc);
  }


}
