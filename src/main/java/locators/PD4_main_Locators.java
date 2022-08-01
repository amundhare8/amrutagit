package locators;


import org.gs4tr.qa.framework.TestSystem;

import actions.Verify;


public class PD4_main_Locators {
	private static PD4_main_Locators ue;
	
	public static synchronized PD4_main_Locators exts(){
		try{
			if(ue.equals(null))
			{
				ue = new PD4_main_Locators();
			}
		}
		catch(Exception NOSYSTEM){
			ue = new PD4_main_Locators();
		}
		return ue;
	}
	public final String forgetpassLink="//a[contains(text(),'Forgot your Password?')]";
	public final String LoginLink="//a[contains(text(),'Login with local account')]";
	public final String loginButton ="//button//span[contains(text(),'Login')]";//"//span[text()='Log in' or text()='Login']";// "//span[text()='Login']//ancestor::button";
	public final String loginButton_disabled = "//button[contains(@disabled,'true')]//span[contains(text(),'Login')]";//"//a[contains(@class,'disabled')]//span[text()='Log in']";//div[starts-with(@id,'gs4trloginwindow')]//div[starts-with(@id,'button') and contains(@class,'x-item-disabled')]//span[contains(text(),'Login')]/..";
	public final String logoutButton = "//span[text()='Logout']/following-sibling::div";
	public final String inputLoginUsername = "//input[contains(@name,'username')]";//"//input[@name='userName']";
	public final String inputLoginPassword = "//input[contains(@name,'password')]";//"//input[@name='password']";
	public final String inputLoginOldPassword = "//input[@name='oldPassword']";
	public final String inputLoginNewPassword = "//input[contains(@name,'newPassword')][contains(@id,'expiredwindow')]";//"//input[@name='newPassword']";//"//div[@name='newPassword']//input[@name='newPassword']";
	public final String inputLoginNewPasswordRepeat = "//input[contains(@name,'repeatpassword')][contains(@id,'expiredwindow')]";//"//input[@name='repeatpassword']";//"//div[@name='repeatNewPassword']//input[@name='repeatNewPassword']";
	
	public final String admin_accountButton = "//div[contains(@id,'appsettingstool')]//span[contains(@id,'AppSettingsAccountButton')][contains(@class,'toolbar-medium')][2]";//"//div[contains(@id,'appsettingstool')]//span[contains(@id,'AppSettingsAccountButton')]";
	public final String admin_accountButton_impersonate = "//div//a//span[text()='Impersonate']";
	public final String admin_accountButton_switchBack_button = "//span[contains(text(),'Switch Back')]";
	public final String admin_accountButton_impersonate_searchInput = "//div[contains(@name,'userFilter')]//input[contains(@name,'userFilter')]";//"//div[contains(@name,'userFilter')]//input";//"//table[starts-with(@name,'textfield')]//input";
	public final String admin_accountButton_Due_date="//div[@class='x-grid-item-container']//table//tbody//tr[1]//td[9]";
	public final String admin_accountButton_Project ="//div[@class='x-grid-item-container']//table//tbody//tr[1]//td[12]";
	public final String admin_accountButton_Completed2="//span[contains(text(),'Completed')]/..//span[contains(@class,'x-btn-icon-el x-btn-icon-el-default-toolbar-medium submission_completed_pm')]";//"//span[@id='gs4trnavigationgroupfolderbutton-1210-btnEl']//span[contains(text(),'Completed')]";
	public final String admin_accountButton_Completed="//a[@id='gs4trnavigationgroupfolderbutton-1209']//span[@id='gs4trnavigationgroupfolderbutton-1209-btnEl' ]";
	public final String admin_filter_select="//input[contains(@name,'fieldLabelCombo')]";
	public final String admin_filter_Completedtextbox="//input[@name='numberFieldFilter']";
	public final String admin_filter_SubId="//input[contains(@name,'numberFieldFilter')]";
	public final String admin_filter_search="//span[contains(@class,'x-btn-icon-el x-btn-icon-el-default-toolbar-small find ')]";//div[@id='gs4trfilterstoolbar-1154-innerCt']//span[@id='button-1195-btnIconEl']";
	public final String admin_filter_search2="//a[@id='button-1196']";
	public final String admin_Completed_Instruction="//div[@class='x-grid-item-container']//table//tbody//tr[1]//td[14]";
	public final String admin_Completed_Instruction_Details="//div[contains(text(),'language')]";
	public final String Admin_manage_Button="//span[contains(text(),'manage')]";
	public final String Admin_manage_DownloadSource_Button="//span[contains(@id,'pd_download_submission_source_files_action-1366-btnInnerEl')]";
	public final String Admin_manage_DownloadSource_Button_here="//a[contains(text(),'here')]";
	public final String admin_RowSelect(String Sub_Id)
	{
	return "//table[contains(@id,'gridview-1044-record-824')]//tr//td//span[contains(text(),'"+Sub_Id+"')]";
	}
	
