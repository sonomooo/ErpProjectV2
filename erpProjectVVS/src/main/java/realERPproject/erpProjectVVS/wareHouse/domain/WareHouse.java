package realERPproject.erpProjectVVS.wareHouse.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import realERPproject.erpProjectVVS.product.entity.Product;
import realERPproject.erpProjectVVS.stock.entity.Stock;

import java.util.ArrayList;
import java.util.List;

public class WareHouse {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    private List<Stock> stocks = new ArrayList<>();

    public void decreaseStock(Product product,int quantity){
        Stock stock = findStock(product);
        stock.decrease(quantity);
    }

    public void increaseStock(Product product,int quantity){
        Stock stock = findStock(product);
        stock.addQuantity(quantity);
    }

    private Stock findStock(Product product) {
        return stocks.stream()
                .filter(s -> s.getProduct().equals(product))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("재고 없음"));
    }
}

