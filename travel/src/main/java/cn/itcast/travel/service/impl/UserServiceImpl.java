package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

/**
 * @author Dremeue
 * @create 2019-09-16 23:44
 **/
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 用户注册功能
     *
     * @param user
     * @return
     */
    @Override
    public boolean register(User user) {
        User user1 = userDao.findByUsername(user.getUsername());
        if (user1 != null) {
            // 用户存在, 则返回false
            return false;
        }

        // 用户注册时,默认是未激活状态
        user.setStatus("N");
        user.setCode(UuidUtil.getUuid());

        // 发送邮件
        String content = "<a href='http://localhost/travel/activeServlet?code=" + user.getCode() + "'>点击激活【黑马旅游网】</a>";
        MailUtils.sendMail(user.getEmail(), content, "黑马旅游网-激活邮件");

        // 用户不存在则注册用户
        userDao.save(user);
        return true;
    }

    @Override
    public boolean active(String code) {
        User user = userDao.findByCode(code);
        if (user != null) {
            userDao.updateStatus(user);
            return true;
        } else {
            return false;
        }
    }
}
