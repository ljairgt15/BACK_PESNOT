package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableJpaAuditing
@EnableWebMvc
public class BackPesnotApplication extends SpringBootServletInitializer {
	

	public static void main(String[] args) {
		SpringApplication.run(BackPesnotApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	    return builder.sources(BackPesnotApplication.class);
	}
	
}
