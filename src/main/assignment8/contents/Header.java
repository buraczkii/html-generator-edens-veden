/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.contents;

import java.util.List;

import neu.ccs.edu.cs5004.seattle.assignment8.HtmlFormatter;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Line;

/**
 * @author joshuaveden
 *
 */
public class Header extends AbstractContent {
  private final Line line;

  /**
   * Creates a Header instance
   *
   * @param line the document line that represents a header
   */
  public Header(Line line) {
    this.line = line;
  }

  /**
   * @return the line
   */
  public Line getLine() {
    return this.line;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void accept(HtmlFormatter formatter, List<String> acc) {
    formatter.visit(this, acc);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = (prime * result) + ((this.line == null) ? 0 : this.line.hashCode());
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!super.equals(obj)) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Header other = (Header) obj;
    if (this.line == null) {
      if (other.line != null) {
        return false;
      }
    } else if (!this.line.equals(other.line)) {
      return false;
    }
    return true;
  }


}
