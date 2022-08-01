package locators;


public class PD4_main_client_dashboard_Locators {
	private static PD4_main_client_dashboard_Locators ue;
	
	public static synchronized PD4_main_client_dashboard_Locators exts(){
		try{
			if(ue.equals(null))
			{
				ue = new PD4_main_client_dashboard_Locators();
			}
		}
		catch(Exception NOSYSTEM){
			ue = new PD4_main_client_dashboard_Locators();
		}
		return ue;
	}
	
//Folders
	public final String workflows_activeSubmissionsButton = "//span[text()='Active']";
	public final String workflows_onHoldSubmissionsButton = "//span[text()='On Hold']";
	public final String workflows_archiveSubmissionsButton = "//span[text()='Archived']";
	public final String workflows_templatesSubmissionsButton = "//span[text()='Templates']";
	public final String workflows_completedSubmissionsButton = "//span[text()='Completed']";
	public final String workflows_gateSubmissionsButton = "//span[text()='Gate']";
	public final String workflows_clientCompletedSubmissionsButton = "css=button.submission_completed_clientfoldermedium";
	
	
//Main Pane

	public final String firstDataRowSubmissionId = "//table[contains(@id,'grid')]//tbody//tr//td[1]//div";
	public final String firstDataRowName = "//div[contains(@id,'pdmaingrid') or contains(@id,'pdMainGrid')]//table//tr//td[2]//div";
	
	public final String firstDataRow_projectName = "//div[contains(@id,'pdmaingrid') or contains(@id,'pdMainGrid')]//table//tr//td[12]//div";
	public final String firstDataRow_ownerName = "//div[contains(@id,'pdmaingrid') or contains(@id,'pdMainGrid')]//table//tr//td[6]//div";
	public final String firstDataRow_submittertName = "//div[contains(@id,'pdmaingrid') or contains(@id,'pdMainGrid')]//table//tr//td[19]//div";
	public final String firstDataRow_customAttribute_combo_value = "//div[contains(@id,'pdmaingrid') or contains(@id,'pdMainGrid')]//table//tr//td[19]//div";
	public final String firstDataRow_customAttribute_text_value = "//div[contains(@id,'pdmaingrid') or contains(@id,'pdMainGrid')]//table//tr//td[20]//div";
	
	public final String firstDataRowName_submissionQuoteStatus(String quoteStatus){
		return "//div[contains(@id,'pdmaingrid') or contains(@id,'pdMainGrid')]//table//tr//td[2]//div/../following-sibling::td//div[contains(@class,'"+quoteStatus+"')]";
	}
	
	public final String firstDataRowName_template = "//table/tbody/tr/td[1]/div";
	public final String secondDataRowName_template="//table[2]/tbody/tr/td[1]/div";//"//table/tbody/tr[2]/td[1]/div";

	public final String secondDataRowName = "//div[contains(@id,'pdMainGrid')]//descendant::tr[contains(@class,'x-grid-row')][2]/td[2]/div[contains(@class,'x-grid-cell-inner')]";//css=table>tbody>tr:nth-child(3)>td:nth-child(3)>div";

	public final String thirdDataRowName = "//table[3]//tbody//tr//td[2]//div";//"//table//tbody//tr[3]//td[2]//div";
	public final String fourthDataRowName = "//table[4]//tbody//tr//td[2]//div";//"//table//tbody//tr[4]//td[2]//div";
	public final String fifthDataRowName = "//table[5]//tbody//tr//td[2]//div";//"//table//tbody//tr[5]//td[2]//div";
	public final String sixthDataRowName = "//table[6]//tbody//tr//td[2]//div";//"//table//tbody//tr[6]//td[2]//div";
	
