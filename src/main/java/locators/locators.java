package locators;
/*Created by Mayureshwar Kadam
 * 03/03/2020
 */

public class locators {
	private static locators ue;
	public static synchronized locators exts(){
		try{
			if(ue.equals(null))
			{
				ue = new locators();
			}
		}
		catch(Exception NOSYSTEM){
			ue = new locators();
		}
		return ue;
	}
	
	
	
	//Login
	public final String Login_email ="//input[@id='LoginControl_UserName']";
	public final String Login_password = "//input[@id='LoginControl_Password']";
	public final String Login_button = "//input[@type='submit']";
	public final String Login_cookies_Ok_button ="//div[@class='cookies jsCookies']//button[text()='Ok']";
	
	//Dashboard
	public final String Dashboard_mdc_top_aap_bar = "//span[contains(@class,'mdc-top-app-bar__title')]//..//button[1]";
	public final String Dashboard_mdc_drawer = "//div[@class='mdc-drawer__content']";
	public final String Dashboard_mdc_drawer_Dashboard = "//a[@href='/EPiServer']";
	public final String Dashboard_mdc_drawer_CMS = "//a[@href='/EPiServer/Cms']";
	public final String Dashboard_mdc_drawer_find = "//a[@href='/EPiServer/Find/#']";
	public final String Dashboard_mdc_drawer_GlobalLink = "//a[contains(@href,'/EPiServer/GlobalLink.Translation/Dashboard')]";
	public final String Dashboard_mdc_drawer_MainDashboard="//a[@href='/EPiServer/GlobalLink.Translation/Dashboard']";
	public final String Dashboard_mdc_drawer_content_CMS="//div[@class='mdc-drawer__content']//a[contains(@href,'/EPiServer/Cms')]";
	public final String Dashboard_Jobname="//div[@class='dijitContentPane']/table/tbody//tr[1]/td[2]/div/span[@class='table-item-detail-content']";
	public final String Edit_Project_Moreoptions="//span[@class='epi-project-mode-toolbar__contextmenu']//span[@title='More options']";
	public final String Edit_Project_Moreoptions_NewProject="//tbody/tr[2]/td[contains(text(),'New Project')]";
	public final String  Edit_Project_Moreoptions_NewProject_Name="//input[@name='name']";
	public final String  Edit_Project_Moreoptions_NewProject_NameOk="//span[contains(text(),'OK')]";
	public final String Edit_Project_Moreoptions_TranslateProject="//tbody/tr[1]/td[contains(text(),'Translate Project')]";
	
	////////////////////ADMINNN
	public final String Gl_Dashboard_admin_Edit="//div[@class='epi-navigation-container2']/ul[@id='global_cms_sub']/li[1]/a[@class='epi-navigation-global_cms_Home ']";
		public final String Gl_Dashboard_admin="//div[@class='epi-navigation-container1']/ul/li[@class='epi-navigation-standard ']/a[contains(@href,'global_cms_sub')]";
		public final String Gl_Dashboard_admin_admin="//div[@class='epi-navigation-container2']/ul[@id='global_cms_sub']/li[2]/a[@class='epi-navigation-global_cms_admin ']";
		public final String Gl_Dashboardadmin_admin_Glschedular="//div[@class='epi-localNavigation']/ul/li[2]/ul[@id='admin_scheduledJobs_sub']/li/a[contains(text(),'Globallink Scheduler')]";
		public final String GL_Schedular_Setting_tab(String tabName){
			return "//div[@class='epi-tabView']//following::a[text()='"+tabName+"']";
		}	
		
		public final String GL_Schedular_HistoryMsg_FirstRow(int documents,int submissions){
			return "//div[contains(@id,'FullRegion_MainRegion')]//tr[3]//td[contains(text(),'"+documents+" documents(s) sent for translation. "+submissions+" submission(s) started.')]";
		}	
		
		public final String GL_Schedular_HistoryMsg_SecondRow(int submissions){
			return "//div[contains(@id,'FullRegion_MainRegion')]//tr[3]td[contains(text(),'sent for translation. "+submissions+" submission(s) started.')]";
		}	
		
		public final String GL_Schedular_HistoryMsg = "//div[contains(@id,'FullRegion_MainRegion')]//tr[2]//td[contains(text(),'OK 0 Completed target(s) imported.  46 target(s) sent for translation. 1 submission(s) started.')]";
		
		public final String Schedular_start_manually="//input[@id='FullRegion_MainRegion_startNowButton']";
		public final String Schedular_window_iframe="//iframe[contains(@src,'/EPiServer/CMS/Admin/SiteInfo.aspx')]";
		public final String schedular_msg="//div[@class='epi-contentArea']/p[@class='EP-systemInfo']";
		
		public final String GL_Admin_Schedular_history_status="//div[@id='FullRegion_MainRegion_TabView']//table[@class='epi-default']/tbody//tr[2]//td[3]";
		
		public  String Gl_Submit_for_translation_Post_Translation_Action_selectOption(String Option){
						return "//div[@class='action-wrapper']//select[@name='publishitem']//option[contains(text(),'"+Option+"')]";
					}
		
		public final String WarningMsg_Schedular_JobStartedWithout_Problems = "//div[contains(text(),'The job started without any problems')]";
		public final String WarningMsg_Scheduler_JobCompleted = "//li[contains(text(),'The job has completed. Please refresh the page to see the status.')]";
		public final String WarningMsg_Schedular_JobIs_Running = "//li[contains(text(),'The job is running')]";
	
	//Globallink Jobs
		public  String Gl_Globalink_Translation_JobName(String JobName){
			return "//div[contains(@data-dojo-type,'ContentList')]//div[3]";
		}
		
		public  String Gl_Globalink_Translation_JobName_Intrash(String JobName){
			return "//table[@class='dgrid-row-table']/tr/td/div[contains(text(),'"+JobName+"')]";
		}		
		
		public  String Gl_Globalink_Translation_JobName_WithoptionsDropdown(String JobName){
			return "//div[contains(@data-dojo-type,'ContentList')]//div[contains(@title,'"+JobName+"')]//..//span[contains(@title,'Options')]";
		}
		public  String Gl_Globalink_Translation_PageName_WithoptionsDropdown(String pageName){
		return "//div[contains(@title,'"+ pageName +"')]//..//span[contains(@data-dojo-attach-point,'iconNodeMenu')]";
		
		}
		public  String Gl_Globalink_Translation_JobName_SelectOptions(String Option){
			return "//table[contains(@widgetid,'uniqName')]//td[contains(text(),'"+Option+"')]";
		}
		
		public  String Gl_Globalink_Translation_ReverifyJobName(String JobName){
			return "//strong[contains(text(),'"+JobName+"')]";
		}
		
		public final String GL_Global_JobDelete_MoveToTrashButton ="//span[contains(text(),'Move to Trash')]";
		public final String GL_Pagename_MoveToTrash="//table[contains(@class,'dijitMenuActive')]//tr[6]//td[contains(text(),'Move to Trash')]";
		public final String GL_MoveToTrash="//span[contains(text(),'Move to Trash Anyway')]";
		public final String GL_Addon_Configuration(String version)
		{
			return "//h1[contains(text(),'GlobalLink Add-on configuration GLEPI"+version+"')]";
			
		}
	//GL GLOBAL
		public  String	Gl_Submit_for_translation_Post_Translation_Action="//table[@id='uniqName_168_0']/tbody/tr/td[2]/input[@class='dijitReset dijitInputField dijitArrowButtonInner']";
	public final String GL_Global_Dashboard ="//div[@class='epi-navigation-container-root']//ul//li//a[@class='epi-navigation-global_dashboard ']";
	public final String GL_Global_CMS ="//div[@class='epi-navigation-container-root']//ul//li//a[contains(text(),'CMS')]";
	public final String GL_Global_GlobalLink ="//div[@class='epi-navigation-container-root']//ul//li//a[@href='#global_admin_sub']";
	public final String GL_Global_Find ="//div[@class='epi-navigation-container-root']//ul//li//a[@class='epi-navigation-global_find']";
	public final String GLGlobal_Ignore="//span[@id='dijit_form_Button_2_label']";
	public final String CMS_edit_Configuration_Include_reffered_content="//div[contains(@widgetid,'dijit__WidgetsInTemplateMixin_12')]";
	public final String CMS_edit_Configuration_Include_Child_Items ="//li[contains(@id,'dijit__TemplatedMixin_52')]//input[@class='dijitReset dijitCheckBoxInput']";
	public final String CMS_edit_Referenced_Content_Types_pages="//div[contains(@widgetid,'dijit_form_CheckBox_17')]//input[contains(@class,'dijitReset dijitCheckBoxInput')]";
	public final String CMS_edit_Referenced_Content_Types_Block="//div[contains(@widgetid,'dijit_form_CheckBox_18')]//input[contains(@class,'dijitReset dijitCheckBoxInput')]";
	public final String CMS_edit_Referenced_Content_Types_Media="//div[contains(@widgetid,'dijit_form_CheckBox_19')]//input[contains(@class,'dijitReset dijitCheckBoxInput')]";
	
	public final String CMS_Edit_Togglebuttons="//span[contains(@title,'Compare different versions')]";
	public final String CMS_edit_Alloy_Content_TeaserText="//textarea[contains(@name,'teaserText')]";
	public final String Content_Mainbody_frmae="//iframe[@id='uniqName_95_5_editorFrame_ifr']";
	public final String CMS_edit_Alloy_Content_Mainbody_Iframe="//label[contains(@title,'Main editorial content of the page')]/..//iframe[contains(@id,'editorFrame')]";
	public final String CMS_edit_Alloy_Content_XhtmlMainbody_Iframe="//iframe[contains(@title,'Rich Text Area')]";	
	public final String CMS_edit_Alloy_Content_Mainbody="//body[contains(@class,'mce-content-body ')]";
	public final String CMS_edit_Content_EditableMainBody="//body[contains(@class,'mce-content-body') and (@contenteditable='false')]";
	public final String CMS_edit_Content_EditableMainBody_Source="//body[contains(@class,'mce-content-body') and contains(@data-id,'14_editorFrame')]";
	public final String Notification_Translation_Job="//div[@class='epi-event__message']/a[contains(text(),'EpiServer_Sub')]";
	public final String Gl_Post_Translation_Action_Select= "//li[@widgetid='dijit__TemplatedMixin_37']//table/tbody/tr/td[2]/input";
	public final String Gl_Submit_for_translation_Post_Translation_Action_select="//div[@id='uniqName_168_0_menu']/table/tbody/tr[3]/td[contains(text(),'Create EPiServer Project For Approval')]";	
	public final String Gl_Submit_for_translation_Post_Translation_Action_select_None="//table[contains(@class,'dijitMenuTable')]//tr//td[text()='None']";
	public final String Gl_Submit_for_translation_Post_Translation_Action_select_AutoPublish="//table[contains(@class,'dijitMenuTable')]//tr[2]//td[text()='Auto Publish']";
	public final String GL_Global_CMS_selected ="//div[@class='epi-navigation-container-root']//ul//li//a[@class='epi-navigation-global_cms  epi-navigation-focus']";
	
	public final String Cms_Select_Project(String Projname)
	{
		return "//label[contains(@class,'epi-selector-list__title dojoxEllipsis')]/strong[contains(@title,'"+Projname+"')]";
	}
	
