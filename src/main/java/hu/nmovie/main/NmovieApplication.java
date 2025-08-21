package hu.nmovie.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A Spring Boot alkalmazás fő indító osztálya.
 * Ez az osztály tartalmazza a main metódust, amely elindítja az alkalmazást.
 */

@SpringBootApplication
public class NmovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(NmovieApplication.class, args);
	}

}