	public final String vendorFirstDataRowName="//div[contains(@id,'pdMainGrid')]//descendant::tr[contains(@class,'x-grid-row')][1]/td[contains(@class,' x-grid-cell-first')]/div[contains(@class,'x-grid-cell-inner ')]";//"//div[contains(@id,'pdmaingrid')]//descendant::tr[contains(@class,'x-grid-row')][1]/td[contains(@class,' x-grid-cell-first')]/div[contains(@class,'x-grid-cell-inner ')]";
	public final String add_submission_uploadReferenceFiles_cancelButton="//div[contains(@id,'pduploadreferencesfiles')]//span[contains(text(),'Cancel')]";//div[contains(@id,'pduploadreferencesfiles')]/div[@class='x-toolbar x-docked x-toolbar-footer x-docked-bottom x-toolbar-docked-bottom x-toolbar-footer-docked-bottom x-box-layout-ct']//button/span[contains(text(),'Cancel')]";

	
	public final String firstDataRowStatus = "//tbody//tr//td[12]//div";	
	// you can use this locator '//table//tr[contains(@class,'x-grid-row')]'. Using verify text of this locator will give entire row contents. you can check whether it contains the content you want to verify.
	public final String firstDataRowStatus_ActiveFolder = "//table//tr[contains(@class,'x-grid-row')]";
	public final String firstDataRowStatus_OnHoldFolder = "//table//tr[contains(@class,'x-grid-row')]";
	public final String firstDataRowStatus_CompletedFolder = "//table//tr[contains(@class,'x-grid-row')]";
	public final String firstDataRowOwner_OnHoldFolder = "//div[contains(@id,'pdMainGrid')]//table//tr//td[6]//div";
	public final String firstDataRowOwner_ActiveFolder = "//div[contains(@id,'pdMainGrid')]//table//tr//td[6]//div";
	public final String firstDataRowProgress_ActiveFolder = "//div[contains(@style,'visible')]//tr[contains(@class,'x-grid-row')]//td[17]/div/div";
	public final String firstDataRowInstrctions_ActiveFolder = "//tbody//tr//td[14]//div//div";
	public final String firstDataRowDueDate_ActiveFolder = "//tbody//tr//td[9]//div";
	public final String firstDataRowInstrctions_OnHoldFolder = "//table//tbody//tr//td[15]//div//div";
	public final String firstDataRowInstrctions_OnHoldFolder_checkedSign = "//table//tbody//tr//td[15]//div//div";
	
	
	public final String gateColumnHandSign = "//div[contains(@class,'handsign')]";//"css=div.handsign";
	
//Column Names Active Folder
	public final String columnGate_ActiveFolder = "//div[contains(@id,'gridcolumn')]/div/span[contains(text(),'Gate')]";//"css=div[id*='gridcolumn']>div>span:contains(Gate)";
	public final String columnProject_ActiveFolder = "css=div.x-grid3-header-offset>table>thead>tr>td:nth-child(14)>div";
	public final String columnFiles_ActiveFolder = "css=div.x-grid3-header-offset>table>thead>tr>td:nth-child(19)>div";
	public final String columnOwner_ActiveFolder = "css=div.x-grid3-header-offset>table>thead>tr>td:nth-child(20)>div";
	
