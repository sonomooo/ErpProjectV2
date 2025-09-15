package realERPproject.erpProjectVVS.stock.stockRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import realERPproject.erpProjectVVS.stock.entity.Stock;

public interface StockRepositoryImpl extends JpaRepository<Stock,Long> {

    Stock findQuantityById(Long Id);

}
