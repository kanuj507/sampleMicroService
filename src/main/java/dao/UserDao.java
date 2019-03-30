package dao;


import model.User;

public interface UserDao {

    /**
     * Insert User details.
     * 
     * @param user Details of the User.
     * @return Number of rows inserted.
     */
    int insert(User user);
    
    /**
     * Search user details.
     * 
     * @param userName of the User.
     * @return Number of rows inserted.
     */
    int searchUserByUserName(String userName);
}
