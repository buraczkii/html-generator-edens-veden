/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.lineAndText;

/**
 * @author susannaedens
 *
 */
public class Marks {
  /**
   * Given an integer representing the level of nesting (1 for base level, 2 for within base level,
   * etc.), return the mark string that OrderedListItems should have on that level of nesting
   *
   * @param level the level of nesting of the ordered listItem
   * @return the appropriate mark string according to nesting level
   */
  public static String getOrderedListMark(Integer level) {
    return "^[\" \"]{0," + (level * 2) + "}[1][\\.][\\s].*";
  }

  /**
   * @return the generic mark string for ordered lists
   */
  public static String getOrderedListMark() {
    return "^([\\s]{2})*[1][\\.][\\s].*";
  }

  /**
   * Given a string representing a ordered list's mark, return the nesting level of the ordered
   * list item. A nesting level of an ordered list's mark is represented by any number of a pair
   * spaces and then "1.". Zero spaces indicate 1st level nesting, two spaces indicate 2nd, and so
   * on.
   *
   * @param s the string to analyze
   * @return the nesting level of the ordered list item
   */
  public static Integer getOrderedListLevel(String s) {
    Integer index = s.indexOf("1.");
    if (index.equals(-1)) {
      return 0;
    }
    return (index / 2) + 1;
  }


  /**
   * Given an integer representing the level of nesting (1 for base level, 2 for within base level,
   * etc.), return the mark string that UnorderedListItems should have on that level of nesting
   *
   * @param level the level of nesting of the unordered listItem
   * @return the appropriate mark string according to nesting level
   */
  public static String getUnorderedListMark(Integer level) {
    return "^([\\s]{2}){1," + (level) + "}[*].*";
  }

  /**
   * @return the generic mark string for unordered lists
   */
  public static String getUnorderedListMark() {
    return "^([\\s]{2})+[*][\\s].*";
  }


  /**
   * Given a string representing a unordered list's mark, return the nesting level of the unordered
   * list item. A nesting level of an unordered list's mark is represented by any number of a pair
   * spaces and then an asterisk. Two spaces indicate 1st level nesting, four spaces indicate 2nd,
   * and so on.
   *
   * @param s the string to analyze
   * @return the nesting level of the unordered list item
   */
  public static Integer getUnorderedListLevel(String s) {
    Integer index = s.indexOf("  * ");
    if (index.equals(-1)) {
      return 0;
    }
    return (index / 2) + 1;
  }


  /**
   * Given an integer representing the level of nesting, return the mark string that Headers should
   * have on that level of nesting
   *
   * @param level the level of nesting of the header
   * @return the appropriate mark string according to nesting level
   */
  public static String getHeaderMark(Integer level) {
    return "^[#]{1," + (level) + "}[\" \"*].*";
  }

  /**
   * @return the generic mark string for Headers
   */
  public static String getHeaderMark() {
    return "^[#]+[\" \"*].*";
  }


  /**
   * Given a string representing a header's mark, return the nesting level of the header
   *
   * @param s the string to analyze
   * @return the number of header marks indicating the nesting level
   */
  public static Integer getHeaderLevel(String s) {
    Integer index = s.indexOf("# ");
    return index + 1;
  }



  /**
   * @return the appropriate string for a ParagraphLine mark
   */
  public static String getParagraphMark() {
    return "^[^#1*].*";
  }

  /**
   * @return the appropriate string for an EmptyLine mark
   */
  public static String getEmptyLineMark() {
    return "^\\s*$";
  }


  /**
   * @return the appropriate string for an Emphasized mark
   */
  public static String getEmphasizedMark() {
    return "[*][^\\s].*?[^\\s][*]";
  }

}
