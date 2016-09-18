/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * _____VEDENS FORMATTING CO._____
 * Text to HTML formatting service
 *
 * Welcome Client!
 *
 * This program enables you to pass in the name of the file you wish to format and formats the
 * document using proper html syntax, overwriting the original. We will place the appropriate html
 * tags in your document, capturing nested levels of headers and lists, capturing empty lines and
 * paragraphs, and capturing ordered(numbered) and unordered(bulleted) lists.
 *
 * Use the following instructions to provide us with a properly prepared document. If you do, you
 * will get the HTML you want. If not, you might get something funky (like an error message or a
 * messed up document).
 *
 *
 * RE: ORIGINAL FILE FOR FORMATTING
 * 1. A txt file (ending in .txt)
 * 2. A file that is accessible from your computer
 *
 *
 * RE: DOCUMENT MARKINGS
 * 1. Headers are denoted by any number of '#' in a row at the beginning of a
 * line followed by a space. The number of '#' represents the level of nesting. You may skip levels
 * if you wish.
 * ..........Examples:
 * .............# Header at level 1
 * .............### Header at level 3
 *
 * 2. Lists are either ordered(numbered) or unordered(bulleted). Ordered lists are denoted by any
 * number of two spaces("  ") followed by '1.'. A level one ordered list line would have no spaces,
 * level two would have two. Unordered lists are also denoted by quantity of space-pairs but a level
 * one unordered list line would have 2 spaces and level two would have 4, and so on. If you give an
 * odd number of spaces, the list item will be placed on the next higher level of nesting. (7 spaces
 * would act the same as 6 spaces: level 4 nesting for ordered lists and level 3 for unordered).
 *
 * ..........Examples: (I will use dashes to represent spaces for visual purposes)
 * .............1. OrderedList at level 1
 * .............----1. OrderedList at level 3
 * .............--* UnorderedList at level 1
 * .............----* UnorderedList at level 2
 *
 *
 * If you do not follow these instructions, you won't get the product you want. Your headers or
 * lists may not be recognized and numbering may be off, among other things. Thanks for reading!
 *
 * Thanks for using Vedens Services for all your formatting needs!!
 *
 * @author susannaedens
 * @author joshuaveden
 *
 */
public class Main {
  private static final Integer NUM_ARGS = 1;
  private static final String USAGE =
      "Usage:\n" + "      This program accepts one argument, the name of a document to"
          + "be converted to html.\n"
          + "      The file must exists on the system and have a '.txt' extension.\n"
          + "Examples:\n" + "      document.txt";
  private static final String IO_ERR = "\n\n      Error: There was a fatal IO issue";

  /**
   * Hosts the Document Processor program
   *
   * @param args Command Line Arguments
   */
  public static void main(String[] args) {
    try {
      if (args.length != Main.NUM_ARGS) {
        throw new InvalidArgException();
      }
      Path filePath = Paths.get(args[0]);
      TextProcessor processor = MyProcessor.getInstance();
      processor.toHtml(filePath);
    } catch (InvalidArgException | InvalidFileTypeException | FileNotFoundException e) {
      System.out.println(Main.USAGE);
    } catch (IOException e) {
      System.out.println(Main.IO_ERR);
    }
  }

}
