package cl.mainStream;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import cl.mainStream.BSException;


//import org.apache.struts2.Globals;
//import org.apache.struts2.util.MessageResources;




/**
 * UserState is a session-scope bean that stores the user's language
 * preference, service authorizations, and other variables that apply to the whole application.<br>
 * The default language preference is the language preference set in the user's browser.<br>
 * The default language preference can be over-ridden by the user's selecting a "switch language"
 * button on a web form.<br>
 * When the preferred laguage is <code>ARABIC</code>, <code>direction</code> is "rtl", 
 * (right-to-left) otherwise direction is "ltr".
 */
public class UserState implements ServiceNames, LanguageSelector, Serializable {
    
   
	public Locale ENGLISH_LOCALE = new Locale(ENGLISH, "");
    public Locale ARABIC_LOCALE = new Locale(ARABIC, "");

    public static final String ALIGN_LEFT  = "left";
    public static final String ALIGN_RIGHT = "right";

    public static final String RIGHT_TO_LEFT = "rtl";
    public static final String LEFT_TO_RIGHT = "ltr";
    
    public static final String INTERNAL_USER = "INT";
    public static final String EXTERNAL_USER = "EXT";
    
    private static final String[] emptyArray = {};
    
    private ServletContext servletContext;
    private String remoteUser;
    private String userType;
    private String userClient;
    private String browserLanguage;
    private String interactiveLanguage;
 
    private int screenWidth         = 1014;  // make this an init param
    private int menuWidth           = 144;   // make this an init param
    private int contentBordersWidth = 16;    // make this an init param
    private String defaultCountryCode;
    private String defaultIsdCode;
    private String systemError;
    private Exception systemException;
    private String currentPage = "splash";

    private HttpSession session;
    private String pageTitleKey;
    private boolean newPageTitle;
    private String pageType;
        
    private static HashMap<String, String> menuServices;

    private String[] messages = emptyArray;
    private boolean setupError;

    // services for the main menu
    static {
        menuServices = new HashMap<String, String>();

        menuServices.put("menu.members.members", GET_MEMBER_LIST_SERVICE);
        menuServices.put("menu.members.transactionCodes", GET_TRANSACTION_CODE_LIST_SERVICE);
        menuServices.put("menu.members.adjustments", GET_ADJUSTMENTS_LIST_SERVICE);
        menuServices.put("menu.members.reports", GET_REPORT_REQUEST_LIST_SERVICE);
		menuServices.put("menu.members.services", GET_SERVICES_LIST_SERVICE);
		menuServices.put("menu.members.groups", GET_MEMBER_GROUPS_LIST_SERVICE);
		menuServices.put("menu.members.accesslogging", GET_ACCESSLOGGING_LIST_SERVICE);
		
        menuServices.put("menu.consumers.consumerEnquiry", CONSUMER_ENQUIRY_SERVICE);
        menuServices.put("menu.consumers.consumerEnquiryPublic", CONSUMER_ENQUIRY_SERVICE);//pvo26
		// {check service name }
		menuServices.put("menu.consumers.consumerEnquiryAdverse", CONSUMER_ENQUIRY_SERVICE);//6632
		menuServices.put("menu.consumers.consumerEnquiryScore", CONSUMER_ENQUIRY_SERVICE);//9286
        menuServices.put("menu.consumers.historicalEnquiries", GET_PREVIOUS_ENQUIRIES_LIST_SERVICE);
        menuServices.put("menu.consumers.historicalEnquiriesPublic", GET_PREVIOUS_ENQUIRIES_LIST_SERVICE);//pvo26
		// {check service name }
		menuServices.put("menu.consumers.historicalEnquiriesAdverse", GET_PREVIOUS_ENQUIRIES_LIST_SERVICE);//6632
		
		menuServices.put("menu.consumers.consumerEnquiryMiscellaneous", CONSUMER_ENQUIRY_SERVICE);
		menuServices.put("menu.consumers.historicalEnquiriesMiscellaneous", GET_PREVIOUS_ENQUIRIES_LIST_SERVICE);
		menuServices.put("menu.consumers.historicalEnquiriesScore", GET_PREVIOUS_ENQUIRIES_LIST_SERVICE);

        menuServices.put("menu.consumers.accounts", GET_CREDIT_INSTRUMENT_LIST_SERVICE);
        menuServices.put("menu.consumers.defaults", GET_WRITEOFF_LIST_SERVICE);
        menuServices.put("menu.consumers.monitors", GET_MONITOR_LIST_SERVICE);
        menuServices.put("menu.consumers.publicNotices", GET_PUBLIC_NOTICE_LIST_SERVICE);
        
        menuServices.put("menu.consumers.files", GET_CONSUMER_LIST_SERVICE);
       
        menuServices.put("menu.consumers.namesearchlist.files", GET_CONSUMER_NAMESEARCHLIST_SERVICE); 
        
        menuServices.put("menu.b2b.logs", GET_B2B_EVENT_LIST_SERVICE);
        
        //extra service
        menuServices.put("member.list.service", GET_MEMBER_LIST_SERVICE);
    }
    
