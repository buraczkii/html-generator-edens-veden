/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.BuilderStuff;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.EmphasizedText;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Marks;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.NonEmptyLine;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.PlainText;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Text;

/**
 * @author susannaedens
 *
 */
public class BuildNonEmptyLine {
  private static final Integer MARK_OFFSET = 2;
  private static final Integer OLMARK_OFFSET = 3;
  private static Pattern hePattern = Pattern.compile(Marks.getHeaderMark());
  private static Pattern olPattern = Pattern.compile(Marks.getOrderedListMark());
  private static Pattern ulPattern = Pattern.compile(Marks.getUnorderedListMark());
  private static Pattern emphasizedPat = Pattern.compile(Marks.getEmphasizedMark());
  private static String paMark = "abc";
  private String val;

  /**
   * Creates a new builder for a non-empty line and sets it's val need to build the line.
   *
   * @param val the string need to build a non-empty line
   */
  public BuildNonEmptyLine(String val) {
    this.val = val;
  }

  /**
   * This method works in coordination with BuildDocument in order to return a NonEmptyLine
   * capturing one line of the document.
   *
   * @return a NonEmptyLine
   */
  public NonEmptyLine build() {
    Integer markIndex = getMarkIndex();
    // your mark is set to the beginning of the string up to the markIndex
    String mark = this.val.substring(0, markIndex);
    // if the markIndex is 0, you found a paragraph. We have a constant mark for paragraph
    if (markIndex.equals(0)) {
      mark = BuildNonEmptyLine.paMark;
    }
    // break down the rest of the string that follows the mark
    List<Text> textList = breakDownLine(this.val.substring(markIndex));
    return new NonEmptyLine(mark, textList);
  }

  /**
   * Given a string, return the index of the end of the mark in the string.
   *
   * @return the index of the end of the mark in the string.
   */
  public Integer getMarkIndex() {
    Matcher heMatcher = BuildNonEmptyLine.hePattern.matcher(this.val);
    Matcher olMatcher = BuildNonEmptyLine.olPattern.matcher(this.val);
    Matcher ulMatcher = BuildNonEmptyLine.ulPattern.matcher(this.val);
    // if you find a match, look for the index of the tag and add the appropriate offset to the
    // index to return the index of where the Text starts
    if (heMatcher.find()) {
      Integer index = this.val.indexOf("# ");
      return index + BuildNonEmptyLine.MARK_OFFSET;
    } else if (olMatcher.find()) {
      Integer index = this.val.indexOf("1. ");
      return index + BuildNonEmptyLine.OLMARK_OFFSET;
    } else if (ulMatcher.find()) {
      Integer index = this.val.indexOf("* ");
      return index + BuildNonEmptyLine.MARK_OFFSET;
    } else {
      // you didn't find a match, so your Text starts at index 0
      return 0;
    }
  }

  /**
   * Given a string, split the string into substrings based on the presence/absence of specific
   * inline marks. These substrings become Text where Text is PlainText of EmphasizedText.
   *
   * @param s the string to analyze
   * @return a List of Text capturing the substrings of the given string
   */
  public List<Text> breakDownLine(String s) {
    // create your list of text
    LinkedList<Text> myText = new LinkedList<Text>();
    // if your string is not empty, look for your marks
    while (!s.isEmpty()) {
      Matcher emphasizedMat = BuildNonEmptyLine.emphasizedPat.matcher(s);
      if (emphasizedMat.find()) {
        // if you find a mark, up to that mark is your first piece of plainText
        String start = s.substring(0, emphasizedMat.start());
        PlainText p = new PlainText(start);
        // remove the marks from the marked text you found and that becomes emphasizedText
        String emph = removeInlineMarks(emphasizedMat.group());
        EmphasizedText e = new EmphasizedText(emph);
        // add them both to the list
        myText.add(p);
        myText.add(e);
        // s is set to whatever comes after the piece of emphasizedText you removed
        s = s.substring(emphasizedMat.end());
      } else {
        // you didn't find any marks? It's all plainText then!!
        PlainText p = new PlainText(s);
        myText.add(p);
        break;
      }
    }
    return myText;
  }

  /**
   * Given a string, remove the first and last character
   *
   * @param s the string to format
   * @return the string without the first and last character
   */
  public String removeInlineMarks(String s) {
    return s.substring(1, s.length() - 1);
  }
}
