package neu.ccs.edu.cs5004.seattle.assignment8.contents;

import java.util.List;

import neu.ccs.edu.cs5004.seattle.assignment8.HtmlFormatter;

public interface Content {
  void accept(HtmlFormatter formatter, List<String> acc);

}
