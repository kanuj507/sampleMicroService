package component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import service.UserService;

@Component
public class ApplicationComponent {

    // field-based dependency injection
    @Autowired
    private UserService service;

    // constructor-based dependency injection
    // @Autowired
    // public MyApplication(MessageService svc){
    // this.service=svc;
    // }

    // @Autowired
    // public void setService(UserService svc) {
    // this.service = svc;
    // }

    // public boolean processMessage(String msg, String rec) {
    // // some magic like validation, logging etc
    // return this.service.sendMessage(msg, rec);
    // }
}