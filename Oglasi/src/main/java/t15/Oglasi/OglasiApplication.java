package t15.Oglasi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import t15.Oglasi.baza.DB;

@SpringBootApplication
public class OglasiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OglasiApplication.class, args);
	}

}
