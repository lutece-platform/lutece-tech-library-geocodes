package fr.paris.lutece.plugins.geocode.v1.web.rs.util;

public class Constants {
	
	public static final String PROPERTY_APPLICATION_VERSION = "identitystore.version";
    public static final String VERSION_PATH_V1 = "/v1";
    public static final String CITIES_PATH = "/cities";
    public static final String LIST_PATH = "/list";
    public static final String COUNTRIES_PATH = "/countries";
    public static final String SEARCH_PATH = "/search";
    public static final String DOWNLOAD_FILE_PATH = "/file";
    public static final String UPDATE_IDENTITY_PATH = "/update";
    public static final String CREATE_IDENTITY_PATH = "/create";
    public static final String CERTIFY_ATTRIBUTES_PATH = "/certify";
    public static final String PARAM_ID_CONNECTION = "connection_id";
    public static final String PARAM_ID_CUSTOMER = "customer_id";
    public static final String PARAM_CLIENT_CODE = "client_code";
    public static final String PARAM_CERTIFIER_CODE = "certifier_code";
    public static final String PARAM_FILE = "file";
    public static final String PARAM_ATTRIBUTE_KEY = "attribute_key";
    public static final String PARAM_DATE_VALIDITY = "dateref";
    public static final String PARAM_RESULT = "result";
    public static final String PARAM_SEARCH_NAME_CITY = "search";
    public static final String PLUGIN_PATH = "identitystore";
    public static final String RESPONSE_OK = "OK";
    public static final String PARAM_IDENTITY_CHANGE = "identityChange";
    public static final String ERROR_FIELD_MISSING = "FIELD_MISSING";
    public static final String ERROR_FIELD_PERMISSION = "FIELD_PERMISION_ERROR";
    public static final String PARAMETER_NAME = "name";

    /** The Constant CONTENT_FORMAT. */
    public static final String CONTENT_FORMAT_CHARSET = "application/json; charset=utf-8";

    // HTTP ERROR MESSAGE
    public static final String ERROR_MESSAGE = "Failed : HTTP error code : ";
    public static final String NO_CUSTOMER_ID = "";

    /**
     * Default constructor
     */
    private Constants( )
    {
    }

}
