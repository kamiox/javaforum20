/**
 * CC-LGPL 2.1
 * http://creativecommons.org/licenses/LGPL/2.1/
 */
package hu.javaforum.commons;

import hu.javaforum.logger.Logger;
import hu.javaforum.logger.PerfLogger;
import hu.javaforum.logger.PerfTracer;
import hu.javaforum.logger.Tracer;
import hu.javaforum.services.CommonBean;
import hu.javaforum.util.NumberConvert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * This class processes the "Accept-Language" header and returns the
 * selected Locale or the default Locale, if the value of the header
 * is unprocessable or not exists.
 *
 * Changelog:
 * JFPORTAL-94 (2011-07-31)
 * JFPORTAL-94 (2010-02-24)
 * JFPORTAL-79 (2009-09-12)
 * Refactoring (2009-06-18)
 * Refactoring (2008-06-04)
 * The first implementation (2008-05-11)
 *
 * @author Gábor AUTH <auth.gabor@javaforum.hu>
 */
public final class AcceptLanguage extends CommonBean
{

  /**
   * Serial version UID.
   */
  private static final long serialVersionUID = 1L;
  /**
   * The static instance of the logger.
   */
  private static final Logger LOGGER = new Logger(AcceptLanguage.class);
  /**
   * The static trace logger instance.
   */
  private static final Tracer TRACER = new Tracer(AcceptLanguage.class);
  /**
   * The static instance (singleton pattern).
   */
  public static final AcceptLanguage INSTANCE = new AcceptLanguage();

  /**
   * The constructor.
   */
  private AcceptLanguage()
  {
    super();
  }

  /**
   * Processes the acceptLaguages parameter (ex.: 'en;q=0.6, hu-HU;q=0.8, en;q=0.7')
   * and returns the selected Locale which is preferred by the user.
   *
   * @param acceptLanguages The value of the 'Accept-Language' header
   * @return The selected Locale or the default Locale
   */
  public Locale getLocale(final String acceptLanguages)
  {
    PerfTracer tracer = new PerfTracer(TRACER);
    tracer.entry();

    try
    {
      PerfLogger logger = new PerfLogger(LOGGER);

      if (acceptLanguages == null)
      {
        Locale defaultLocale = Locale.getDefault();
        logger.debug("The acceptLanguages is null, returns a default locale '%1$s'", defaultLocale);
        return defaultLocale;
      }

      StringTokenizer tokens = new StringTokenizer(acceptLanguages, ",");
      List<LanguageQuality> languages = new ArrayList<LanguageQuality>();
      while (tokens.hasMoreTokens())
      {
        String language = tokens.nextToken().trim();
        Double quality = 1.0;

        if (language.indexOf(';') > 0)
        {
          String qualityText = language.substring(language.indexOf(';') + 1);
          language = language.substring(0, language.indexOf(';'));

          final int indexOfEquals = qualityText.indexOf('=');
          if (indexOfEquals > 0)
          {
            qualityText = qualityText.substring(indexOfEquals + 1);
            quality = NumberConvert.doubleValue(qualityText);
          }
        }

        if (!"*".equals(language))
        {
          languages.add(new LanguageQuality(language, quality));
        }
      }

      if (languages.isEmpty())
      {
        Locale defaultLocale = Locale.getDefault();
        logger.debug("The list of the languages is empty, returns a default locale '%1$s'", defaultLocale);
        return defaultLocale;
      }

      Collections.sort(languages);
      LanguageQuality ql = languages.get(0);
      String language = ql.getLanguage();
      String country = language;
      int indexOfCountrySeparator = language.indexOf('-');
      if (indexOfCountrySeparator > -1)
      {
        country = language.substring(indexOfCountrySeparator + 1).trim();
        language = language.substring(0, indexOfCountrySeparator).trim();
      }

      Locale locale = new Locale(language, country);
      logger.debug("The selected locale is '%1$s'", locale.toString());

      return locale;
    } finally
    {
      tracer.exit();
    }
  }
}