	public final String GL_Global_CMS_Select_tab(String TabName){
		return "//a[text()='"+TabName+"']";
	}
	
	public final String GL_dashboardt_tab(String TabName){
		return "//div[@class='epi-navigation-row__primary mdc-top-app-bar__row']//following::span[text()='"+TabName+"']";
	}
	//AM
	public final String Dashboard_Notification_GlobalLink = "//a[contains(@href,'/EPiServer/GlobalLink.Translation/Dashboard?jd=')]";	
	public final String Dashboard_Notification_GlobalLink1 = "//a[contains(@href,'/EPiServer/GlobalLink.Translation/Dashboard?jd=')]";	
	public final String Dashboard_DashboardButton ="//div[@class='epi-navigation-container2']//a[@href='/EPiServer/GlobalLink.Translation/Dashboard']";
	public final String Dashboard="//div[text()='Dashboard']/ancestor::a";
	
	//iframes
	public final String GlobalLink_iFrame="//iframe[@src='/EPiServer/GlobalLink.Translation/views/ui/Configuration.aspx']";
	
	public final String GL_Dashboard_Serach_keyword="//div[contains(@class,'fluid')]//input[contains(@placeholder,'Keyword')]";
	public final String GL_Dashboard_Serach_keyword_Button="//div[@class='dijitReset dijitInputField dijitInputContainer']//input[@class='epi-cmsButton-text epi-cmsButton-tools epi-cmsButton-Search']";
	public final String GL_Dashboard_Serach_inallJobs="//input[@ng-reflect-model='true']";
	public final String GL_Dashboard_Search_Message="//div[@class='dijitContentPane']/table/tbody/tr/td[contains(text(),'no data')]";
	public final String GlobalLink_Globallink_config = "//div[@class='epi-navigation-container2']/ul[@id='global_admin_sub']/li[2]/a[@class='epi-navigation-global_admin_main ']";
	public final String GlobalLink_Dashboard ="//div[@class='epi-navigation-container2']/ul[@id='global_admin_sub']/li[1]/a[text()='Dashboard']";
	public final String GlobalLink_Dashboard_selected = "//div[@class='epi-navigation-container2']/ul[@id='global_admin_sub']/li[@class='epi-navigation-selected']";
	
	public final String GlobalLink_Dashboard_table_row="//table[@class='epi-default']//tbody//tr";
	public final String GlobalLink_Dashboard_tree_icon_opened="//span[contains(@class,'dijitChecked')]";
	public final String GlobalLink_Dashboard_tree_icon="//span[contains(@class,'dijitToggleButton')]";
	public final String OtherSetting_Archive="//input[contains(@name,'btnArchive')]";
	public final String Othersetting_Archive_message="//div[@id='UpdatePanel3']//span[@class='lblStatus']";
			//div[contains(@class,'epi-padding')]//span[starts-with(text(),'Archived 0 jobs and ')]";
	public final String Othersetting_Archive_nothing_message="//div[contains(@class,'epi-padding')]//span[contains(text(),'Nothing archvied')]";
	//tree 
	public final String GlobalLink_Dashboard_tree_MyJobs="(//div[@class='f-tree open']//div[@class='node-content-wrapper']//tree-node-content)[1]";
	public final String GlobalLink_Dashboard_tree_ActiveJobs="(//div[@class='f-tree open']//div[@class='node-content-wrapper']//tree-node-content)[2]";
	public final String GlobalLink_Dashboard_tree_CompletedJobs="(//div[@class='f-tree open']//div[@class='node-content-wrapper']//tree-node-content)[4]";
	public final String GlobalLink_Dashboard_tree_PublishedJobs="//div[@class='f-tree open']//div[@class='node-content-wrapper']//tree-node-content[@ng-reflect-index='4']";    
	public final String GlobalLink_Dashboard_tree_CancelledJobs="(//div[@class='f-tree open']//div[@class='node-content-wrapper']//tree-node-content)[6]";
	public final String GlobalLink_Dashboard_tree_ErrorJobs="(//div[@class='f-tree open']//div[@class='node-content-wrapper']//tree-node-content)[7]";
	public final String GlobalLink_Dashboard_tree_ArchiveJobs="//div[@class='f-tree open']//div[@class='node-content-wrapper']//tree-node-content[@ng-reflect-index='7']";  
																
	public final String GlobalLink_Dashboard_tree_PublishedJobplus="//tree-node[@ng-reflect-index='4']/div/tree-node-wrapper/div/tree-node-expander/span";
	public final String GlobalLink_Dashboard_ArchiveCheckbox="//table//tr[1]//td//div[@class='dijit dijitReset dijitInline dijitCheckBox']//input[contains(@class,'archiveItemCheck')]";
	public final String GlobalLink_Dashboard_ArchiveCheckbox_checked="//table//tr[1]//td//div[contains(@class,'dijitCheckBoxChecked ')]//input[contains(@class,'archiveItemCheck')]";
	public final String GlobalLink_Dashboard_Search_In_all_Jobs="//input[@ng-reflect-model='false']";
	public final String GlobalLink_Dashboard_Archive_selected_jobs_button="(//div[@class='f-tree open']//div[@class='node-content-wrapper']//tree-node-content)[7]";
	public final String GlobalLink_Dashboard_tree_CancelledJob="(//div[@class='f-tree open']//div[@class='node-content-wrapper']//tree-node-content)[6]";
	
	public final String GlobalLink_addon_config_text = "//div[@class='epi-contentContainer epi-padding']//h1[contains(text(),'Add-on configuration ')]";
	public final String GlobalLink_Changes_Saved_msg = "//span[@id='lblStatus1'] [text()='Changes saved. GlobalLink Configuration is correct']";
	public final String GlobalLink_Changes_Saved_NOPDconnection_msg = "//span[@id='lblStatus1']//font [text()='No PD connection']";
	public final String GlobalLink_Changes_Saved_incorrect_login_msg = "//span[@id='lblStatus1']//font [text()='Incorrect login information']";
	public final String GlobalLink_Changes_Saved_classifier_notSupported_msg = "//span[@id='lblStatus1']//font [text()='Classifier not supported']";

	//Verify submission status
	public final String GlobalLink_Dashboard_verify_Archived_status="//div[contains(@class,'table-language')]//table//tr[1]//td[4]//span[contains(text(),'Archived')]";
	public final String GlobalLink_Dashboard_verify_Imported_status="//div[contains(@class,'table-language')]//table//tr[1]//td[4]//span[@title='Imported']";
	public final String GlobalLink_Dashboard_verify_Sent_status="//div[contains(@class,'table-language')]//table//tr[1]//td[4]//span[@title='Sent']";
	public final String GlobalLink_Dashboard_verify_Published_status="//div[contains(@class,'table-language')]//table//tr[1]//td[4]//span[contains(text(),'Published')]";
	public final String GlobalLink_Dashboard_AutomationJob="//div[@class='header']//h4[starts-with(text(),'The result for term:')]";
	
	public final String Edit_Selectpage_howtobuy="//span[contains(text(),'How to buy')]/..//span[contains(@class,'dijitTreeExpandoClosed')]";
	
	
	//Dashboard Table
	public final String GlobalLink_Dashboard_Submission_ID="//div[contains(@class,'table-language')]//table//tbody//tr[1]//td[1]//span[@class='table-item-detail-content']";
	public final String GlobalLink_Dashboard_Job_Name="//div[contains(@class,'table-language')]//table//tbody//tr[1]//td[2]//span[@class='table-item-detail-content']";
	public final String GlobalLink_Dashboard_MaxJob_Name="//div[contains(@class,'table-language')]//table//tbody//tr[2]//td[2]//span[@class='table-item-detail-content']";
	public final String GlobalLink_Dashboard_Target_language="//div[contains(@class,'table-language')]//table//tbody//tr[1]//td[3]//span[@class='table-item-detail-content']";
	public final String GlobalLink_Dashboard_Status="//div[contains(@class,'table-language')]//table//tbody//tr[1]//td[4]//span[@class='table-item-detail-content']";
	public final String GlobalLink_Dashboard_Date="//div[contains(@class,'table-language')]//table//tbody//tr[1]//td[6]//span[@class='table-item-detail-content']";
	public final String GlobalLink_Dashboard_Modified ="//div[contains(@class,'table-language')]//table//tbody//tr[1]//td[7]//span[@class='table-item-detail-content']";
	public final String GlobalLink_Dashboard_Creator="//div[contains(@class,'table-language')]//table//tbody//tr[1]//td[5]//span[@class='table-item-detail-content']";
	public final String GlobalLink_Dashboard_Submission_DatePrint = "//div[contains(@class,'dijitReset')]//div[contains(@class,'dijitInputContainer')]//input[contains(@name,'dueDate')]";
	public final String GlobalLink_Dashboard_Target_languageFound(String Lang)
	{
		return "//div[contains(@class,'table-language')]//table//tbody//tr[1]//td[3]//span[contains(text(),'"+Lang+"')]";
	}
	public final String GlobalLink_Dashboard_cancel_chkbox="//div[contains(@class,'dijitContentPane')]//table//tbody//tr[1]//td[8]//input[@class='dijitReset dijitCheckBoxInput archiveItemCheck']";
	public final String GlobalLink_Dashboard_cancelJobs="//div[contains(@class,'archive-Job')]//span[2]//input[contains(@class,'epi-cmsButton-text epi-cmsButton-tools epi-cmsButton-Save')]";
	public final String GlobalLink_Dashboard_Submission_DateValue(String Date){
		return "//div[contains(@class,'NoGutter')]//ul//li//div[contains(@id,'DateTime')]//input[contains(@value,'"+Date+"')]";
	}
	//Dashboard Submission
	public final String GL_Dashboard_Submission_Contentname="//div[@class='dijitContentPane']/table/tbody/tr[1]/td[1]/div/span/a";
	public final String GL_Dashboard_Submission_References="//div[@class='dijitContentPane']/table/tbody/tr[1]/td[2]/div/span";
	public final String GL_Dashboard_Submission_Contenttype="//div[@class='dijitContentPane']/table/tbody/tr[1]/td[3]/div/span";
	public final String GL_Dashboard_Submission_targetlang="//div[@class='dijitContentPane']/table/tbody/tr[1]/td[4]/div/span";
	public final String GL_Dashboard_Submission_status="//div[@class='dijitContentPane']/table/tbody/tr[1]/td[5]/div/span";
	public final String GL_Dashboard_Submission_translated="//div[@class='dijitContentPane']/table/tbody/tr[1]/td[6]/div/span";
	//Am
	
	
	 public final String Globallink_DB_Date_Button="//input[contains(@id,'cleanDateBtn')]";
    public final String Globallink_DB_Date_Button_Before="//div[@id='widget_cleanOldDate']//input[contains(@class,'dijitReset dijitInputField dijitArrowButtonInner')]"; //div[@class='epi-contentContainer']//input[contains(@name,'cleanOldDateBtn')]";
    public final String Globallink_DB_Date_Button_after_button= "//div[@id='widget_cleanDate']//input[contains(@class,'dijitReset dijitInputField dijitArrowButtonInner')]";	  
    public final String Globallink_DB_Date_Button_before_button_cal="//table[@id='cleanOldDate_popup']/tbody/tr[4]/td[3]/span[contains(text(),'22')]";
    public final String Globallink_DB_Date_Button_after_button_cal="//table[@id='cleanDate_popup']/tbody/tr[3]/td[6]/span[contains(text(),'18')]";       
    public final String Globallink_DB_Date_Button_after_text= "//div[@class='epi-contentContainer']//input[contains(@name,'cleanDate')]";
    public final String GlobalLink_DB_All_submissions_created_before="//div[@class='epi-contentContainer']//input[contains(@name,'cleanType')]//..//label[contains(text(),'All submissions created before')]";
    public final String Globallink_DB_Date_Button_before_button_cal1="//div[contains(@class,'dijitReset dijitInputField dijitInputContainer')]//input[@id='cleanOldDate']";
    public final String Globallink_DB_Date_Button_after_button_cal1 ="//div[contains(@class,'dijitReset dijitInputField dijitInputContainer')]//input[@id='cleanDate']";
  
	
	 //Setting tab
    public final String GlobalLink_Schedular_Active="//div[@class='epi-indent']//input[contains(@id,'FullRegion_MainRegion_isActiveInput')]";
    public final String GlobalLink_Schedular_Jobinterval="//div[@class='epi-size15']//input[contains(@class,'EP-requiredField')]";
    public final String GlobalLink_Schedular_Jobinterval_select_Time(String Time_In){
		return "//div[@class='epi-size15']//select[contains(@name,'ctl00$FullRegion$MainRegion$recurrenceInput')]//option[contains(@value,'"+Time_In+"')]";
	}

