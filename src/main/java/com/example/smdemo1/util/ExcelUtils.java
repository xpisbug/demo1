package com.example.smdemo1.util;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class ExcelUtils{
	public static void main(String[] args) {
		Workbook wb =null;
		Sheet sheet = null;
		Row row = null;
		List<Map<String,String>> list = null;
		String cellData = null;
		String filePath = "D:\\test.xlsx";
		String columns[] = {"name","age","score"};
		wb = readExcel(filePath);
		if(wb != null){
			//用来存放表中数据
			list = new ArrayList<Map<String,String>>();
			//获取第一个sheet
			sheet = wb.getSheetAt(0);
			//获取最大行数
			int rownum = sheet.getPhysicalNumberOfRows();
			//获取第一行
			row = sheet.getRow(0);
			//获取最大列数
			int column = row.getPhysicalNumberOfCells();
			for (int i = 1; i<rownum; i++) {
				Map<String,String> map = new LinkedHashMap<String,String>();
				row = sheet.getRow(i);
				if(row !=null){
					for (int j=0;j<column;j++){
						cellData = (String) getCellFormatValue(row.getCell(j));
						map.put(columns[j], cellData);
					}
				}else{
					break;
				}
				list.add(map);
			}
			//遍历解析出来的list
			for (Map<String,String> map : list) {
				for (Map.Entry<String,String> entry : map.entrySet()) {
					System.out.print(entry.getKey()+":"+entry.getValue()+",");
				}
				System.out.println();
			}
		}else{
			System.out.println("read excel data is null.");
		}

	}

	/**
	 * 读取excel
	 * @param filePath
	 * @return
	 */
	public static Workbook readExcel(String filePath){
		if(filePath==null){
			return null;
		}
		Workbook wb = null;
		String extString = filePath.substring(filePath.lastIndexOf("."));
		try {
			InputStream is = new FileInputStream(filePath);
			if(".xls".equals(extString)){
				wb = new HSSFWorkbook(is);
			}else if(".xlsx".equals(extString)){
				wb = new XSSFWorkbook(is);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wb;
	}
	public static Object getCellFormatValue(Cell cell){
		Object cellValue = null;
		if(cell!=null){
			//判断cell类型
			switch(cell.getCellType()){
				case NUMERIC:{
					cellValue = String.valueOf(cell.getNumericCellValue());
					break;
				}
				case FORMULA:{
					//判断cell是否为日期格式
					if(DateUtil.isCellDateFormatted(cell)){
						//转换为日期格式YYYY-mm-dd
						cellValue = cell.getDateCellValue();
					}else{
						//数字
						cellValue = String.valueOf(cell.getNumericCellValue());
					}
					break;
				}
				case STRING:{
					cellValue = cell.getRichStringCellValue().getString();
					break;
				}
				default:
					cellValue = "";
			}
		}else{
			cellValue = "";
		}
		return cellValue;
	}

	/**
	 * 判断当前单元格是否是合并单元格
	 * @param sheet
	 * @param row
	 * @param column
	 * @return
	 */
	public static boolean isMergedRegion(Sheet sheet,int row ,int column){
		int sheetMergeCount = sheet.getNumMergedRegions();
		for(int i = 0; i < sheetMergeCount; i++){
			CellRangeAddress ca = sheet.getMergedRegion(i);
			int firstColumn = ca.getFirstColumn();
			int lastColumn = ca.getLastColumn();
			int firstRow = ca.getFirstRow();
			int lastRow = ca.getLastRow();
			if(row >= firstRow && row <= lastRow){
				if(column >= firstColumn && column <= lastColumn){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 判断当前单元格是否是合并单元格,返回是否是合并单元格，合并单元格始末行，始末列
	 * @param sheet
	 * @param row
	 * @param column
	 * @return
	 */
	public static Result isMergedRegionInfo(Sheet sheet,int row ,int column){
		int sheetMergeCount = sheet.getNumMergedRegions();
		for(int i = 0; i < sheetMergeCount; i++){
			CellRangeAddress ca = sheet.getMergedRegion(i);
			int firstColumn = ca.getFirstColumn();
			int lastColumn = ca.getLastColumn();
			int firstRow = ca.getFirstRow();
			int lastRow = ca.getLastRow();
			if(row >= firstRow && row <= lastRow){
				if(column >= firstColumn && column <= lastColumn){
					return new Result(true, firstRow, lastRow, firstColumn, lastColumn);
				}
			}
		}
		return new Result(false, 0, 0, 0, 0);
	}

	public static class Result{
		private boolean merged;
		private int startRow;
		private int endRow;
		private int startCol;
		private int endCol;

		public Result(boolean merged, int startRow, int endRow, int startCol, int endCol){
			this.merged = merged;
			this.startRow = startRow;
			this.endRow = endRow;
			this.startCol = startCol;
			this.endCol = endCol;
		}

		public boolean isMerged(){
			return merged;
		}

		public void setMerged(boolean merged){
			this.merged = merged;
		}

		public int getStartRow(){
			return startRow;
		}

		public void setStartRow(int startRow){
			this.startRow = startRow;
		}

		public int getEndRow(){
			return endRow;
		}

		public void setEndRow(int endRow){
			this.endRow = endRow;
		}

		public int getStartCol(){
			return startCol;
		}

		public void setStartCol(int startCol){
			this.startCol = startCol;
		}

		public int getEndCol(){
			return endCol;
		}

		public void setEndCol(int endCol){
			this.endCol = endCol;
		}
	}
}
