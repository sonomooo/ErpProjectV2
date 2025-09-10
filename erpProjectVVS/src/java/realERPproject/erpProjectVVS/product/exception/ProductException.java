package realERPproject.erpProjectVVS.product.exception;

import realERPproject.erpProjectVVS.common.exception.ErrorCode;
import realERPproject.erpProjectVVS.common.exception.GlobalException;

public class ProductException extends GlobalException {

    public ProductException(ErrorCode errorCode){
        super(errorCode);
    }
}
