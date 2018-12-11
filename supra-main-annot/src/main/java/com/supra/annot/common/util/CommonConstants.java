package com.supra.annot.common.util;



public final class CommonConstants {
	
	public static final int LANG_AR = 1;
	public static final int LANG_EN = 2;
	public static final String LANG_ID = "langId";
	
    public static final String LATITUDE="latitude";
    public static final String LONGITUDE="longitude";
    public static final String REFERENCE_ID="referenceId";
    public static final String REFERENCE_NO="referenceNo";
    public static final String EMIRATES_ID="emiratesId";
    public static final String EMAIL = "email"; 
    
    public static final String STR_ZERO ="0";
    public static final String STR_ONE ="1";
    public static final String STR_TWO ="2";
    public static final String STR_QUESTION_MARK ="?";
    
    public static final int INT_ZERO_NO = 0;
    public static final int INT_ONE_YES = 1;
    
    public static final int INT_ZERO = 0;
    public static final int INT_ONE = 1;
    public static final int INT_TWO = 2;
    public static final int CUSTOMER_TYPE_RESIDENT = 1;
    public static final int CUSTOMER_TYPE_VISITOR = 2;
    public static final int INT_THREE = 3;
    
    public static final long LONG_ZERO = 0L;
    public static final long LONG_100 = 100L;
    public static final long LONG_200 = 200L;
    public static final long LONG_300 = 300L;
    public static final long LONG_400 = 400L;
    public static final long LONG_500 = 500L;
    
    public static final String RESULT = "result";
    public static final String RESPONSE_CODE="responseCode";
    public static final String RESPONSE_DESC="responseDesc";
    

    public static final String STR_1000=   "1000";
    public static final String STR_2000=   "2000";
    

    
    public static final String CHARSET_UTF8 = ";charset=" + "UTF-8";
    public static final String UTF8 = "UTF-8";
    
    
    
    /**
     * dd/MM/yyyy
     * */
    public static final String DATE_ddMMyyyy = "dd/MM/yyyy";
    
    /**
     * yyyyMMddHHmmss
     * */
    public static final String DATE_yyyyMMddHHmmss = "yyyyMMddHHmmss";
    /**
     * yyyyMMdd
     * */
    public static final String DATEyyyyMMdd = "yyyyMMdd";
    /**
     * dd/MM/yyyy HH:mm:ss
     * */
    public static final String DATE_ddMMyyyyHHmmss="dd/MM/yyyy HH:mm:ss";
    /**
     * dd/MM/YYYY hh:mm:ss
     * */
	 public static final String DATE_ddMMyyyy_HH_MM_SS = "dd/MM/YYYY hh:mm:ss";
    /**
     * dd-MM-yyyy
     * */
    public static final String DATE_dd_MM_yyyy = "dd-MM-yyyy";
    /**
     * HH:mm:ss
     * */
    public static final String DATE_HHMMSS = "HH:mm:ss";
    /**
     * yyyy/MM/dd
     * */
    public static final String DATE_yyyyMMdd = "yyyy/MM/dd";
    
    /**
     * yyyy-MM-dd
     * */
    public static final String DATE_yyyy_MM_dd = "yyyy-MM-dd";
    /**
     * dd-MMM-yy
     * */
    public static final String DATE_dd_MMM_yy = "dd-MMM-yy";
    
    public static final int ATTACHMENT_TYPE_ALL = 0;
    public static final int ATTACHMENT_TYPE_IMAGE = 1;
    public static final int ATTACHMENT_TYPE_AUDIO = 2;
    public static final int ATTACHMENT_TYPE_VIDEO = 3;
    public static final int ATTACHMENT_TYPE_DOCS = 4;
    
    public static final int EXC_NO_DATA_FOUND = 1403;
    public static final String EXC_NO_DATA_FOUND_ERROR = "ORA-01403: no data found";
    public static final String EXC_NO_DATA_FOUND_JPA_STR = "returned no results";
    public static final String EXC_NO_DATA_FOUND_JPA_ERROR = "Error calling CallableStatement.getMoreResults";
    
    public static final String EXC_SERVER_ERROR = "Server Error";
    
    public static final String SUBSCRIBE = "Y";
    public static final String UNSUBSCRIBE = "N";
    
    public static final int SUCCESS_CODE = 1;
    public static final String SUCCESS_DESC = "SUCCESS";
    
    public static final int PENDING_CODE = 2;
    public static final String PENDING_DESC = "PENDING";
    
    public static final int TRANS_FAILED_CODE = 3;
    public static final String TRANS_FAILED_DESC = "FAILURE";
    
    public static final int FAILURE_CODE = 0;
    public static final String FAILURE_DESC = "FAILURE";
    
    public static final int INVALID_USER_ID = 2;
    public static final int INVALID_PASSWORD = 3;

    public static final String DB_EXC_ORA_UNIQUE = "ORA-00001";
    public static final String DB_EXC_ORA_FK = "ORA-02291";
    public static final String DB_EXC_ORA_NO_DATA_FOUND = "ORA-01403";


	public static final String EMAIL_NOT_FOUND = "Email Not Found";
	
	

	
	
	public static final String LOGGER_SUPRA_SERVICES_ERROR = "supraerror";
	public static final String LOGGER_SUPRA_SERVICES_INFO = "suprainfo";
			 
	public static final String Y = "Y";
	public static final String N = "N";
	public static final String[] ATTACHMENT_IMAGE_TYPES = {"image/jpeg", "image/png", "image/jpg","application/pdf"};
	public static final int MAX_IMAGE_SIZE = 512;
	
		
	public static final String EMPTY_STR ="";
	public static final String UNDEFINED ="undefined";
	public static final String SPACE_STR =" ";
	public static final String FAILED_DESC = "FAILED";
	
}
