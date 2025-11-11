package jp.co.sss.crud.io;

import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;

public class ConsoleWriter {
	public static void showEmployees(List<Employee> employees) {
		if (employees.isEmpty()) {
			// 該当者がいませんでした と表示
			showNonExistTarget();
		} else {
			// ヘッダー表示
			showHeader();
			for (Employee employee : employees) {
				System.out.println(employee);
			}
		}
	}

	private static void showNonExistTarget() {
		// 該当者なしメッセージ
		System.out.println(ConstantMsg.MSG_NOT_APPLICABLE_PERSON);
	}

	private static void showHeader() {
		// レコードのヘッダー表示
		System.out.println(ConstantMsg.MSG_RECORD_OUT);
	}

	public static void showMenu() {
		// メニューの表示
		System.out.println(ConstantMsg.MSG_EMPLYEE_MANAGEMENT_SYSTEM);
		System.out.println(ConstantMsg.MSG_MENU_DISPLAY_ALL);
		System.out.println(ConstantMsg.MSG_MENU_SEARCH_EMPLOYEE);
		System.out.println(ConstantMsg.MSG_MENU_SEARCH_DEPT_ID);
		System.out.println(ConstantMsg.MSG_MENU_REGIST_EMPLOYEE);
		System.out.println(ConstantMsg.MSG_MENU_UPDATE_EMPLOYEE);
		System.out.println(ConstantMsg.MSG_MENU_DELETEEMPLOYEE);
		System.out.println(ConstantMsg.MSG_MENU_END);
		System.out.print(ConstantMsg.MSG_MENU);

	}
}