	public final String columnSubmissionIdMenu_ActiveFolder = "//div[contains(@data-qtip,'Submission ID')]//following-sibling::div";//"//span[text()='Submission Id']/following-sibling::div";
	public final String columnSubmissionNameMenu_ActiveFolder = "//div[contains(@data-qtip,'Submission Name')]//following-sibling::div";//"//span[text()='Submission Name']/following-sibling::div";
	public final String columnSourceLanguageMenu_ActiveFolder = "//div[contains(@data-qtip,'Source Language')]//following-sibling::div";//"//span[text()='Source Language']/following-sibling::div";
	public final String columnDateStartedMenu_ActiveFolder = "//div[contains(@data-qtip,'Date Started')]//following-sibling::div";//"//span[text()='Date Started']/following-sibling::div";
	public final String columnDueDateMenu_ActiveFolder = "//div[contains(@data-qtip,'Due Date')]//following-sibling::div";//"//span[text()='Due Date']/following-sibling::div";
	public final String columnPriorityMenu_ActiveFolder = "//div[@class='x-box-inner ']//div[contains(@data-qtip,'Priority')]/span/following-sibling::div";//"//div[@class='x-box-inner ']/div/div[12]/div/div";
	public final String columnProjectMenu_ActiveFolder = "//div[contains(@data-qtip,'Project')]//following-sibling::div";//"//span[text()='Project']/following-sibling::div";
	public final String columnWorkflowStatusMenu_ActiveFolder = "//div[contains(@data-qtip,'Workflow Status')]//following-sibling::div";//"//span[text()='Workflow Status']/following-sibling::div";
	public final String columnInstructionsMenu_ActiveFolder = "//div[@class='x-box-inner ']/div/div[16]/div/div";
	public final String columnProgressBarMenu_ActiveFolder = "//div[contains(@data-qtip,'Progress Bar')]//following-sibling::div";//"//span[text()='Progress Bar']/following-sibling::div";
	public final String columnFilesMenu_ActiveFolder = "//div[@class='x-box-inner ']/div/div[20]/div/div";
	public final String columnOwnerMenu_ActiveFolder = "//div[contains(@data-qtip,'Owner')]//following-sibling::div";//"//span[text()='Owner']/following-sibling::div";


	public final String activeFolder_columnName(String columnName)
	{
		return "//div[contains(@id,'headercontainer')]//div[contains(@data-qtip,'"+columnName+"')]";
	}

	public final String columnXMenu_ActiveFolder(Integer orderNumber)
	{
		return "//div[contains(@id,'tabpanel')]//div[contains(@id,'headercontainer')]/div["+orderNumber+"]//span[contains(@class,'x-column-header-text')]";
	}

	public final String client_clickOnColumnNameX(String columnName){
		return "//div[contains(@class,'x-menu')]/a/span[text()='"+columnName+"']";
	}
	
	public final String client_checkedColumnNameX(String columnName){
		return "//div[contains(@class,'x-menu-item-checked')]/a/span[text()='"+columnName+"']";
	}
	
	
	public final String client_alertRow = "//div[contains(@class,'alertsnormalgridsmall')]";
	public final String client_alert_plus = "//div[contains(@id,'alert') or contains(@id,'Alert')]//div[contains(@class,'x-tree-elbow-end-plus')]";//"//div[contains(@id,'alert') or contains(@id,'Alert')]//img[contains(@class,'x-tree-elbow-end-plus')]";//div[contains(@id,'gs4tralertsdialog')]//img[contains(@class,'x-tree-elbow-end-plus')]";
	public final String client_alert_minus = "//div[contains(@id,'alert') or contains(@id,'Alert')]//div[contains(@class,'x-tree-elbow-end-plus')]";
	public final String client_alertWindow_close = "//div[contains(@id,'alert') or contains(@id,'Alert')]//div[contains(@class,'x-tool-close')]";//"//div[contains(@id,'alert') or contains(@id,'Alert')]//div/img[contains(@class,'close')]";//div[contains(@id,'gs4tralertsdialog')]//img[@class='x-tool-close']";
	public final String client_alertWindow_More = "//div[contains(@id,'AlertsDialog')]//a[contains(text(),'more')]";
	public final String client_fullAlertMessageWindow_Close="//div[contains(@id,'fullalertmessagewindow')]//span[contains(text(),'Close')]";
	//On Hold Folder
	public final String parentRow = "//tr[contains(@class,'x-grid-row-dark-blue')]";
	public final String childRow = "//tr[contains(@class,'x-grid-row-blue')]";
	 
	public final String submissions_rowTable = "//div[starts-with(@id,'pdmaingrid') and contains(@class,'x-panel-body-default')]//descendant::tr[starts-with(@class,'x-grid-row')]";
	public final String submissions_rowTable_status(Integer row) {
		return "//tr["+(row+1)+"][contains(@class,'x-grid-row')]/td[13]/div"; 
	}
	