	public final String admin_userImpersonationWarning_userName(String userName){
		return "//div[contains(@id,'warningdialog')]//span[contains(text(),'"+userName+"')]";	
	}
	public final String admin_accountButton_impersonate_userX(String userName){
		return "//div[contains(@class,'impersonateusercontainer')]//div[contains(text(),'"+userName+"')]";//"//div[contains(@class,'impersonateuseritem')][contains(text(),'"+userName+"')]";	
	}
	
	
	public final String admin_accountButton_impersonate_user_warningMessage(String userName){
		return "//div[contains(@id,'warningdialog')]//div[contains(text(),'You are about to impersonate the following user: ')]//span[contains(text(),'"+userName+"')]";
	}
	
	
	public final String admin_accountButton_impersonate_yesButton = "//div[contains(@id,'warningdialog')]//span[text()='Yes']";//"//div[contains(@id,'warningdialog')]//span[text()='Yes']/following-sibling::span";
	public final String admin_accountButton_impersonate_noButton = "//div[contains(@id,'warningdialog')]//span[text()='No']";//"//div[contains(@id,'warningdialog')]//span[text()='No']/following-sibling::span";

	public final String admin_usersButton = "//span[text()='Users']";
	public final String admin_projectsButton = "//div[contains(@id,'navigationtoolbar')]//span[contains(text(),'Projects')]";//"//span[text()='Projects']";
	public final String admin_organizationsButton = "//span[contains(text(),'Organizations')]";
	public final String admin_vendorsButton = "//span[contains(text(),'Vendors')]";
	public final String admin_securityButton = "//span[contains(text(),'Security')]/preceding-sibling::span[contains(@class,'security')]";//span[contains(text(),'Security')]";
	public final String admin_workflowDefinitionsButton = "//div[starts-with(@id,'toolbar') and contains(@class,'x-toolbar-default')]//span[text()='Workflows']/following-sibling::span";//ancestor::button";
	public final String admin_translationMemoryButton = "//div[starts-with(@id,'toolbar') and contains(@class,'x-toolbar-default')]//span[text()='TM']";
	public final String admin_deliveryButton = "//div[starts-with(@id,'toolbar') and contains(@class,'x-toolbar-default')]//span[text()='Delivery']";
	public final String admin_reportsButton = "//span[contains(text(),'Reports')]/following-sibling::span";
	public final String admin_Model_languageModelsButton = "//div[contains(@id,'MainGrid')]//span[contains(text(),'Language Models')]";//"//div[starts-with(@id,'toolbar') and contains(@class,'x-toolbar-default')]//span[text()='Language Models']";
	public final String admin_Model_costScopesButton = "//div[contains(@id,'MainGrid')]//span[contains(text(),'Cost Model')]";//div[starts-with(@id,'toolbar') and contains(@class,'x-toolbar-default')]//span[contains(text(),'Cost Scopes')]";
	