    private static HashMap<String, String> toolbarServices;
    private static HashMap<String, String> toolbarActions;

	
    static {
        toolbarServices = new HashMap<String, String>();
        toolbarActions = new HashMap<String, String>();

        // services and actions for the ClientList toolbar
        toolbarServices.put("toolbar.client.filter", GET_MEMBER_LIST_SERVICE);
        toolbarActions.put("toolbar.client.filter", "M");
        toolbarServices.put("common.add", UPDATE_MEMBER_SERVICE);
        toolbarActions.put("common.add", "A");
        toolbarServices.put("toolbar.client.change", UPDATE_MEMBER_SERVICE);
        toolbarActions.put("toolbar.client.change", "M");
        toolbarServices.put("toolbar.client.view", VIEW_MEMBER_SERVICE);
        toolbarActions.put("toolbar.client.view", "E");
        toolbarServices.put("toolbar.client.users", GET_USER_LIST_SERVICE);
        toolbarActions.put("toolbar.client.users", "M");
        toolbarServices.put("toolbar.client.transactions", GET_TRANSACTION_LIST_SERVICE);
        toolbarActions.put("toolbar.client.transactions", "M");
        toolbarServices.put("toolbar.client.narratives", GET_NARRATIVE_LIST_SERVICE);
        toolbarActions.put("toolbar.client.narratives", "M");
        toolbarServices.put("toolbar.client.transcodes", GET_TRANSACTION_CODE_LIST_SERVICE);
        toolbarActions.put("toolbar.client.transcodes", "M");
        toolbarServices.put("toolbar.client.adjustments", GET_ADJUSTMENTS_LIST_SERVICE);
        toolbarActions.put("toolbar.client.adjustments", "M");
        
        toolbarServices.put("toolbar.adjustment.filter", GET_ADJUSTMENTS_LIST_SERVICE);
        toolbarActions.put("toolbar.adjustment.filter", "M");
        toolbarServices.put("common.add", UPDATE_ADJUSTMENT_SERVICE);
        toolbarActions.put("common.add", "A");
        toolbarServices.put("toolbar.adjustment.view", VIEW_ADJUSTMENT_SERVICE);
        toolbarActions.put("toolbar.adjustment.view", "E");
        toolbarServices.put("toolbar.adjustment.authorise", UPDATE_ADJUSTMENT_SERVICE);
        toolbarActions.put("toolbar.adjustment.authorise", "AUTHR");
        toolbarServices.put("toolbar.adjustment.decline", UPDATE_ADJUSTMENT_SERVICE);
        toolbarActions.put("toolbar.adjustment.decline", "DCLND");
 
 
		toolbarServices.put("toolbar.groups.filter", GET_MEMBER_GROUPS_LIST_SERVICE);
		toolbarActions.put("toolbar.groups.filter", "M");
		toolbarServices.put("common.add", UPDATE_MEMBER_GROUPS_SERVICE);
		toolbarActions.put("common.add", "A");
		toolbarServices.put("toolbar.groups.change", UPDATE_MEMBER_GROUPS_SERVICE);
		toolbarActions.put("toolbar.groups.change", "M");
		toolbarServices.put("toolbar.groups.view", VIEW_MEMBER_GROUPS_SERVICE);
		toolbarActions.put("toolbar.groups.view", "E");
		toolbarServices.put("common.delete", UPDATE_MEMBER_GROUPS_SERVICE);
		toolbarActions.put("common.delete", "D");
		
		toolbarServices.put("toolbar.accesslogging.filter", GET_ACCESSLOGGING_LIST_SERVICE);
		toolbarActions.put("toolbar.accesslogging.filter", "M");
		toolbarServices.put("toolbar.accesslogging.view", VIEW_ACCESSLOGGING_SERVICE);
		toolbarActions.put("toolbar.accesslogging.view", "E");

		toolbarServices.put("toolbar.groups.member", GET_MEMBER_GROUPSMEMBER_LIST_SERVICE);
		toolbarActions.put("toolbar.groups.member", "M");
		toolbarServices.put("common.add", UPDATE_MEMBER_GROUPSMEMBER_SERVICE);
		toolbarActions.put("common.add", "A");
		toolbarServices.put("common.delete", VIEW_MEMBER_GROUPSMEMBER_SERVICE);
		toolbarActions.put("common.delete", "D");
				
        toolbarServices.put("toolbar.narrative.filter", GET_NARRATIVE_LIST_SERVICE);
        toolbarActions.put("toolbar.narrative.filter", "M");
        toolbarServices.put("common.add", UPDATE_NARRATIVE_SERVICE);
        toolbarActions.put("common.add", "A");
        toolbarServices.put("toolbar.narrative.change", UPDATE_NARRATIVE_SERVICE);
        toolbarActions.put("toolbar.narrative.change", "M");
        toolbarServices.put("toolbar.narrative.view", VIEW_NARRATIVE_SERVICE);
        toolbarActions.put("toolbar.narrative.view", "E");
     	toolbarServices.put("common.delete", UPDATE_NARRATIVE_SERVICE);
        toolbarActions.put("common.delete", "D");
    
        toolbarServices.put("toolbar.transaction.filter", GET_TRANSACTION_LIST_SERVICE);
        toolbarActions.put("toolbar.transaction.filter", "M");
        
        toolbarServices.put("toolbar.transcode.filter", GET_TRANSACTION_CODE_LIST_SERVICE);
        toolbarActions.put("toolbar.transcode.filter", "M");

        
        toolbarServices.put("common.add", UPDATE_TRANSACTION_CODE_SERVICE);
        toolbarActions.put("common.add", "A");
       
        toolbarServices.put("toolbar.transcode.change", UPDATE_TRANSACTION_CODE_SERVICE);
        toolbarActions.put("toolbar.transcode.change", "M");
        toolbarServices.put("toolbar.transcode.view", VIEW_TRANSACTION_CODE_SERVICE);
        toolbarActions.put("toolbar.transcode.view", "E");
     	toolbarServices.put("toolbar.transcode.listmemberoverrides", GET_OVERRIDES_LIST_SERVICE);
        toolbarActions.put("toolbar.transcode.listmemberoverrides", "M");

		toolbarServices.put("toolbar.transcodemo.filter", GET_TRANSACTION_CODE_LIST_SERVICE);
        toolbarActions.put("toolbar.transcodemo.filter", "M");

        toolbarServices.put("toolbar.service.filter", GET_SERVICES_LIST_SERVICE);
        toolbarActions.put("toolbar.service.filter", "M");
        toolbarServices.put("toolbar.service.add", UPDATE_SERVICE_SERVICE);
        toolbarActions.put("toolbar.service.add", "A");
        toolbarServices.put("toolbar.service.view", VIEW_SERVICE_SERVICE);
        toolbarActions.put("toolbar.service.view", "E");
        toolbarServices.put("toolbar.service.actions", GET_SERVICE_ACTIONS_LIST_SERVICE);
        toolbarActions.put("toolbar.service.actions", "M");

        toolbarServices.put("toolbar.action.add", UPDATE_SERVICE_ACTION_SERVICE);
        toolbarActions.put("toolbar.action.add", "A");
        toolbarServices.put("toolbar.action.view", VIEW_SERVICE_ACTION_SERVICE);
        toolbarActions.put("toolbar.action.view", "E");
        toolbarServices.put("toolbar.action.change", UPDATE_SERVICE_ACTION_SERVICE);
        toolbarActions.put("toolbar.action.change", "M");
        
        toolbarServices.put("toolbar.user.filter", GET_USER_LIST_SERVICE);
        toolbarActions.put("toolbar.user.filter", "M");
        toolbarServices.put("toolbar.user.add", UPDATE_USER_SERVICE);
        toolbarActions.put("toolbar.user.add", "A");
        toolbarServices.put("toolbar.user.view", VIEW_USER_SERVICE);
        toolbarActions.put("toolbar.user.view", "E");
        toolbarServices.put("toolbar.user.change", UPDATE_USER_SERVICE);
        toolbarActions.put("toolbar.user.change", "A");
        toolbarServices.put("toolbar.user.enable", UPDATE_USER_SERVICE);
        toolbarActions.put("toolbar.user.enable", "F");
        toolbarServices.put("toolbar.user.disable", UPDATE_USER_SERVICE);
        toolbarActions.put("toolbar.user.disable", "D");
        toolbarServices.put("toolbar.user.reset", UPDATE_USER_SERVICE);
        toolbarActions.put("toolbar.user.reset", "P");
        toolbarServices.put("toolbar.user.override", GET_USER_OVERRIDE_LIST_SERVICE);
        toolbarActions.put("toolbar.user.override", "M");
        
        toolbarServices.put("toolbar.user.overrides.filter", GET_USER_OVERRIDE_LIST_SERVICE);
        toolbarActions.put("toolbar.user.overrides.filter", "M");
        toolbarServices.put("toolbar.user.overrides.view", VIEW_USER_OVERRIDE_SERVICE);
        toolbarActions.put("toolbar.user.overrides.view", "E");
        toolbarServices.put("common.add", UPDATE_USER_OVERRIDE_SERVICE);
        toolbarActions.put("common.add", "A");
        toolbarServices.put("toolbar.user.overrides.change", UPDATE_USER_OVERRIDE_SERVICE);
        toolbarActions.put("toolbar.user.overrides.change", "M");

        toolbarServices.put("toolbar.consumer.filter", GET_CONSUMER_LIST_SERVICE);
        toolbarActions.put("toolbar.consumer.filter", "M");

        toolbarServices.put("common.add", UPDATE_CONSUMER_DETAIL_SERVICE);
        toolbarActions.put("common.add", "A");
        toolbarServices.put("common.delete", UPDATE_CONSUMER_DETAIL_SERVICE);
        toolbarActions.put("common.delete", "D");
        
        toolbarServices.put("toolbar.consumer.details.update", UPDATE_CONSUMER_PERSONAL_DETAILS_SERVICE);
        toolbarActions.put("toolbar.consumer.details.update", "M");

        toolbarServices.put("toolbar.consumer.narrative.filter", GET_CONSUMER_NARRATIVE_LIST_SERVICE);
        toolbarActions.put("toolbar.consumer.narrative.filter", "M");
  
        toolbarServices.put("common.add", UPDATE_CONSUMER_NARRATIVE_SERVICE);
        toolbarActions.put("common.add", "A");
        toolbarServices.put("toolbar.consumer.narrative.change", UPDATE_CONSUMER_NARRATIVE_SERVICE);
        toolbarActions.put("toolbar.consumer.narrative.change", "M");
        toolbarServices.put("common.delete", UPDATE_CONSUMER_NARRATIVE_SERVICE);
        toolbarActions.put("common.delete", "D");
        toolbarServices.put("toolbar.consumer.narrative.view", VIEW_CONSUMER_NARRATIVE_SERVICE);
        toolbarActions.put("toolbar.consumer.narrative.view", "E");
        
        toolbarServices.put("toolbar.consumer.name.filter", GET_CONSUMER_NAME_LIST_SERVICE);
        toolbarActions.put("toolbar.consumer.name.filter", "M");
        toolbarServices.put("common.add", UPDATE_CONSUMER_NAME_SERVICE);
        toolbarActions.put("common.add", "A");
        toolbarServices.put("toolbar.consumer.name.change", UPDATE_CONSUMER_NAME_SERVICE);
        toolbarActions.put("toolbar.consumer.name.change", "M");
        toolbarServices.put("common.delete", UPDATE_CONSUMER_NAME_SERVICE);
        toolbarActions.put("common.delete", "D");
        toolbarServices.put("toolbar.consumer.name.view", VIEW_CONSUMER_NAME_SERVICE);
        toolbarActions.put("toolbar.consumer.name.view", "E");

        toolbarServices.put("toolbar.consumer.id.filter", GET_CONSUMER_ID_LIST_SERVICE);
        toolbarActions.put("toolbar.consumer.id.filter", "M");
        toolbarServices.put("common.add", UPDATE_CONSUMER_ID_SERVICE);
        toolbarActions.put("common.add", "A");
        toolbarServices.put("toolbar.consumer.id.change", UPDATE_CONSUMER_ID_SERVICE);
        toolbarActions.put("toolbar.consumer.id.change", "M");
        toolbarServices.put("common.delete", UPDATE_CONSUMER_ID_SERVICE);
        toolbarActions.put("common.delete", "D");
        toolbarServices.put("toolbar.consumer.id.view", VIEW_CONSUMER_ID_SERVICE);
        toolbarActions.put("toolbar.consumer.id.view", "E");

        toolbarServices.put("common.filter", GET_CONSUMER_ADDRESS_LIST_SERVICE);
        toolbarActions.put("common.filter", "M");
        toolbarServices.put("common.address.add", UPDATE_CONSUMER_ADDRESS_SERVICE);
        toolbarActions.put("common.address.add", "A");
        toolbarServices.put("common.change", UPDATE_CONSUMER_ADDRESS_SERVICE);
        toolbarActions.put("common.change", "M");
        toolbarServices.put("common.delete", UPDATE_CONSUMER_ADDRESS_SERVICE);
        toolbarActions.put("common.delete", "D");
        toolbarServices.put("common.view", VIEW_CONSUMER_ADDRESS_SERVICE);
        toolbarActions.put("common.view", "E");

        toolbarServices.put("toolbar.consumer.contact.filter", GET_CONSUMER_CONTACT_LIST_SERVICE);
        toolbarActions.put("toolbar.consumer.contact.filter", "M");
        toolbarServices.put("common.add", UPDATE_CONSUMER_CONTACT_SERVICE);
        toolbarActions.put("common.add", "A");
        toolbarServices.put("toolbar.consumer.contact.change", UPDATE_CONSUMER_CONTACT_SERVICE);
        toolbarActions.put("toolbar.consumer.contact.change", "M");
        toolbarServices.put("common.delete", UPDATE_CONSUMER_CONTACT_SERVICE);
        toolbarActions.put("common.delete", "D");
        toolbarServices.put("toolbar.consumer.contact.view", VIEW_CONSUMER_CONTACT_SERVICE);
        toolbarActions.put("toolbar.consumer.contact.view", "E");

        toolbarServices.put("toolbar.consumer.occupation.filter", GET_CONSUMER_OCCUPATION_LIST_SERVICE);
        toolbarActions.put("toolbar.consumer.occupation.filter", "M");
        toolbarServices.put("common.add", UPDATE_CONSUMER_OCCUPATION_SERVICE);
        toolbarActions.put("common.add", "A");
        toolbarServices.put("toolbar.consumer.occupation.change", UPDATE_CONSUMER_OCCUPATION_SERVICE);
        toolbarActions.put("toolbar.consumer.occupation.change", "M");
        toolbarServices.put("common.delete", UPDATE_CONSUMER_OCCUPATION_SERVICE);
        toolbarActions.put("common.delete", "D");
        toolbarServices.put("toolbar.consumer.occupation.view", VIEW_CONSUMER_OCCUPATION_SERVICE);
        toolbarActions.put("toolbar.consumer.occupation.view", "E");

        toolbarServices.put("toolbar.consumer.enquiry.filter", GET_PREVIOUS_ENQUIRIES_LIST_SERVICE);
        toolbarActions.put("toolbar.consumer.enquiry.filter", "M");
        toolbarServices.put("toolbar.consumer.enquiry.viewInputDetail", VIEW_CONSUMER_INPUT_DETAIL_SERVICE);
        toolbarActions.put("toolbar.consumer.enquiry.viewInputDetail", "M");
        toolbarServices.put("toolbar.consumer.enquiry.viewSavedReport", VIEW_CONSUMER_REPORT_SERVICE);
        toolbarActions.put("toolbar.consumer.enquiry.viewSavedReport", "A");
        toolbarServices.put("toolbar.consumer.enquiry.processEnquiry", GET_PREVIOUS_ENQUIRY_DETAIL_SERVICE);
        toolbarActions.put("toolbar.consumer.enquiry.processEnquiry", "E");

		
		toolbarServices.put("toolbar.consumer.enquiry.all.filter", GET_PREVIOUS_ENQUIRIES_LIST_SERVICE);
        toolbarActions.put("toolbar.consumer.enquiry.all.filter", "ALL");
        


		//pvo26   confirm the actions!!!
        toolbarServices.put("toolbar.consumer.enquirypublic.filter", GET_PREVIOUS_ENQUIRIES_LIST_SERVICE);
        toolbarActions.put("toolbar.consumer.enquirypublic.filter", "PE");
        toolbarServices.put("toolbar.consumer.enquirypublic.viewInputDetail", VIEW_CONSUMER_INPUT_DETAIL_SERVICE);
        toolbarActions.put("toolbar.consumer.enquirypublic.viewInputDetail", "M");
        toolbarServices.put("toolbar.consumer.enquirypublic.viewSavedReport", VIEW_CONSUMER_REPORT_SERVICE);
        toolbarActions.put("toolbar.consumer.enquirypublic.viewSavedReport", "PE");
        toolbarServices.put("toolbar.consumer.enquirypublic.processEnquiry", GET_PREVIOUS_ENQUIRY_DETAIL_SERVICE);
        toolbarActions.put("toolbar.consumer.enquirypublic.processEnquiry", "E");

		toolbarServices.put("toolbar.consumer.enquiryadverse.filter", GET_PREVIOUS_ENQUIRIES_LIST_SERVICE);
		toolbarActions.put("toolbar.consumer.enquiryadverse.filter", "NEG");
		toolbarServices.put("toolbar.consumer.enquiryadverse.viewInputDetail", VIEW_CONSUMER_INPUT_DETAIL_SERVICE);
		toolbarActions.put("toolbar.consumer.enquiryadverse.viewInputDetail", "M");
		toolbarServices.put("toolbar.consumer.enquiryadverse.viewSavedReport", VIEW_CONSUMER_REPORT_SERVICE);
		toolbarActions.put("toolbar.consumer.enquiryadverse.viewSavedReport", "NEG");
		toolbarServices.put("toolbar.consumer.enquiryadverse.processEnquiry", GET_PREVIOUS_ENQUIRY_DETAIL_SERVICE);
		toolbarActions.put("toolbar.consumer.enquiryadverse.processEnquiry", "E");


		toolbarServices.put("toolbar.consumer.enquirymis.filter", GET_PREVIOUS_ENQUIRIES_LIST_SERVICE);
		toolbarActions.put("toolbar.consumer.enquirymis.filter", "ME");
		toolbarServices.put("toolbar.consumer.enquirymis.viewInputDetail", VIEW_CONSUMER_INPUT_DETAIL_SERVICE);
		toolbarActions.put("toolbar.consumer.enquirymis.viewInputDetail", "M");
		toolbarServices.put("toolbar.consumer.enquirymis.viewSavedReport", VIEW_CONSUMER_REPORT_SERVICE);
		toolbarActions.put("toolbar.consumer.enquirymis.viewSavedReport", "ME");
		toolbarServices.put("toolbar.consumer.enquirymis.processEnquiry", GET_PREVIOUS_ENQUIRY_DETAIL_SERVICE);
		toolbarActions.put("toolbar.consumer.enquirymis.processEnquiry", "E");
		toolbarServices.put("toolbar.consumer.enquirymis.processEnquiry", GET_PREVIOUS_ENQUIRY_DETAIL_SERVICE);
		toolbarActions.put("toolbar.consumer.enquirymis.processEnquiry", "E");


		toolbarServices.put("toolbar.consumer.enquiryscore.filter", GET_PREVIOUS_ENQUIRIES_LIST_SERVICE);
		toolbarActions.put("toolbar.consumer.enquiryscore.filter", "SCORE");
		toolbarServices.put("toolbar.consumer.enquiryscore.viewInputDetail", VIEW_CONSUMER_INPUT_DETAIL_SERVICE);
		toolbarActions.put("toolbar.consumer.enquiryscore.viewInputDetail", "M");
		toolbarServices.put("toolbar.consumer.enquiryscore.viewSavedReport", VIEW_CONSUMER_REPORT_SERVICE);
		toolbarActions.put("toolbar.consumer.enquiryscore.viewSavedReport", "SCORE");
		toolbarServices.put("toolbar.consumer.enquiryscore.processEnquiry", GET_PREVIOUS_ENQUIRY_DETAIL_SERVICE);
		toolbarActions.put("toolbar.consumer.enquiryscore.processEnquiry", "E");


		toolbarServices.put("toolbar.consumer.enquiry.changeDisplayFlag", CHANGE_DISPLAY_FLAG_SERVICE);
		toolbarActions.put("toolbar.consumer.enquiry.changeDisplayFlag", "E");

		toolbarServices.put("toolbar.consumer.enquirymis.changeDisplayFlag", CHANGE_DISPLAY_FLAG_SERVICE);
		toolbarActions.put("toolbar.consumer.enquirymis.changeDisplayFlag", "E");

        toolbarServices.put("toolbar.consumer.search.alternate", SELECTED_CONSUMER_LIST_SERVICE);
        toolbarActions.put("toolbar.consumer.search.alternate", "M");
        
        toolbarServices.put("toolbar.b2blog.filter", GET_B2B_EVENT_LIST_SERVICE);
        toolbarActions.put("toolbar.b2blog.filter", "M");        
        toolbarServices.put("toolbar.b2blog.view", VIEW_B2B_EVENT_SERVICE);
        toolbarActions.put("toolbar.b2blog.view", "E");
        
        toolbarServices.put("toolbar.report.filter", GET_REPORT_REQUEST_LIST_SERVICE);
        toolbarActions.put("toolbar.report.filter", "M");
        toolbarServices.put("toolbar.report.request", MAINTAIN_REPORT_REQUEST_SERVICE);
        toolbarActions.put("toolbar.report.request", "A");
        toolbarServices.put("toolbar.report.view", VIEW_REPORT_CONTENT_SERVICE);
        toolbarActions.put("toolbar.report.view", "E");
        toolbarServices.put("toolbar.report.reprint", MAINTAIN_REPORT_REQUEST_SERVICE);
        toolbarActions.put("toolbar.report.reprint", "R");
        toolbarServices.put("common.delete", MAINTAIN_REPORT_REQUEST_SERVICE);
        toolbarActions.put("common.delete", "D");
        toolbarServices.put("toolbar.report.hold", MAINTAIN_REPORT_REQUEST_SERVICE);
        toolbarActions.put("toolbar.report.hold", "HLD");
        toolbarServices.put("toolbar.report.release", MAINTAIN_REPORT_REQUEST_SERVICE);
        toolbarActions.put("toolbar.report.release", "RLS");
      
        toolbarServices.put("toolbar.report.maintain.reportdefinitions", GET_REPORT_DEFINITIONS_LIST_SERVICE);
        toolbarActions.put("toolbar.report.maintain.reportdefinitions", "M");

        toolbarServices.put("toolbar.reportdefinition.filter",  GET_REPORT_DEFINITIONS_LIST_SERVICE);
        toolbarActions.put("toolbar.reportdefinition.filter", "M");
        toolbarServices.put("common.add", UPDATE_REPORT_DEFINITION_SERVICE);
        toolbarActions.put("common.add", "A");
        toolbarServices.put("toolbar.reportdefinition.view", VIEW_REPORT_DEFINITION_SERVICE);
        toolbarActions.put("toolbar.reportdefinition.view", "E");
        toolbarServices.put("toolbar.reportdefinition.change", UPDATE_REPORT_DEFINITION_SERVICE);
        toolbarActions.put("toolbar.reportdefinition.change", "M");
        toolbarServices.put("common.delete", UPDATE_REPORT_DEFINITION_SERVICE);
        toolbarActions.put("common.delete", "D");
        
        toolbarServices.put("toolbar.consumer.audit", GET_AUDIT_LIST_SERVICE);
        toolbarActions.put("toolbar.consumer.audit", "M");
        toolbarServices.put("toolbar.audit.filter", GET_AUDIT_LIST_SERVICE);
        toolbarActions.put("toolbar.audit.filter", "M");

        toolbarServices.put("toolbar.consumer.merge.filter", GET_CONSUMERS_TOMERGE_LIST_SERVICE);
        toolbarActions.put("toolbar.consumer.merge.filter", "M");
        toolbarServices.put("toolbar.consumer.merge.merge", MERGE_CONSUMERS_SERVICE);
        toolbarActions.put("toolbar.consumer.merge.merge", "M");
     
	    toolbarServices.put("toolbar.instrument.filter", GET_CREDIT_INSTRUMENT_LIST_SERVICE);
        toolbarActions.put("toolbar.instrument.filter", "M");
        toolbarServices.put("toolbar.instrument.change", UPDATE_CREDIT_INSTRUMENT_SERVICE);
        toolbarActions.put("toolbar.instrument.change", "M");
        toolbarServices.put("toolbar.instrument.validate", UPDATE_CREDIT_INSTRUMENT_SERVICE);
        toolbarActions.put("toolbar.instrument.validate", "V");
        toolbarServices.put("common.delete", UPDATE_CREDIT_INSTRUMENT_SERVICE);
        toolbarActions.put("common.delete", "D");
        toolbarServices.put("toolbar.instrument.view", VIEW_CREDIT_INSTRUMENT_SERVICE);
        toolbarActions.put("toolbar.instrument.view", "E");  
        
        toolbarServices.put("toolbar.instrument.cycles", GET_CYCLE_LIST_SERVICE);
        toolbarActions.put("toolbar.instrument.cycles", "M"); 
        toolbarServices.put("common.add", UPDATE_CONSUMER_CONTACT_SERVICE);
        toolbarActions.put("common.add", "A");
        toolbarServices.put("toolbar.cycle.change", UPDATE_CONSUMER_CONTACT_SERVICE);
        toolbarActions.put("toolbar.cycle.change", "M");
        toolbarServices.put("common.delete", UPDATE_CONSUMER_CONTACT_SERVICE);
        toolbarActions.put("common.delete", "D");
        toolbarServices.put("toolbar.cycle.view", VIEW_CONSUMER_CONTACT_SERVICE);
        toolbarActions.put("toolbar.cycle.view", "E");
        
        toolbarServices.put("toolbar.instrument.writeoffs", GET_WRITEOFF_LIST_SERVICE);
        toolbarActions.put("toolbar.instrument.writeoffs", "M");
        toolbarServices.put("toolbar.writeoff.filter", GET_WRITEOFF_LIST_SERVICE);
        toolbarActions.put("toolbar.writeoff.filter", "M"); 
        toolbarServices.put("toolbar.writeoff.change", UPDATE_WRITEOFF_SERVICE);
        toolbarActions.put("toolbar.writeoff.change", "M");
		toolbarServices.put("common.add", UPDATE_WRITEOFF_SERVICE);
		toolbarActions.put("common.add", "A");
		toolbarServices.put("common.delete", UPDATE_WRITEOFF_SERVICE);
		toolbarActions.put("common.delete", "D");
         toolbarServices.put("toolbar.writeoff.view", VIEW_WRITEOFF_SERVICE);
        toolbarActions.put("toolbar.writeoff.view", "E");
        
        toolbarServices.put("toolbar.publicn.filter", GET_PUBLIC_NOTICE_LIST_SERVICE);
        toolbarActions.put("toolbar.publicn.filter", "M");
        toolbarServices.put("toolbar.publicn.change", UPDATE_PUBLIC_NOTICE_SERVICE);
        toolbarActions.put("toolbar.publicn.change", "M");
        toolbarServices.put("common.add", UPDATE_PUBLIC_NOTICE_SERVICE);
        toolbarActions.put("common.add", "A");
        toolbarServices.put("common.delete", UPDATE_PUBLIC_NOTICE_SERVICE);
        toolbarActions.put("common.delete", "D");
        toolbarServices.put("toolbar.publicn.view", VIEW_PUBLIC_NOTICE_SERVICE);
        toolbarActions.put("toolbar.publicn.view", "E");  
        
        toolbarServices.put("toolbar.monitor.filter", GET_MONITOR_LIST_SERVICE);
        toolbarActions.put("toolbar.monitor.filter", "M");
        toolbarServices.put("toolbar.monitor.change", UPDATE_MONITOR_SERVICE);
        toolbarActions.put("toolbar.monitor.change", "M");
        toolbarServices.put("common.add", UPDATE_MONITOR_SERVICE);
        toolbarActions.put("common.add", "A");
        toolbarServices.put("common.delete", UPDATE_MONITOR_SERVICE);
        toolbarActions.put("common.delete", "D");
        toolbarServices.put("toolbar.monitor.view", VIEW_MONITOR_SERVICE);
        toolbarActions.put("toolbar.monitor.view", "E");  
         
        toolbarServices.put("consumer.detail.details.vip", MAINTAIN_VIP_FLAG_SERVICE);
        toolbarActions.put("consumer.detail.details.vip", "A");  
        toolbarActions.put("consumer.detail.details.vip", "D");  
      
    }
    
        
	
	
	
    
	/**
	 * Returns the width, in pixels, of the menu frame.<br>
     * Stored here so that:
     * <ol>
     *     <li>We could, in future, enable the user to customize screen size.</li>
     *     <li>We can make default screen size easily configurable.</li>
     * </ol>
     * 
	 * @return The width, in pixels, of the menu (left) frame.
	 */
    public int getMenuWidth() {
        return (menuWidth);
    }
    
