/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author joshuaveden
 *
 */
public class MainTest {

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {}

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {}

  @Test
  public void invalidNumArgsTest() {
    String[] args = {"foo", "bar"};
    Main.main(args);
  }

  @Test
  public void fileDoesNotExistTest() {
    String[] args = {"dne.txt"};
    Main.main(args);
  }

  @Test
  public void invalidFileTypeTest() throws IOException {
    try {
      Files.createFile(Paths.get("invalidType.doc"));
      String[] args = {"invalidType.doc"};
      Main.main(args);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      Files.delete(Paths.get("invalidType.doc"));
    }
  }
}