	public final String admin_batchMonitorButton = "//span[contains(text(),'Batch Monitor')]";//"//span[contains(text(),'Batch Monitor')]/following-sibling::span";
	public final String admin_clusterInfoButton = "//span[contains(text(),'Cluster Info')]";
	public final String admin_systemActionsButton = "//div[starts-with(@id,'toolbar') and contains(@class,'x-toolbar-default')]//a//span[contains(text(),'System')]";//"//div[starts-with(@id,'toolbar') and contains(@class,'x-toolbar-default')]//a//span[contains(text(),'System Configuration')]";//"//div[starts-with(@id,'toolbar') and contains(@class,'x-toolbar-default')]//span[text()=' System']";
	public final String admin_systemActionsSystemTab = "//div[contains(@name,'MainGrid')]//span[contains(text(),'System')]";//"//div[contains(@name,'mainGrid')]//span[contains(text(),'System')]";
	public final String admin_paClientsButton="//div[contains(@name,'MainGrid')]//span[text()='PA Clients']";//"//div[starts-with(@id,'toolbar') and contains(@class,'x-toolbar-default')]//span[text()='PA Clients']";
	public final String admin_Model_gradingNScoringButton="//div[contains(@id,'MainGrid')]//span[contains(text(),'G+S')]";//"//a//span[text()='G+S']";//"//div[contains(@id,'MainGrid')]//span[contains(text(),'Grading+Scoring')]";
	public final String admin_modelsButton="//div[contains(@id,'navigationgroup')]//span[contains(text(),'Models')]";//"//a//span[text()='G+S']";

	public final String systemActions_configureApplicationButton = "//span[contains(text(),'Configure')]";
	public final String systemActions_configureApplicationButton_trpUrl = "css=div>label:contains('trp.url:')+div>input";
	public final String systemActions_configureApplicationButton_trpPassword = "css=div>label:contains('trp.password:')+div>input";
	public final String systemActions_configureApplicationButton_otsUrl = "//input[contains(@name,'transstudio.address')]";
	public final String systemActions_configureApplicationButton_transstudioRviewUrl="//input[@name='transstudioReview.address']";
	public final String systemActions_configureApplicationButton_transstudioRviewUrl_valueName="//td[div[text()='transstudioReview.address']]/following-sibling::td";
	
	//element for xpathcount (opened tab)
	public final String rowNumber = "//div[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder' and contains(@style,'visible')]/div/div/div/div/div[contains(@class,'x-grid3-row')]";
	
	//Import Workflow Definition
	public final String addButton = "css=div[class='x-window-bl'] button:contains('Add')";

	public final String saveButton = "//div[contains(@id,'AdminVendor')]//span[contains(text(),'Save')]";//"//div[contains(@class,'x-toolbar-footer x-docked-bottom')]//span[contains(text(),'Save')]/following-sibling::span";
	public final String saveAsButton = "//div[contains(@id,'workflowmodelerdialog')]//div[contains(@id,'toolbar')]//span[contains(text(),'Save As')]/following-sibling::span";//"css=div[id*='pdworkflowmodelerdialog'] div[id*='toolbar'] span:contains('Save As')";	
	public final String noButton = "//div[contains(@id,'warning')]//span[contains(text(),'No')]/..";


	public final String yesButton = "//div[contains(@id,'warning')]//span[contains(text(),'Yes')]";

	public final String yesButton2 = "css=button:contains('Yes')";
	public final String logOut_yesButton = "//div[contains(@id,'warningdialog')]//div[contains(@id,'toolbar')]//span[text()='Yes']";
	public final String cacheRefresh_yesButton = "//div[contains(@id,'warningdialog')]//a//span[text()='Yes']";
	public final String removeFilter_yesButton = "//div[contains(@id,'warning')]/div[contains(@class,'x-toolbar-footer')]//span[contains(text(),'Yes')]";//"//div[contains(@id,'warning')]/div[contains(@class,'x-toolbar-footer')]//span[contains(text(),'Yes')]/following-sibling::span";
	public final String finalizeQuote_yesButton = "//div[contains(@id,'gs4trwarningmessage') and contains(@class,'x-window-default')]//div[text()='Are you sure you want to finalize this quote(s)?']//ancestor::div[starts-with(@id,'gs4trwarningmessage-') and (contains(@class,'x-window-default'))]//div[starts-with(@id,'button') and not(contains(@style,'display: none;'))]//span[contains(text(),'Yes')]/ancestor::button";
	
