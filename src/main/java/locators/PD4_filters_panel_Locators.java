package locators;


public class PD4_filters_panel_Locators {
	private static PD4_filters_panel_Locators ue;
	
	public static synchronized PD4_filters_panel_Locators exts(){
		try{
			if(ue.equals(null))
			{
				ue = new PD4_filters_panel_Locators();
			}
		}
		catch(Exception NOSYSTEM){
			ue = new PD4_filters_panel_Locators();
		}
		return ue;
	}
	//Filters Panel Locators//Filters Panel Locators
	public final String filters_saveFilterButton = "//span[text()='Save filter']";
	public final String filters_saveFilterButton_disabled = "//a[starts-with(@id,'button') and contains(@class,'x-btn-disabled')]//span[text()='Save']";
	public final String filters_removeButton = "//div[starts-with(@id,'gs4trnavigationsplitmenuitem') and contains(@class,'x-component-default')]//img[contains(@class,'gs4trsplit')]";
	public final String filters_removeButton(String filterName){
		return "//span[text()='"+filterName+"']/../div[contains(@class,'split')]";
	}
	public final String filters_errorCloseButton = "//div[contains(@id,'warningdialog')]//span[contains(text(),'Close')]";
	public final String filters_findButton = "//span[contains(@class,'find')]";
	public final String filters_clearButton = "//div[contains(@id,'filterstoolbar')]//a//span[text()='Clear']";
	public final String filters_customizeButton = "//img[@data-qtip='Click to customize filter']";	
	public final String filters_saveFilter_inputFilterName = "//input[@name='filterName']";
	public final String filters_inputFilterSave_button = "//div[contains(@class,'x-window-default-closable')]/div[contains(@class,'x-toolbar-footer')]//span[contains(text(),'Save')]";
	public final String filters_inputFilterCancel_button = "//div[contains(@id,'navigations')]//span[contains(text(),'Cancel')]";
	public final String filters_removeCustomFilter_yesButton = "//div[contains(@id,'warning')]//span[contains(text(),'Yes')]/..";
	public final String filters_selectCustomFilter_dropDownMenu(String nameMenu){
		String result = "//em[starts-with(@id,'splitbutton')][child::button/span[text()='"+nameMenu+"']]";
		return result;
		
	}

	//pass the name of applied filter to be cleared
	public final String  filters_clearAppliedFilter(String filterWithTextToClear){
		String result = "//td[contains(@class,'gs4trfiltervaluespan ')][//div[contains(text(),'"+filterWithTextToClear+"')]]/following-sibling::td";
		return result;
	}
	
	//new for PD 4.6
	public final String filters_chooseFilter_trigger = "//div[@name='fieldLabelCombo']//div[contains(@class,'x-form-arrow-trigger')]";
	public final String filters_chooseFilter_firstFilter = "//div[@name='fieldLabelCombo-boundlist']/div/ul/li";
	public final String filters_chooseFilter_secondFilter="//div[@name='fieldLabelCombo-boundlist']/div/ul/li[2]";
	public final String filters_chooseFilter_thirdFilter="//div[@name='fieldLabelCombo-boundlist']/div/ul/li[3]";
	
	public final String filters_chooseFilter_triggerFromDate = "//div[@name='fromDateFilter']//div[contains(@class,'trigger')]//div[2]";
	public final String filters_chooseFilter_comboTriggerFromDate = "//table[@name='comboFieldFilter']//table//div[@role='button']";
	public final String filters_chooseFilter_triggerToDate = "//div[@name='toDateFilter']//div[contains(@class,'date-trigger')]";
	public final String filters_chooseFilter_valueFirstFilter (String text) {
	    	String result = "//div[contains(@name,'fieldLabelCombo-boundlist')]//div//li[text()='"+text+"']";
		return result;
	}
	public final String filters_firstInput = "//input[@name='textFieldFilter']";
	public final String filters_secondInput = "//input[contains(@name,'ComboFieldFilter')]";
	public final String filters_summaryfieldInput = "//input[@name='summaryField']";
	public final String filters_numberFieldInput = "//input[@name='numberFieldFilter']";
	public final String filters_popUpText_summaryfieldInput(String textFirstFilter)
	{
		return "//div[contains(@class,'x-container-default gs4trfullfiltercontainer')]//b[contains(text(),'"+textFirstFilter+"')]";
	}
	

}
