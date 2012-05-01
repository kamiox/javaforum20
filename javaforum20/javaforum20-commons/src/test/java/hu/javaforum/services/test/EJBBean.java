/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.services.test;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Test EJB class for the ServiceLocator's tests.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * First implementation (2011-07-30)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
@Remote
@Stateless(mappedName = "hu.javaforum.services.test.EJBBeanRemote")
public class EJBBean implements EJBBeanRemote
{

  /**
   * Simple echo-reply method.
   *
   * @param text The text
   * @return The text as echo
   */
  public final String echo(final String text)
  {
    return text;
  }
}
