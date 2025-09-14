package realERPproject.erpProjectVVS.product.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import realERPproject.erpProjectVVS.product.entity.Product;

import java.awt.print.Pageable;

public interface ProductRepositoryImpl extends JpaRepository<Product,Long> {

    Product save(Product product);

    Page<Product> findByProductNameContaining(String keyword, PageRequest pageable);
}
