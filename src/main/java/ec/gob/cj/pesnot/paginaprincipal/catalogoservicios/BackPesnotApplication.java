package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BackPesnotApplication {
	
	public SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	    return builder.sources(BackPesnotApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BackPesnotApplication.class, args);
	}
	

}