	public final String finishButton = "//span[contains(text(),'Finish')]";
	public final String nextButton = "//span[contains(text(),'Next')]";
	public final String addNewProject_nextButton = "//span[contains(text(),'Next')]";
	public final String nextButtonDisabled = "//div[contains(@id,'toolbar') and contains(@class,'x-toolbar-footer')]//a[contains(@class,'x-item-disabled')]//span[contains(text(),'Next >')]/..";
	public final String nextButton2 = "//span[contains(text(),'Next')]";
	public final String newButton = "//div[contains(@id,'Languages') or contains(@id,'languages')]//div[not(contains(@style,'none'))]//span[text()='New']";
	public final String newButton_Lang = "//span[text()='New']";//"//div[starts-with(@id,'newprojectwizard') and contains(@class,'x-window-body-default')]//div[starts-with(@id,'pdusermanagerlanguagetoolbar')]//span[contains(text(),'New')]/ancestor::button";
	public final String newButton_configureQuotes = "//div[contains(@id,'quotes') or contains(@id,'Quote')][not(contains(@style,'display: none'))]//a//span[text()='New']";

	public final String previousButton = "//span[contains(text(),'Previous')]";//"//span[contains(text(),'Previous')]/following-sibling::span";
	public final String proceedButton = "//span[contains(text(),'Proceed')]/following-sibling::span";

	public final String announcementCloseButton="//div[contains(@id,'pdannouncementwindow')]//span[text()='Close']/..";//css=div[id*='announcement'] button:contains('Close')";
	
	public final String preferences_clearCacheButton = "//span[text()='Clear Cache']";
    public final String preferences_showAnnouncementsButton = "//button[contains(text(),'Show Announcements')]";
	public final String preferencesButton = "//span[text()='Preferences']";
	public final String preferences_preferencesGeneralTab = "//span[contains(text(),'General')]";//"//span[contains(text(),'General')]/following-sibling::span";//"//span[contains(text(),'General')]";
	public final String preferences_general_inputItemsPerPage = "//input[contains(@name,'itemsPerPage')]";//"//input[@name='itemsPerPage']";
	public final String preferences_general_inputReloadTime = "//input[contains(@name,'reloadTime')]";//"//input[@name='reloadTime']";	
	public final String preferences_general_inputLanguage = "//input[contains(@name,'localizationLanguage')]";//"//input[@name='localizationLanguage']";

	public final String preferences_notificationTab_receiveEmail = "//span[text()='Email']/../span";
	public final String preferences_notificationTab="//span[text()='Notifications']";
	public final String preferences_notificationTab_emailAll="//span[text()='Email']/preceding-sibling::span[contains(@class,'checkheader')]";
	public final String preferences_notificationTab_emailAll_checked="//span[text()='Email']/preceding-sibling::span[contains(@class,'checked')]";
	public final String preferences_notificationTab_bubbles="//span[text()='Bubbles']/preceding-sibling::span[contains(@class,'checkheader')]";
	public final String preferences_notificationTab_bubbles_checked="//span[text()='Bubbles']/preceding-sibling::span[contains(@class,'checked')]";
	public final String preferences_notificationTab_dashboardAll="//span[following-sibling::span[text()='Alerts']]";
	public final String preferences_notificationTab_dashboardAll_checked="//span[contains(text(),'Alerts')]/preceding-sibling::span[contains(@class,'checked')]";
	public final String preferences_notificationTab_alertNormalButton = "//div[contains(@class,'alertsnormalgridsmall')]";//"css=div.alertsnormalgridsmall";
	public final String preferences_notificationTab_alertLowButton = "//div[contains(@class,'alertslowgridsmall')]";//"css=div.alertslowgridsmall";
	public final String preferences_notificationTab_alertSelect = "//div[contains(@id,'gs4trpreferencesnotificationstab')]//div[contains(@class,' x-form-arrow-trigger-default  x-form-trigger-focus')]";//"//div[contains(@id,'gs4trpreferencesnotificationstab')]//div[contains(@class,'x-trigger-index-0 x-form-trigger x-form-arrow-trigger x-form-trigger-first')]";    //table[@name='currentPriority']//div[contains(@class,'x-form-arrow-trigger')]";
	
