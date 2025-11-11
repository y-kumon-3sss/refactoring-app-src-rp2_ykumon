package jp.co.sss.crud.exception;

public class IllegalInputException extends Exception {
	/** コンストラクタ */
	public IllegalInputException(String message) {
		super(message);
	}

	public IllegalInputException(String message, Throwable cause) {
		super(message, cause);
	}
}
