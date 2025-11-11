package jp.co.sss.crud.service;

import java.sql.SQLException;

import jp.co.sss.crud.db.EmployeeDAO;

public class EmployeeDeleteService {
	public static void delete() throws ClassNotFoundException, SQLException {
		EmployeeDAO.delete();// 社員情報削除
	}
}
