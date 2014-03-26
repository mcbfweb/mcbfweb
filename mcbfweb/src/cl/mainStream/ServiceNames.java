package cl.mainStream;

/**
 * Constant definitions for the names of all the services the Saudi 
 * Credit Bureau application requires.<br>
 * Java source files should use these constants rather than String literals
 * for service names, so that any change can be made in one place.
 */
public interface ServiceNames {
    public static final String GET_USER_TYPE_SERVICE                     = "GETUSRTYP";
    public static final String GET_USER_OPTIONS_SERVICE                  = "GETUSROPT";
    public static final String GET_TABLES_SERVICE                        = "GETTABXML";

    public static final String GET_MEMBER_LIST_SERVICE                   = "ADMCUSLS";
	
	public static final String GET_MEMBER_LIST_SERVICE2                  = "ADMCUSLS1";
	
    public static final String VIEW_MEMBER_SERVICE                       = "ADMCUSGT";
    public static final String UPDATE_MEMBER_SERVICE                     = "ADMCUSMNT";
	public static final String GET_GROUP_TYPES_SERVICE					 = "ADMGRPLS";

    public static final String GET_NARRATIVE_LIST_SERVICE                = "ADMNARLS";
    public static final String VIEW_NARRATIVE_SERVICE                    = "ADMNARGT";
    public static final String UPDATE_NARRATIVE_SERVICE                  = "ADMNARMNT";

    public static final String GET_TRANSACTION_LIST_SERVICE              = "ADMTRNLS";

    public static final String GET_USER_LIST_SERVICE                     = "ADMUSRLS";
    public static final String VIEW_USER_SERVICE                         = "ADMUSRGT";
    public static final String UPDATE_USER_SERVICE                       = "ADMUSRMNT";

    public static final String VIEW_SECURITY_CATEGORY_SERVICE            = "ADMUSSGT";
    public static final String UPDATE_SECURITY_CATEGORY_SERVICE          = "ADMUSSMNT";

    public static final String GET_USER_OVERRIDE_LIST_SERVICE            = "ADMUSALS";
    public static final String VIEW_USER_OVERRIDE_SERVICE                = "ADMUSAGT";
    public static final String UPDATE_USER_OVERRIDE_SERVICE              = "ADMUSAMNT";

    public static final String GET_MEMBER_GROUPS_LIST_SERVICE            = "ADMMGPLS";
	public static final String VIEW_MEMBER_GROUPS_SERVICE                = "ADMMGPGT";
	public static final String UPDATE_MEMBER_GROUPS_SERVICE              = "ADMMGPMNT";
 
	public static final String GET_ACCESSLOGGING_LIST_SERVICE            = "ADMACCLS";
	public static final String VIEW_ACCESSLOGGING_SERVICE                = "ADMACCGT";
	 
	public static final String GET_MEMBER_GROUPSMEMBER_LIST_SERVICE      = "ADMMGMLS";
	public static final String VIEW_MEMBER_GROUPSMEMBER_SERVICE          = "ADMMGMGT";
	public static final String UPDATE_MEMBER_GROUPSMEMBER_SERVICE        = "ADMMGMMNT";
        
    public static final String GET_SERVICES_LIST_SERVICE                 = "AUTSRVLS";
    public static final String VIEW_SERVICE_SERVICE                      = "AUTSRVGT";
    public static final String UPDATE_SERVICE_SERVICE                    = "AUTSRVMNT";

    public static final String GET_SERVICE_ACTIONS_LIST_SERVICE          = "AUTACTLS";
    public static final String VIEW_SERVICE_ACTION_SERVICE               = "AUTACTGT";
    public static final String UPDATE_SERVICE_ACTION_SERVICE             = "AUTACTMNT";

    public static final String GET_TRANSACTION_CODE_LIST_SERVICE         = "ADMTCDLS";
    public static final String VIEW_TRANSACTION_CODE_SERVICE             = "ADMTCDGT";

    
    public static final String UPDATE_TRANSACTION_CODE_SERVICE           = "ADMTCDMNT";

