package proyekmagang.restfullapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import proyekmagang.restfullapi.repository.UserRepository;

@SpringBootApplication
public class AppRestfullApplication {

	@Autowired
	private UserRepository userRepository;


	public static void main(String[] args) {
		SpringApplication.run(AppRestfullApplication.class, args);
	}


}
