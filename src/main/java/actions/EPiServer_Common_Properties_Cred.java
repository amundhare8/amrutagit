package actions;

public class EPiServer_Common_Properties_Cred {

	//TODO BELOW DETAILS SHOULD BE REQUIRED AT EVERY NEW BUILD.
	public  final static String  DBcleanup_password ="CLEAN_Password!1"; 
	//---------------------------------------------------------------------
	//Epi Uname/Pass 
	public  final static String  username ="Administrator";   
	public  final static String  psw ="Password1!";   
	
	//PD2 Uname/Pass and URL
	public  final static String GlobalLink_url="https://qa-pd-released-adaptors.translations.com/PD/";
	public  final static String HTTPSGlobalLink_url="https://qa-pd-released-adaptors.translations.com/PD/local";
	public  final static String	Username="epi_pm";
	public  final static String	Pass="Password!1";
	
	//PD2 Uname/Pass
	public  final static String	Username_Com="epi_com";
	public  final static String	Pass_Com="Password$1";
	
	//GL Setting Tab
	public  final static String	Submission_Name_Prefix="Automation_11.8.4_RC2";
	public  final static String	Classifier="EPiServer";
	public  final static String	Max_number_of_files_per_submission="500";
	public  final static String	Translation_retrieval_batch_size="1000";
	public  final static String	UID="GLEPI11.8.4";
	public  final static String	Projectshortcode = "EPI000045";
	public  final static String	FileFormat= "EPiServer";

	//GCC SERVER
	public  final static String PSS_URL="https://connect-dev.translations.com/api/v1";
	public  final static String PSS_Username="gnilawar";
	public  final static String PSS_Password="password1!";
	public  final static String PSS_ConnectorID="414b8b777c67ed0a7257d178bbfbcafd";
		
		//Notifications
	public  final static String	SMTP_Host="smtp.gmail.com";
	public  final static String SMTP_Port="587";
	public  final static String Login="smtp.translation@gmail.com";
	public  final static String Password="TPT2022!";//Gl0bal!nk2";
	public  final static String Recipients="pnair@transperfect.com, amundhare@transperfect.com";

		//Version (Update this with version you are testing)
	public  final static String GlobalLinkAdaptor_Version="11.8.4";
	
	//Comments before script execute
	public final static String GL_EpiServer_tc_comment = "Executed and passed on GLEPI_11.8.4_RC2 CMS11.20.x and Commerce 13.32.x versions using PD 7.3.0  on Chrome browser..";//"Executed and Passed on GLEPI_11.15.x_Commerce 13.22.x_PD6.3.1_Chrome";//GLEPI_11.20.x_Commerce 13.31.x_PD6.x_Chrome

		
}
 	