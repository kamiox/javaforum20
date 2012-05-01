/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.util;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/**
 * The ListToEnumeration class creates an enumeration from the list values.
 *
 * Changelog:
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * The first implementation (2009-01-27)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class ListToEnumeration implements Enumeration
{

  /**
   * The iterator.
   */
  private final Iterator listIterator;

  /**
   * The constructor.
   *
   * @param list The list
   */
  public ListToEnumeration(final List list)
  {
    if (list == null)
    {
      this.listIterator = new ArrayList().iterator();
    } else
    {
      this.listIterator = list.iterator();
    }
  }

  /**
   * Gets the hasNext from the iterator.
   *
   * @return True, if has element in the iterator
   */
  @Override
  public final boolean hasMoreElements()
  {
    return listIterator.hasNext();
  }

  /**
   * Gets the next element from the iterator.
   *
   * @return The next element
   */
  @Override
  public final Object nextElement()
  {
    return listIterator.next();
  }
}
