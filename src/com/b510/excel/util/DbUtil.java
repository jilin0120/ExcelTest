/**
 * 
 */
package com.b510.excel.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.b510.common.Common;
import com.b510.excel.vo.CcChapter;
import com.b510.excel.vo.Student;

/**
 * @author Hongten
 * @created 2014-5-18
 */
public class DbUtil {

	/**
	 * @param sql
	 */
	public static void insert(String sql, CcChapter chapter) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName(Common.DRIVER);
			conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
			ps = conn.prepareStatement(sql);
			ps.setString(1, chapter.getChapterId());
			ps.setString(2, chapter.getFatherId());
			ps.setString(3, Common.COURSE_ID);
			ps.setString(4, chapter.getChapterName());
			ps.setString(5, chapter.getChapterNum());
			ps.setInt(6, chapter.getLevel());
			ps.setString(7, chapter.getCode());
			ps.setInt(8, chapter.getNum());
			ps.setInt(9, chapter.getIsUse());
			ps.setString(10, Common.CREATE_ID);
			ps.setTimestamp(11, chapter.getCreateTime());
			boolean flag = ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String selectOne(String sql, String courseId, String code) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(Common.DRIVER);
			conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
			ps = conn.prepareStatement(sql);
			ps.setString(1, courseId);
			ps.setString(2, code);
			rs = ps.executeQuery();
			while(rs.next()){
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return null;
	}
	
	
	public static ResultSet selectAll(String sql) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(Common.DRIVER);
			conn = DriverManager.getConnection(Common.URL, Common.USERNAME, Common.PASSWORD);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return rs;
	}

}
