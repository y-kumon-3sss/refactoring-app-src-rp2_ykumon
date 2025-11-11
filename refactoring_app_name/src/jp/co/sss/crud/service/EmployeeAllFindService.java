package jp.co.sss.crud.service;

import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeAllFindService {
	public static void findAll() throws ClassNotFoundException, SQLException {
		List<Employee> employees = EmployeeDAO.findAll();// 社員情報取得
		ConsoleWriter.showEmployees(employees);//コンソール出力
	}
}