    /**
     * Returns the width, in pixels, of the content (main) frame, including borders.<br>
     * Stored here so that:
     * <ol>
     *     <li>We could, in future, enable the user to customize screen size.</li>
     *     <li>We can make default screen size easily configurable.</li>
     * </ol>
     * 
     * @return The width, in pixels, of the content (main) frame, including borders.
     */
    public int getContentOuterWidth() {
        return (screenWidth - menuWidth);
    }
    
    /**
     * Returns the width, in pixels, of the content (main) frame, excluding borders.<br>
     * Stored here so that:
     * <ol>
     *     <li>We could, in future, enable the user to customize screen size.</li>
     *     <li>We can make default screen size easily configurable.</li>
     * </ol>
     * 
     * @return The width, in pixels, of the content (main) frame, excluding borders.
     */
    public int getContentInnerWidth() {
        return (screenWidth - menuWidth - contentBordersWidth);
    }
    
    /**
     * Returns <code>interactiveLanguage</code> or if that is not set, <code>browserLanguage</code>
     * 
     * @return String
     */
    public String getPreferredLanguage() {
        if (interactiveLanguage == null) {
            return (browserLanguage);
        } else {
            return (interactiveLanguage);
        }
    }
    
    /**
     * Returns the Locale for the preferred language.
     * 
     * @return The Locale for the preferred language.
     */
    public Locale getPreferredLocale() {
        if (getPreferredLanguage() == ENGLISH) {
            return (ENGLISH_LOCALE);
        } else {
            return (ARABIC_LOCALE);
        }
    }
    
