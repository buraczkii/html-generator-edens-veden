/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8.contents;

/**
 * @author susannaedens
 *
 */
public class ListTuple {

  private AListItem item;
  private DocuList sublist;

  /**
   * Given a listItem and a sublist, create a ListTuple, effectively capturing a ListItem in a list
   * and it's sublist (empty or not).
   *
   * @param item the listItem of this listTuple
   * @param sublist the sublist of the listItem
   */
  public ListTuple(AListItem item, DocuList sublist) {
    super();
    this.item = item;
    this.sublist = sublist;
  }

  /**
   * @return the item
   */
  public AListItem getItem() {
    return this.item;
  }

  /**
   * @return the sublist
   */
  public DocuList getSublist() {
    return this.sublist;
  }

  /**
   * @return true if the list tuple has a sublist else false
   */
  public Boolean hasSublist() {
    return this.sublist != null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((this.item == null) ? 0 : this.item.hashCode());
    result = (prime * result) + ((this.sublist == null) ? 0 : this.sublist.hashCode());
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
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    ListTuple other = (ListTuple) obj;
    if (this.item == null) {
      if (other.item != null) {
        return false;
      }
    } else if (!this.item.equals(other.item)) {
      return false;
    }
    if (this.sublist == null) {
      if (other.sublist != null) {
        return false;
      }
    } else if (!this.sublist.equals(other.sublist)) {
      return false;
    }
    return true;
  }

}
