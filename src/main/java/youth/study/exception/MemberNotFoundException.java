package youth.study.exception;

public class MemberNotFoundException extends Exception {

    public MemberNotFoundException() {  }
    public MemberNotFoundException(String message) {
        super(message);
    }
}
