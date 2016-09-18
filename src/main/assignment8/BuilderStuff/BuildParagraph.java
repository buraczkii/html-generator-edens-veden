/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.BuilderStuff;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import neu.ccs.edu.cs5004.seattle.assignment8.contents.Paragraph;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Line;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Marks;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.NonEmptyLine;

/**
 * @author susannaedens
 *
 */
public class BuildParagraph {

  private ListIterator<Line> itr;
  private static Pattern hePattern = Pattern.compile(Marks.getHeaderMark());
  private static Pattern olPattern = Pattern.compile(Marks.getOrderedListMark());
  private static Pattern ulPattern = Pattern.compile(Marks.getUnorderedListMark());
  private static Pattern elPattern = Pattern.compile(Marks.getEmptyLineMark());

  /**
   * Given an iterator, create a new builder for paragraph. The iterator is what's needed to build a
   * Paragraph.
   *
   * @param itr the iterator for the list of lines of the document
   */
  public BuildParagraph(ListIterator<Line> itr) {
    super();
    this.itr = itr;
  }


  /**
   * Using this iterator, iterate over the list of Lines of the document and collect a list of
   * subsequent paragraph lines. Using this list, create and return a Paragraph.
   *
   * @return a new Paragraph capturing all subsequent paragraph lines from the iterator
   */
  public Paragraph build() {
    // create a list for your paragraph
    LinkedList<NonEmptyLine> pList = new LinkedList<NonEmptyLine>();
    while (this.itr.hasNext()) {
      Line line = this.itr.next();
      Matcher heMatcher = BuildParagraph.hePattern.matcher(line.getMark());
      Matcher olMatcher = BuildParagraph.olPattern.matcher(line.getMark());
      Matcher ulMatcher = BuildParagraph.ulPattern.matcher(line.getMark());
      Matcher elMatcher = BuildParagraph.elPattern.matcher(line.getMark());
      // if you match any other type of content, set the iterator back one and break
      if (elMatcher.find() || ulMatcher.find() || olMatcher.find() || heMatcher.find()) {
        this.itr.previous();
        break;
      } else {
        // you found a paragraph line! add it to the list! You have to create a NonEmptyLine because
        // right now it's just a line
        NonEmptyLine neline = new NonEmptyLine(line.getMark(), line.getTokens());
        pList.add(neline);
      }
    }
    return new Paragraph(pList);
  }


}
