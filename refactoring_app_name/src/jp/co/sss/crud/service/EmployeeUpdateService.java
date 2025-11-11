package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;

public class EmployeeUpdateService {
	public static void update(String empId) throws ClassNotFoundException, SQLException, IOException, ParseException {
		EmployeeDAO.update(empId);// 社員情報更新
	}
}
