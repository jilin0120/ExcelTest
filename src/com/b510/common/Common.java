/**
 * 
 */
package com.b510.common;

/**
 * @author Hongten
 * @created 2014-5-18
 */
public class Common {

	// connect the database
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_NAME = "wsp";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "combanc";
	public static final String IP = "192.168.10.20";
	public static final String PORT = "3306";
	public static final String URL = "jdbc:mysql://" + IP + ":" + PORT + "/" + DB_NAME;
	
	// common需要修改的项目
	public static final String EXCEL_PATH = "D:\\资料\\微课\\目录梳理\\土力学目录.xlsx";//文件目录
	public static final String COURSE_ID = "402802c754e699810154e70c30f2000a";//课程ID
	public static final String CREATE_ID = "402802c754e674560154e67c4a210007";//用户ID
	
	// sql
	public static final String INSERT_STUDENT_SQL = "insert into cc_chapter(chapterId, fatherId, courseId, chapterName,chapterNum,level,code,num,isUse,createId,createTime) values(?, ?, ?, ?,?,?, ?, ?, ?,?,?)";
	public static final String SELECT_STUDENT_SQL = "select * from cc_chapter where courseId = ? and code = ? ";
}
