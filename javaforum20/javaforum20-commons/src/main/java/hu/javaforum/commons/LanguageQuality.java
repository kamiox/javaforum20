/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.commons;

import hu.javaforum.annotations.PrintField;
import hu.javaforum.services.CommonBean;
import hu.javaforum.util.NullSafe;

/**
 * Holds language and quality value pair, it used in the AcceptLanguage.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * Refactoring (2009-06-12)
 * The first implementation (2008-06-03)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
class LanguageQuality extends CommonBean implements Comparable<LanguageQuality>
{

  /**
   * Serial version UID.
   */
  private static final long serialVersionUID = 1L;
  /**
   * The language.
   */
  @PrintField
  private String language;
  /**
   * The quality.
   */
  @PrintField
  private Double quality;

  /**
   * The constructor.
   *
   * @param language The language
   * @param quality The quality
   */
  public LanguageQuality(final String language, final Double quality)
  {
    this.language = language;
    this.quality = quality;
  }

  /**
   * Gets the value of the language.
   *
   * @return The value
   */
  public final String getLanguage()
  {
    return language;
  }

  /**
   * Sets the value of the language.
   *
   * @param language The new value
   */
  public final void setLanguage(final String language)
  {
    this.language = language;
  }

  /**
   * Gets the value of the quality.
   *
   * @return The value
   */
  public final Double getQuality()
  {
    return quality;
  }

  /**
   * Sets the value of the quality.
   *
   * @param quality The new value
   */
  public final void setQuality(final Double quality)
  {
    this.quality = quality;
  }

  /**
   * Compares two instance by quality.
   *
   * @param other The other instance
   * @return The result
   */
  @Override
  public final int compareTo(final LanguageQuality other)
  {
    if (this.getQuality() != null && other != null && other.getQuality() != null)
    {
      return other.getQuality().compareTo(this.getQuality());
    }

    return 0;
  }

  /**
   * Equals method.
   *
   * @param other The other instance
   * @return True, if the hash code is equals
   */
  @Override
  public final boolean equals(final Object other)
  {
    return other instanceof LanguageQuality && other.hashCode() == this.hashCode();
  }

  /**
   * Generates hashcode to equals method.
   *
   * @return The hashcode
   */
  @Override
  public final int hashCode()
  {
    int hash = HASH_BASE;
    hash = HASH_MULTIPLIER * hash + NullSafe.hashCode(this.language);
    hash = HASH_MULTIPLIER * hash + NullSafe.hashCode(this.quality);
    return hash;
  }
}
