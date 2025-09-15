package realERPproject.erpProjectVVS.stock.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import realERPproject.erpProjectVVS.common.response.ApiResponse;
import realERPproject.erpProjectVVS.stock.mapper.StockRequest;
import realERPproject.erpProjectVVS.stock.mapper.StockResponse;
import realERPproject.erpProjectVVS.stock.service.StockService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stock")
public class StockController {

    private final StockService stockService;

    @PostMapping
    public ResponseEntity<ApiResponse<StockResponse>> wareHousing(StockRequest stockRequest){

        StockResponse wareHousing = stockService.getWareHousing(stockRequest);

        return ApiResponse.success(wareHousing, "입고가 완료되었습니다.");
    }
}
