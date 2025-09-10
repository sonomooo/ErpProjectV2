package realERPproject.erpProjectVVS.common.exception;

public class GlobalException extends RuntimeException {

    private final ErrorCode errorCode;

    public GlobalException(ErrorCode errorCode) {
        super("[" + errorCode.getCode() + "] "
                + errorCode.getHttpStatus()
                + " - " + errorCode.getMessage());
        this.errorCode = errorCode;
    }

}
