package exception;

public class MakeException extends Exception { // �����ڰ� ���� Exception Ŭ���� - �⺻ Ʋ
	private String errorMessage;	
	
	public MakeException() {
		
	}
	
	public MakeException(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	@Override
	public String toString() {
		return getClass()+" : errorMessage";
	}
}
