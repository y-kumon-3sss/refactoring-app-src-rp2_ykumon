package jp.co.sss.crud.dto;

import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantValue;

/**
 * 社員情報DTO
 *
 * @author 公文勇弥
 */

public class Employee {

	// 社員ID
	private int empId;
	// 社員名
	private String empName;
	// 性別
	private int gender;
	// 生年月日
	private String birthday;
	// 部署ID
	private int deptId;
	// 部署名
	private String deptName;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		// 性別変換処理
		String gender_jp = "";
		if (gender == ConstantValue.GENDER_NO_ANSWER) {
			gender_jp = ConstantValue.STRING_GENDER_NOT_ANSWER;
		} else if (gender == ConstantValue.GENDER_MALE) {
			gender_jp = ConstantValue.STRING_GENDER_MALE;

		} else if (gender == ConstantValue.GENDER_FEMALE) {
			gender_jp = ConstantValue.STRING_GENDER_FEMALE;

		} else if (gender == ConstantValue.GENDER_OTHERS) {
			gender_jp = ConstantValue.STRING_GENDER_OTHERS;

		}

		// コンソール出力
		return this.empId + ConstantMsg.DELIMITER_TAB + this.empName +
				ConstantMsg.DELIMITER_TAB + gender_jp +
				ConstantMsg.DELIMITER_TAB + this.birthday +
				ConstantMsg.DELIMITER_TAB + this.deptName;
	}
}