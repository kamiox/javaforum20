/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.util;

/**
 * This class is implements some null-safe methods. Only a following methods
 * are implemented:
 * - "compare"
 * - "hashCode"
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-03-14)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public final class NullSafe
{

  /**
   * The static instance (singleton pattern).
   */
  public static final NullSafe INSTANCE = new NullSafe();

  /**
   * The constructor is private, because "all" methods are static.
   */
  private NullSafe()
  {
    super();
  }

  /**
   * Compares the two object.
   *
   * @param object The first object
   * @param other The second object
   * @return The value 0 if the arguments is equals, less than zero if the
   * second argument greater than first argument; and a value greater than zero
   * if the second argument is less than the first argument
   */
  public static int compare(final Comparable object, final Comparable other)
  {
    if (object == null)
    {
      return other == null ? 0 : -1;
    } else
    {
      return other == null ? 1 : object.compareTo(other);
    }
  }

  /**
   * Compares the two object with historical comparison, it useful when
   * more than one compare need in the compareTo method.
   *
   * An example:
   *
   * <code>
   * int result = NullSafeCompare.compare(this, other);
   * result = NullSafeCompare.compare(result, this.field, other.field);
   * ...
   * return result;
   * </code>
   *
   * @param previousResult Previous result
   * @param object The first object
   * @param other The second object
   * @return If the previousResult value is 0: the value 0 if the arguments is
   * equals, less than zero if the second argument greater than first
   * argument; and a value greater than zero if the second argument is less
   * than the first argument. If the previousResult value is not 0 the
   * result value is equals the previousResult value
   */
  public static int compare(final int previousResult, final Comparable object, final Comparable other)
  {
    return previousResult == 0 ? compare(object, other) : previousResult;
  }

  /**
   * Returns with the object's hash code or 0 if the object is null.
   *
   * @param object The object instance
   * @return The hash code
   */
  public static int hashCode(final Object object)
  {
    if (object instanceof Enum)
    {
      return object.toString().hashCode();
    }

    return object == null ? 0 : object.hashCode();
  }
}
