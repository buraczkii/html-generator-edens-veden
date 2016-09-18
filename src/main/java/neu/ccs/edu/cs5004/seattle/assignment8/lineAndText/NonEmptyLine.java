/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.lineAndText;

import java.util.List;

/**
 * @author joshuaveden
 *
 */
public class NonEmptyLine extends Line {
  private String mark;
  private List<Text> tokens;


  /**
   * Creates a NonEmptyLine
   *
   * @param mark mark prepending the rest of the stirng
   * @param tokens list of Text tokens that comprise a line
   */
  public NonEmptyLine(String mark, List<Text> tokens) {
    this.mark = mark;
    this.tokens = tokens;
  }

  /**
   * @return the mark
   */
  @Override
  public String getMark() {
    return this.mark;
  }

  /**
   * @return the tokens
   */
  @Override
  public List<Text> getTokens() {
    return this.tokens;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = (prime * result) + ((this.mark == null) ? 0 : this.mark.hashCode());
    result = (prime * result) + ((this.tokens == null) ? 0 : this.tokens.hashCode());
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
    NonEmptyLine other = (NonEmptyLine) obj;
    if (this.mark == null) {
      if (other.mark != null) {
        return false;
      }
    } else if (!this.mark.equals(other.mark)) {
      return false;
    }
    if (this.tokens == null) {
      if (other.tokens != null) {
        return false;
      }
    } else if (!this.tokens.equals(other.tokens)) {
      return false;
    }
    return true;
  }


}
