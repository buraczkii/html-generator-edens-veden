/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.contents;

import java.util.List;

/**
 * @author joshuaveden
 *
 */
public abstract class DocuList extends AbstractContent {

  private final List<ListTuple> mylist;

  /**
   * Given a list of ListTuples, create a DocuList
   *
   * @param mylist the components of the DocuList
   */
  public DocuList(List<ListTuple> mylist) {
    super();
    this.mylist = mylist;
  }

  /**
   * @return mylist, the contents of the DocuList
   */
  public List<ListTuple> getMylist() {
    return this.mylist;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = (prime * result) + ((this.mylist == null) ? 0 : this.mylist.hashCode());
    return result;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!super.equals(obj)) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    DocuList other = (DocuList) obj;
    if (this.mylist == null) {
      if (other.mylist != null) {
        return false;
      }
    } else if (!this.mylist.equals(other.mylist)) {
      return false;
    }
    return true;
  }


}
