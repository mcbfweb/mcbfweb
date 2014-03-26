/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.mainStream;

/**
 *
 * @author anil
 */
public final class VedaConstants {

    // --- Tokens ----
    /**
     * <p> The token representing a "cancel" request. </p>
     */
    public static final String CANCEL = "cancel";
    /**
     * <p> The token representing a "create" task. </p>
     */
    public static final String CREATE = "Create";
    /**
     * <p> The application scope attribute under which our user database is
     * stored. </p>
     */
    public static final String DATABASE_KEY = "database";
    /**
     * <p> The token representing a "edit" task. </p>
     */
    public static final String DELETE = "Delete";
    /**
     * <p> The token representing a "edit" task. </p>
     */
    public static final String EDIT = "Edit";
    /**
     * <p> The session scope attribute under which the Subscription object
     * currently selected by our logged-in User is stored. </p>
     */
    public static final String SUBSCRIPTION_KEY = "subscription";
    /**
     * <p> The session scope attribute under which the User object for the
     * currently logged in user is stored. </p>
     */
    public static final String USER_KEY = "user";
    /**
     * <p>The token representing the "Host" property.
     */
    public static final String HOST = "host";
    // ---- Error Messages ----
    /**
     * <p>
     * A static message in case message resource is not loaded.
     * </p>
     */
    public static final String ERROR_MESSAGES_NOT_LOADED =
            "ERROR:  Message resources not loaded -- check servlet container logs for error messages.";
    /**
     * <P>
     * A "magic" username to trigger an ExpiredPasswordException for testing.
     *</p>
     */
    public static final String EXPIRED_PASSWORD_EXCEPTION = "ExpiredPasswordException";
    /**
     * <p>
     * Name of field to associate with authentification errors.
     * <p>
     */
    public static final String PASSWORD_MISMATCH_FIELD = "password";
    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";

    public static final String MBR_FLG = "member";
}

