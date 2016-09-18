/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import neu.ccs.edu.cs5004.seattle.assignment8.BuilderStuff.BuildDocument;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.Content;

/**
 * @author joshuaveden
 */
public class MyProcessor implements TextProcessor {
  private static Integer TXT_EXTENSION = 4;
  private static MyProcessor INSTANCE = null;

  /**
   * Creates an instance of MyProcessor.
   *
   * NOTE: MyProcessor is implemented as a singleton and thus hides its constructor so client cannot
   * create instances
   */
  private MyProcessor() {}

  /**
   * Retrieves the single instance of MyProcessor
   *
   * @return the single instances of MyProcessor
   */
  public static MyProcessor getInstance() {
    if (MyProcessor.INSTANCE == null) {
      MyProcessor.INSTANCE = new MyProcessor();
    }
    return MyProcessor.INSTANCE;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void toHtml(Path filePath)
      throws FileNotFoundException, InvalidFileTypeException, IOException {
    this.validate(filePath);
    BuildDocument myBuilder = new BuildDocument(filePath);
    MyDocument doc = myBuilder.build();
    String fileName = filePath.getFileName().toString();
    // Convert doc into list of strings that will represent the html file
    List<String> html = this.htmlify(fileName, doc);
    // Remove the 4 character extension '.txt'
    String fileNameWithoutExtension =
        fileName.substring(0, fileName.length() - MyProcessor.TXT_EXTENSION);
    // Write all the lines to the html file
    try (BufferedWriter writer =
        Files.newBufferedWriter(Paths.get(fileNameWithoutExtension + ".html"))) {
      for (String line : html) {
        writer.write(line);
        writer.newLine();
      }
    } catch (IOException e) {
      throw e;
    }
  }

  /**
   * Converts the passed doc to a List of String that represents the html file
   *
   * @param fileName name of the file to be formatted
   * @param doc the document to be formatted
   * @return html file as a list of strings
   */
  private List<String> htmlify(String fileName, MyDocument doc) {
    HtmlFormatter formatter = new HtmlFormatter();
    List<String> acc = new LinkedList<>();
    // opening tags
    acc.add("<!DOCTYPE html>");
    acc.add("<html>");
    acc.add("<head>");
    acc.add("<title>" + fileName + "</title>");
    acc.add("</head>");
    acc.add("<body>");
    // meat & potatoes (Visit each content in the list)
    for (Content content : doc.getContents()) {
      content.accept(formatter, acc);
    }
    // closing tags
    acc.add("</body>\n");
    acc.add("</html>\n");
    return acc;
  }


  /**
   * Validates a file path checking for existence and file type. This method specifically checks for
   * a file with a '.txt' extension
   *
   * @param filePath Path to the file to be validated
   * @throws FileNotFoundException thrown if file does not exist on system
   * @throws InvalidFileTypeException thrown if file does not have a '.txt' extension
   */
  protected void validate(Path filePath) throws FileNotFoundException, InvalidFileTypeException {
    FileValidator validator = MyValidator.getInstance();
    // File exists
    if (!validator.fileExists(filePath)) {
      throw new FileNotFoundException();
    }
    // Valid file type
    if (!validator.validFileType(filePath)) {
      throw new InvalidFileTypeException();
    }
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