    /**
     * Returns the HTTP client (web browser) language setting.<br>
     * A servlet needs to initialise this value from <code>request.getLocale().getLanguage()</code>
     * 
     * @return String
     */
    public String getBrowserLanguage() {
        return browserLanguage;
    }

    /**
     * Returns the direction for displaying elements on the HTML page.<br>
     * When the preferred laguage is <code>ARABIC</code>, <code>direction</code> is "rtl", 
     * (right-to-left) otherwise direction is "ltr".<br>
     * Interactive language selection takes precedence over browser setting.
     * 
     * @return String
     */
    public String getDirection() {
        String language = getPreferredLanguage();
        
        if ((language != null) && (language.indexOf(ARABIC) == 0)) {
            //return (RIGHT_TO_LEFT);
        	return (LEFT_TO_RIGHT);
        } else {
            return (LEFT_TO_RIGHT);
        }
    }

    /**
     * Returns the "start" alignment: "left" when direction is ltr, "right when alignment is rtl
     * 
     * @return String
     */
    public String getAlignStart() {
        String language = getPreferredLanguage();
        
        if ((language != null) && (language.indexOf(ARABIC) == 0)) {
            return (ALIGN_RIGHT);
        } else {
            return (ALIGN_LEFT);
        }
    }

    /**
     * Returns the "end" alignment: "right" when direction is ltr, "left when alignment is rtl
     * 
     * @return String
     */
    public String getAlignEnd() {
        String language = getPreferredLanguage();
        
        if ((language != null) && (language.indexOf(ARABIC) == 0)) {
            return (ALIGN_LEFT);
        } else {
            return (ALIGN_RIGHT);
        }
    }

