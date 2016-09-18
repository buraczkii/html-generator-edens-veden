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
public class EmphasizedText extends Text {

  /**
   * Creates an instance of EmphasizedText
   *
   * @param val the value of the EmphasizedText instance
   */
  public EmphasizedText(String val) {
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
