/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8;

import java.util.LinkedList;
import java.util.List;

import neu.ccs.edu.cs5004.seattle.assignment8.contents.EmptySpace;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.Header;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.ListTuple;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.OrderedDocuList;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.Paragraph;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.UnorderedDocuList;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.EmphasizedText;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Line;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.PlainText;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Text;

/**
 * @author joshuaveden
 *
 */
public class HtmlFormatter implements Visitor {
  private static final String PARA_OPEN_TAG = "<p>";
  private static final String PARA_CLOSE_TAG = "</p>";
  private static final String EMPH_OPEN_TAG = "<b>";
  private static final String EMPH_CLOSE_TAG = "</b>";
  private static final String OL_OPEN_TAG = "<ol>";
  private static final String OL_CLOSE_TAG = "</ol>";
  private static final String UL_OPEN_TAG = "<ul>";
  private static final String UL_CLOSE_TAG = "</ul>";
  private static final String LI_OPEN_TAG = "<li>";
  private static final String LI_CLOSE_TAG = "</li>";
  private static final Integer MAX_HEADER_LEVEL = 6;

  /**
   * {@inheritDoc}
   */
  @Override
  public void visit(Paragraph paragraph, List<String> lineAcc) {
    // Add opening paragraph tag
    lineAcc.add(HtmlFormatter.PARA_OPEN_TAG);

    // Format the paragraph lines
    for (Line line : paragraph.getLines()) {
      lineAcc.add(formatLine(line));
    }

    // Add closing paragraph tag
    lineAcc.add(HtmlFormatter.PARA_CLOSE_TAG);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void visit(Header header, List<String> lineAcc) {
    String mark = header.getLine().getMark();
    Integer headerLevel = mark.length() - 1;
    String openTag = "";
    String closeTag = "";

    if (headerLevel > HtmlFormatter.MAX_HEADER_LEVEL) {
      openTag = "<h" + HtmlFormatter.MAX_HEADER_LEVEL + ">";
      closeTag = "</h" + HtmlFormatter.MAX_HEADER_LEVEL + ">";
    } else {
      openTag = "<h" + headerLevel + ">";
      closeTag = "</h" + headerLevel + ">";
    }

    // Build header string and add to line accumulator
    openTag += formatLine(header.getLine());
    openTag += closeTag;
    lineAcc.add(openTag);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void visit(EmptySpace space, List<String> lineAcc) {
    // Trivial formatting for empty space (i.e. just add its toString representation)
    for (int i = 0; i < space.getLines().size(); i++) {
      lineAcc.add("");
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void visit(OrderedDocuList list, List<String> lineAcc) {
    // Add ordered list open tag
    lineAcc.add(HtmlFormatter.OL_OPEN_TAG);

    // Format the list of ListTuples
    formatTuples(list.getMylist(), lineAcc);

    // Add ordered list closing tag
    lineAcc.add(HtmlFormatter.OL_CLOSE_TAG);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void visit(UnorderedDocuList list, List<String> lineAcc) {
    // Add unordered list open tag
    lineAcc.add(HtmlFormatter.UL_OPEN_TAG);

    // Format the list of ListTuples
    formatTuples(list.getMylist(), lineAcc);

    // Add unordered list closing tag
    lineAcc.add(HtmlFormatter.UL_CLOSE_TAG);

  }

  /**
   * Applies html tags to all ListTuple's list item and its sublist. These tagged lines are
   * accumulated using the lineAcc
   *
   * @param tuples List of line items and their sublist
   * @param lineAcc accumulator for html formatted lines
   */
  private void formatTuples(List<ListTuple> tuples, List<String> lineAcc) {
    for (ListTuple tuple : tuples) {
      // Build line item string
      String lineItem = HtmlFormatter.LI_OPEN_TAG;
      lineItem += formatLine(tuple.getItem().getLine());

      // Recursively format any potential sublists
      if (tuple.hasSublist()) {
        // Add the line item line to the line accumulator
        lineAcc.add(lineItem);
        // Format the sublist
        tuple.getSublist().accept(this, lineAcc);
        // Add the closing line item tag after the sublist
        lineAcc.add(HtmlFormatter.LI_CLOSE_TAG);
      } else {
        // Append the closing line item tag to the line
        lineItem += HtmlFormatter.LI_CLOSE_TAG;
        // Add line item line to the line accumulator
        lineAcc.add(lineItem);
      }
    }
  }

  /**
   * Applies inline html tags to a line and adds it to the line accumulator
   *
   * @param line Line that will be formatted for inline html
   * @param lineAcc accumulator for html formatted lines
   */
  private String formatLine(Line line) {
    // Accumulator for format line tokens
    List<String> tokenAcc = new LinkedList<>();

    // Format tokens in the line
    for (Text token : line.getTokens()) {
      token.accept(this, tokenAcc);
    }

    // Concatenate all tokens together
    String str = "";
    for (String token : tokenAcc) {
      str += token;
    }

    return str;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void visit(EmphasizedText emph, List<String> tokenAcc) {
    // Add open emphasis tag to token accumulator
    tokenAcc.add(HtmlFormatter.EMPH_OPEN_TAG);
    // Add text to the token accumulator
    tokenAcc.add(emph.getVal());
    // Add closing emphasis tag to token accumulator
    tokenAcc.add(HtmlFormatter.EMPH_CLOSE_TAG);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void visit(PlainText text, List<String> tokenAcc) {
    // Add the text to the token accumulator
    tokenAcc.add(text.getVal());
  }

}
