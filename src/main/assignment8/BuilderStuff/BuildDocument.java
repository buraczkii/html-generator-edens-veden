package neu.ccs.edu.cs5004.seattle.assignment8.BuilderStuff;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import neu.ccs.edu.cs5004.seattle.assignment8.MyDocument;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.Content;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.EmptyLine;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Line;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.Marks;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.NonEmptyLine;

/**
 * @author susannaedens
 */
public class BuildDocument {
  private static Pattern hePattern = Pattern.compile(Marks.getHeaderMark());
  private static Pattern olPattern = Pattern.compile(Marks.getOrderedListMark());
  private static Pattern ulPattern = Pattern.compile(Marks.getUnorderedListMark());
  private static Pattern elPattern = Pattern.compile(Marks.getEmptyLineMark());

  private Path myPath;

  /**
   * Given a path, create a new BuildDocument containing the methods needed to build MyDocument.
   *
   * @param myPath the path of the document to be builded
   */
  public BuildDocument(Path myPath) {
    super();
    this.myPath = myPath;
  }


  /**
   * Based on BuildDocument's file, this method will read the file and generate a MyDocument
   * representing all components of the file in a beautiful succinct manner.
   *
   * @return a MyDocument
   * @throws IOException if the reader fails
   */
  public MyDocument build() throws IOException {
    // generate a list of lines using this path
    List<Line> lineList = generateLineList();
    // using the lineList to build a list of content
    List<Content> contentList = buildContentList(lineList);
    // return a Document containing your list of content
    return new MyDocument(contentList);
  }


  /**
   * Given a file, read each line of the file. Depending on the type of line (empty or non-empty),
   * create an EmptyLine or a NonEmptyLine and them to the List of Lines. Then, return the list.
   *
   * @return a List of Lines that represent the given file
   * @throws IOException if the reader fails
   */
  public List<Line> generateLineList() throws IOException {
    // create a new list for your list of lines
    LinkedList<Line> lineList = new LinkedList<Line>();
    try (BufferedReader reader = Files.newBufferedReader(this.myPath)) {
      String s;
      while ((s = reader.readLine()) != null) {
        Matcher emptyLineMat = BuildDocument.elPattern.matcher(s);
        // if you find an empty line, grab an instance of it and add it to the list
        if (emptyLineMat.find()) {
          EmptyLine eline = EmptyLine.getInstance();
          lineList.add(eline);
        } else {
          // send the string to the builder to build a NonEmptyLine and add it to the list
          BuildNonEmptyLine bline = new BuildNonEmptyLine(s);
          NonEmptyLine neline = bline.build();
          lineList.add(neline);
        }
      }
    } catch (IOException e) {
      System.out.println("Error: IO Exception:" + e);
    }
    // return your list of lines if you manage to get out of the try block!
    return lineList;
  }

  /**
   * Given a list of lines, generate a list of Content based on the markings present on that line.
   *
   * @param lineList the list of lines representing each line in the document
   * @return a list of Content representing the different contents of the document
   */
  public List<Content> buildContentList(List<Line> lineList) {
    // create a list of content for your document
    LinkedList<Content> myList = new LinkedList<Content>();
    // create a list iterator for the given list
    ListIterator<Line> itr = lineList.listIterator();
    while (itr.hasNext()) {
      Line line = itr.next();
      Matcher heMatcher = BuildDocument.hePattern.matcher(line.getMark());
      Matcher olMatcher = BuildDocument.olPattern.matcher(line.getMark());
      Matcher ulMatcher = BuildDocument.ulPattern.matcher(line.getMark());
      Matcher elMatcher = BuildDocument.elPattern.matcher(line.getMark());
      // if you find a header, build a header and add it to the content list
      if (heMatcher.find()) {
        BuildHeader bheader = new BuildHeader(line);
        myList.add(bheader.build());
      }
      // if you find an empty line, build an EmptySpace and add it to the content list
      else if (elMatcher.find()) {
        // set the iterator back so when you send it to the builder, it has that line
        itr.previous();
        BuildEmptySpace bempty = new BuildEmptySpace(itr);
        myList.add(bempty.build());
      }
      // if you find an ordered list item, build an OrderedList and add it to the content list
      else if (olMatcher.find()) {
        BuildOrderedList bOrdList = new BuildOrderedList(line, itr);
        myList.add(bOrdList.build());
      }
      // if you find an unordered list item, build an UnorderedList and add it to the content list
      else if (ulMatcher.find()) {
        BuildUnorderedList bUnordList = new BuildUnorderedList(line, itr);
        myList.add(bUnordList.build());
      }
      // you got nothing left but paragraph lines! Build a paragraph
      else {
        // set the iterator back so when you pass it, it has the paragraph line
        itr.previous();
        BuildParagraph bpara = new BuildParagraph(itr);
        myList.add(bpara.build());
      }
    }
    return myList;
  }


}
