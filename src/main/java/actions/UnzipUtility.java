package actions;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipUtility {
	/**
     * Size of the buffer to read/write data
     */
    private static final int BUFFER_SIZE = 4096;
    String txtFile="";
    /**
     * Extracts a zip file specified by the zipFilePath to a directory specified by
     * destDirectory (will be created if does not exists)
     * @param zipFilePath
     * @param destDirectory
     * @throws IOException
     */
    public String unzip(String zipFilePath, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        System.out.println("zipFilePath is" +zipFilePath);
        System.out.println("destDir is" +destDir);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
        System.out.println("ZIP IN IS "+ zipIn);
        
        ZipEntry entry = zipIn.getNextEntry();
        System.out.println("entry-1  IS "+ entry);
        
        // iterates over entries in the zip file
        while (entry != null) {
        	String filepath=destDirectory + File.separator;
            String filePathname = destDirectory + File.separator + entry.getName();
            System.out.println("File path is "+ filePathname);
            if (!entry.isDirectory()) {
                // if the entry is a file, extracts it
                extractFile(zipIn, filePathname);
                //
                
                File directory = new File(filepath);
                System.out.println("Directory is "+filepath);

        		List<File> resultList = new ArrayList<File>();

        		// get all the files from a directory
        		File[] fList = directory.listFiles();

        		resultList.addAll(Arrays.asList(fList));
        		for (File file : fList) {
        			System.out.println("LIST IS___________" + file);

        			String str = file.getName();
        			 System.out.println("==>>" + str);

        			if (str.contains("GlobalLink")) {
        				if (file.getAbsolutePath().endsWith("GlobalLink.log")) {
        					 txtFile = file.getAbsolutePath();
        					System.out.println("----Filename  is------" + txtFile);
        				}
        				
        			}
        		}
        		 String line = null;
        		    try
        		    {
        		        /* FileReader reads text files in the default encoding */
        		        FileReader fileReader = new FileReader(txtFile);

        		        /* always wrap the FileReader in BufferedReader */
        		        BufferedReader bufferedReader = new BufferedReader(fileReader);

        		        while((line = bufferedReader.readLine()) != null)
        		        {
        		            System.out.println(line);    		          
        		            
        		        }

        		        /* always close the file after use */
        		        bufferedReader.close();
        		        
        		      
        		    }
        		    catch(IOException ex)
        		    {
        		        System.out.println("Error reading file named '" + txtFile + "'");
        		    }
        		
        		
                
            } else {
                // if the entry is a directory, make the directory
                File dir = new File(filePathname);
                dir.mkdirs();
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
           // System.out.println("entry-2  IS "+ entry);
        }
        zipIn.close();
		return txtFile;
    }
    /**
     * Extracts a zip entry (file entry)
     * @param zipIn
     * @param filePath
     * @throws IOException
     */
    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        
        
        bos.close();
    }
    
    public static String dateconvertformatter()
    {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("(yyyyMMdd)");
		String SS=LocalDate.now().format(formatter);
		
		System.out.println(LocalDate.now().format(formatter));
		String s="GlobalLinkLogs."+SS;
		String ss1="GlobalLinkLogs."+SS+".zip";
		System.out.println("String is "+ ss1);
		return ss1;
		 
    }
    
    public boolean read_Data(String testString , String filePath) throws Exception {
		boolean result = false;
	        String strLine;
	        int numRead=0;

	        try {
	            FileInputStream fstream = new FileInputStream(filePath);
	            DataInputStream in = new DataInputStream(fstream);
	            BufferedReader br = new BufferedReader(new InputStreamReader(in));

	            while ((strLine = br.readLine()) != null)   {
	                strLine = strLine + " ";
	                String [] strArry = strLine.split(testString);

	                if (strArry.length > 1) {
	                	  result = true;
	                     numRead = numRead + strArry.length - 1;
	                }
	                else {
	                     if (strLine == testString) {
	                         numRead++;
	                     }
	                }
	            }

	            in.close();

	            System.out.println("*********************************************************");
	            System.out.println(testString + " was found " + numRead + " times.");
	            System.out.println("*********************************************************");

	        }catch (Exception e){
	        }
			return result;
	    
	
	}
}
