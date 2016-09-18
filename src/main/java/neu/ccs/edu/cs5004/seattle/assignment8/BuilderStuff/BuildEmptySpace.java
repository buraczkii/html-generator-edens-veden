/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.BuilderStuff;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import neu.ccs.edu.cs5004.seattle.assignment8.contents.EmptySpace;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.EmptyLine;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Line;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Marks;

/**
 * @author susannaedens
 *
 */
public class BuildEmptySpace {
  private static Pattern elPattern = Pattern.compile(Marks.getEmptyLineMark());

  private ListIterator<Line> itr;

  /**
   * Given an iterator, create a new builder for emptyspace. The iterator is the object needed to
   * build an EmptySpace.
   *
   * @param itr the iterator for the list of lines of the document
   */
  public BuildEmptySpace(ListIterator<Line> itr) {
    super();
    this.itr = itr;
  }

  /**
   * Using this iterator, iterate over the list of Lines of the document and collect a list of
   * subsequent empty lines. Using this list, create and return an EmptySpace.
   *
   * @return a new EmptySpace capturing all subsequent empty lines from the iterator
   */
  public EmptySpace build() {
    // create a list for your empty lines
    LinkedList<EmptyLine> eList = new LinkedList<EmptyLine>();
    while (this.itr.hasNext()) {
      Line line = this.itr.next();
      Matcher elMatcher = BuildEmptySpace.elPattern.matcher(line.getMark());
      if (elMatcher.find()) {
        // if you match an empty line, add it to the list
        eList.add(EmptyLine.getInstance());
      } else {
        // you found something else, set the iterator back and break
        this.itr.previous();
        break;
      }
    }
    // return your empty space with your accumulated list of empty lines
    return new EmptySpace(eList);
  }



}
