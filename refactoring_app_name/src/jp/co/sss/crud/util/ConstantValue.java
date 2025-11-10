package jp.co.sss.crud.util;

/**
 * 設定値をまとめたクラス(メッセージ関連)
 *
 * @author System Shared
 *
 */
public class ConstantValue {

	/** インスタンス化を禁止 */
	private ConstantValue() {
	}

	/** メニュー番号1 */
	public static final int MENU_NUMBER_ONE = 1;
	/** メニュー番号2 */
	public static final int MENU_NUMBER_TWO = 2;
	/** メニュー番号3 */
	public static final int MENU_NUMBER_THREE = 3;
	/** メニュー番号4 */
	public static final int MENU_NUMBER_FOUR = 4;
	/** メニュー番号5 */
	public static final int MENU_NUMBER_FIVE = 5;
	/** メニュー番号6 */
	public static final int MENU_NUMBER_SIX = 6;
	/** メニュー番号7 */
	public static final int MENU_NUMBER_SEVEN = 7;

	/** カラム名_社員ID */
	public static final String COL_EMP_ID = "emp_id";
	/** カラム名_社員名 */
	public static final String COL_EMP_NAME = "emp_name";
	/** カラム名_性別 */
	public static final String COL_GENDER = "gender";
	/** カラム名_生年月日 */
	public static final String COL_BIRTHDAY = "birthday";
	/** カラム名_部署ID */
	public static final String COL_DEPT_ID = "dept_id";
	/** カラム名_部署名 */
	public static final String COL_DEPT_NAME = "dept_name";

	/** 性別_回答なし */
	public static final int GENDER_NO_ANSWER = 0;
	/** 性別_男性 */
	public static final int GENDER_MALE = 1;
	/** 性別_女性 */
	public static final int GENDER_FEMALE = 2;
	/** 性別_その他 */
	public static final int GENDER_OTHERS = 3;
	/** 性別_回答なし */
	public static final String STRING_GENDER_NOT_ANSWER = "回答なし";
	/** 性別_男性 */
	public static final String STRING_GENDER_MALE = "男性";
	/** 性別_女性 */
	public static final String STRING_GENDER_FEMALE = "女性";
	/** 性別_その他 */
	public static final String STRING_GENDER_OTHERS = "その他";

	/** 部署_営業部 */
	public static final int DEPT_SALES_DEPARTMENT = 1;
	/** 部署_経理部 */
	public static final int DEPT_ACCOUNTING_DEPARTMENT = 2;
	/** 部署_総務部 */
	public static final int DEPT_GENERAL_AFFAIRS_DEPARTMENT = 3;
	/** 部署_文字列_営業部 */
	public static final String DEPT_STRING_SALES_DEPARTMENT = "営業部";
	/** 部署_文字列_経理部 */
	public static final String DEPT_STRING_ACCOUNTING_DEPARTMENT = "経理部";
	/** 部署_文字列_総務部 */
	public static final String DEPT_STRING_GENERAL_AFFAIRS_DEPARTMENT = "総務部";

	/** 入力値バインド1 */
	public static final int PARAM_INDEX_ONE = 1;
	/** 入力値バインド2 */
	public static final int PARAM_INDEX_TWO = 2;
	/** 入力値バインド3 */
	public static final int PARAM_INDEX_THREE = 3;
	/** 入力値バインド4 */
	public static final int PARAM_INDEX_FOUR = 4;
	/** 入力値バインド5 */
	public static final int PARAM_INDEX_FIVE = 5;

	/** 日付フォーマット(yyyy/MM/dd) */
	public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy/MM/dd";
	/** ワイルドカード */
	public static final String SQL_WILDCARD = "%";

}