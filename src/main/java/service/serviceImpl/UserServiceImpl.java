package service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import model.User;
import service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    // @Autowired(required = true)
    @Autowired
    public UserServiceImpl(final UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public int addUser(User user) {
        // TODO Auto-generated method stub
        return this.userDao.insert(user);

    }

}
