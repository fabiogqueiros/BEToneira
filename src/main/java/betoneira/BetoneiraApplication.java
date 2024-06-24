package betoneira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BetoneiraApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetoneiraApplication.class, args);
	}

}