    public static final String GET_OVERRIDES_LIST_SERVICE                = "ADMTCDLS1";

    public static final String GET_ADJUSTMENTS_LIST_SERVICE              = "ADMBADLS";
    public static final String VIEW_ADJUSTMENT_SERVICE                   = "ADMBADGT";
    public static final String UPDATE_ADJUSTMENT_SERVICE                 = "ADMBADMNT";

    public static final String GET_CREDIT_INSTRUMENT_LIST_SERVICE        = "ENTACHLS";
    public static final String VIEW_CREDIT_INSTRUMENT_SERVICE            = "ENTACHGT";
    public static final String UPDATE_CREDIT_INSTRUMENT_SERVICE          = "ENTACHMNT";

    public static final String GET_CYCLE_LIST_SERVICE                    = "ENTACYLS";
    public static final String VIEW_CYCLE_SERVICE                        = "ENTACYGT";
    public static final String UPDATE_CYCLE_SERVICE                      = "ENTACYMNT";

    public static final String GET_REPORT_REQUEST_LIST_SERVICE           = "RPTRPTLS";
    public static final String MAINTAIN_REPORT_REQUEST_SERVICE           = "RPTRPTMNT";
    public static final String VIEW_REPORT_CONTENT_SERVICE               = "RPTRPTVIEW";
    public static final String GET_REPORT_DETAIL_SERVICE                 = "RPTRPTGT";

    public static final String GET_REPORT_DEFINITIONS_LIST_SERVICE       = "RPTDEFLS";

    public static final String VIEW_REPORT_DEFINITION_SERVICE            = "RPTDEFGT";
    public static final String UPDATE_REPORT_DEFINITION_SERVICE          = "RPTDEFMNT";
    
    public static final String CONSUMER_ENQUIRY_SERVICE                  = "ENQUIRY";

    public static final String GET_WRITEOFF_LIST_SERVICE                 = "ENTBDTLS";
    public static final String VIEW_WRITEOFF_SERVICE                     = "ENTBDTGT";
    public static final String UPDATE_WRITEOFF_SERVICE                   = "ENTBDTMNT";

    public static final String GET_PUBLIC_NOTICE_LIST_SERVICE            = "ENTIPNLS";
    public static final String VIEW_PUBLIC_NOTICE_SERVICE                = "ENTIPNGT";
    public static final String UPDATE_PUBLIC_NOTICE_SERVICE              = "ENTIPNMNT";

    public static final String GET_MONITOR_LIST_SERVICE                  = "ENTIMNLS";
    public static final String VIEW_MONITOR_SERVICE                      = "ENTIMNGT";
    public static final String UPDATE_MONITOR_SERVICE                    = "ENTIMNMNT";

    public static final String GET_PREVIOUS_ENQUIRIES_LIST_SERVICE       = "ENTIPILS";
    public static final String VIEW_CONSUMER_REPORT_SERVICE              = "HISTORIC";
    public static final String VIEW_CONSUMER_INPUT_DETAIL_SERVICE        = "ENTIPIGT";
    public static final String GET_PREVIOUS_ENQUIRY_DETAIL_SERVICE       = "ENTIPGET";
	public static final String CHANGE_DISPLAY_FLAG_SERVICE     			 = "ENTIPIMNT";

  
    public static final String GET_CONSUMER_LIST_SERVICE                 = "ENTCONLS";

    public static final String SELECTED_CONSUMER_LIST_SERVICE            = "ENTCNSLS";

    public static final String UPDATE_CONSUMER_DETAIL_SERVICE            = "ENTCONMNT";
    
    public static final String VIEW_CONSUMER_PERSONAL_DETAILS_SERVICE    = "ENTINDGT";
    public static final String UPDATE_CONSUMER_PERSONAL_DETAILS_SERVICE  = "ENTINDMNT";