	public final String preferences_notificationTab_alertPrioritySelectX (String priority){
		return "//div[contains(@class,'combo-list-item')][contains(text(),'"+ priority +"')]";//"css=div.x-combo-list-item:contains('"+ priority +"')";
	}
	
	public final String preferences_notificationTab_dueDateItems_firstRowCheckBox = "css=div>div:nth-child(2)>div>table>tbody>tr>td:nth-child(4)>div>div";
	public final String preferences_notificationTab_dueDateItems_firstRowPriority = "css=div>div:nth-child(2)>div>table>tbody>tr>td:nth-child(5)>div>div";	
	public final String preferences_notificationTab_errorItems_firstRowCheckBox = "css=div:nth-child(2)>div:nth-child(2)>div>table>tbody>tr>td:nth-child(4)>div>div";
	public final String preferences_notificationTab_errorItems_firstRowPriority = "css=div:nth-child(2)>div:nth-child(2)>div>table>tbody>tr>td:nth-child(5)>div>div";
	
	public final String preferences_applyButton = "//div[contains(@id,'gs4trpreferences')]//span[contains(@id,'button') and contains(text(),'Apply')]";//"//div[contains(@id,'gs4trpreferences')]//span[contains(@id,'button') and contains(text(),'Apply')]/following-sibling::span";
	public final String preferences_applyButton_disabled ="//div[contains(@id,'gs4trpreferences')]//a[contains(@class,'disabled')]//span[contains(@id,'button') and contains(text(),'Apply')]";//"//div[contains(@id,'gs4trpreferences')]//a[contains(@class,'disabled')]//span[contains(@id,'button') and contains(text(),'Apply')]/following-sibling::span";
	public final String preferences_theamchange_WarningMsg_OkButton = "//div[contains(@id,'warningdialog')]//div[contains(@id,'toolbar')]//span[contains(text(),'OK')]";
	public final String preferences_OkButton = "//div[contains(@id,'gs4trpreferences')]//span[contains(@id,'button') and contains(text(),'OK')]";	
	public final String preferences_OkButton_disabled ="//div[contains(@id,'gs4trpreferences')]//a[contains(@class,'disabled')]//span[contains(@id,'button') and contains(text(),'OK')]";//"//div[contains(@id,'gs4trpreferences')]//a[contains(@class,'disabled')]//span[contains(@id,'button') and contains(text(),'OK')]/following-sibling::span";
	public final String preferences_changePasswordButton = "//span[text()='Change Password']";
	public final String preferences_general_inputOldPassword = "//div[@name='oldPassword']//input[@name='oldPassword']";
	public final String preferences_general_inputNewPassword = "//div[@name='newPassword']//input[@name='newPassword']";

	public final String preferences_general_inputRpeatNewPassword = "//div[@name='newPasswordRepeat']//input[@name='newPasswordRepeat']";	
	public final String preferences_expiredPassword_OkButton ="//div[contains(@id,'expiredwindow')]//button//span[contains(text(),'OK')]";//"//div[contains(@class,'PasswordExpired')]//a//span[text()='OK']";
	public final String preferences_ChangePassword_OkButton ="//div[contains(@class,'ChangePassword')]//a//span[text()='OK']";//"//div[contains(@class,'PasswordExpired')]//div//span[text()='OK']";//"//div[contains(@class,'ChangePassword')]//div//span[text()='OK']";//"//div[contains(@id,'passwordexpired')]//div//span[text()='OK']";//"//div[contains(@id,'ext-comp')][contains(@class,'ChangePassword')]//span[text()='OK']";
	public final String preferences_ChangePassword_CancelButton = "//div[contains(@class,'ChangePassword')]//a//span[text()='Cancel']";
	public final String preferences_ChangePassword_OkButton_enabled ="//div[contains(@class,'ChangePassword')]//a[not(contains(@class,'disabled'))]//span[text()='OK']";
	public final String preferences_ChangePassword_warning_close_btn ="//div[contains(@id,'warningdialog')]//div[contains(@id,'toolbar')]//a//span[text()='Close']";
	public final String preferences_ChangePassword_terminateAllSession_warning_no_btn ="//div[contains(@class,' x-toolbar-footer')]//a//span[contains(text(),'No')]";
	public final String passwordExpired_okButton="//div[contains(@id,'expiredwindow')]//button//span[contains(text(),'OK')]";//"//div[contains(@id,'passwordexpired')]//a//span[text()='OK']";
	
