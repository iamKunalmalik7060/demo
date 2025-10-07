package generic_utility;

import java.io.IOException;

public class ProvideDatatoutillty {
	public static void main(String[] args) throws IOException {
	FileUtility fUtil=new FileUtility();
	
	// Get the data from properties file
	String Browser=fUtil.getDataFromPropertiesFile("bro");
	String URL=fUtil.getDataFromPropertiesFile("url");
	String USERNAME=fUtil.getDataFromPropertiesFile("un");
	String PASSWORD=fUtil.getDataFromPropertiesFile("pwd");
	System.out.println(Browser);	
	System.out.println(URL);
	System.out.println(USERNAME);
	System.out.println(PASSWORD);

	String file1=fUtil.getStringDataFromExcelFile("A12", 1, 0);
	String file2=fUtil.getStringDataFromExcelFile("A12", 2, 0);
	String file3=fUtil.getStringDataFromExcelFile("A12", 3, 0);
	String file4=fUtil.getStringDataFromExcelFile("A12", 4, 0);
	System.out.println(file1);
	System.out.println(file2);
	System.out.println(file3);
	System.out.println(file4);
	
	int filee=fUtil.getNumericDataFromExcelFile("A12", 12, 0);
	int file5=fUtil.getNumericDataFromExcelFile("A12", 9, 0);
	int file6=fUtil.getNumericDataFromExcelFile("A12", 10, 0);
	int file7=fUtil.getNumericDataFromExcelFile("A12", 11, 0);
	System.out.println(filee);
	System.out.println(file5);
	System.out.println(file6);
	System.out.println(file7);
	}
}
