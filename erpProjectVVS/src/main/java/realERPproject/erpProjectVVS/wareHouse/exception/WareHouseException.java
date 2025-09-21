package realERPproject.erpProjectVVS.wareHouse.exception;

import realERPproject.erpProjectVVS.common.exception.ErrorCode;
import realERPproject.erpProjectVVS.common.exception.GlobalException;

public class WareHouseException extends GlobalException {

    public WareHouseException(ErrorCode errorCode){
        super(errorCode);
    }
}
