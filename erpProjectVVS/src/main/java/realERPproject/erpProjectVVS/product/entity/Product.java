package realERPproject.erpProjectVVS.product.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Product {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;
    String size;
    String type;

}
