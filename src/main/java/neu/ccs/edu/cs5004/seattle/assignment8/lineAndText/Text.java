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
public abstract class Text {
  private final String val;

  /**
   * Creates a Text instance
   *
   * @param val the value of the text instance
   */
  public Text(String val) {
    this.val = val;
  }

  /**
   * @return the val
   */
  public String getVal() {
    return this.val;
  }

  public abstract void accept(Visitor formatter, List<String> acc);

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((this.val == null) ? 0 : this.val.hashCode());
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
    Text other = (Text) obj;
    if (this.val == null) {
      if (other.val != null) {
        return false;
      }
    } else if (!this.val.equals(other.val)) {
      return false;
    }
    return true;
  }
}