	//Preview Pane
	public final String previewMain_firstRow_awardedVendorsColumn = "//div[contains(@id,'treegrid')]//table[1]/tbody/tr/td[5]/div/span";//css=div[id*='pdmaintreegrid'] table tr:nth-child(2)>td:nth-child(5)>div>span";
	public final String previewMain_secondRow_awardedVendorsColumn = "//div[contains(@id,'treegrid')]//table[2]/tbody/tr/td[5]/div/span";
	public final String previewMain_firstRow_TranslationColumn = "//div[contains(@id,'pdmaintreegrid')]/div/table/tbody/tr[2]/td[6]/div/span";
	public final String previewMain_firstRow_ProofColumn = "css=div[class='x-panel x-panel-noborder x-grid-panel x-border-panel'] div>div.x-grid3-row:nth-child(1)>table>tbody>tr>td:nth-child(8)>div.x-grid3-cell-inner";
	public final String previewMain_budgetStatusColumn = "//div[contains(@id,'maintreegrid')]//table//tr/td[last()]/div/div";//div[contains(@class,'pmenteredbudget')]";//div[@class='pmenteredbudget']";
	public final String previewMain_budgetStatusHeader="//span[@class='budgetheader']";
	

	public final String previewMain_rightClick_ActionX(String action)
	{
		return "//a/span[text()='"+action+"']";
	}

	public final String addManualSubmissionBatchPreview_savewarningDiscardButton="//div[contains(@id,'warningdialog')]//span[contains(text(),'Discard')]";//"//div[contains(@id,'warningdialog')]//span[contains(text(),'Discard')]/following-sibling::span";//"//div[contains(@id,'gs4trwarningmessage')]//span[contains(text(),'Discard')]";
	public final String addManualSubmission_discardReferenceFiles_savebutton="//div[contains(@id,'warning')]//span[contains(text(),'Save')]";//"//div[contains(@id,'warning')]//span[contains(text(),'Save')]/following-sibling::span";
	public final String addManualSubmission_verifyBatchName="//div[contains(@name,'batchGrid')]//div//table//tr//td//div//a[contains(text(),'Batch1')][@class='batchLink']";//"css=table[class='x-grid-table x-grid-table-resizer'] tr>td>div:contains('Batch1')";
	public final String addManualSubmission_deleteBatchButton="//a//span[contains(text(),'Delete Batch')]";//"//a//span[contains(text(),'Delete Batch')]/following-sibling::span";//"css=a>span:contains('Delete Batch')";
	public final String removeFileButton="//div[contains(@id,'AddUploadPanel')]//a//span[contains(text(),'Remove')]";//"//div[contains(@id,'uploadfilespanel')]//span[contains(text(),'Remove')]/following-sibling::span";//"css=div[id*='pduploadfilespanel'] span:contains('Remove')";
	public final String addManualSubmissionBatchPreview_batchRemoveButton="//div[contains(@id,'AddBatchPreviewFileLeverageStatistics')]//span[contains(text(),'Remove')]";//"//div[contains(@id,'fileleveragestatisticspanel')]//span[contains(text(),'Remove')]/following-sibling::span";//"css=div[id*='pdfileleveragestatisticspanel'] span:contains('Remove')";//"css=div[id*='pdfileleveragestatisticspanel'] button>span:contains('Remove')";
	public final String fileList_closeButton="//div[contains(@id,'Leverage')]/following-sibling::div//span[text()='Close']";
	public final String adManualSubmission_sourceFilesUpload_removeFileX(String fileName){
		return "//div[contains(@id,'uploadfiles')]//table[contains(@id,'gridview')]//tr//td[div[contains(text(),'"+fileName+"')]]/following-sibling::td//img";
	}
	
	
	public final String verifyFilePresent(String name)
	{		
		return "//div[contains(@id,'UploadStandardFile')]//table//td/div[contains(text(),'"+name+"')]";//"//div[contains(@id,'uploadfilespanel')]//div[contains(@id,'gridview')]/table//td/div[contains(text(),'"+name+"')]";//"css=div[id*='pduploadfilespanel'] div[id*='gridview']>table td:contains('"+name+"')";
	}
	public final String addManualSubmissionBatchPreview_VerifyFileName(String fileName)
	{
		return "//div[contains(@id,'pdstatisticsgrid')]//table//tr//td/div[contains(text(),'"+fileName+"')]";
	}
	public final String groupTitleX (String title){
		return "//div[contains(@class,'x-grid-group-title') and contains(text(),'"+title+"')]";//"css=div.x-grid-group-title:contains('"+title+"')";
	}
	
