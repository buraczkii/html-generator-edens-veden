package neu.ccs.edu.cs5004.seattle.assignment8;

import java.nio.file.Path;

public interface FileValidator {
  /**
   * Determines if the file path references an existing file
   *
   * @param filePath Path to a file
   * @return true if the file exists else false
   */
  Boolean fileExists(Path filePath);

  /**
   * Determines if the file has a valid file extension. The following extensions are valid:
   *
   * - '.txt'
   *
   * @param filePath Path to a file
   * @return true if the file has '.txt' extension else false
   */
  Boolean validFileType(Path filePath);
}
