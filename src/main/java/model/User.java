package model;

@Entity
public class User {

    public User() {

    }
    public User(String fName, String lName, int usrId) {
        this.fName = fName;
        this.lName = lName;
        this.usrId = usrId;
    }

    public int getUsrId() {
        return usrId;
    }

    public void setUsrId(int usrId) {
        this.usrId = usrId;
    }
    private String fName;
    private String lName;
    private int usrId;

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String toString() {
        String info = String.format("usrId = %d, firstname = %s, lastname = %s", usrId, fName, lName);
        return info;
    }
}
