package realERPproject.erpProjectVVS.wareHouse.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import realERPproject.erpProjectVVS.common.exception.ErrorCode;

@Getter
@RequiredArgsConstructor
public enum WareHouseErrorCode implements ErrorCode {

    WARE_HOUSE_ERROR_CODE("WAREHOUSE-001",HttpStatus.NOT_FOUND,"창고를 찾을 수 없습니다.");


    private final String code;
    private final HttpStatus httpStatus;
    private final String message;
}