	public final String rowTitleOptions_sortAscending = "//span[text()='Sort ascending']";//"//span[text()='Sort Ascending']";//"css=span:contains('Sort Ascending')";
	public final String rowTitleOptions_sortDescending = "//span[text()='Sort descending']";//"//span[text()='Sort Descending']";//"css=span:contains('Sort Descending')";
	public final String rowTitleOptions_showInGroups = "//a/span[text()='Show in groups']";//"//a/span[text()='Show in Groups']";//a[contains(@id,'menucheckitem') and contains(@class,'x-menu-item-link')]/span[contains(@id,'menucheckitem') and contains(text(),'Show in groups')]/..";//"css=span:contains('Show in Groups')";
	public final String rowTitleOptions_showInGroups_checked = "//div[contains(@class,'x-menu-item-checked')]/a/span[text()='Show in groups']";//"//div[contains(@class,'x-menu-item-checked')]/a/span[text()='Show in Groups']";
	public final String rowTitleOptions_groupByThisField = "//span[text()='Group by this field']/..";

	public final String ascendingSorted_columnX(String columnName)
	{
		return "//div[contains(@id,'gridcolumn')][contains(@class,'sort-ASC')]//span[text()='"+columnName+"']";
	}
	
	
	public final String nameRowTitleOptions_groupByThisField = "//a/span[text()='Group by this field']";//"//a/span[text()='Group By This Field']";
	public final String typeRowTitleOptions_groupByThisField = "//a[contains(@id,'menuitem') and contains(@class,'x-menu-item-link')]/span[contains(@id,'menuitem') and contains(text(),'Group by this field')]/..";
	public final String mouseOverColumns = "//a[contains(@id,'menuitem') and contains(@class,'x-menu-item-link')]/span[contains(@id,'menuitem') and contains(text(),'Columns')]";
	public final String clickOnUsername = "//a[contains(@id,'menucheckitem')]/img/../span[text()='Username']";
	public final String clickOnName = "//a[contains(@id,'menucheckitem')]/span[text()='Name']";
	public final String clickOnLastName = "//a[contains(@id,'menucheckitem')]/img/../span[text()='Last Name']";
	public final String clickOnEnabled = "//a[contains(@id,'menucheckitem')]/span[text()='Enabled']";
	public final String clickOnOrganization = "//a[contains(@id,'menucheckitem')]/span[text()='Organization']";
	public final String ascSortOrder = "//div[contains(@id,'menu')]//span[contains(@id,'menuitem') and contains(text(),'Sort ascending')]";//"//div[contains(@id,'menu')]//span[contains(@id,'menuitem') and contains(text(),'Sort Ascending')]";
	public final String descSortOrder = "//div[contains(@id,'menu')]//span[contains(@id,'menuitem') and contains(text(),'Sort descending')]";//"//div[contains(@id,'menu')]//span[contains(@id,'menuitem') and contains(text(),'Sort Descending')]";
	public final String rowClass = "//div[contains(@id,'pdMainGrid')]//tr[contains(@class,'x-grid-row')]";

	public final String closeButton = "//span[contains(text(),'Close')]";
	public final String applyButton="//span[contains(text(),'Apply')]/following-sibling::span";
	
