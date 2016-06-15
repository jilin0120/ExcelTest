/**
 * 
 */
package com.b510.excel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.b510.common.Common;
import com.b510.excel.util.DbUtil;
import com.b510.excel.vo.CcChapter;

/**
 * @author jilin
 * @created 2014-5-18
 */
public class SaveData2DB {

	@SuppressWarnings({ "rawtypes" })
	public void save() throws IOException, SQLException {
		ReadExcel xlsMain = new ReadExcel();
		CcChapter chapter = null;
		List<CcChapter> list = xlsMain.readXls();

		for (int i = 0; i < list.size(); i++) {
			chapter = list.get(i);
			if(chapter.getLevel() != 0){
				String fatherId = DbUtil.selectOne(Common.SELECT_STUDENT_SQL, Common.COURSE_ID, chapter.getCode().substring(0, chapter.getCode().lastIndexOf(".")));
				chapter.setFatherId(fatherId);
			}
			DbUtil.insert(Common.INSERT_STUDENT_SQL, chapter);
		}
	}
}
