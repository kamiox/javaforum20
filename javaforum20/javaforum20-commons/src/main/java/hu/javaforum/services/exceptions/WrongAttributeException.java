/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.services.exceptions;

/**
 * The wrong attribute exception, it throws when least one parameter is
 * missing or invalid.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * Refactoring (2009-06-14)
 * Refactoring (2008-06-01)
 * The first implementation (2007-12-16)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public class WrongAttributeException extends ServiceRuntimeException
{

  /**
   * Serial version UID.
   */
  private static final long serialVersionUID = -4271644086217287933L;

  /**
   * The default constructor.
   */
  public WrongAttributeException()
  {
    super();
  }

  /**
   * The default constructor with message.
   *
   * @param message The message
   */
  public WrongAttributeException(final String message)
  {
    super(message);
  }

  /**
   * The default constructor with message and cause.
   *
   * @param message The message
   * @param cause The cause
   */
  public WrongAttributeException(final String message, final Throwable cause)
  {
    super(message, cause);
  }
}