	public final String firstPageButton = "//a[contains(@data-qtip,'First')]//span[contains(@class,'x-tbar-page-first')]";//"//a[@data-qtip='First Page']//span[contains(@class,'x-tbar-page-first')]";
	public final String previousPageButton = "//a[contains(@data-qtip,'Previous')]//span[contains(@class,'x-tbar-page-prev')]";//"//a[@data-qtip='Previous Page']//span[contains(@class,'x-tbar-page-prev')]";
	public final String nextPageButton = "//a[contains(@data-qtip,'Next')]//span[contains(@class,'x-tbar-page-next')]";//"//a[@data-qtip='Next Page']//span[contains(@class,'x-tbar-page-next')]"; 
	public final String lastPageButton = "//a[contains(@data-qtip,'Last')]//span[contains(@class,'x-tbar-page-last')]";//"//a[@data-qtip='Last Page']//span[contains(@class,'x-tbar-page-last')]";
	public final String inputPageNumber = "//input[@name= 'pageNo']";
	
	
	//Cross button
	public final String crossButtonLastDisplayed = "//div[contains(@class,'x-window-default-closable')]//div[contains(@id,'tool') and contains(@class,'x-tool-default')]/img";
	//crossButtonLastDisplayed works only for the last opened window with cross
		
	
	public final String elementWithText(String itemText) throws Exception{
		//return "//table/tbody/tr/td//span[contains(text(),'"+itemText+"')]";
//		return "//table/tbody/tr/td//div[contains(text(),'"+itemText+"')]";
		
		if(Verify.action().verifyElementPresent("//table/tbody/tr/td//div[contains(text(),'"+itemText+"')]", 5)){
			return "//table/tbody/tr/td//div[contains(text(),'"+itemText+"')]";
		}else{
			return "//table/tbody/tr/td//span[contains(text(),'"+itemText+"')]";
		
		}
	}
	
	/**
	 * This locator is for verify file format name in Edit Project
	 * @param itemText
	 * @return
	 */
	public final String elementWithText_X(String itemText){
		//return "//table/tbody/tr/td//span[contains(text(),'"+itemText+"')]";
		return "//table/tbody/tr/td//span[contains(text(),'"+itemText+"')]";
	}
	
	public final String spanWithText(String text){
		return "//div[contains(@id'gs4trwarningmessage']//div[contains(text(),'"+text+"')]";
	}
	
	public final String divWithText(String text){
		return "//div[contains(text(),'"+text+"')]";
	}
	
	public final String maxPageNumber(){
		String pageNum = TestSystem.SystemEngine().findElement("//div[contains(@id,'gs4trpagingtoolbar')]//label[contains(text(),' of ')]").getText();		
		return pageNum.substring(3);
	}
	
	public final String toolTipText(String text){
		return "//div[contains(@data-qtip,'"+text+"')]";//"//div[@data-qtip='"+text+"']";		
	}
	
	public final String button_toolTipText(String locator)
	{
		return "//a[contains(@data-qtip,'"+locator+"')]";
	}
	
	
	public final String groupTitleX (String title){
		return "//td//div//div[@class='x-grid-group-title'][contains(text(),'"+title+":')]";
	}
	
	public final String errorMessageWithText(String text){
		return "//div[contains(@id,'warning')]//div[text()='"+text+"']";
	}
	
	public final String WarningWithText(String text){
		return "css=span[class='x-window-header-text']:contains('"+text+"')";
	}
	
	public final String WarningWithText2(String text)
	{
		return "//div[contains(@id,'warningmessage')]/div[2]/div[2]//div[text()='"+text+"']";
	}
	

	public final String WarningWithTextPasswExpired ="//div[contains(@class,'expiredwindow')]//p[contains(text(),'Your password has expired. Please change it using the form below.')]";//"//div[contains(@class,'PasswordExpired')]//div[text()='Your password has expired. Please change it using the form below.']";

