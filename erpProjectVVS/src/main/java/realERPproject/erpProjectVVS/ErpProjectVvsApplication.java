package realERPproject.erpProjectVVS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ErpProjectVvsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpProjectVvsApplication.class, args);
	}

}
