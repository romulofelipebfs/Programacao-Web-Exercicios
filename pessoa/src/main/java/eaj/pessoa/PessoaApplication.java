package eaj.pessoa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class PessoaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PessoaApplication.class, args);
	}

}