    public static final String GET_CONSUMER_NAME_LIST_SERVICE            = "ENTINNLS";
    public static final String VIEW_CONSUMER_NAME_SERVICE                = "ENTINNGT";
    public static final String UPDATE_CONSUMER_NAME_SERVICE              = "ENTINNMNT";

    public static final String GET_CONSUMER_ID_LIST_SERVICE              = "ENTIDLS";
    public static final String VIEW_CONSUMER_ID_SERVICE                  = "ENTIDGT";
    public static final String UPDATE_CONSUMER_ID_SERVICE                = "ENTIDMNT";

    public static final String GET_CONSUMER_OCCUPATION_LIST_SERVICE      = "ENTOCCLS";
    public static final String VIEW_CONSUMER_OCCUPATION_SERVICE          = "ENTOCCGT";
    public static final String UPDATE_CONSUMER_OCCUPATION_SERVICE        = "ENTOCCMNT";

    public static final String GET_CONSUMER_NARRATIVE_LIST_SERVICE       = "ENTNARLS";

    public static final String VIEW_CONSUMER_NARRATIVE_SERVICE           = "ENTNARGT";
    public static final String UPDATE_CONSUMER_NARRATIVE_SERVICE         = "ENTNARMNT";

    public static final String GET_CONSUMER_ADDRESS_LIST_SERVICE         = "ENTADRLS";
    public static final String VIEW_CONSUMER_ADDRESS_SERVICE             = "ENTADRGT";
    public static final String UPDATE_CONSUMER_ADDRESS_SERVICE           = "ENTADRMNT";

    public static final String GET_CONSUMER_CONTACT_LIST_SERVICE         = "ENTCNTLS";
    public static final String VIEW_CONSUMER_CONTACT_SERVICE             = "ENTCNTGT";
    public static final String UPDATE_CONSUMER_CONTACT_SERVICE           = "ENTCNTMNT";

    public static final String GET_CONSUMERS_TOMERGE_LIST_SERVICE        = "ENTMRGLS";
    public static final String MERGE_CONSUMERS_SERVICE                   = "ENTMRGMNT";

    public static final String GET_AUDIT_LIST_SERVICE                    = "ENTAUDLS";

    public static final String GET_B2B_EVENT_LIST_SERVICE                = "B2BLOGLS";
    public static final String VIEW_B2B_EVENT_SERVICE                    = "B2BLOGGT";
    
    public static final String MAINTAIN__CONSUMER_XREF_SERVICE           ="ENTLNKMNT";
    
    public static final String MAINTAIN_VIP_FLAG_SERVICE                 ="ENTVIPMNT";
    
    
    public static final String GET_CONSUMER_NAMESEARCHLIST_SERVICE       = "ENTCONLSE";  //PVO28