	public final String WarningWithTextStartSubmission ="//div[contains(@id,'panel') and contains(@class,'x-panel-body-default')][text()='Do you want to start submission?']";
	public final String WarningWithTextSaveData ="//div[contains(@id,'panel') and contains(@class,'x-panel-body-default')][text()='You have unsaved data. Do you want to save changes?']";
	public final String WarningWithTextBatchesWithoutTargLang ="//div[contains(text(),'Batches without target languages detected.')]";//"//div[contains(text(),'There are batches without target languages')]";//div[contains(@id,'panel') and contains(@class,'x-panel-body-default')][text()='There are batches without target languages'];
	public final String WarningWithTextUnchecking ="//div[contains(@id,'panel') and contains(@class,'x-panel-body-default')][text()='Unchecking available translation memories or delivery profiles might cause them being detached from organization projects.']";

	public final String firstDataRow= "//div[contains(@id,'Main')]//table//tr//td";
	public final String firstDataRow_organizationValue = "//div[contains(@id,'pdmaingrid')]//descendant::tr[contains(@class,'x-grid-row')][1]/td[contains(@class,' x-grid-cell')][8]/div";
	public final String verifyCustomFilter(String filter)
	{
		return "//span[text()='"+filter+"']";
	}
	

	public final String refreshButton = "//span[contains(text(),'Refresh')]";
	public final String trpRefreshButton="//button[contains(text(),'Refresh')]";
	public final String helpButton = "//span[contains(@class,'medium help')]";//"//span[contains(@class,'x-btn-icon-el help ')]";
	public final String helpWindow="//title[contains(text(),'GlobalLink_Project_Director_Help')]";
	
	
	//Translation memeory locs-by Amol	
	public final String translationMemoryButton="css=a>span:contains('TM')";//"css=button>span:contains('Translation Memory')";
	public final String translationMemory_addTMButton="css=a[id*='pd_add_tm_profile_action'] span>span:nth-child(2)";
	public final String translationMemory_editTMProfileButton="css=a[id*='pd_edit_tm_profile_action'] span>span:nth-child(2)";
	public final String translationMemory_deleteTMProfileButton="css=a[id*='pd_delete_tm_profile_action'] span>span:nth-child(2)";
	public final String translationMemory_importTMButton="css=a[id*='pd_import_tm_profile_action'] span>span:nth-child(2)";
	
	public final String translationMemory_translationMemorySequenceTab="css=a>span:contains('TRANSLATION MEMORY SEQUENCES')";
	public final String translationMemory_translationMemorySequenceTab_addTMSequence="css=a[id*='pd_add_tm_sequence_action'] span>span:nth-child(2)";
	public final String translationMemory_translationMemorySequenceTab_editTMSequence="css=a[id*='pd_edit_tm_sequence_action'] span>span:nth-child(2)";
	public final String translationMemory_translationMemorySequenceTab_copyTMSequence="css=a[id*='pd_copy_tm_sequence_action'] span>span:nth-child(2)";
	public final String translationMemory_translationMemorySequenceTab_autoCreateTMSequence="css=a[id*='pd_auto_create_tm_sequence_action'] span>span:nth-child(2)";
	// @swapnil have added
	
	public final String  vendor_group_by_display(int index)
	{
		String result="";
		switch(index)
		{
			case 1: result="//td//div[contains(@class,'x-grid-group-title')][contains(text(),'Name')]";
					break;
					
			case 2: result="//td//div[contains(@class,'x-grid-group-title')][contains(text(),'Enabled')]";
					break;
										
		}
		return result;
	}	
	
	public final String import_importButton = "//a//span[text()='Import']";
	public final String import_downloadSummaryReport = "//div[contains(@class,'x-window')]//span[contains(text(),'Download Summary Report')]";
	public final String import_downloadSummaryReport_disabled = "//a[contains(@class,'disabled')]//span[text()='Download Summary Report']/following-sibling::span";
	public final String import_closeButton = "//div[contains(@class,'x-window-default-closable')]//span[text()='Close']";
	
	public final String summaryAddedRejected ="//table[contains(@name,'summaryField')]//div[contains(@name,'summaryField')]";
	
	public final String warningMsg_CancelButton="//div[contains(@id,'warning')]//span[text()='Cancel']";
	public final String warningMsg_DiscardButton="//div[contains(@id,'warning')]//span[text()='Discard']";
	public final String warningMsg_SaveButton="//div[contains(@id,'warning')]//span[text()='Save']";
}
