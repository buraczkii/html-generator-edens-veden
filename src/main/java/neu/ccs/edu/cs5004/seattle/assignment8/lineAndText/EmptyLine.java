/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.lineAndText;

import java.util.LinkedList;
import java.util.List;

/**
 * @author joshuaveden
 *
 */
public class EmptyLine extends Line {
  private static EmptyLine INSTANCE = null;

  /**
   * Creates an instance of EmptyLine.
   *
   * NOTE: EmptyLine is implemented as a singleton and thus hides its constructor so client cannot
   * create instances
   */
  private EmptyLine() {}

  public static EmptyLine getInstance() {
    if (EmptyLine.INSTANCE == null) {
      EmptyLine.INSTANCE = new EmptyLine();
    }

    return EmptyLine.INSTANCE;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "\n";
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getMark() {
    return "";
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Text> getTokens() {
    return new LinkedList<Text>();
  }
}
