package jp.co.sss.crud.exception;

public class SystemErrorException extends Exception {
	/** コンストラクタ */
	public SystemErrorException(String message, Throwable cause) {
		super(message, cause);
	}
}
