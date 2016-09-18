/**
 *
 */
package neu.ccs.edu.cs5004.seattle.assignment8;

import java.util.LinkedList;
import java.util.List;

import neu.ccs.edu.cs5004.seattle.assignment8.contents.Content;

/**
 * @author joshuaveden
 *
 */
public class MyDocument {
  private final List<Content> contents;

  /**
   * Creates an instance of MyDocument
   *
   * @param contents contents of the document
   */
  public MyDocument(List<Content> contents) {
    this.contents = contents;
  }

  public MyDocument() {
    this(new LinkedList<>());
  }

  /**
   * @return the contents
   */
  public List<Content> getContents() {
    return this.contents;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + ((this.contents == null) ? 0 : this.contents.hashCode());
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
    MyDocument other = (MyDocument) obj;
    if (this.contents == null) {
      if (other.contents != null) {
        return false;
      }
    } else if (!this.contents.equals(other.contents)) {
      return false;
    }
    return true;
  }



}
