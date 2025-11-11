package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeFindByDeptIdService {
	public static void findByDeptId(String deptId) throws ClassNotFoundException, SQLException, IOException {
		List<Employee> employees = EmployeeDAO.findByDeptId(deptId);// 社員情報取得
		ConsoleWriter.showEmployees(employees);//コンソール出力
	}
}
