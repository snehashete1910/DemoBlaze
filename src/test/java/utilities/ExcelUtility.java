package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow ro;
	public static XSSFCell ce;
	public static CellStyle style;
	 String path;
	
	public ExcelUtility(String path)
	{
		this.path=path;
	}
	
	public  int getrowcount(String sheetname) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(sheetname);
		int rowcount=sh.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
		
	}
	public  int getcellcount(String sheetname,int rownum) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(sheetname);
		ro=sh.getRow(rownum);
		int cellcount=ro.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
		
	}
	
	public  String getcelldata(String sheetname,int rownum,int cellcount) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(sheetname);
		ro=sh.getRow(rownum);
		ce=ro.getCell(cellcount);
		
		String data ;
		try
		{
			DataFormatter formater=new DataFormatter();
			data=formater.formatCellValue(ce); //return formatted cell value string
			
		}
		catch(Exception e)
		{
		data=" ";	
		}
		wb.close();
		fi.close();
		return data;
	}
	
	public  void setcelldata(String sheetname,int rownum,int column,String data) throws IOException
	{
		File xfile=new File(path);
		if(!xfile.exists())
		{
			wb=new XSSFWorkbook();
			fo=new FileOutputStream(path);
			wb.write(fo);
		}
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		
		if(wb.getSheetIndex(sheetname)==-1)
			wb.createSheet(sheetname);
		sh=wb.getSheet(sheetname);
		
		if(sh.getRow(rownum)==null)
			sh.createRow(rownum);
		ro=sh.getRow(rownum);
			
		
		ce=ro.createCell(column);
		ce.setCellValue(data);
		fo=new FileOutputStream(path);
		
		
		wb.close();
		fi.close();
		fo.close();
	}
	public  void green(String sheetname,int rownum,int column) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(sheetname);
		ro=sh.getRow(rownum);
		ce=ro.getCell(column);
		style=wb.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		ce.setCellStyle(style);
		fo=new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	
	public  void red(String sheetname,int rownum,int column) throws IOException
	{
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(sheetname);
		ro=sh.getRow(rownum);
		ce=ro.getCell(column);
		style=wb.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		ce.setCellStyle(style);
		fo=new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

}