    /**
     * The user's language preference as set interactively within the application.
     * 
     * @return String
     */
    public String getInteractiveLanguage() {
        return interactiveLanguage;
    }

    /**
     * Saves the HTTP client (web browser) language setting.<br>
     * A servlet needs to initialise this value from <code>request.getLocale().getLanguage()</code>
     * 
     * @param browserLanguage The browserLanguage to set
     */
    public void setBrowserLanguage(String browserLanguage) {
        this.browserLanguage = browserLanguage;
    }

    /**
     * Sets the user's language preference interactively within the application.<br>
     * Also sets the <code>newPageTitle</code> flag.
     * 
     * @param interactiveLanguage The interactiveLanguage to set
     */
    public void setInteractiveLanguage(String interactiveLanguage) {
        newPageTitle = true;
        this.interactiveLanguage = interactiveLanguage;
    }

	/**
	 * Sets the servletContext.
	 * @param servletContext The servletContext to set
	 */
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	/**
	 * Returns the UserID of the user.<br>
     * <code>index.jsp</code> sets this value when the user opens the application home page.
     * 
	 * @return The UserID
	 */
	public String getRemoteUser() {
		return remoteUser;
	}

	

	/**
	 * Returns the userType:
     * <ul>
     *     <li><b>INTERNAL_USER</b> for Internal users</li>
     *     <li><b>EXTERNAL_USER</b> for External users</li>
     * </ul>
	 * @return The user type
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * Returns the Client which user belongs to
	 * @return The User Client
	 */
	public String getUserClient() {
		return userClient;
	}
	/**
	 * Returns the systemError.
	 * @return String
	 */
	public String getSystemError() {
		return systemError;
	}

