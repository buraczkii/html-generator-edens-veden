package neu.ccs.edu.cs5004.seattle.assignment8;

import java.util.List;

import neu.ccs.edu.cs5004.seattle.assignment8.contents.EmptySpace;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.Header;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.OrderedDocuList;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.Paragraph;
import neu.ccs.edu.cs5004.seattle.assignment8.contents.UnorderedDocuList;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.EmphasizedText;
import neu.ccs.edu.cs5004.seattle.assignment8.lineAndText.PlainText;

public interface Visitor {

  void visit(Paragraph paragraph, List<String> acc);

  void visit(Header header, List<String> acc);

  void visit(EmptySpace space, List<String> acc);

  void visit(OrderedDocuList list, List<String> acc);

  void visit(UnorderedDocuList list, List<String> acc);

  void visit(EmphasizedText emph, List<String> acc);

  void visit(PlainText text, List<String> acc);
}
