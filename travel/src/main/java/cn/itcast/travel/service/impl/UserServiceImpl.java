package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;

/**
 * @author Dremeue
 * @create 2019-09-16 23:44
 **/
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean register(User user) {
        User user1 = userDao.findByUsername(user.getUsername());
        if (user1 != null) {
            // 用户存在, 则返回false
            return false;
        }

        // 用户不存在则注册用户
        userDao.save(user);
        return true;
    }
}
