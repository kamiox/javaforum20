/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.enums;

/**
 * Simple enumeration to support the vertical and horizontal movement.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * The first implementation (2009-06-13)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public enum Move
{

  /**
   * Move to up.
   */
  UP,
  /**
   * Move to down.
   */
  DOWN,
  /**
   * Move to top.
   */
  TOP,
  /**
   * Move to bottom.
   */
  BOTTOM,
  /**
   * Move to left.
   */
  LEFT,
  /**
   * Move to right.
   */
  RIGHT,
  /**
   * Move to first.
   */
  FIRST,
  /**
   * Move to last.
   */
  LAST;
}
