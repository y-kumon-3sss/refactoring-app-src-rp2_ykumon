package jp.co.sss.crud.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantSQL;
import jp.co.sss.crud.util.ConstantValue;

public class EmployeeDAO {
	public static List<Employee> findAll() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		// データがない場合は空のリストを返すため、リストを初期化
		List<Employee> employeeList = new ArrayList<>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			// DBから取得した社員情報をDTOにセット
			while (resultSet.next()) {
				Employee employeeDto = new Employee();
				employeeDto.setEmpId(resultSet.getInt(ConstantValue.COL_EMP_ID));
				employeeDto.setEmpName(resultSet.getString(ConstantValue.COL_EMP_NAME));
				employeeDto.setGender(resultSet.getInt(ConstantValue.COL_GENDER));
				employeeDto.setBirthday(resultSet.getString(ConstantValue.COL_BIRTHDAY));
				employeeDto.setDeptName(resultSet.getString(ConstantValue.COL_DEPT_NAME));

				// リストへ格納
				employeeList.add(employeeDto);
			}
		} finally {
			// ResultSetをクローズ
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}

		return employeeList;
	}

	/**
	 * 社員名に該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static List<Employee> findByEmployeeName(String empName)
			throws ClassNotFoundException, SQLException, IOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		// データがない場合は空のリストを返すため、リストを初期化
		List<Employee> employeeList = new ArrayList<>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_NAME);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setString(ConstantValue.PARAM_INDEX_ONE,
					ConstantValue.SQL_WILDCARD + empName + ConstantValue.SQL_WILDCARD);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Employee employeeDto = new Employee();
				employeeDto.setEmpId(resultSet.getInt(ConstantValue.COL_EMP_ID));
				employeeDto.setEmpName(resultSet.getString(ConstantValue.COL_EMP_NAME));
				employeeDto.setGender(resultSet.getInt(ConstantValue.COL_GENDER));
				employeeDto.setBirthday(resultSet.getString(ConstantValue.COL_BIRTHDAY));
				employeeDto.setDeptName(resultSet.getString(ConstantValue.COL_DEPT_NAME));

				// リストへ格納
				employeeList.add(employeeDto);
			}

		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}

		return employeeList;
	}

	/**
	 * 部署IDに該当する社員情報を検索
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static List<Employee> findByDeptId(String deptId) throws ClassNotFoundException, SQLException, IOException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		// データがない場合は空のリストを返すため、リストを初期化
		List<Employee> employeeList = new ArrayList<>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_DEPT_ID);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setInt(ConstantValue.PARAM_INDEX_ONE, Integer.parseInt(deptId));

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Employee employeeDto = new Employee();
				employeeDto.setEmpId(resultSet.getInt(ConstantValue.COL_EMP_ID));
				employeeDto.setEmpName(resultSet.getString(ConstantValue.COL_EMP_NAME));
				employeeDto.setGender(resultSet.getInt(ConstantValue.COL_GENDER));
				employeeDto.setBirthday(resultSet.getString(ConstantValue.COL_BIRTHDAY));
				employeeDto.setDeptName(resultSet.getString(ConstantValue.COL_DEPT_NAME));
				// リストへ格納
				employeeList.add(employeeDto);
			}

		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}

		return employeeList;
	}

	/**
	 * 社員情報を1件登録
	 * 
	 * @param empName 社員名
	 * @param gender 性別
	 * @param birthday 生年月日
	 * @param deptId 部署ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public static void insert(String empName, String gender, String birthday, String deptId)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);

			// 入力値をバインド
			preparedStatement.setString(ConstantValue.PARAM_INDEX_ONE, empName);
			preparedStatement.setInt(ConstantValue.PARAM_INDEX_TWO, Integer.parseInt(gender));
			SimpleDateFormat sdf = new SimpleDateFormat(ConstantValue.DATE_FORMAT_YYYY_MM_DD);
			preparedStatement.setObject(ConstantValue.PARAM_INDEX_THREE, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(ConstantValue.PARAM_INDEX_FOUR, Integer.parseInt(deptId));

			// SQL文を実行
			preparedStatement.executeUpdate();

			// 登録完了メッセージを出力
			System.out.println(ConstantMsg.MSG_REGISTED_EMPLOYEE);
		} finally {
			DBManager.close(preparedStatement);
			DBManager.close(connection);
		}
	}

	/**
	 * 社員情報を1件更新
	 * 
	 * @param empId 社員ID
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException            DB処理でエラーが発生した場合に送出
	 * @throws IOException             入力処理でエラーが発生した場合に送出
	 * @throws ParseException 
	 */
	public static void update(String empId)
			throws ClassNotFoundException, SQLException, IOException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);

			System.out.print(ConstantMsg.MSG_INPUT_EMPLOYEE_NAME);
			String empName = br.readLine();
			// 性別を入力
			System.out.print(ConstantMsg.MSG_INPUT_GENDER);
			String gender = br.readLine();
			// 誕生日を入力
			System.out.print(ConstantMsg.MSG_INPUT_BIRTHDAY);
			String birthday = br.readLine();

			// 部署IDを入力
			System.out.print(ConstantMsg.MSG_INPUT_DEPT_ID);
			String deptId = br.readLine();

			// 入力値をバインド
			preparedStatement.setString(ConstantValue.PARAM_INDEX_ONE, empName);
			preparedStatement.setInt(ConstantValue.PARAM_INDEX_TWO, Integer.parseInt(gender));
			SimpleDateFormat sdf = new SimpleDateFormat(ConstantValue.DATE_FORMAT_YYYY_MM_DD);
			preparedStatement.setObject(ConstantValue.PARAM_INDEX_THREE, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(ConstantValue.PARAM_INDEX_FOUR, Integer.parseInt(deptId));
			preparedStatement.setInt(ConstantValue.PARAM_INDEX_FIVE, Integer.parseInt(empId));

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

		} finally {
			// クローズ処理
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 社員情報を1件削除
	 *
	 * @throws ClassNotFoundException ドライバクラスが不在の場合に送出
	 * @throws SQLException           DB処理でエラーが発生した場合に送出
	 * @throws IOException            入力処理でエラーが発生した場合に送出
	 */
	public static void delete() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			// データベースに接続
			connection = DBManager.getConnection();
			String empId = br.readLine();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_DELETE);

			// 社員IDをバインド
			preparedStatement.setInt(ConstantValue.PARAM_INDEX_ONE, Integer.parseInt(empId));

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

			System.out.println(ConstantMsg.MSG_DELETED_EMPLOYEE);

		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			try {
				// Statementをクローズ
				DBManager.close(preparedStatement);
				// DBとの接続を切断
				DBManager.close(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