	public final String previewMain_rowWithTextX(Integer rowNum,String text){
		return "//div[contains(@id,'treeview')]//table[contains(@id,'treeview')]["+rowNum+"]/tbody/tr/td/div/span[contains(text(),'"+text+"')]";
				//"//div[contains(@id,'treeview')]//table[contains(@id,'treeview')]/tbody/tr["+rowNum+"]/td/div/span[contains(text(),'"+text+"')]";//div[contains(@id,'treeview')]/table[@class='x-grid-table x-grid-table-resizer']/tbody/tr[contains(@class,'x-grid-row')]["+rowNum+"]/td/div[contains(text(),'"+text+"')]";
		
	}
	
	public final String previewMain_rowX(Integer rowNum){
		return "//div[contains(@id,'treeview')]//table[contains(@id,'treeview')]["+rowNum+"]/tbody/tr/td/div";
		//"//div[contains(@id,'treeview')]//table[contains(@id,'treeview')]/tbody/tr["+rowNum+"]/td/div";//div[contains(@id,'treeview')]/table[@class='x-grid-table x-grid-table-resizer']/tbody/tr["+(rowNum+1)+"]/td/div";
	}
	
	public final String previewMain_rowXColumnX(String langCode,String user)
	{
		if(user.equals(""))
		{
			return "//div[contains(@id,'treeview')]//tr[contains(@class,'x-grid-row')]/td/div[contains(text(),'"+langCode+"')]";	
		}
		else
		{
		return "//div[contains(@id,'treeview')]//tr[contains(@class,'x-grid-row')]/td[div[contains(text(),'"+langCode+"')]]/following-sibling::td/div/a[text()='"+user+"']";
		}
	}
	
	public final String preview_fileList_verifyFileName(String fileName)
	{
	//	return "//div[contains(@name,'cumulativeTmGrid')]//table[contains(@id,'gridview')]//tr//td//div[contains(text(),'"+fileName+"')]";
		return "//div[contains(@id,'SubmissionFileLeverageStatisticTabGrid')]//table[contains(@id,'gridview')]//tr[contains(@class,'grid')]//div[contains(text(),'"+fileName+"')]";
	}
	
	
	public final String previewMain_plus_commonX(Integer row){
		//return "//div[contains(@id,'treeview')]/table/tbody/tr["+(row)+"]/td/div/img[contains(@class,'expander')]";
		return "//div[contains(@id,'treeview')]//table["+row+"]//tr[not(contains(@class,'node-expanded'))]//div[contains(@class,'expander')]";//"//div[contains(@id,'treeview')]//table//tr["+row+"]//div[contains(@class,'expander')]";
	}
	
	public final String previewMain_plus_lastRowX(Integer row){
	//	return "//div[contains(@id,'treeview')]/table[contains(@id,'treeview')]/tbody/tr["+(row+1)+"]/td/div/img[contains(@class,'x-tree-elbow-end-plus')]";//div[contains(@id,'treeview')]/table[@class='x-grid-table x-grid-table-resizer']/tbody/tr["+(row+1)+"]/td/div/img[contains(@class,'x-tree-elbow-end-plus')]";
	return "//div[contains(@id,'treeview')]//table[contains(@id,'treeview')]["+(row+1)+"]/tbody/tr["+row+"]//div[contains(@class,'x-tree-elbow-end-plus')]";
	}
	