    public final String GlobalLink_Schedular_NextSchedular_Date_Button="//div[@class='epiinputdate']//input[contains(@class,'epismallbutton')]";
    public final String GlobalLink_Schedular_Jobinterval_select_TimeInterval(String Time_In){
  		return "//div[contains(@id,'timerow')]//select[@id='f_time']//option[contains(@value,'"+Time_In+"')]";
  	}
    public final String GlobalLink_Schedular_NextSchedular_Date_OK_Button="//div[@class='epi-buttonContainer']//input[@id='FullRegion_ctl00']";
    public final String GlobalLink_Schedular_Save_Button="//input[contains(@id,'FullRegion_MainRegion_saveChanges')]";
    public final String GlobalLink_Schedular_Save_msg="//div[@class='EP-systemMessage EP-systemMessage-None']";
    public final String GlobalLink_Schedular_Stop_Job_Button= "//input[contains(@id,'FullRegion_MainRegion_stopRunningJobButton')]";
    public final String GlobalLink_Schedular_Date_select="//div[@class='epi-paddingVertical-small']//table/tbody/tr[6]/td[1]";
    public final String GlobalLink_Schedular_history_Message="//div[@id='FullRegion_MainRegion_TabView']//table[@class='epi-default']/tbody//tr[2]//td[5]";
    //////
    
	public final String GlobalLink_Dashboard_Back_Button="//input[@class='epi-cmsButton-text epi-cmsButton-tools epi-cmsButton-ArrowLeft']";
	public final String GlobalLink_Dashboard_table_row_Header_Content="//table[@class='epi-default']//thead/tr/th[1]";
	public final String GlobalLink_Dashboard_table_row_Header_Content_type="//table[@class='epi-default']//thead/tr/th[3]";
	public final String GlobalLink_Dashboard_table_row_Header_Target_Language="//table[@class='epi-default']//thead/tr/th[4]";
	
	public final String GlobalLink_Dashboard_table_row_Header_Status="//table[@class='epi-default']//thead/tr/th[5]";
	public final String GlobalLink_Dashboard_table_row_Header_Translated="//table[@class='epi-default']//thead/tr/th[6]";
	public final String GlobalLink_Dashboard_table_row_Header_Published="//table[@class='epi-default']//thead/tr/th[7]";
	public final String GlobalLink_Wizard_ContenttypeSelect="//select[@id='lstNTSource']";
	public final String GlobalLink_Wizard_Contenttype="//select[@id='lstNTSource']";
	//GlobalLink Settings main tabs
	
	public final String GlobalLink_GlobalLink_Settings_Tab="//div[@class='epi-tabView']//a[text()='GlobalLink Settings']";
	public final String  GlobalLink_GlobalLink_Fieldselect="//div[@class='ui-icon']";
	public final String  GlobalLink_GlobalLink_Fields="//ul[@id='filteredList']";
	public final String GlobalLink_GlobalLink_Settings_Tab(String TabName){
		return "//div[@class='epi-tabView']//a[contains(text(),'"+TabName+"')]";
	}
	
	public final String GlobalLink_Admin_TabOptions(String TabName){
		return "//div[contains(@id,'FullRegion_adminPanel')]//a[contains(text(),'"+TabName+"')]";
	}
	
	 
	public final String GlobalLink_DB_allsubmissions_active_history="//div[@class='epi-contentContainer']//input[contains(@name,'cleanType')]//..//label[contains(text(),'All submissions (active and history)')]";
	public final String GlobalLink_DB_all_active_submissions_only="//div[@class='epi-contentContainer']//input[contains(@name,'cleanType')]//..//label[contains(text(),'All active submissions only (keep history)')]";
	public final String GlobalLink_DB_all_active_submissions_keepactive="//div[@class='epi-contentContainer']//input[contains(@name,'cleanType')]//..//label[contains(text(),'All history submissions only (keep active)')]";
	public final String GlobalLink_DB_All_submissions_created_after="//div[@class='epi-contentContainer']//input[contains(@id,'cleanType3')]//..//label[contains(text(),'All submissions created after')]";
	public final String Globalink_DB_password_input = "//div[@class='epi-contentContainer']//input[contains(@name,'cleanPassword')]";
	public final String Globallink_DB_clean_button ="//input[contains(@value,'CLEAN')]";
	public final String Globallink_DB_remap_button ="//input[contains(@value,'Remap')]";
	
	public final String Globallink_DB_all_active_submissions_keep_history ="//div[contains(@class,'epi-contentContainer')]//span[contains(@id,'lblStatus6')]";
        public final String  Globallink_DB_password_incorrect="//div[contains(@class,'epi-contentContainer')]//span[contains(@id,'lblErorrStatus6')]";
        
     //Set access right Locators
     public final String SAR_select_Globalink_translation = "//a[contains(text(),'GlobalLink Translations')]";
     public final String SAR_inherit_setting_checkbox = "//div//input[contains(@id,'FullRegion_MainRegion_IsInherited')][contains(@type,'checkbox')]";
     
     //Administrator Role
     public final String SAR_administrator_read_setting_checkbox = "//table[contains(@class,'accessrights')]//tr[contains(@id,'0')]//td//input[@id='FullRegion_MainRegion_p_0_1']";
     public final String SAR_administrator_create_setting_checkbox = "//table[contains(@class,'accessrights')]//tr[contains(@id,'0')]//td//input[@id='FullRegion_MainRegion_p_0_2']";
     public final String SAR_administrator_change_setting_checkbox = "//table[contains(@class,'accessrights')]//tr[contains(@id,'0')]//td//input[@id='FullRegion_MainRegion_p_0_4']";   
     public final String SAR_administrator_delete_setting_checkbox = "//table[contains(@class,'accessrights')]//tr[contains(@id,'0')]//td//input[@id='FullRegion_MainRegion_p_0_8']";
     public final String SAR_administrator_publish_setting_checkbox = "//table[contains(@class,'accessrights')]//tr[contains(@id,'0')]//td//input[@id='FullRegion_MainRegion_p_0_16']";
     public final String SAR_administrator_administer_setting_checkbox = "//table[contains(@class,'accessrights')]//tr[contains(@id,'0')]//td//input[@id='FullRegion_MainRegion_p_0_32']";
	
     
     //Everyone Role
     public final String SAR_everyone_read_setting_checkbox = "//table[contains(@class,'accessrights')]//tr[contains(@id,'1')]//td//input[@id='FullRegion_MainRegion_p_1_1']";
     public final String SAR_everyone_create_setting_checkbox = "//table[contains(@class,'accessrights')]//tr[contains(@id,'1')]//td//input[@id='FullRegion_MainRegion_p_1_2']";
     public final String SAR_everyone_change_setting_checkbox = "//table[contains(@class,'accessrights')]//tr[contains(@id,'1')]//td//input[@id='FullRegion_MainRegion_p_1_4']";   
     public final String SAR_everyone_delete_setting_checkbox = "//table[contains(@class,'accessrights')]//tr[contains(@id,'1')]//td//input[@id='FullRegion_MainRegion_p_1_8']";
     public final String SAR_everyone_publish_setting_checkbox = "//table[contains(@class,'accessrights')]//tr[contains(@id,'1')]//td//input[@id='FullRegion_MainRegion_p_1_16']";
     public final String SAR_everyone_administer_setting_checkbox = "//table[contains(@class,'accessrights')]//tr[contains(@id,'1')]//td//input[@id='FullRegion_MainRegion_p_1_32']";
     
     
   //WebAdmins Role
     public final String SAR_webadmin_read_setting_checkbox = "//table[contains(@class,'accessrights')]//tr[contains(@id,'2')]//td//input[@id='FullRegion_MainRegion_p_2_1']";
     public final String SAR_webadmin_create_setting_checkbox = "//table[contains(@class,'accessrights')]//tr[contains(@id,'2')]//td//input[@id='FullRegion_MainRegion_p_2_2']";
     public final String SAR_webadmin_change_setting_checkbox = "//table[contains(@class,'accessrights')]//tr[contains(@id,'2')]//td//input[@id='FullRegion_MainRegion_p_2_4']";   
     public final String SAR_webadmin_delete_setting_checkbox = "//table[contains(@class,'accessrights')]//tr[contains(@id,'2')]//td//input[@id='FullRegion_MainRegion_p_2_8']";
     public final String SAR_webadmin_publish_setting_checkbox = "//table[contains(@class,'accessrights')]//tr[contains(@id,'2')]//td//input[@id='FullRegion_MainRegion_p_2_16']";
     public final String SAR_webadmin_administer_setting_checkbox = "//table[contains(@class,'accessrights')]//tr[contains(@id,'2')]//td//input[@id='FullRegion_MainRegion_p_2_32']";
     
     //Locale mapping
	public final String CMS_admin_localeMapping_add_button="//div//span[@class='epi-cmsButton']//input[@value='Add']";
	public final String CMS_admin_localeMapping_EpiLoacaleSource_list="//div[@class='epi-formArea']//select[@id='lstSource']";
	
	public final String CMS_admin_localeMapping_GlobalLink_locale_list="//div[@class='epi-formArea']//select[@id='lstTargets']";
	
	
	public final String CMS_admin_localeMapping_EpiLoacaleSource_list_select_language(String Language){
		return "//div[@class='epi-formArea']//select[@id='lstSource']//option[contains(@value,'"+Language+"')]";
	}
	
	public final String CMS_admin_localeMapping_GlobalLink_locale_list_select_language(String Language){
		return "//div[@class='epi-formArea']//select[@id='lstTargets']//option[contains(@value,'"+Language+"')]";
	}

	public final String  GlobalLink_Locale_Mapping_Ava_Source_Locale="//div[@class='epi-formArea']//input[@id='chkAvSource']";
	public final String  GlobalLink_Locale_Mapping_Ava_Target_Locale="//div[@class='epi-formArea']//input[@id='chkAvTarget']";
	public final String GlobalLink_Reviewers_Email="//div[@class='epi-formArea']//input[@name='txtEmailReviewers']";
	
	
	//AM- Other Setting Tab-S
		public final String GlobalLink_Other_Settings_Tab="//div[@class='epi-tabView']//a[starts-with(text(),'Other')]";
		public final String GlobalLink_Other_Settings_Tab(String TabName) {
			// TODO Auto-generated method stub
			return "//div[@class='epi-tabView']//a[starts-with(text(),'"+TabName+"')]";
		}
		
