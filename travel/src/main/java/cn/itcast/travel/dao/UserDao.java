package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

/**
 * @author Dremeue
 * @create 2019-09-16 23:43
 **/
public interface UserDao {
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 用户保存
     * @param user
     */
    public void save(User user);

    /**
     * 根据激活码查找用户
     * @param code
     * @return
     */
    public User findByCode(String code);

    /**
     * 修改用户状态
     * @param user
     */
    public void updateStatus(User user);
}
