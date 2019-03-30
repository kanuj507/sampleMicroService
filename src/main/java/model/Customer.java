package model;

public class Customer {
    private int custId;
    private String firstname;
    private String lastname;
    private int age;

    public Customer() {
    }

    public Customer(int custId, String firstname, String lastname, int age) {
        this.custId = custId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public Customer(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        String info = String.format("custId = %d, firstname = %s, lastname = %s, age = %d", custId, firstname, lastname, age);
        return info;
    }
}