		public final String GlobalLink_OtherSetting_Scheduler_User="//div[@class='epi-formArea']//input[@name='txtSchedulerUser']";//*[@id="txtSchedulerUser"]//"
		public final String GlobalLink_OtherSetting_Retrived_Completed="//div[@class='epi-formArea']//select[@name='lstRetrieveType']";
		public final String GlobalLink_OtherSetting__Log_Lavel="//div[@class='epi-formArea']//select[@name='lstLogLevel']";
		public final String GlobalLink_OtherSetting_Setting_Submission="//div[@class='epi-formArea']//input[@id='chkKeepOnUninstall']";
		public final String GlobalLink_OtherSetting_SubmitJob="//select[@name='lstSubmitType']";
		public final String GlobalLink_OtherSetting_SubmitJobSelect(String Job)
		{
			return "//select[@name='lstSubmitType']/option[contains(text(),'"+Job+"')]";
		}
		public final String GlobalLink_OtherSetting_Allow_Cancellations="//div[@class='epi-formArea']//input[@name='chkAllowCancel']";
		public final String GlobalLink_OtherSetting_Archives_Submissions="//div[contains(@class,'dijitReset dijitRight dijitButtonNode dijitArrowButton dijitDownArrowButton dijitArrowButtonContainer')]";//"//div[@class='epi-formArea']//input[@name='txtArchiveDate']";
		public final String GlobalLink_OtherSetting_Archives_Submissions_date="//div[@id='widget_txtArchiveDate']//input[contains(@class,txtArchiveDate)]";
		public final String GlobalLink_OtherSetting_Archives_Submissions_date_input="//div[@class='dijitReset dijitInputField dijitInputContainer']//input[contains(@id,'txtArchiveDate')]";
		public final String GlobalLink_OtherSetting_Save_Other_Setting="//div[@class='epi-buttonContainer']//input[@name='btnSave3']";
		
		public final String GlobalLink_OtherSetting_Retrived_Completed_selectOption(String Option){
			return "//div[@class='epi-formArea']//select[@name='lstRetrieveType']//option[contains(text(),'"+Option+"')]";
		}
		
		
		public final String GlobalLink_OtherSetting__Log_Lavel_selectOption(String Option){
			return "//div[@class='epi-formArea']//select[@name='lstLogLevel']//option[contains(text(),'"+Option+"')]";
		}
		
		public final String GlobalLink_Changes_saved="//div[@id='UpdatePanel3']//span[@id='lblStatus3']";
		public final String GlobalLink_Other_AdapterSettings_Log="//input[@name='btnDwnlLog']";
		
		//AM-E
		public final String GlobalLinkDashboard_Notification_Selection="//a[@href='/EPiServer/GlobalLink.Translation/Dashboard?jd=604366ed-186d-47c6-afc3-9d36ad052702']";
		public final String GlobalLinkDashboard_Notification_tree="//span[@class='dijit dijitReset dijitInline epi-leadingToggleButton epi-mediumButton dijitToggleButton dijitToggleButtonFocused dijitFocused dijitChecked']";
		//AM-S Plugin_manager
		
				public final String GlobalLink_Config_Plugin_Manager="//table[@class='epi-default']/tbody/tr[3]/td[3]";
				
				//AM--E Plugin_manager
				
				public final String GlobalLink_Dashboard_Notification_Bell="//span[contains(@title,'Notifications')]";
			
		
				//AM-S Wizard Setting
				public  String GlobalLink_WizardTab_Default_project_SelectOptions(String Option){
					return "//div[@class='epi-formArea']//select[@id='lstCmsProject']//option[contains(text(),'"+Option+"')]";
				}
				
				public  String GlobalLink_WizardTab_select_content(String content_name){
					return "//div[contains(@class,'epi-formArea')]//table//td//select//option[contains(text(),'"+content_name+"')]";
				}
				
				//Select content type Buttons
				public final String content_select_right_button = "//td[contains(@class,'roleButtons')]//input[contains(@name,'Button1')]";
				public final String content_select_left_button = "//td[contains(@class,'roleButtons')]//input[contains(@name,'Button2')]";
				public final String content_select_rightAll_button = "//td[contains(@class,'roleButtons')]//input[contains(@name,'Button4')]";
				public final String content_select_leftAll_button = "//td[contains(@class,'roleButtons')]//input[contains(@name,'Button5')]";
				
				public final String CMS_default_Project_select_dropdown = "//label[contains(text(),'GlobalLink Translation Project')]//..//input[contains(@class,'dijitArrowButtonInner')]";
				
				public  String GlobalLink_WizardTab_Default_Source_Locale_SelectOptions_text="//div[@class='epi-formArea']//select[@name='lstDefSource']";
				public  String GlobalLink_WizardTab_Default_GL_Locale_SelectOptions_text="//div[@class='epi-formArea']//select[@name='lstTargets']";
				public  String GlobalLink_WizardTab_Default_Source_Locale_SelectOptions(String Option){
					return "//div[@class='epi-formArea']//select[@name='lstDefSource']//option[contains(text(),'"+Option+"')]";
				}

				public final String GlobalLink_WizardTab_Due_date="//input[@id='txtDefDueDate']";

				public final String advanced_settings_tab = "//a[contains(text(),'Advanced Settings')]";
				public final String content_settings_tab = "//a[contains(text(),'Content Settings')]";
				
				public final String GlobalLink_WizardSetting_Include_child_nodes="//div[@class='epi-formArea']//input[@id='chkIncludeChild']";
				public final String GlobalLink_WizardSetting_Include_unchanged_content="//div[@class='epi-formArea']//input[@id='chkInclUnchanged']";
				
				
				public final String GlobalLink_WizardSetting_referenced_content_Block="//div[@class='epi-formArea']//input[@id='chkIncludeRefBlocks']";
				public final String GlobalLink_WizardSetting_referenced_content_Pages="//div[@class='epi-formArea']//input[@id='chkIncludeRefPages']";
				public final String GlobalLink_WizardSetting_referenced_content_Media="//div[@class='epi-formArea']//input[@id='chkIncludeRefMedia']";
				
				public final String GlobalLink_WizardTab_Reference_depth="//div[@class='epi-formArea']//input[@name='txtRefDepth']";
				
				public final String GlobalLink_WizardSetting_Include_Unchanged_Content="//div[@class='epi-formArea']//input[@id='chkInclUnchanged']";
				public final String GlobalLink_WizardSetting_Include_expired_source_content="//div[@class='epi-formArea']//input[@id='chkInclExpiredSource']";
				public final String GlobalLink_WizardSetting_Include_expired_target_content="//div[@class='epi-formArea']//input[@id='chkInclExpiredTarget']";
				public final String GlobalLink_WizardSetting_Exclude_showing_CMS_content="//div[@class='epi-formArea']//input[@id='chkDisableTree']";
				
				
				public  String GlobalLink_WizardSetting_Post_Translation_Action_selectOption(String Option){
					return "//div[@class='epi-formArea']//select[@name='ddlPostTranslationAction']//option[contains(text(),'"+Option+"')]";
				}
				
				//////
				public  String GlobalLink_SubmitTranslation_Post_Translation_Action_selectOption(String Option){
					return "//div[@class='action-wrapper']//select[@name='publishitem']//option[contains(text(),'"+Option+"')]";
				}
				
				
				
				public final String GlobalLink_WizardSetting_Include_Duplicate_Request="//div[@class='epi-formArea']//input[@id='chkNotCancelIfResend']";
			
				
				///table
				public final String  GlobalLink_WizardSetting_Existing_Content_Type="//div[@class='epi-formArea']//select[@name='lstNTSource']";
				
				public  String GlobalLink_WizardSetting_Existing_Content_Type_selectOption(String Option){
					return "//div[@class='epi-formArea']//select[@name='lstNTSource']//option[contains(text(),'"+Option+"')]";
				}
				
				public  String GlobalLink_WizardSetting_Existing_Content_Type_selectMultiOption(String Option){
					return "//div[@class='epi-formArea']//select[@name='lstNTSource']//option[contains(text(),'"+Option+"')]";
				}
				public  String GlobalLink_WizardSetting_Existing_Content_Type_selectAllOption(String[] Option){
					return "//div[@class='epi-formArea']//select[@name='lstNTSource']//option[contains(text(),'"+Option+"')]";
				}
				public final String GlobalLink_WizardSetting_ContentType_Single_Forword="//div[@class='epi-formArea']//input[@name='Button1']";
				public final String GlobalLink_WizardSetting_ContentType_Single_Backword="//div[@class='epi-formArea']//input[@name='Button2']";
				public final String GlobalLink_WizardSetting_ContentType_Single_DoubleForword="//div[@class='epi-formArea']//input[@name='Button4']";
				public final String GlobalLink_WizardSetting_ContentType_Single_DoubleBackword="//div[@class='epi-formArea']//input[@name='Button5']";
				
				
				
				public final String GlobalLink_WizardSetting_Save_Wizard_Settings="//div[@class='epi-buttonContainer']//input[@name='btnSave9']";
				
				public final String GlobalLink_WizardSetting_Changes_saved="//div[@id='UpdatePanel9']//span[@id='lblStatus9']";
				
				//AM-E Wizard Setting
				
		//AM-S -GlobalLink Export/Import Tab
		public final String GlobalLink_ExpportTab_Property_Import_Excludes="//div[@class='epi-size25']//input[@name='txtExclude']";
		
		public final String GlobalLink_ExpportTab_Copy_properties_from="//div[@class='epi-size25']//select[@name='lstCopyProps']";
		
		public  String GlobalLink_ExpportTab_Copy_properties_from_SelectOptions(String Option){
			return "//div[@class='epi-size25']//select[@name='lstCopyProps']//option[contains(text(),'"+Option+"')]";
		}
		
		public final String GlobalLink_ExpportTab_Copy_Name_in_URL="//div[@class='epi-size25']//select[@name='lstCopyUrl']";
		public  String GlobalLink_ExpportTab_Copy_Name_in_URLselectOption(String Option){
			return "//div[@class='epi-size25']//select[@name='lstCopyUrl']//option[contains(text(),'"+Option+"')]";
		}
		
		public final String GlobalLink_ExpportTab_translatable_fields="//div[@class='epi-size25']//select[@name='lstNTCreate']";
		public  String GlobalLink_ExpportTab_translatable_fields_selectOption(String Option){
			return "//div[@class='epi-size25']//select[@name='lstNTCreate']//option[contains(text(),'"+Option+"')]";
		}
		
		public  String GlobalLink_ExpportTab_Error_Happens_Send_selectOption(String Option){
			return "//div[@class='epi-size25']//select[@name='lstExportErrors']//option[contains(text(),'"+Option+"')]";
		}		
		
		public final String GlobalLink_ExpportTab_source_content="//div[@class='epi-size25']//select[@name='lstNEContent']";
		public  String GlobalLink_ExpportTab_source_content_selectOption(String Option){
			return "//div[@class='epi-size25']//select[@name='lstNEContent']//option[contains(text(),'"+Option+"')]";
		}
		
