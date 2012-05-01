/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.commons;

import hu.javaforum.annotations.PrintField;
import hu.javaforum.services.CommonBean;

/**
 * Stores a key-value pair with timestamp.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * JFPORTAL-76 (2009-08-15)
 * JFPORTAL-74 (2009-06-26)
 *
 * @author Auth Gábor <auth.gabor@javaforum.hu>
 */
public class CacheEntry extends CommonBean
{

  /**
   * Serial version UID.
   */
  private static final long serialVersionUID = 1L;
  /**
   * The content.
   */
  @PrintField
  private Object content;
  /**
   * Timestamp.
   */
  @PrintField
  private Long created;
  /**
   * The key.
   */
  @PrintField
  private final Object key;

  /**
   * The constructor.
   *
   * @param key The key
   * @param content The content
   */
  public CacheEntry(final Object key, final Object content)
  {
    if (key == null)
    {
      throw new IllegalArgumentException("The key parameter is null");
    }

    this.created = System.nanoTime();
    this.content = content;
    this.key = key;
  }

  /**
   * Gets the value of the content.
   *
   * @return The value
   */
  public final Object getContent()
  {
    return content;
  }

  /**
   * Sets the value of the content.
   *
   * @param content The new value
   */
  public final void setContent(final Object content)
  {
    this.content = content;
    this.created = System.nanoTime();
  }

  /**
   * Gets the value of the created.
   *
   * @return The value
   */
  public final Long getCreated()
  {
    return created;
  }

  /**
   * Gets the value of the key.
   *
   * @return The value
   */
  public final Object getKey()
  {
    return key;
  }
}
