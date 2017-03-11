package com.qs.service;

import com.qs.entity.user.UserInfo;

/**
 * Created by Administrator on 2017/3/7.
 */
public interface UserService {
    /**
     * 增
     */
    void saveOrUpdate(UserInfo user);

    /**
     * 删（这里遗留一个问题：使用session.delete(Object obj)无法删除掉记录）
     */
    void delete(int userId);

    /**
     * 删（使用query对象 删除数据）
     */
    void deleteByUserId(int userId);


    /**
     * 查 （支持懒加载）
     */
    UserInfo load(int userId);

    /**
     * 查
     */
    UserInfo getEntity(int userId);
}
