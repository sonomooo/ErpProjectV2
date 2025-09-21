package realERPproject.erpProjectVVS.wareHouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import realERPproject.erpProjectVVS.wareHouse.domain.WareHouse;

@Repository
public interface WareHouseRepositoryImpl extends JpaRepository<WareHouse,Long> {


}
