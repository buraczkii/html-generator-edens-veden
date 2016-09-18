package neu.ccs.edu.cs5004.seattle.assignment8;

import java.util.LinkedList;
import java.util.List;

import neu.ccs.edu.cs5004.seattle.assignment8.contents.EmptySpace;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.Header;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.ListTuple;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.OrderedDocuList;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.OrderedListItem;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.Paragraph;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.UnorderedDocuList;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.UnorderedListItem;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.EmptyLine;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.NonEmptyLine;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.PlainText;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Text;

/**
 *
 */

/**
 * @author joshuaveden
 *
 */
public class TestHarness {
  public static PlainText createPlainText() {
    return new PlainText("plain text");
  }

  public static Paragraph createPlainTextParagraph() {
    PlainText pt = TestHarness.createPlainText();

    List<Text> line1 = new LinkedList<>();
    line1.add(pt);
    line1.add(pt);
    List<Text> line2 = new LinkedList<>();
    line2.add(pt);
    line2.add(pt);

    List<NonEmptyLine> lines = new LinkedList<>();
    lines.add(new NonEmptyLine("", line1));
    lines.add(new NonEmptyLine("", line2));
    return new Paragraph(lines);
  }

  public static Header createHeader(Integer level) {
    PlainText pt = TestHarness.createPlainText();

    // Create a mark
    String mark = "";
    for (int i = 0; i < level; i++) {
      mark += "#";
    }
    mark += " ";

    List<Text> line1 = new LinkedList<>();
    line1.add(pt);

    return new Header(new NonEmptyLine(mark, line1));
  }

  public static EmptySpace createEmptySpace(Integer numSpaces) {
    EmptyLine empty = EmptyLine.getInstance();

    List<EmptyLine> emptyLines = new LinkedList<>();
    for (int i = 0; i < numSpaces; i++) {
      emptyLines.add(empty);
    }

    return new EmptySpace(emptyLines);
  }

  public static UnorderedDocuList createUnorderedList() {
    List<Text> listItemTokens = new LinkedList<>();
    listItemTokens.add(new PlainText("This is a list item"));

    UnorderedListItem uli1 = new UnorderedListItem(new NonEmptyLine("1.", listItemTokens));
    UnorderedListItem uli2 = new UnorderedListItem(new NonEmptyLine("2.", listItemTokens));
    UnorderedListItem uli3 = new UnorderedListItem(new NonEmptyLine("3.", listItemTokens));
    ListTuple listTuple4 = new ListTuple(uli1, null);
    ListTuple listTuple5 = new ListTuple(uli2, null);
    ListTuple listTuple6 = new ListTuple(uli3, null);
    List<ListTuple> tupleList2 = new LinkedList<>();
    tupleList2.add(listTuple4);
    tupleList2.add(listTuple5);
    tupleList2.add(listTuple6);
    UnorderedDocuList udl = new UnorderedDocuList(tupleList2);
    return udl;
  }

  public static OrderedDocuList createOrderedLIst() {
    List<Text> listItemTokens = new LinkedList<>();
    listItemTokens.add(new PlainText("This is a list item"));

    OrderedListItem oli1 = new OrderedListItem(new NonEmptyLine("1.", listItemTokens));
    OrderedListItem oli2 = new OrderedListItem(new NonEmptyLine("2.", listItemTokens));
    OrderedListItem oli3 = new OrderedListItem(new NonEmptyLine("3.", listItemTokens));
    ListTuple listTuple4 = new ListTuple(oli1, null);
    ListTuple listTuple5 = new ListTuple(oli2, null);
    ListTuple listTuple6 = new ListTuple(oli3, null);
    List<ListTuple> tupleList2 = new LinkedList<>();
    tupleList2.add(listTuple4);
    tupleList2.add(listTuple5);
    tupleList2.add(listTuple6);
    OrderedDocuList odl = new OrderedDocuList(tupleList2);
    return odl;
  }
}
