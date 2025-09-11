package realERPproject.erpProjectVVS.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import realERPproject.erpProjectVVS.product.entity.Product;

public interface ProductRepositoryImpl extends JpaRepository<Product,Long> {

    Product save(Product product);
}
