package cl.spring.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cl.model.TabEcoSec;



@Configuration
public class ApplicationConfig {

	@Bean
	public TabEcoSec tabEcoSec(){
		return new TabEcoSec();
	}
}