	public final String previewMain_expandLevelLanguage(String langPair){
		return "//table[contains(@id,'treeview')]//div[contains(@class,'elbow-end-plus')][following-sibling::span[contains(text(),'"+langPair+"')]]";//"//tr[contains(@id,'treeview')]/td/div/img[contains(@class,'expander')][following-sibling::span[contains(text(),'"+langPair+"')]]";//div[starts-with(@id,'pdmaintreegrid') and contains(@class,'x-panel-body-default')]//table//tr[contains(@class,'x-grid-row')][child::td/div[text()='"+langPair+"']]/td/div/img[contains(@class,'x-tree-expander')]";
	}
	
	public final String previewMain_expandLevelBatch(String batchName){
		return "//table[contains(@id,'treeview')]//div[contains(@class,'expander')][following-sibling::span[contains(text(),'"+batchName+"')]]";//"//tr[contains(@id,'treeview')]/td/div/img[contains(@class,'expander')][following-sibling::span[contains(text(),'"+batchName+"')]]";//div[starts-with(@id,'pdmaintreegrid') and contains(@class,'x-panel-body-default')]//table//tr[contains(@class,'x-grid-tree-node-expanded')]//following-sibling::tr[contains(@class,'x-grid-row')][child::td/div[contains(text(),'"+batchName+"')]]//td/div/img[contains(@class,'x-tree-expander')]";
	}
	
	public final String previewMain_LevelFile(String fileName){
		return "//table[contains(@id,'treeview')]//span[text()='"+fileName+"']";//"//tr[contains(@id,'treeview')]/td/div/span[text()='"+fileName+"']";//div[starts-with(@id,'pdmaintreegrid') and contains(@class,'x-panel-body-default')]//table//tr[contains(@class,'x-grid-tree-node-expanded')][child::td/div/img]//following-sibling::tr[contains(@class,' x-grid-tree-node-leaf')][child::td/div[text()='"+fileName+"']]";
	}
	
	public final String add_editSubmission_batches_workflow_rowX(Integer rowNum){
		return "//div[contains(@id,'pdbatchgrid')][contains(@class,'x-grid-with-row-lines')]//table["+rowNum+"]//td[2]//div";
	}
	public final String add_editSubmission_batchGrid_fileCountX(int row)
	{
		return "//div[contains(@id,'pdbatchgrid')]/div/table/tbody/tr["+row+"]/td[4]/div";
	}
	public final String editSubmission_wordCount_NA ="//div[contains(@id,'pdbatchgrid')]//table//tbody//td[5]//div[contains(text(),'N/A')]";
	public final String previewMain_wordCount_rowX(Integer rowNum){
		return "//div[contains(@id,'treeview')]//table[contains(@id,'treeview')]["+rowNum+"]/tbody/tr/td[2]/div";
	}
	
	public final String previewMain_fileListLeverageStats_file(String fileName, int leverageColumnNumber){
		return "//div[contains(@id,'FileLeverageStatisticTabGridPanel')]//table//tr[td//div[contains(text(),'"+fileName+"')]]//td["+leverageColumnNumber+"]//div";
	}
	
	public final String fileManagement_fileListLeverageStats_file(String fileName, int leverageColumnNumber){
		return "//div[contains(@id,'LinguistFileGrid')]//table//tr[td//span[contains(text(),'"+fileName+"')]]//td["+leverageColumnNumber+"]//div";
	}
	
	public final String previewMain_fileListLeverageStats_originalTotal(int leverageColumnNumber){
		return "//div[contains(@name,'totalStats')]//table//tr//td["+leverageColumnNumber+"]";
	}
	
	
	public final String claimSubmission_fuzzyMatches(int ColumnNumber){
		return "//table[contains(@id,'SubmissionClaimGridViewTable')]//td["+ColumnNumber+"]";
	}
	
	public final String previewMain_fileFormat_plus_rowX(Integer row){
		return "//img[contains(@class,'x-tree-elbow-end-plus x-tree-expander')]";
	}
	
	public final String previewMain_moreLinkX = "//div[contains(@id,'pdmaintreegrid') and contains(@class,'x-panel-body-default')]//descendant::tr[contains(@class,'x-grid-tree-node-leaf')]//span[contains(text(),'more ...')]";
	
