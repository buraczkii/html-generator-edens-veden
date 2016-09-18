/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.BuilderStuff;

import neu.ccs.edu.cs5004.seattle.assignment8.contents.Header;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Line;

/**
 * @author susannaedens
 *
 */
public class BuildHeader {

  private Line line;

  /**
   * Given a line, create a new BuildHeader that captures the information needed to build a header
   *
   * @param line the line that represents the header
   */
  public BuildHeader(Line line) {
    super();
    this.line = line;
  }

  /**
   * @return a new header containing the line contained in BuildHeader
   */
  public Header build() {
    return new Header(this.line);
  }
}
