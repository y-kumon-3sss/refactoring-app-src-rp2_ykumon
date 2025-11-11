package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;

public class EmployeeRegisterService {
	public static void insert(String empName, String gender, String birthday, String deptId)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		EmployeeDAO.insert(empName, gender, birthday, deptId);// 社員情報登録
	}
}
