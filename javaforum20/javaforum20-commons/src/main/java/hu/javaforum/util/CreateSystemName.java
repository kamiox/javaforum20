/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.util;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * The CreateSystemName class provides one method to convert any text
 * to URL conform text without '%nn' entities, because the deaccented
 * characters and/or the '_' signs are more readable by human eyes.
 *
 * At this time only the Hungarian accents are converted to deaccented
 * form!
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * Refactoring (2009-06-12)
 * Refactoring (2008-05-31)
 * The first implementation (2007-12-16)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public final class CreateSystemName
{

  /**
   * The static instance (singleton pattern).
   */
  public static final CreateSystemName INSTANCE = new CreateSystemName();
  /**
   * The allowed characters (entities) in the URL.
   */
  private static final String ALLOWED_HTML_ENTITIES = "abcdefghijklmnopqrstuvwxyz0123456789";
  /**
   * The deaccent map will be filled up in the static constructor.
   */
  private static final Map<String, String> DEACCENT_MAP = new HashMap<String, String>();

  static
  {
    /**
     * The hungarian accents
     */
    DEACCENT_MAP.put("á", "a");
    DEACCENT_MAP.put("é", "e");
    DEACCENT_MAP.put("í", "i");
    DEACCENT_MAP.put("ó", "o");
    DEACCENT_MAP.put("ö", "o");
    DEACCENT_MAP.put("ő", "o");
    DEACCENT_MAP.put("ú", "u");
    DEACCENT_MAP.put("ü", "u");
    DEACCENT_MAP.put("ű", "u");
  }

  /**
   * The private constructor, because "all" methods are static.
   */
  private CreateSystemName()
  {
    super();
  }

  /**
   * This method converts the source text to URL conform text.
   * All characters which are not in the allowed characters and not in
   * the deaccent map will be converted to '_' sign. The length of source
   * and the result text is equal.
   *
   * @param text The source text
   * @return The result text
   */
  public static String toDeAccent(final String text)
  {
    StringBuilder source = new StringBuilder(text.toLowerCase(Locale.getDefault()));
    StringBuilder sb = new StringBuilder(source.length());

    for (int count = 0; count < source.length(); count++)
    {
      CharSequence charSequence = source.subSequence(count, count + 1);
      if (ALLOWED_HTML_ENTITIES.contains(charSequence))
      {
        sb.append(charSequence);
      } else if (DEACCENT_MAP.containsKey(charSequence.toString()))
      {
        sb.append(DEACCENT_MAP.get(charSequence.toString()));
      } else
      {
        sb.append("_");
      }
    }

    return sb.toString();
  }
}
