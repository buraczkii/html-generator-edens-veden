/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.contents;

import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Line;

/**
 * @author susannaedens
 *
 */
public abstract class AListItem {

  private Line line;

  public AListItem(Line line) {
    super();
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
  public int hashCode() {
    final int prime = 31;
    int result = 1;
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
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    AListItem other = (AListItem) obj;
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
