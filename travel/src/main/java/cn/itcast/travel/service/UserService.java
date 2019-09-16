package cn.itcast.travel.service;

import cn.itcast.travel.domain.User;

/**
 * @author Dremeue
 * @create 2019-09-16 23:43
 **/
public interface UserService {
    /**
     * 用户注册
     * @param user
     * @return
     */
    public boolean register(User user);

    /**
     * 用户激活
     * @param code
     * @return
     */
    boolean active(String code);
}