		public  String GlobalLink_ExpportTab_SimpleAddress_selectOption(String Option){
			return "//div[@class='epi-size25']//select[@name='lstSimpleAddress']//option[contains(text(),'"+Option+"')]";
		}
		
		
		
		public final String GlobalLink_ExpportTab_Default_status="//div[@class='epi-size25']//select[@name='lstSaveStatus']";
		public  String GlobalLink_ExpportTab_Default_status_selectOption(String Option){
			return "//div[@class='epi-size25']//select[@name='lstSaveStatus']//option[contains(text(),'"+Option+"')]";
		}
		
		public final String GlobalLink_ExpportTab_xhtml_import_fails="//div[@class='epi-size25']//select[@name='lstXhtmlImport']";
		public  String GlobalLink_ExpportTab_xhtml_import_fails_selectOption(String Option){
			return "//div[@class='epi-size25']//select[@name='lstXhtmlImport']//option[contains(text(),'"+Option+"')]";
		}
		public final String GlobalLink_ExpportTab_Save_Import_Export_Settings="//div[@class='epi-buttonContainer']//input[@name='btnSave11']";
		public final String GlobalLink_ExpportTab_Save_changees="//div[@id='UpdatePanel11']//span[@id='lblStatus11']";
		//AM-E
		
	//Field configuration tab
	public final String CMS_admin_Field_configuration_tab_list_arrow="//div[@class='epi-formArea']//select[@id='lstTargets']";
	public final String CMS_admin_Field_configuration_tab_list="//input[contains(@class,'custom-combobox-input ui-widget ui-corner-left ui-autocomplete-input')]";
	public final String CMS_admin_Field_configuration_tab_list_selectOption(String Option){
		return "//div[@class='epi-formArea']//select[@id='pageTypeList']//option[contains(text(),'"+Option+"')]";
	}
	
	public final String CMS_admin_Field_configuration_tab_list_option(String Opt)
	{
		return "//ul[contains(@id,'filteredList')]//li[contains(@data-value,'"+ Opt +"')]";
	}
	//AM
	public final String Field_Configuration_Synchronise_Button="//div[@class='epi-contentContainer']//input[@name='syncButton']";
	public final String Field_Configuration_Synchronise_table_imagefile="//table[@id='pagePropsGrid']//tr//td[text()='LongString']";	
	public final String CMS_admin_Field_configuration_Synchronize_button="//span[@class='epi-cmsButton']//input[@value='Save&Test GL Settings']";
	
	//GlobalLink Settings
	public final String GlobalLink_URL="//div[@class='epi-formArea']//input[@name='txtURL']";
	public final String GlobalLink_Username="//div[@class='epi-formArea']//input[@name='txtUsername']";
	public final String GlobalLink_Password="//div[@class='epi-formArea']//input[@name='txtPassword']";
	public final String GlobalLink_SubmissionNamePrefix="//div[@class='epi-formArea']//input[@name='txtPrefix']";
	public final String GlobalLink_Classifier="//div[@class='epi-formArea']//input[@name='txtFileFormat']";
	public final String GlobalLink_Maxnumber_of_filespersubmission="//div[@class='epi-formArea']//input[@name='txtMaxPerSub']";
	public final String GlobalLink_Translation_retrieval_batch_size="//div[@class='epi-formArea']//input[@name='txtMaxTargets']";
	public final String GlobalLink_UID="//div[@class='epi-formArea']//input[@name='txtUserAgent']";
	public final String GlobalLink_Use_UID_for_retrieval_checkbox="//div[@class='epi-formArea']//input[@name='userAgentIdentifier']";
	public final String GlobalLink_Use_UID_for_retrieval_checkbox_checked="//div[@class='epi-formArea']//input[@name='userAgentIdentifier'][@checked='checked']";	
	public final String Gl_Submit_for_translation_Include_expired_target_content_checkbox_checked="//label[contains(text(),'Select Expired Target')]//..//div[contains(@class,'Checked')]//input[contains(@class,'dijitReset dijitCheckBoxInput')]";			

	public final String GlobalLink_Save_and_Test_button="//div[@class='epi-buttonContainer']//input[@name='btnSave1']";
	
	public final String GlobalLink_UID_verify_placeholder(String UID){
		return "//div[@class='epi-formArea']//input[@name='txtUserAgent'][@placeholder='"+UID+"']";
	}

	//Dashboard configuration
	public final String Dashboard_configuration_Job_paging="//div[@class='epi-formArea']//input[@name='txtDashboardPaging']";
	public final String Dashboard_configuration_Save_Configuration_button="//div[@class='epi-buttonContainer']//input[@value='Save Configuration']";
	public final String Dashboard_configuration_Changes_Saved_msg = "//div[contains(@id,'UpdatePanel')]//span[text()='Changes saved']";
	
	
	//lOCAL MAPPING
	public final String Dashboard_configuration_Localemapping_delete_button="//input[contains(@class,'epi-cmsButton-Delete')]";
	
    public final String GlobalLink_Local_mapping_table_chk="//div[@class='epi-contentContainer']//input[@name='GridView2_chkDelete_4']";
	public final String CMS_locale_mapping_selectlanguage(String RowNumber){
		return "//div[@class='epi-contentContainer']//table//tr["+RowNumber+"]//td[1]//span//input";
	}
	
	public final String CMS_locale_mapping_Verifylanguage(String RowNumber, String Lanugae){
			return "//div[@class='epi-contentContainer']//table//td[contains(text(),'"+Lanugae+"')]";
	}	
		
	public final String CMS_locale_mapping_verify_lang_present( String Lanugae){				
	return "//div[@class='epi-contentContainer']//table//td[contains(text(),'"+Lanugae+"')]/..//input[contains(@type,'checkbox')]";
	}	
	//Scheduler	
	public final String Scheduler_Send_targets_checkbox="//input[@id='chkSchedSend']";
	public final String Scheduler_Send_targets_checkbox_checked="//input[@id='chkSchedSend']";
	public final String Scheduler_Retrieve_completed_targets_checkbox="//input[@id='chkSchedRetrieve']";
	public final String Scheduler_Retrieve_completed_targets_checkbox_checked="//input[@id='chkSchedRetrieve']";
	public final String Scheduler_Cancel_targets_checkbox="//input[@id='chkSchedCancel']";
	public final String Scheduler_Cancel_targets_checked="//input[@id='chkSchedCancel']";
	
	public final String CMS_locale_mapping_verify_lang_present1( String Lanugae){
		return "//div[@class='epi-contentContainer']//table//tr//td[contains(text(),'"+Lanugae+"')]";
		}
	
	public final String Scheduler_Start_schedulerbutton="//input[@value='Start scheduler']";
	
	
	public final String Scheduler_JobStarted_msg="//span[text()='Job started']";
	public final String Scheduler_Error_msg="//span[text()='ERROR: Please select at least one task']";
	
	
	//Notification
	public final String Notification_SMTP_Host="//input[@name='txtSmtpHost']";
	public final String Notification_SMTP_Port="//input[@name='txtSmtpPort']";
	public final String Notification_Login="//input[@name='txtSmtpLogin']";
	public final String Notification_Password="//input[@name='txtSmtpPass']";
	
	public final String Notification_Use_SSL_checkbox="//input[@name='chkEnableSSL']";
	public final String Notification_Recipients="//textarea[contains(@id,'txtMailRecepients')]";
	public final String Notification_Sendmailforerrors_checkbox="//input[@name='chkSendError']";
	public final String Notification_Send_mail_for_scheduler_job_results="//input[@name='chkSendSuccess']";
	public final String Notification_Save_Notification_button="//input[@value='Save Notification Settings']";
	public final String Notification_SendTestEmails_button="//input[@id='btnTestEmail']";
	
	
	public final String Notification_Changessaved_msg="//span[text()='Changes saved'] ";
	public final String Notification_Changessaved_Error_msg="//span[(contains(text(),'ERROR:'))]";
	public final String Notification_Test_emails_sent_msg="//span[contains(text(),'Test email(s) sent')]";
	
	//Other Settings Tab
	public final String Dashboard__Versions_gadget_By_GloballinkUser_column="//table//tr[1]//td[1]//span[contains(text(),'GlobalLinkuser')]";	
	public final String gadget_menu_moreoptions = "//span[contains(text(),'Project:')]//..//span[contains(@title,'More options')]";
	public final String gadget_menu_newproject = "//td[contains(text(),'New Project')]";
	
		
	
	//CMS-EDIT	
	public final String CMS_edit_toggle_open="//div[@class='epi-toolbarGroupContainer']//span[@title='Toggle navigation pane'][@aria-pressed='false']";
	public final String CMS_edit_toggle_close="//div[@class='epi-toolbarGroupContainer']//span[@title='Toggle navigation pane'][@aria-pressed='true']";
	public final String CMS_edit_toggle_pin_button="//span[contains(@class,'Pin')]";
	
	//
	public final String CMS_edit_assetspane_toggle_open="//div[contains(@class,'epi-pinnable-unpinned')]//span[contains(@class,'epi-chromelessButton dijitToggleButton')]";
	public final String CMS_edit_assetspane_toggle_close="//div[contains(@class,'epi-pinnable-pinned')]//span[contains(@class,'epi-chromelessButton dijitToggleButton')]";
	public final String CMS_edit_assetspane_pin_button="//span[contains(@title,'Unpin')]";	
	public final String CMS_Edit_asset_togglepane="//span[contains(@class,'epi-iconFolder')]";	
	public final String CMS_edit_assetspane_toggle_close1="//div[@class='epi-toolbarGroupContainer']//span[@title='Pin'][@aria-pressed='false']";
	
	//Page
	public final String CMS_edit_plus_icon="//div[@class='epi-toolbarGroupContainer']//span[@title='Create content']";
	public final String CMS_edit_plus_icon_newpage="//table[contains(@class,'dijitMenuTable')]//tr//td[text()='New Page']";
	
	//New Page
	public final String CMS_edit_newpage_name_input="//div[contains(@class,'epi-createContent')]//input[contains(@id,'dijit_form_ValidationTextBox')]";
	public final String CMS_edit_newpage_Standard_page_="//ul[@class='epi-advancedListing']//li[4]";
	public final String CMS_edit_newpage_Publish_arrow="//span[contains(text(),'Publish?')]//..//span[contains(@class,'ArrowButtonInner')]";//"//span[@id='dijit_form_DropDownButton_16']";
	public final String CMS_edit_newpage_Publish_button="//span[(text()='Publish')]";
	public final String CMS_edit_newpage_Publish_Changes="//span[contains(text(),'Publish Changes')]";
	
