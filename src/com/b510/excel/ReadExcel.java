/**
 * 
 */
package com.b510.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.b510.common.Common;
import com.b510.excel.vo.CcChapter;
import com.b510.excel.vo.Student;

/**
 * @author Hongten
 * @created 2014-5-18
 */
public class ReadExcel {

	public List<CcChapter> readXls() throws IOException {
		InputStream is = new FileInputStream(Common.EXCEL_PATH);
		XSSFWorkbook  hssfWorkbook = new XSSFWorkbook (is);
		CcChapter chapter = null;
		List<CcChapter> list = new ArrayList<CcChapter>();
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			for (int rowNum = 2; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				XSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow != null) {
					chapter = new CcChapter();
					String code = getValue(hssfRow.getCell(0));
					if(code == null || "".equals(code)){
						break;
					}
					if(code.contains(".0")){
						code = code.replace(".0", "");
					}
					String name = getValue(hssfRow.getCell(1));
					chapter.setChapterName(name);
					chapter.setChapterNum(code);
					chapter.setCode(code);
					String[] str = code.split("\\.");
					chapter.setLevel(str.length-1);
					chapter.setNum(Integer.parseInt(str[str.length-1]));
					chapter.setChapterId(getUUID());
					chapter.setIsUse(0);
					chapter.setCreateTime(new Timestamp(System.currentTimeMillis()));
					list.add(chapter);
				}
			}
		}
		return list;
	}
	
	 @SuppressWarnings("static-access")
	private String getValue(XSSFCell hssfCell) {
	        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
	            // ���ز������͵�ֵ
	            return String.valueOf(hssfCell.getBooleanCellValue());
	        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
	            // ������ֵ���͵�ֵ
	            return String.valueOf(hssfCell.getNumericCellValue());
	        } else {
	            // �����ַ����͵�ֵ
	            return String.valueOf(hssfCell.getStringCellValue());
	        }
	    }
	 
	 /**
	   * 随机生成UUID
	   * @return
	   */
	  public static synchronized String getUUID(){
	    UUID uuid=UUID.randomUUID();
	    String str = uuid.toString(); 
	    String uuidStr=str.replace("-", "");
	    return uuidStr;
	  }

}
