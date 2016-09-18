/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.contents;

import java.util.List;

import neu.ccs.edu.cs5004.seattle.assignment8.HtmlFormatter;

/**
 * @author joshuaveden
 *
 */
public class OrderedDocuList extends DocuList {

  /**
   * Given a list of ListTuples, create an OrderedDocuList.
   *
   * @param mylist List of List Tuples
   */
  public OrderedDocuList(List<ListTuple> mylist) {
    super(mylist);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void accept(HtmlFormatter formatter, List<String> acc) {
    formatter.visit(this, acc);
  }



}
