package book.bookException;

import book.bookException.commonException.exception.ErrorCode;
import book.bookException.commonException.exception.GlobalException;


public class BookException extends GlobalException {

    public BookException(ErrorCode errorCode){
        super(errorCode);
    }
}
