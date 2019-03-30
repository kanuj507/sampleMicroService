import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import dao.UserDao;
import dao.daoImpl.UserDaoImpl;
import model.User;
import service.UserService;
import service.serviceImpl.UserServiceImpl;

@SpringBootApplication(scanBasePackages = { "controller", "dao.*" })
@EnableAutoConfiguration
// @ComponentScan(basePackages = "controller")
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

    // @Bean
    // public UserService getUserService() {
    // UserDao usr = new UserDaoImpl();
    // return new UserServiceImpl(usr);
    // }
}

