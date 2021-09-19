package t15.Oglasi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OglasiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OglasiApplication.class, args);
		System.out.println(System.getProperty("user.dir"));
	}

}
