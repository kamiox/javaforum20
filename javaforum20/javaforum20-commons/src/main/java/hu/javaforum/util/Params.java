/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.util;

import java.util.HashMap;

/**
 * The Params class holds a simple String-String key-value pairs.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * Refactoring (2009-06-13)
 * The first implementation (2007-10-09)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class Params extends HashMap<String, String>
{

  /**
   * Serial version UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * The default constructor.
   */
  public Params()
  {
    super();
  }
}
