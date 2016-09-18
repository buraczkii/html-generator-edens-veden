/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.BuilderStuff;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import neu.ccs.edu.cs5004.seattle.assignment8.contents.AListItem;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.ListTuple;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.OrderedDocuList;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Line;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Marks;

/**
 * @author susannaedens
 *
 */
public class BuildListTuple {
  private static Pattern olPattern = Pattern.compile(Marks.getOrderedListMark());
  private static Pattern ulPattern = Pattern.compile(Marks.getUnorderedListMark());

  private AListItem listItem;
  private ListIterator<Line> itr;
  private Integer level;

  /**
   * Given a listItem, an iterator, and a nesting level, create a new builder for ListTuple.
   *
   * @param listItem the line representing the listitem for this Tuple
   * @param itr the iterator for the list of lines of the document
   * @param level the nesting level of the given listItem
   */
  public BuildListTuple(AListItem listItem, ListIterator<Line> itr, Integer level) {
    super();
    this.listItem = listItem;
    this.itr = itr;
    this.level = level;
  }

  /**
   * Using this line, this iterator, and this line's nesting level, create a new ListTuple and set
   * it's listItem to the given ListItem. Using the iterator and the nesting level, generate the
   * necessary sublist for this Tuple. The sublist will only contain subsequent ListItems that are
   * of a deeper nesting level.
   *
   * @return a ListTuple using the fields of BuildListTuple
   */
  public ListTuple build() {
    while (this.itr.hasNext()) {
      Line line = this.itr.next();
      Matcher olMatcher = BuildListTuple.olPattern.matcher(line.getMark());
      Matcher ulMatcher = BuildListTuple.ulPattern.matcher(line.getMark());
      if (olMatcher.find()) {
        // if you find an orderedlist item that is a deeper nesting level, build an ordered list
        if (Marks.getOrderedListLevel(line.getMark()) > this.level) {
          BuildOrderedList bOrdList = new BuildOrderedList(line, this.itr);
          return new ListTuple(this.listItem, bOrdList.build());
        } else {
          // if it's the same level or higher, set the iterator back and break
          this.itr.previous();
          break;
        }
      } else if (ulMatcher.find()) {
        // if you find an unorderedlist item that is a deeper nesting level, build an unordered list
        if (Marks.getUnorderedListLevel(line.getMark()) > this.level) {
          BuildUnorderedList bUnordList = new BuildUnorderedList(line, this.itr);
          return new ListTuple(this.listItem, bUnordList.build());
        } else {
          // if it's the same level or higher, set the iterator back and break
          this.itr.previous();
          break;
        }
      } else {
        // you didn't find any list marks, set the iterator back and break
        this.itr.previous();
        break;
      }
    }
    // if the iterator is empty, return the tuple with an empty sublist
    return new ListTuple(this.listItem, new OrderedDocuList(new LinkedList<ListTuple>()));
  }


}
