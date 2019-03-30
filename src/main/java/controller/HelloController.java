package controller;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import common.WebResponse;
import model.Customer;
import model.User;
import service.UserService;
import service.serviceImpl.UserServiceImpl;

@RestController
public class HelloController {

    Map<Integer, Customer> custStores = new HashMap<Integer, Customer>();

    Map<Integer, User> userStores = new HashMap<Integer, User>();

    // @Autowired
    // public UserServiceImpl usrService;

    @RequestMapping("/")
    public String defaultMethod() {
        return "Welcome";
    }

    @GetMapping("/user")
    public String getUser() {
        return "Username";
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/hello/{userName}")
    public String sayHelloName(@PathVariable String userName) {
        return "Hello World " + userName;
    }

    @PostMapping("/user")
    public User postData(@RequestBody User user) {

        Random r = new Random();
        user.setUsrId(r.nextInt());

        // POST processing
        userStores.put(user.getUsrId(), user);

        // Log out custStores after POST
        System.out.println("Customer Stores after POST:");
        userStores.forEach((id, usr) -> System.out.println(usr.toString()));

        return user;
    }

    @PostMapping("/post")
    public Customer postMethod(@RequestBody Customer customer) {
        Random r = new Random();
        customer.setCustId(r.nextInt());

        // POST processing
        custStores.put(customer.getCustId(), customer);

        // Log out custStores after POST
        System.out.println("Customer Stores after POST:");
        custStores.forEach((id, cust) -> System.out.println(cust.toString()));

        return customer;
    }

    // @PostMapping("/add/user")
    // public WebResponse<Boolean> addNewUser(@RequestBody User user) {
    // this.usrService.addUser(user);
    // return new WebResponse<>(Boolean.TRUE);
    // }
}
