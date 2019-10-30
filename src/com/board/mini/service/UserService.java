package com.board.mini.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;

import com.board.mini.common.DBCon;
import com.board.mini.common.DBExecutor;

// 연결 순서 : con => ps => rs
// 닫는 순서 : rs => ps => con

public class UserService {
	public Map<String, Object> doLogin(String id, String pwd){
		Connection con = DBCon.getCon();
		DBExecutor dbe = new DBExecutor();
		String sql = "select * from user_info where id=? and pwd=? ";

		try {
			PreparedStatement ps = dbe.prepared(con, sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			ResultSet rs = dbe.executeQuery();
			if(rs.next()) {
				Map<String, Object> user = new HashMap<>();
				user.put("ui_num", rs.getInt("ui_num"));
				user.put("ui_name", rs.getInt("ui_name"));
				user.put("ui_id", rs.getInt("ui_id"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbe.closeAll();
			DBCon.closeCon();
		}
		return null;
	}
	public Map<String, Object> doSignup(String ui_name, String ui_id, String ui_pwd){
		DBExecutor dbe = new DBExecutor();
		try {
			Connection con = DBCon.getCon();
			String sql = "insert into user_info(ui_num, ui_name, ui_id, ui_pwd, credat, cretim, moddat, modtim) ";
			sql += "values(seq_ui_num.nextval, ?, ?, ?, to_char(SYSDATE, 'YYYYMMDD'), TO_CHAR(SYSDATE, 'HH24MISS'), to_char(SYSDATE, 'YYYYMMDD'), TO_CHAR(SYSDATE, 'HH24MISS'))";
			
			PreparedStatement ps = dbe.prepared(con, sql);
			ps.setString(1, ui_name);
			ps.setString(2, ui_id);
			ps.setString(3, ui_pwd);
			
			if(ps.executeUpdate() == 1) {
				Map<String, Object> rMap = new HashMap<String, Object>();
				rMap.put("msg", "Welcome, " + ui_name);
				rMap.put("url", "/views/user/login");
				return rMap;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			dbe.closeAll();
			DBCon.closeCon();
		}
		return null;
	}
}
