/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.services;

import hu.javaforum.services.exceptions.ServiceException;
import javax.xml.bind.annotation.XmlTransient;

/**
 * The parent of all request.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * First implementation
 *
 * @author Gábor AUTH <gabor.auth@javaforum.hu>
 */
@XmlTransient
public abstract class CommonRequest extends CommonBean
{

  /**
   * A protected constructor.
   */
  protected CommonRequest()
  {
    super();
  }

  /**
   * Validates the bean.
   *
   * @throws ServiceException ServiceException
   */
  public abstract void validate() throws ServiceException;
}
