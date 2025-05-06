package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Data_Provider {
	
	@DataProvider(name="logindata")
	public String[][] getData() throws IOException
	{
		String path="D:\\Project_Site\\DemoBlaze\\TestData\\logindata.xlsx";
		ExcelUtility util=new ExcelUtility(path);
		
		int totalrow=util.getrowcount("Sheet1");
		int totalcolm=util.getcellcount("Sheet1",1);
		
		String logindata[][]=new String[totalrow][totalcolm];
		 for(int i=1;i<totalrow;i++)
		 {
			 for(int j=0;j<totalcolm;j++)
			 {
				 logindata[i-1][j]=util.getcelldata("Sheet1", i, j);
			 }
		 }
		
		return logindata;
	}

}
