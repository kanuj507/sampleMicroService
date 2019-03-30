package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import dao.UserDao;
import dao.daoImpl.UserDaoImpl;
import service.UserService;
import service.serviceImpl.UserServiceImpl;

@Configuration
@ComponentScan(value = { "component" })
public class UserConfiguration {

    @Bean
    public UserService getMessageService() {
        UserDao usrDao = new UserDaoImpl();
        return new UserServiceImpl(usrDao);
    }

}