	/**
	 * Sets the systemError.
	 * @param systemError The systemError to set
	 */
	public void setSystemError(String systemError) {
		this.systemError = systemError;
	}

	/**
	 * Returns the lastForward.
	 * @return String
	 */
	public String getCurrentPage() {
		return currentPage;
	}

	/**
	 * Sets the lastForward.
	 * @param lastForward The lastForward to set
	 */
	public void setCurrentPage(String lastForward) {
		this.currentPage = lastForward;
	}

	/**
	 * Returns the defaultCountryCode.
	 * @return String
	 */
	public String getDefaultCountryCode() {
		return defaultCountryCode;
	}

	/**
	 * Returns the defaultIsdCode.
	 * @return String
	 */
	public String getDefaultIsdCode() {
		return defaultIsdCode;
	}

	/**
	 * Sets the defaultCountryCode.
	 * @param defaultCountryCode The defaultCountryCode to set
	 */
	public void setDefaultCountryCode(String defaultCountryCode) {
		this.defaultCountryCode = defaultCountryCode;
	}

	/**
	 * Sets the defaultIsdCode.
	 * @param defaultIsdCode The defaultIsdCode to set
	 */
	public void setDefaultIsdCode(String defaultIsdCode) {
		this.defaultIsdCode = defaultIsdCode;
	}