    public static final String[] allServices = { GET_USER_TYPE_SERVICE,
GET_USER_OPTIONS_SERVICE                  , // "GETUSROPT";
GET_TABLES_SERVICE                        , // "GETTABXML";

GET_MEMBER_LIST_SERVICE                   , // "ADMCUSLS";
GET_MEMBER_LIST_SERVICE2				  , // "ADMCUSLS1";
VIEW_MEMBER_SERVICE                       , // "ADMCUSGT";
UPDATE_MEMBER_SERVICE                     , // "ADMCUSMNT";
GET_GROUP_TYPES_SERVICE					  , // "ADMGRPLS";

GET_NARRATIVE_LIST_SERVICE                , // "ADMNARLS";
VIEW_NARRATIVE_SERVICE                    , // "ADMNARGT";
UPDATE_NARRATIVE_SERVICE                  , // "ADMNARMNT";

GET_TRANSACTION_LIST_SERVICE              , // "ADMTRNLS";

GET_USER_LIST_SERVICE                     , // "ADMUSRLS";
VIEW_USER_SERVICE                         , // "ADMUSRGT";
UPDATE_USER_SERVICE                       , // "ADMUSRMNT";

VIEW_SECURITY_CATEGORY_SERVICE            , // "ADMUSSGT";
UPDATE_SECURITY_CATEGORY_SERVICE          , // "ADMUSSMNT";

GET_USER_OVERRIDE_LIST_SERVICE            , // "ADMUSALS";
VIEW_USER_OVERRIDE_SERVICE                , // "ADMUSAGT";
UPDATE_USER_OVERRIDE_SERVICE              , // "ADMUSAMNT";

GET_SERVICES_LIST_SERVICE                 , // "AUTSRVLS";
VIEW_SERVICE_SERVICE                      , // "AUTSRVGT";
UPDATE_SERVICE_SERVICE                    , // "AUTSRVMNT";

GET_MEMBER_GROUPS_LIST_SERVICE            , // "ADMMGPLS";
VIEW_MEMBER_GROUPS_SERVICE                , // "ADMMGPGT";
UPDATE_MEMBER_GROUPS_SERVICE              , // "ADMMGPMNT";

GET_ACCESSLOGGING_LIST_SERVICE            , // "ADMACCLS";
VIEW_ACCESSLOGGING_SERVICE                , // "ADMACCGT";

GET_MEMBER_GROUPSMEMBER_LIST_SERVICE      , // "ADMMGMLS";
VIEW_MEMBER_GROUPSMEMBER_SERVICE          , // "ADMMGMGT";
UPDATE_MEMBER_GROUPSMEMBER_SERVICE        , // "ADMMGMMNT";

GET_SERVICE_ACTIONS_LIST_SERVICE          , // "AUTACTLS";
VIEW_SERVICE_ACTION_SERVICE               , // "AUTACTGT";
UPDATE_SERVICE_ACTION_SERVICE             , // "AUTACTMNT";

GET_TRANSACTION_CODE_LIST_SERVICE         , // "ADMTCDLS";
VIEW_TRANSACTION_CODE_SERVICE             , // "ADMTCDGT";
UPDATE_TRANSACTION_CODE_SERVICE           , // "ADMTCDMNT";
GET_OVERRIDES_LIST_SERVICE                , // "ADMTCDLS1";

GET_ADJUSTMENTS_LIST_SERVICE              , // "ADMBADLS";
VIEW_ADJUSTMENT_SERVICE                   , // "ADMBADGT";
UPDATE_ADJUSTMENT_SERVICE                 , // "ADMBADMNT";

GET_CREDIT_INSTRUMENT_LIST_SERVICE        , // "ENTACHLS";
VIEW_CREDIT_INSTRUMENT_SERVICE            , // "ENTACHGT";
UPDATE_CREDIT_INSTRUMENT_SERVICE          , // "ENTACHMNT";

GET_CYCLE_LIST_SERVICE                    , // "ENTACYLS";
VIEW_CYCLE_SERVICE                        , // "ENTACYGT";
UPDATE_CYCLE_SERVICE                      , // "ENTACYMNT";

GET_REPORT_REQUEST_LIST_SERVICE           ,// "RPTRPTLS";
MAINTAIN_REPORT_REQUEST_SERVICE           ,// "RPTRPTMNT";
VIEW_REPORT_CONTENT_SERVICE               ,// "RPTRPTVIEW";
GET_REPORT_DETAIL_SERVICE                 ,// "RPTRPTGT";

GET_REPORT_DEFINITIONS_LIST_SERVICE       , // "RPTDEFLS";
VIEW_REPORT_DEFINITION_SERVICE            , // "RPTDEFGT";
UPDATE_REPORT_DEFINITION_SERVICE          , // "RPTDEFMNT";
    

CONSUMER_ENQUIRY_SERVICE                  , // "CONSENQ";
CHANGE_DISPLAY_FLAG_SERVICE     		  , // "ENTIPIMNT";

GET_WRITEOFF_LIST_SERVICE                 , // "ENTBDTLS";
VIEW_WRITEOFF_SERVICE                     , // "ENTBDTGT";
UPDATE_WRITEOFF_SERVICE                   , // "ENTBDTMNT";

GET_PUBLIC_NOTICE_LIST_SERVICE            , // "ENTIPNLS";
VIEW_PUBLIC_NOTICE_SERVICE                , // "ENTIPNGT";
UPDATE_PUBLIC_NOTICE_SERVICE              , // "ENTIPNMNT";

GET_MONITOR_LIST_SERVICE                  , // "ENTIMNLS";
VIEW_MONITOR_SERVICE                      , // "ENTIMNGT";
UPDATE_MONITOR_SERVICE                    , // "ENTIMNMNT";

GET_PREVIOUS_ENQUIRIES_LIST_SERVICE       , // "ENTIPILS";
VIEW_CONSUMER_REPORT_SERVICE              , // "ENTSVRGT";

GET_CONSUMER_LIST_SERVICE                 , // "ENTCONLS";
SELECTED_CONSUMER_LIST_SERVICE,				// "ENTCNSLS";

UPDATE_CONSUMER_DETAIL_SERVICE,

VIEW_CONSUMER_PERSONAL_DETAILS_SERVICE    , // "ENTINDGT";
UPDATE_CONSUMER_PERSONAL_DETAILS_SERVICE  , // "ENTINDMNT";

GET_CONSUMER_NAME_LIST_SERVICE            , // "ENTINNLS";
VIEW_CONSUMER_NAME_SERVICE                , // "ENTINNGT";
UPDATE_CONSUMER_NAME_SERVICE              , // "ENTINNMNT";

GET_CONSUMER_ID_LIST_SERVICE              , // "ENTIDLS";
VIEW_CONSUMER_ID_SERVICE                  , // "ENTIDGT";
UPDATE_CONSUMER_ID_SERVICE                , // "ENTIDMNT";

GET_CONSUMER_OCCUPATION_LIST_SERVICE      , // "ENTOCCLS";
VIEW_CONSUMER_OCCUPATION_SERVICE          , // "ENTOCCGT";
UPDATE_CONSUMER_OCCUPATION_SERVICE        , // "ENTOCCMNT";

GET_CONSUMER_NARRATIVE_LIST_SERVICE       , // "ENTNARLS";
VIEW_CONSUMER_NARRATIVE_SERVICE           , // "ENTNARGT";
UPDATE_CONSUMER_NARRATIVE_SERVICE         , // "ENTNARMNT";

GET_CONSUMER_ADDRESS_LIST_SERVICE         , // "ENTADRLS";
VIEW_CONSUMER_ADDRESS_SERVICE             , // "ENTADRGT";
UPDATE_CONSUMER_ADDRESS_SERVICE           , // "ENTADRMNT";

GET_CONSUMER_CONTACT_LIST_SERVICE         , // "ENTCNTLS";
VIEW_CONSUMER_CONTACT_SERVICE             , // "ENTCNTGT";
UPDATE_CONSUMER_CONTACT_SERVICE           , // "ENTCNTMNT";

GET_CONSUMERS_TOMERGE_LIST_SERVICE        , // "ENTMRGLS";
MERGE_CONSUMERS_SERVICE                   , // "ENTMRGMNT";

GET_AUDIT_LIST_SERVICE                    , // "ENTAUDLS";

GET_B2B_EVENT_LIST_SERVICE                , // "B2BEVTLS";
VIEW_B2B_EVENT_SERVICE                    , // "B2BEVTGT";

VIEW_CONSUMER_INPUT_DETAIL_SERVICE          , //ENTIPIGT
GET_PREVIOUS_ENQUIRY_DETAIL_SERVICE          , //ENTIPGET

MAINTAIN_VIP_FLAG_SERVICE                 ,//ENTVIPMNT

GET_CONSUMER_NAMESEARCHLIST_SERVICE                 ,//= "ENTCONLSE" PVO28
    };

}
