/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author joshuaveden
 *
 */
public class MyValidator implements FileValidator {
  private static MyValidator INSTANCE = null;

  /**
   * Creates an instance of MyValidator.
   *
   * NOTE: MyValidator is implemented as a singleton and thus hides its constructor so client cannot
   * create instances
   */
  private MyValidator() {}

  /**
   * Retrieves the single instance of MyValidator
   *
   * @return the single instances of MyValidator
   */
  public static MyValidator getInstance() {
    if (MyValidator.INSTANCE == null) {
      MyValidator.INSTANCE = new MyValidator();
    }

    return MyValidator.INSTANCE;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean fileExists(Path filePath) {
    return Files.exists(filePath);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Boolean validFileType(Path filePath) {
    String validExtension = ".txt";
    String fileName = filePath.getFileName().toString();
    // Grab the substring from the fileName that should be our valid file extension
    String extension = fileName.substring(fileName.length() - validExtension.length());

    return extension.equals(validExtension);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return 42;
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
    return true;
  }
}
