package locators;

public class Magentolocators {
		private static Magentolocators ue;
		public static synchronized Magentolocators exts(){
			try{
				if(ue.equals(null))
				{
					ue = new Magentolocators();
				}
			}
			catch(Exception NOSYSTEM){
				ue = new Magentolocators();
			}
			return ue;
		}
		
		
		//---------------------Magento-------------------------------
		
		
		public final String Advanced="//button[@id='details-button']";
		public final String Proceed_To="//a[@id='proceed-link']";
		//Login
		public final String Login_Username1 ="//input[@id='username']";
		public final String Login_password1 = "//input[@id='login']";
		public final String Login_button1= "//button[@class='action-login action-primary']";
		
		//Catalog
		public final String Dashboard_Catalog="//li[contains(@id,'menu-magento-catalog-catalog')]//span[contains(text(),'Catalog')]";
		public final String Dashboard_Catalog_Products="//li[contains(@data-ui-id,'menu-magento-catalog-catalog-products')]//span[contains(text(),'Products')]";
		public final String Dashboard_Catalog_AddProducts="//button[contains(@class,'action-default primary add')]//span[contains(text(),'Add Product')]";
		
		public final String Dashboard_catalog_ProductName="//input[contains(@name,'product[name]')]";
		public final String Dashboard_catalog_ProductPrice="//input[contains(@name,'product[price]')]";
		public final String Dashboard_catalog_Quantity="//input[contains(@name,'product[quantity_and_stock_status][qty]')]";
		public final String Dashboard_catalog_Content="//div[contains(@class,'fieldset-wrapper-title')]//span[contains(text(),'Content')]";
		public final String Dashboard_catalog_Content_Show_HideEditor="//button[contains(@class,'scalable action-show-hide')]//span[contains(text(),'Show / Hide Editor')]";
		public final String Dashboard_catalog_Content_ShortDescription="//textarea[contains(@name,'short_description')]";
		public final String Dashboard_catalog_Content_SaveToggle ="//button[contains(@class,'action-toggle primary save primary')and @data-toggle='dropdown']";
		public final String Dashboard_catalog_Content_SaveClose="//span[contains(@id,'save_and_close')]";
		public final String Dashboard_catalog_Content_ProductMessage="//div[contains(text(),'You saved the product.')]";
		public final String Dashboard_catalog_Content_Products_searchbox="//main/div[3]//div[2]//div[@class='data-grid-search-control-wrap']//input[contains(@class,'admin__control-text data-grid-search-control')]";
		public final String Dashboard_catalog_Content_Products_searchbox_Button="//body/div[2]/main//div[5]/button";
		public final String  Dashboard_catalog_Content_Tax_Class(String TaxName){
			return "//div[@class='admin__field-control']//select[@class='admin__control-select']//option[contains(text(),'"+TaxName+"')]";
		}
		public final String Dashboard_catalog_Content_Products_Checkbox="//tbody//tr[1]/td[1]//input[@class='admin__control-checkbox']";
		
		public final String Dashboard_catalog_Content_SubmitforTranslation_button="//div[@class='col-xs-2']//button[contains(@class,'action-select')]";
		
		public final String Dashboard_catalog_Content_SubmitforTranslation="//div[@class='admin__data-grid-header-row row row-gutter']//ul/li[7]/span[contains(text(),'Send for Translation')]";
		
		//Catalog Create Submission
		public final String Dashboard_catalog_Content_Product_Submission_name="//input[contains(@name,'submission[name]')]";
		public final String Dashboard_catalog_Content_Product_Due_date="//button[@class='ui-datepicker-trigger v-middle']";
		public final String Dashboard_catalog_Content_Product_Due_date_input="//input[contains(@name,'submission[due_date]')]";
		public final String Dashboard_catalog_Content_Product_Project="//select[contains(@name,'submission[project]')]";
		public final String Dashboard_catalog_Content_Product_OK="//span[contains(text(),'OK')]";
		public final String Dashboard_catalog_Content_Product_Sub_message="//div[contains(text(),'Products have been saved to translate queue')]";
		public final String Dashboard_catalog_Content_Product_Sub_duedate="//table[@class='ui-datepicker-calendar']/tbody/tr/td/a[contains(text(),'22')]";
		public final String  Dashboard_catalog_Content_SelectProject(String Project){
			return "//select[contains(@name,'submission[project]')]/option[contains(text(),'"+Project+"')]";
		}
		
		public final String  Dashboard_catalog_Submission_Translate="//h1[contains(text(),'Translations - Submissions')]";
		public final String  Dashboard_catalog_Content_SelectTargetStore(String TargetStore){
			return "//div[contains(@class,'field choice admin__field admin__field-option')]//label//span[contains(text(),'"+TargetStore+"')]";
		}
		public final String Dashboard_catalog_Content_Product_SendforTranslation="//button[contains(@title,'Send for Translation')]";
		//
		
		//GlobalLink
		public final String Dashboard_GlobalLink="//li[contains(@id,'menu-transperfect-globallink-globallink')]//span[contains(text(),'GlobalLink')]";
		public final String Dashboard_Submissions="//li[contains(@class,'item-management  parent  level-1')]//div[contains(@class,'submenu')]//span[contains(text(),'Submissions')]";//ul[contains(@role,'menu')]//div[contains(@class,'submenu')]//span[contains(text(),'Submissions')]";
}
	