	//SUBMISSION
	public final String CMS_edit_submission_NewSubmission_plusIcon="//span[@title='New Job']";
	public final String CMS_edit_submission_NewSubmission_name_input="//input[@id='dijit_form_ValidationTextBox_4']";
	public final String CMS_edit_submission_NewSubmission_name_Ok_button="//div[@class='dijitDialogPaneActionBar']//span[text()='OK']";
	public final String CMS_edit_submission_drop="//label[text()='Reference List']//following::div[1]";
	
	
	//Submission Create Dialog Configuration Tab
	public final String RefDepth_Input1="//input[contains(@name,'txtRefDepth')]";
	public final String RefDepth_Input ="//input[contains(@name,'referenceDepth')]/..//input[contains(@class,'Input')]";
	public final String PostAction_dropdown = "//label[contains(@title,'included in an active translation job')]/..//..//input[contains(@class,'ArrowButton')]";
	public final String IncludeExpiredTarget_CheckBoxChecked = "//li[contains(@class,'epi-form-container__section__row--checkbox')][4]//div[contains(@class,'CheckBoxChecked')]";
	public final String IncludeExpiredTarget_Checkbox = "//li[contains(@class,'epi-form-container__section__row--checkbox')][4]//div[contains(@class,'CheckBox')]/..//..//label";
	public final String clickonspinner ="//label[contains(@for,'dijit_form_NumberSpinner')]";
	public final String createJob_Configuration_checkbox(String value){
		return "//label[contains(@title,'"+value+"')]";
	}
	
	
	public final String createJob_Configuration_checbox_checked(String value){
		return "//label[contains(@title,'"+value+"')]/..//div[contains(@class,'CheckBoxChecked')]";		
	}
	
	public final String createJob_Configuration_RCTypes_checkbox(String value){
		return "//label[contains(text(),'"+value+"')]";
	}
	
	public final String createJob_Configuration_RCTypes__checbox_checked(String value){
		return "//label[contains(text(),'"+value+"')]/..//div[contains(@class,'CheckBoxChecked')]";
		
	}
	
	public final String Select_PostTransAction (String Options) {
		return  "//div[contains(@class,'MenuActive')]//table//td[contains(text(),'"+Options+"')]";
	}	
	//new submission implementation	
	public final String CMS_edit_GL_translation_jobs_arrow="//span[text()='GlobalLink Translation Jobs']//following::span[@title='More options']/span[1][1]";  //"//span[@widgetid='dijit_form_DropDownButton_6']/span/span";
	public final String CMS_edit_submission_Newpage_name="//div[@class='dijitDialogPaneContentArea epi-firstVisible']//input[contains(@id,'dijit_form_ValidationTextBox_')]";//div[@class='dijitReset dijitInputField dijitInputContainer']//input[contains(@id,'dijit_form_ValidationTextBox_1')]";
	public final String CMS_edit_submission_Newpage_Ok="//span[@class='dijitReset dijitInline dijitButtonNode']//span[contains(text(),'OK')]";
	public final String CMS_edit_GL_translation_jobs_arrow_create_job="//span[text()='GlobalLink Translation Jobs']//following::td[text()='Create job from current item']";
	public final String CMS_edit_GL_translation_jobs_AutoSubmitCurrentItem="//span[text()='GlobalLink Translation Jobs']//following::td[text()='Auto Submit Current Item']";
	public final String CMS_new_job_submission_name_input="//input[@name='icontent_name']";
	public final String CMS_edit_GL_translation_jobs_arrow_move_to_trash="(//span[text()='GlobalLink Translation Jobs']//following::td[text()='Move to Trash'])[1]";
	public final String CMS_edit_GL_translation_jobs_arrow_move_to_trash_disabled="(//table//tr[5][@aria-disabled='true']//td[text()='Move to Trash'])[2]";
	public final String CMS_edit_submission_NewSubmission_SA_Change ="//a[contains(@name,'pageExternalURL')]";
	public final String CMS_edit_submission_NewSubmission_SA_ChangeText ="//label[contains(@title,'simple address')]/..//div[contains(@class,'epi-previewableTextBox')]//input[contains(@id,'ValidationTextBox')]";
	public final String CMS_edit_submission_NewSubmission_SA_ChangeModified(String SAText) {
	return "//label[contains(@title,'simple address')]/..//div[contains(@class,'epi-previewableTextBox')]//span[contains(@title,'"+SAText+"')]";
	}
	public final String CMS_edit_submission_NewSubmission_page_title ="//div[contains(@class,'dijitInputContainer')]//input[contains(@name,'metaTitle')]";//"//div[@class='dijitReset dijitInputField dijitInputContainer']//input[contains(@id,'dijit_form_ValidationTextBox_14')]";
	public final String CMS_edit_submission_NewSubmission_page_Keywords ="//div[@class=' epiStringList']//textarea[contains(@class,'dijitTextBox dijitTextArea dijitExpandingTextArea')]";
	public final String CMS_edit_submission_NewSubmission_page_description ="//textarea[contains(@name,'metaDescription')]";
	public final String CMS_edit_GL_translation_jobs_AllProperties="//span[contains(@title,'All Properties')]";
	public final String CMS_edit_GL_translation_AllProperties="//span[contains(@title,'All Properties')]";
	public final String CMS_edit_submission_Newjob_de_de="//a[text()='de-de']";
	public final String CMS_edit_submission_Newjob_it_it="//a[text()='it-it']";
	public final String CMS_edit_submission_SEO="//span[contains(text(),'SEO')]";
	public final String CMS_edit_submission_Newjob_en="//a[(text()='en')]";
	public final String CMS_edit_submission_NewSubmission_page_title_de ="//div[@class='dijitReset dijitInputField dijitInputContainer']//input[contains(@name,'metaTitle')]";
	public final String CMS_edit_submission_NewSubmission_ContentTab="//span[contains(text(),'Content')]";
	public final String CMS_edit_submission_TransSubmission_ContentTab="//span[contains(text(),'Content')]/span";
	public final String CMS_edit_LongString="//input[contains(@name,'longstringContent')]";
	
	public final String CMS_MainBody_Button="//button[@id='mceu_91-button']";
	public final String CMS_MainBody_InsertEditLink="//i[contains(@class,'mce-ico mce-i-link')]";
	public final String CMS_Content_longstringContentsMain="//input[@name='longstringContentsMain']";
	public final String CMS_Content_Refpage="//input[@name='longstringContents']";
	public final String CMS_MainBody_PageButton="//div[contains(@class,'epi-hyperLink')]//span[@aria-disabled='false']//span[3]";
	public final String CMS_MainBody_Linktitle="//input[contains(@name,'title')]";
	
	public final String CMS_MAinbody_Selectpg_OK="//span[@class='dijit dijitReset dijitInline Salt dijitButton']";
	public final String CMS_MAinbody_OK="//span[contains(text(),'OK')]";
	//new page create
	public final String page_AddButton = "//div[contains(@class,'dijitAlignTop')]//span[contains(@class,'epi-iconPlus')]";
	public final String OthersettingTab_DBDump="//input[contains(@id,'btnDumpDb')]";
	public final String OthersettingTab_DBDump_message="//span[contains(text(),'DB dump completed successfully')]";
	
	public final String CMS_MainBody_pageSelect(String pagename){
		return "//a[@class='dijitTreeRow']//span[contains(text(),'"+pagename+"')]";
	}
	public final String add_pagetype(String pagetype){
		return "//table[contains(@aria-labelledby,'DropDownButton')]//td[contains(text(),'"+pagetype+"')]";
	}
	
	public final String select_suggested_pagetype(String pagetype){
		return "//h3[contains(text(),'"+pagetype+"')]";
	}
	
	public final String select_suggested_page(String pageName){
		return "//span[contains(text(),'"+pageName+"')]";
	}
	public final String select_Language(String langName){
		return "//label[contains(text(),'"+langName+"')]";
				
	}
	
	public final String Langtab_SourcelangSelect="//ul[@class='epi-form-container__section dijitLayoutContainer dijitContainer']//li[2]//div[@class='dijitReset dijitInputField dijitButtonText']";//li[contains(@id,'dijit__TemplatedMixin_9')]//div[contains(@class,'dijitReset dijitInputField dijitButtonText')]";
	public final String Langtab_Sourcelang="//td[contains(text(),'English (en)')]";
	//select language
	
	public final String CMS_new_job_configuration_tab="//span[text()='Configuration']";
	public final String CMS_new_job_content_tab="//span[text()='Content']";
	public final String CMS_new_job_configuration_tab_media="//div[@class='epi-checkboxContainer']//input[@id='dijit_form_CheckBox_7']";
	
	public final String CMS_new_job_languages_tab="//span[text()='Languages']";
	public final String CMS_new_TargetJobLanguage="//input[contains(@class,'dijitReset dijitCheckBoxInput')][@aria-checked='true']";
	public final String CMS_new_Job__langTab_Source="//table[contains(@class,'dijitSelect dijitValidationTextBox')]/tbody/tr/td[1]/div[1]/span[contains(text(),'English (en)')]";
	public final String CMS_new_Source_languages_select="//table[contains(@id,'uniqName_179_1')]";
	public final String CMS_new_job_languages_Dede="//label[text()='Deutsch (Deutschland) (de-DE)']";
	public final String CMS_new_job_languages_Frfr="//label[text()='français (France) (fr-FR)']";
	public final String CMS_new_job_language_Instruction="//textarea[@name='instructions']";
	public final String CMS_new_job_Content_page(String Pagename,String val)
	{		
		return "//div[contains(@class,'dijitTreeLabel')]//label[starts-with(text(),'"+Pagename+val+"')]";
	}
	
	public final String CMS_new_GL_Project_select_dropdown = "//div[contains(@id,'dijit__TemplatedMixin')]//label[contains(text(),'GlobalLink Translation Project')]//..//input[contains(@class,'dijitArrowButtonInner')]";
	
	public final String CMS_new_GL_Project_select(String project_name){
		return "//fieldset[contains(@class,'dijitContainer')]//ul//li//table//tr//td//div//span[contains(text(),'"+project_name+"')]";//"//div[contains(@class,'cmsEditingForm')]//label[contains(text(),'GlobalLink Translation Project')]//following::table[contains(@class,'dijitValidationTextBox')][1]//span";
	}
	
	public final String CMS_newSub_GL_Project_select(String project_name){
		return "//table[contains(@class,'dijitReset dijitMenuTable')]//tr//td[text()='"+project_name+"']";
	}
	
	//Tools
	public final String CMS_edit_GL_translation_jobs_Alloy_AllProperties=" //span[@class='dijitReset dijitStretch dijitButtonContents' and @title='All Properties'] ";
	public final String CMS_new_job_tools_arrow="//span[@title='More options for the content']/span[3]";
	public final String CMS_EDIT_Tab="//div[@class='mdc-tab__content']//span[contains(text(),'Edit')]";
	public final String CMS_Job_ToolArrow_LanguageSettings="//td[contains(text(),'Language Settings')]";
	public final String CMS_LanguageSettings_Root="//div[@class='epi-marginVertical']//input[contains(@id,'FullRegion_MainRegion_inheritSettings')]";
			
	public final String testt="//div[@id='FullRegion_MainRegion_availableLanguagesView']//ul//li[contains(text(),'English')]";
	public final String CMS_new_job_tools_arrow_submit_for_translation="//table[contains(@class,'MenuTable')]//tr//td[text()='Submit for Translation']";
	public final String CMS_Job_Tool_arrow_ExpirationArchiving ="//div[contains(@class,'dijitMenuPopup')]//table[contains(@class,'MenuTable')]//tr//td[text()='Manage Expiration and Archiving']";
	public final String CMS_Job_Tool_arrow_ExpirationArchiving_Now="//a[contains(text(),'Now')]";
	public final String CMS_Job_Tool_arrow_ExpirationArchiving_Save="//span[contains(text(),'Save')]";
	public final String CMS_Job_Tool_arrow_Remove_Expiration="//span[contains(text(),'Remove Expiration')]";
	
