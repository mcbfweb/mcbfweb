package cl.mainStream;

import java.util.Locale;

/**
 * Implemented by objects that maintain a user's language preference.<br>
 * Classes use a LanguageSelector to retrieve data in the user's preferred language dynamically.
 * 
 * @author brianc
 */
public interface LanguageSelector {

    public static final String ARABIC  = "kh";
    public static final String ENGLISH = "en";

	/**
     * Returns the user's preferred language as a two-character code
     * 
	 * @return the user's preferred language as a two-character code
	 */
    public String getPreferredLanguage();
    
    /**
     * Returns the Locale for the preferred language.
     * 
     * @return The Locale for the preferred language.
     */
    public Locale getPreferredLocale();

}
