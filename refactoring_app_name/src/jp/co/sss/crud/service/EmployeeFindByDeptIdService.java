package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeFindByDeptIdService {
	public static void findByDeptId(String deptId) throws SystemErrorException {
		try {
			List<Employee> employees = EmployeeDAO.findByDeptId(deptId);// 社員情報取得
			ConsoleWriter.showEmployees(employees);//コンソール出力
		} catch (ClassNotFoundException | IOException | SQLException e) {
			//独自例外の送出
			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);
		}
	}
}
