/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;

/**
 * @author joshuaveden
 */
public interface TextProcessor {
  /**
   * Generates an html file for the file at the location specified by the file path. The Text
   * Processor will handle the tags as specified at the following URL:
   * http://www.ccs.neu.edu/home/skotthe/classes/cs5004/Spring/2016/module6.html
   *
   * PRE:
   *
   * - filePath MUST reference an existing file
   *
   * - filePath MUST reference a .txt file
   *
   * @param filePath Path referencing the file to be conertd to html
   * @throws FileNotFoundException Thrown if filePath does not reference an existing file
   * @throws InvalidFileTypeException Thrown if filePath references a non '.txt' file
   * @throws IOException Thrown if writer or reader has an IO issue
   */
  void toHtml(Path filePath) throws FileNotFoundException, InvalidFileTypeException, IOException;
}