	public final String	previewMain_expandLevelmoreLink = "//a[text()='more ...']";
	public final String previewSubmission_moreLink="//span[text()='more ...']";
	public final String window_close="//div[contains(@class,'window')]//div[contains(@class,'tool-close')]";
	
	public final String previewMain_byBatchButton = "//div[contains(@id,'treegridpreviewbuttonsmenu')]//div//a//span[contains(text(),'By Batch')]";
	public final String previewMain_byLanguageButton = "//div[contains(@id,'treegridpreviewbuttonsmenu')]//div//a//span[contains(text(),'By Language')]";
	public final String previewMain_previewSettingButton="//div[contains(@id,'pdmaintreegrid')]//div[contains(@class,'gear')]";
	public final String previewMain_previewSettingSelectLangBatchX(String name)
	{
		return "//div[contains(@id,'pdtreegridpreviewbuttonsmenu')]//div//a//span[contains(text(),'"+name+"')]";	
	}	
	public final String previewMain_alertColumn="//div[contains(@id,'pdmaintreegrid')]//span[@class='alertsheader']";
	public final String previewMain_quoteColumn="//div[contains(@id,'pdmaintreegrid')]//span[@class='quoteheader']";
	public final String previewMain_columnX(Integer col){
		return "//div[contains(@class,'MainTreeGrid')]//div[contains(@id,'headercontainer')]//div[contains(@id,'column')]["+col+"]//span";
		
	}
	

	// Submit Tab
	public final String submitTab="//div[contains(@id,'pdactionbar')]//span[contains(text(),'submit')]";	
	public final String submitTab_span ="//div[contains(@id,'pdactionbar')]//span[contains(text(),'submit')]//ancestor::a[contains(@data-qtip,'Create, clone or edit submissions.')]";
	// Reset Submission
	public final String resetSubmissionButton = "//span[starts-with(@id,'pd_reset_submission_action')]";
	public final String resetbutton = "//div[contains(@id,'resetsubmissiondialog')]//span[text()='Reset']";
	public final String resetHoldbutton = "//div[contains(@id,'resetsubmission')]//span[text()='Reset & Hold']";
	//Add Submission

	public final String addSubmissionButton = "//span[contains(@id,'manual_submission')]//span[contains(text(),'Create')]";
	public final String addSubmission_inputSubmissionName = "//div[contains(@name,'submissionName')]//input[contains(@name,'submissionName') or contains(@name,'SubmissionName')]";
	public final String addSubmission_finishButton = "css=table>tbody>tr>td:nth-child(2)>table>tbody>tr>td>table>tbody>tr>td:nth-child(2)>table>tbody>tr:nth-child(2)>td:nth-child(2)>em>button:contains('Finish')";

	public final String pmUser_claimSubmissionButton = "css=button>span.claimsubmissionpmlarge";
	public final String pmUser_translationTab_getTranslationFilesButton = "//span[contains(@id,'pd_process_linguistic_pm_action')]//span[contains(text(),'Get translation')]";
	
	// Templates/Submit Tab/Apply Template
	public final String submitTab_applyTemplate = "//span[contains(@id,'apply_template')]//span[contains(text(),'Apply')]";
	public final String submitTab_applyTemplate_selectTemplateDialog_OKButton = "//div[contains(@class,'submissiondialogs')]//span[contains(text(),'OK')]"; 
	public final String submitTab_applyTemplate_templateDropdown ="//div[contains(@class,'submissiondialogs')]//div[contains(@class,'arrow-trigger')]";	
	public final String submitTab_applyTemplate_templateName(String templateName)
	{
		return "//div[contains(@name,'templateCombo')]//li[contains(@class,'boundlist') and contains(text(),'"+templateName+"')]";
	}	
	
	public final String applyTemplate_verifyBatchName(String batchName)
	{
		return "//div[contains(@name,'batchGrid')]//div//table//tr//td//div//a[contains(text(),'"+batchName+"')][@class='batchLink']";
	}
	

}