	public final String ContentPreview_Select_Content="//div[contains(@class,'tree-children')]//div[contains(@class,'dijitChecked')]//input[contains(@class,'dijitCheckBoxInput')]";
	public final String Submit_Translation_Contentpreview(String pagename)
	{
		return "//span[contains(@class,'iconCommonCustom timeExpired')]//..//span[contains(text(),'"+pagename+"')]";
	}
	public final String CMS_new_job_tools_arrow_submit_for_translation1="//div[contains(@class,'dijitMenuPopup')]//table//tr//td[text()='Submit for Translation']";
	public final String CMS_new_job_Submit_for_translation_refresh="//button[contains(text(),'Refresh')]";
	public final String CMS_new_job_Submit_job="//button[text()='Submit Job']";
	public final String CMS_new_job_Submit_job_window_iframe="//iframe[contains(@src,'/EPiServer/globallink.translation/ClientResources/Scripts/Asset/Templates/TranslationConfigurator.aspx')]";
	public final String CMS_LanguageSetting_Root_Iframe="//iframe[contains(@src,'/EPiServer/CMS/Edit/LanguageSettings.aspx?moduleArea=LegacyCMS&id=193&IsInLegacyWrapper=true')]";
	
	public final String CMS_new_job_LoadMore = "//button[contains(text(),'Load items')]"; 
	public final String CMS_new_job_contentPreview_warning = "//div[contains(@class,'tree-content')]//span[contains(@class,'iconCustomWarning')]";
	public final String CMS_new_job_contentPreview = "//span[contains(text(),'Content Preview')]";
//	public final String Submit_Translation_Contentpreview_Selectedcontent="//h4[starts-with(text(),'Selected content ')]";
	public final String Submit_Translation_Contentpreview_Referrencedcontent(int CountNo)
	{
		 return "//label[contains(text(),'Referenced Content ("+CountNo+")')]";
	}
	
	public final String Submit_Translation_Contentpreview_Selectedcontent(int CountNo)
	{
	 return "//h4[starts-with(text(),'Selected content ("+CountNo+")')]";
	}
	
	public final String gettreevalues_selected_content ="//div[contains(@class,'tree-content')]/..//span[contains(@class,'content-name')]";// "//div[contains(@class,'tree-node-level-2 tree-node tree-node-expanded')]/..//div[contains(@class,'node-content-wrapper')]";
	public final String gettreevalues_referenced_content = "//div[contains(@class,'refer-content')]/..//span[contains(@class,'referName')]";
	
	public final String CMS_new_job_tools_arrow_submit_for_translation_source="//div[contains(@class,'content--top')]//h5[contains(text(),'Source Locale: en')]";
	public final String CMS_new_job_tools_arrow_submit_for_translation_target="//div[contains(@class,'content--top')]//h5[contains(text(),'Target Locales: de-DE')]";
	public final String CMS_new_job_tools_arrow_submit_for_translation_GLProject="//div[contains(@class,'content--top')]//h5[contains(text(),'GlobalLink project: EPiServer')]";
	public final String CMS_new_job_tools_arrow_submit_for_translation_Duedate="//div[contains(@class,'content--top')]//h5[contains(text(),'Due date: ')]";
	//
	public final String CMS_new_job_Verify_submision_created_msg="//div[text()='Your job is being sent for translation, you will receive a notification when done.']";
	public final String CMS_new_job_Verify_submision_created_msg_window_View_dashboard_button="//span[text()='View Dashboard']";
	public final String CMS_new_job_Verify_submision_created_msg_window_Close_button="//span[text()='Close']";
	public final String Gl_CMS_Project_Drop="//span[@id='dijit_form__FormValueWidget_0']/span[3]";
	public final String GL_Content_CustomReferences="//div[contains(@class,'dijitTreeLabel')]//label[contains(@class,'dijitTreeLabel2')]";
	
	public final String Content_Preview_selectedContent(String Sel_content)
	{
		return "//span[contains(text(),'"+Sel_content+"')]/..//div[contains(@class,'dijitCheckBoxChecked ')]";
		
	}
	public final String Content_Preview_selectedReferenced(String Ref_Name)
	{
		return "//span[contains(@title,'"+Ref_Name+"')]/..//div[contains(@class,'dijitCheckBoxChecked ')]";
	}
	
	
	//verify submission created
	public final String GL_dashboard_verify_submission_created(String subName){
		return "//span[contains(text(),"+subName+")]";
	}

	public final String GL_dashboard_verify_submission_status(String subName,String status){
		return "//span[contains(text(),'"+subName+"')]//following::td[2]//span[contains(text(),'"+status+"')]";
	}
	
	//Gear / Gadget
	public final String CMS_edit_Settings_gear_button="//span[contains(@class,' dijitbelow-altArrowButton')][@title='Settings']";
	public final String CMS_edit_Settings_gear_button_add_gadgets="//table[contains(@class,'dijitMenu dijitReset')]//tr//td[text()='Add Gadgets']";
	public final String CMS_edit_Settings_gear_button_rearrange_gadgets="//table[contains(@class,'dijitMenu dijitReset')]//tr//td[text()='Rearrange Gadgets']";
	
	public final String CMS_edit_GadgetsWindow_GlobalLink_translation_jobs_gadget="//div[contains(@class,'ui-widget-header')]//following::table//tr//td[text()='GlobalLink Translation Jobs']";
	public final String CMS_edit_GlobalLink_translation_jobs_gadget="//span[text()='GlobalLink Translation Jobs']";
	public final String GL_submit_Translation_include_child_Item="//div[contains(@class,'dijit')]//input[contains(@class,'dijitCheckBoxInput IncludeChildItems')]";
	public final String Gl_Submit_for_translation_Include_Referenced_Content="//div[contains(@class,'dijitChecked')]//input[contains(@class,'dijitCheckBoxInput IncludeReferencedContent')]";
	public final String Gl_Submit_for_translation_Include_child_Items_checkbox_checked="//div[contains(@class,'dijitChecked')]//input[contains(@class,'dijitCheckBoxInput IncludeChildItems')]";
	public final String Gl_Submit_for_translation_Include_unchanged_content_checkbox_checked="//label[contains(text(),'Select Unchanged Content')]//..//div[contains(@class,'Checked')]//input[contains(@class,'dijitReset dijitCheckBoxInput')]";
	public final String Gl_Submit_for_translation_Select_Expired_Source_checkbox_checked="//label[contains(text(),'Select Expired Source')]//..//div[contains(@class,'Checked')]//input[contains(@class,'dijitReset dijitCheckBoxInput')]";
	public final String  Gl_Submit_for_translation_Select_Duplicate_Request_checkbox_checked="//label[contains(text(),'Select Duplicate Request')]//..//div[contains(@class,'Checked')]//input[contains(@class,'dijitReset dijitCheckBoxInput')]";
	public final String Gl_Submit_for_translation_Include_expired_source_content_checkbox_checked="//label[contains(text(),'Select Expired Source')]//..//div[contains(@class,'Checked')]//input[contains(@class,'dijitReset dijitCheckBoxInput ng-untouched ng-pristine ng-valid')]";
	public final String Gl_Submit_for_translation_Include_Duplicate_Request_content_checkbox_checked="//label[contains(text(),'Select Duplicate Request')]//..//div[contains(@class,'Checked')]//input[contains(@class,'dijitReset dijitCheckBoxInput ng-untouched ng-pristine ng-valid')]";
	public final String CMS_Select_tab_edit="//div[@class='mdc-tab-scroller__scroll-content']/a[1][contains(@href,'/EPiServer/Cms')]";
	public final String GL_submit_Translation_Select_content_whitepaper ="//div[contains(@class,'node-content-wrapper')]//span[contains(text(),'Whitepaper')]";
	public final String GL_submit_Translation_Reference_Contents="//div[contains(@class,'f-refer-content-item')]//span[contains(text(),'Contact us (Alloy Track)')]";
	public final String GL_submit_Translation_StartafterPlus="//div[@id='uniqName_0_16']/div[1]/span/span[1]";//div[@id='uniqName_0_23']/div[1]/span/span[1]";
	public final String GlobalLink_translation_Job="//div[contains(@id,'dgrid_4-row-')]/div ";
	public final String GlobalLink_translation_Job_moreoptions="//div[contains(@id,'dgrid_4-row-')]/span[2]";
	public final String GL_submit_Translation_StartafterPlusAlloy="//div[contains(@id,'uniqName_0_44')]/div[1]/span/span[1]";
	public final String Gl_Submit_Translation_Refered_content="//div[contains(@id,'dijit__WidgetsInTemplateMixin_6')]//input[@class='dijitReset dijitCheckBoxInput IncludeReferencedContent ng-pristine ng-valid ng-touched']";
	public final String ContentPreview_Referenced="//label[contains(text(),'Referenced Content (0)')]";
	public final String SubmitTranslation_ContentPreview_Tree="//span[contains(@title,'Event list (Alloy Plan)')]";
	public final String SubmitTranslation_ContentPreview_SubTree="//span[contains(@title,'Events')]";
	
	public final String SubmitTranslation_ContentPreview_SubTree1="//span[contains(@title,'Alloy Plan (Start)')]";
	public final String SubmitTranslation_ContentPreview_SubTree2="//span[contains(@title,'Event list')]";
	public final String SubmitTranslation_ContentPreview_SubTree4="//span[contains(@title,'News list')]";
	///
	public final String Gl_Submit_Translation_IncludeExpired(String Settingname)
	{
			return "//label[contains(text(),'"+Settingname+"')]/..//div[contains(@class,'dijitCheckBox')]";
	}
	public final String submissioninputFrame="//html//body//div";
	public final String content_settings = "//div//a[contains(text(),'Content Settings')]";
	public final String Ignore_Btn="//span[contains(text(),'Ignore')]";
	
	public final String CMS_edit_Gadget_gear_button="//span[@widgetid='dijit_form_DropDownButton_1']";
	public final String CMS_edit_Gadget_gear_button_remove_gadgets="//table[contains(@class,'dijitMenu dijitReset')]//tr//td[text()='Remove Gadget']";
	public final String CMS_edit_Gadget_gear_button_remove_gadgets_Yes_button="//span[text()='Yes']";
	public final String CMS_edit_Settings_gear_button_settings="//div[contains(@class,'dijitVisible ')]//span[contains(@class,'epi-componentSettingsButton')]";//span[@widgetid='dijit_form_DropDownButton_4']/span[1]";
	public final String CMS_edit_Settings_gear_button_settings_trash="//table[contains(@class,'dijitMenuActive')]/tbody/tr[2]/td[contains(text(),'View Trash')]";
	public final String CMS_edit_Settings_gear_button_settings_Blocktotrash="//div[@class='epi-dialogDescriptionSummary epi-firstVisible']";
	public final String CMS_edit_Settings_gear_button_settings_trash_search="//div[@class='dijitReset dijitInputField dijitInputContainer']//input[contains(@id,'uniqName_63_2')]";
	public final String CMS_edit_Move_to_Trash_EmptyTrash="//span[contains(text(),'Empty Trash')]";
	public final String CMS_edit_Move_to_Trash_EmptyTrash_Yes="//span[text()='Yes']";
	
