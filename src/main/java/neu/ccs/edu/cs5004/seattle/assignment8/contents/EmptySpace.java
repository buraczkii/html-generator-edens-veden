/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.contents;

import java.util.List;

import neu.ccs.edu.cs5004.seattle.assignment8.HtmlFormatter;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.EmptyLine;

/**
 * @author joshuaveden
 *
 */
public class EmptySpace extends AbstractContent {
  private final List<EmptyLine> lines;

  /**
   * Creates an EmptySpace instance
   *
   * @param lines the document lines of empty space
   */
  public EmptySpace(List<EmptyLine> lines) {
    this.lines = lines;
  }

  /**
   * @return the lines
   */
  public List<EmptyLine> getLines() {
    return this.lines;
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
    result = (prime * result) + ((this.lines == null) ? 0 : this.lines.hashCode());
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
    EmptySpace other = (EmptySpace) obj;
    if (this.lines == null) {
      if (other.lines != null) {
        return false;
      }
    } else if (!this.lines.equals(other.lines)) {
      return false;
    }
    return true;
  }

}