	/**
	 * Returns the pageTitle, and resets the <code>newPageTitle</code> flag.
	 * @return String
	 */
	public String getPageTitle() {
        newPageTitle = false;
        //return ((MessageResources)servletContext.getAttribute(Globals.MESSAGES_KEY)).getMessage(getPreferredLocale(), pageTitleKey);
        return "Page Title in UserState";	
	}

    /**
     * Sets the pageTitle.
     * @param pageTitle The pageTitle to set
     */
    public void setPageTitleKey(String pageTitleKey) {
        if (!pageTitleKey.equals(this.pageTitleKey)) {
            newPageTitle = true;
            this.pageTitleKey = pageTitleKey;
        }
    }

	/**
	 * Returns the pageType.
	 * @return String
	 */
	public String getPageType() {
		return pageType;
	}

	/**
	 * Sets the pageType.
	 * @param pageType The pageType to set
	 */
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}

	/**
	 * Returns the session.
	 * @return HttpSession
	 */
	public HttpSession getSession() {
		return session;
	}

	/**
	 * Sets the session.
	 * @param session The session to set
	 */
	public void setSession(HttpSession session) {
		this.session = session;
	}


	/**
	 * set the newPageTitle.
	 * @param none
	 */
	public void setNewPageTitle() {
		this.newPageTitle = true;
	}

	
	/**
	 * Returns the newPageTitle.
	 * @return boolean
	 */
	public boolean isNewPageTitle() {
		return newPageTitle;
	}

	/**
	 * Returns the messages.
	 * @return String[]
	 */
	public String[] getMessages() {
		return messages;
	}

	/**
	 * Returns the messages.
	 * @return String[]
	 */
	public String getMessage(int idx) {
		return messages[idx];
	}

	/**
	 * Sets the messages.
	 * @param messages The messages to set
	 */
	public void setMessages(String[] messages) {
		this.messages = messages;
	}
	
	/**
	 * Reset the messages.
	 */
	public void resetMessages() {
		this.messages = emptyArray;
	}

	/**
	 * Returns the systemException.
	 * @return Exception
	 */
	public Exception getSystemException() {
		return systemException;
	}

	/**
	 * Sets the systemException.
	 * @param systemException The systemException to set
	 */
	public void setSystemException(Exception systemException) {
		this.systemException = systemException;
        if (systemException == null) {
            return;
        }
        
        if (systemException instanceof BSException) {
            BSException bSException = (BSException)systemException;
            if (bSException.isGeneralError()) {
                setSystemError(bSException.getGeneralError().toString());
            } else if (bSException.isSystemError()) {
                setSystemError(bSException.getSystemError());
            } else {
                setSystemError(bSException.getMessage());
            }
        } else {
            setSystemError(systemException.getMessage());
        }
	}

	
	/**
	 * Returns the setupError.
	 * @return boolean
	 */
	public boolean getSetupError() {
		return setupError;
	}


	

}