	//Field Config Tab
	public final String Field_ConfigTab_MetaTitle="//input[contains(@id,'pagePropsGrid_chkTranslate_0')]";
	public final String Field_ConfigTab_MetaKeywords="//input[contains(@id,'pagePropsGrid_chkTranslate_1')]";
	public final String Field_ConfigTab_TeaserText="//input[contains(@id,'pagePropsGrid_chkTranslate_2')]";
	public final String Field_ConfigTab_MetaDescription="//input[contains(@id,'pagePropsGrid_chkTranslate_3')]";
	public final String Field_ConfigTab_MainBody="//input[contains(@id,'pagePropsGrid_chkTranslate_4')]";
	
	
	
	//contenttype
	
	public final String Standeredpage_Localized="//table[@class='epi-default epi-table-sortable']/tbody/tr[3]/td[7]";
	public final String Standered_page_Localized_iframe="//iframe[contains(@src,'/EPiServer/CMS/Admin/SiteInfo.aspx')]";
	
	public final String contenttype_Stdpage_AddProperty="//input[@name='ctl00$FullRegion$MainRegion$NewDefinitionButton']";
	public final String CMS_amdnin_containt_iFrame="//iframe[@src='/EPiServer/CMS/Admin/SiteInfo.aspx']";
	public final String CMS_amdnin_containt_common_SettingType="//span[contains(@id,'PropertyDefinitionType')]//select[@class='episize240']";
	
	public  String CMS_Admin_CommonSetting_Type_selectOption(String Option){
		return "//span[contains(@id,'PropertyDefinitionType')]//select[@class='episize240']//option[contains(text(),'"+Option+"')]";
	}
	
	public  String CMS_Admincontenttype_stdpage(String Option){
		return"//div[contains(text(),'"+Option+"')]";
	}
	
	public final String CMS_edit_Settings_Page_gear_button_settings="//div[contains(@class,'dijitVisible ')]//span[contains(@class,'epi-componentSettingsButton')]";//span[contains(@aria-owns,'dijit_Menu_4')][@title='Settings']";
	
	public final String CMS_amdnin_containt_common_Type="//input[contains(@id,'FullRegion_MainRegion_Name')]";
	public final String CMS_amdnin_containt_common_valueperLang="//input[contains(@name,'ctl00$FullRegion$MainRegion$LanguageSpecific')]";
	public final String CMS_amdnin_containt_common_Fieldname="//input[contains(@id,'FullRegion_MainRegion_EditCaption')]";
	public final String CMS_Edit_Start="//span[text()='Start']";
	
	public final String CMS_amdnin_containt_common_HelpText="//input[contains(@id,'FullRegion_MainRegion_HelpText')]";
	public final String CMS_amdnin_containt_common_Tab="//div[contains(@id,'FullRegion_MainRegion_Advanced')]//select[@class='episize240']";
	public  String CMS_Admin_CommonSetting_Type_selectTabOption(String Option){
		return "//div[contains(@id,'FullRegion_MainRegion_Advanced')]//select[@class='episize240']//option[contains(text(),'"+Option+"')]";
	}
	public final String CMS_amdnin_containt_Save="//input[contains(@id,'FullRegion_MainRegion_SaveButton')]";
	
	
	public final String CMS_amdnin_containt_Xhtmlframe="//iframe[contains(@id,'uniqName_95_16_editorFrame_ifr')]";
	public final String CMS_amdnin_containt_Xhtmal_test="//body[contains(@class,'mce-content-body ')]";
	//experiment
	
	public final String CMS_Admin_tab="(//span[text()='GlobalLink Translation Jobs']//following::span[contains(@class,'dijitReset dijitStretch dijitButtonContents dijitDownArrowButton')][@title='Settings'])[1]";
	
	public final String CMS_Select_tab(String tabName){
		return "//div[@class='mdc-tab__content']//following::a[contains(@href,'"+tabName+"')]";
	}	////div[@class='epi-navigation-row__primary mdc-top-app-bar__row']//following::a[contains(@href,'"+tabName+"')]
	
	public final String Select_page(String PageName){
		return "//span[text()='"+PageName+"']//..//span[@class='dijitIcon dijitTreeIcon epi-iconObjectPage']";
	}	
	public final String Select_Block(String PageName){
		return "//span[contains(text(),'"+PageName+"') and @aria-selected='false']//..//span[contains(@class,'dijitIcon dijitTreeIcon epi-iconObjectFolder')]";
	}
	public final String Block_Page="//div[contains(@title,'Event list')]";
	//span[contains(@class,'dijitIcon dijitTreeIcon epi-iconObjectFolder')]/..//span[contains(text(),'Alloy Plan') and @aria-selected='false']
	//CMS Admin tab
	public final String Edit_Gl_Primary_version_draft="//table[@class='dgrid-row-table']/tr/td[2]/span[@title='Primary Draft']";
	public final String Edit_Gl_draftDemo="//div[contains(@class,'dgrid dgrid-grid ui-widget dijitLayoutContainer dijitContainer epi-versions')]//table[@class='dgrid-row-table']//tr//td[contains(text(),'Draft')]//..//td[contains(text(),'de-DE')]";
	public final String Edit_Gl_ReadyPublish="//table[@class='dgrid-row-table']/tr[1]/td[contains(text(),'Ready to Publish')]";
	
	public final String Edit_Gl_version_name(String name)
	{
		return "//table[@class='dgrid-row-table']/tr/td[4]/span[contains(text(),'"+name+"')]";
	}
	
	public final String Edit_Gl_Status(String version)
	{
		return "//div[contains(@class,'epi-versions')]//table/tr/td[contains(text(),'"+version+"')]";
		
	}
	
	public final String Edit_Gl_ProjectStatus(String Projname)
	{
		return"//Strong[contains(text(),'"+Projname+"')]";
	}
	
	public final String EditProject_click="//span[contains(@class,'dijitArrowButtonInner')]/../span[contains(text(),'None (use primary drafts)')]";
	public final String AutoSubmission_GLprojClick="//select[@name='lstAutoSubProject']"; 
	public final String AutoSubmission_Creation ="//input[contains(@id,'chkAutoSubEnabled')]";
	public final String AutoSubmission_Pages="//input[contains(@id,'chkAutoSubRefPages')]";
	public final String AutoSubmission_Blocks="//input[contains(@id,'chkAutoSubRefBlocks')]";
	public final String AutoSubmission_Select_Unchangedcontent="//input[contains(@id,'chkAutoSubUnchanged')]";
	public final String AutoSubmission_GLproj="//select[@name='lstAutoSubProject']//option[contains(text(),'EPiServer')]"; 
	public final String AutoSubmission_SourceLangClick="//select[@name='lstAutoSubSource']";
	public final String AutoSubmission_TargetLangClick="//select[@name='lstAutoSubTarget']";
	public final String AutoSubmission_DueDate="//div[contains(@class,'dijitInputField dijitInputContainer')]//input[contains(@id,'txtAutoSubDue')]";
	public final String AutoSubmission_DueDateClk="//div[@class='defDueDateWrap clearBoth']//input[@class='dijitReset dijitInputField dijitArrowButtonInner']";
	public final String Dashboard_ContentType(String Type)
	{
		return "//table[@class='epi-default']//tbody//tr[1]//span[contains(text(),'"+Type+"')]";
	}
	public final String AutoSubmission_SourceLang(String Lang) {
	
	return "//select[@name='lstAutoSubSource']//option[contains(text(),'"+Lang+"')]";
	}
	
	public final String AutoSubmission_TargetLang(String Lang) {
		
		return "//select[@name='lstAutoSubTarget']//option[contains(text(),'"+Lang+"')]";
		}
	//
	public final String AutoSubmission_Prefix="//input[contains(@name,'txtAutoSubPrefix')]";
	public final String AutoSubmission_ReferenceDepth="//input[contains(@name,'txtAutoSubRefDepth')]";
	
	public final String AutoSubmission_PostTranslationAction="//select[contains(@name,'lstAutoSubPostTrans')]";
	public final String AutoSubmission_PostTranslationActionSelect(String Action) {
	return "//select[contains(@name,'lstAutoSubPostTrans')]//option[contains(text(),'"+Action+"')]";
	}
	public final String AutoSubmission_Save="//input[@name='btnSave14']";
	public final String AutoSubmission_Msg="//span[contains(text(),'Changes saved')]";
	public final String Admin_ConfigTab_plug_in_manager="//div[@id='FullRegion_configPanel']//ul[@id='admin_toolSettings_sub']//li//a[contains(@href,'Plug')]";
	public final String Admin_ConfigTab_GlobalLink_config="//ul[@id='admin_toolSettings_sub']//li//a[contains(@href,'Configuration')]";
	public final String Admin_ConfigTab_ManageWebsite_Lang="//ul[@id='admin_systemConfig_sub']//li//a[contains(@href,'EditlanguageBranches.aspx')]";
	public final String ManageWebsite_Lang_AddLang="//span[@class='epi-cmsButton']//input[@title='Add Language']";
	public final String ManageWebsitelang_iframe="//iframe[@src='/EPiServer/CMS/Admin/SiteInfo.aspx']";
	public final String ManageWebsitelang_save="//input[contains(@title,'Save')]";
	public final String ManageWebsitelang_Delete="//input[contains(@title,'Delete')]";
	public final String ManageWebsitelang_Italia="//table[@class='epi-default']/tbody//td[3]/a[contains(text(),'italiano (Svizzera)')]";
	
	//GCC SERVER
	public final String Gccserver_PSSurl="//input[contains(@name,'txtPssUrl')]";
	public final String Gccserver_PssUser="//input[contains(@name,'txtPssUser')]";
	public final String Gccserver_PSSPssPassword="//input[contains(@name,'txtPssConnector')]";
	public final String Gccserver_PSStxtPssConnector="//input[contains(@name,'txtPssConnector')]";
	public final String Gccserver_PSSPreviewReview="//input[contains(@id,'chkPssAllow')]";
	public final String Gccserver_PSSCleanup="//input[contains(@id,'chkPssCleanup')]";
	public final String Gccserver_PSSGccLogging="//input[contains(@id,'chkGccLogging')]";
	public final String Gccserver_Save="//input[contains(@name,'btnSave13')]";
	public final String Gccserver_Msg="//span[contains(text(),'Changes saved. Connection is correct')]";
	
	public final String ManageWebsitelang_Italia(String Lang){
		return "//div[@class='epi-contentContainer epi-padding']/table/tbody//td[1]/a[contains(text(),'"+ Lang +"')]";
	}
	
	public final String ManageWebsitelang_Chk(String Lang){
		return "//table[@class='epi-default']/tbody//td[3]/a[contains(text(),'"+ Lang +"')]";
	}
	
	public final String Admin_Select_tab(String tabName){
		return "//div[@class='epi-tabView epi-tinyTabs']//following::a[text()='"+tabName+"']";
	}	
	
	
	public final String verify_plugIn_version(String PluginName, String version){
		return "//table[contains(@id,'groupList_assemblyGrid')]//tr//td//a[text()='"+PluginName+"']//..//..//td[3][contains(text(),'"+version+"')]";
	}	
	
	public final String CMS_amdnin_menu_iFrame="//iframe[@src='/EPiServer/CMS/Admin/Menu.aspx']";
	
	//test
	public final String Edit_Notification_msg="//div[@class='epi-event ']//h3[contains(text(),'GlobalLink - Translation job sent')]";
	//
	public final String webtable="//div[@class='f-tree']";
	public final String roes="//div[@class='tree-node-level-1 tree-node tree-node-expanded']";
	
}
