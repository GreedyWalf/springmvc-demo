package com.qs.service.impl;

import com.qs.entity.user.UserInfo;
import com.qs.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/3/7.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    public SessionFactory sessionFactory;


    public void saveOrUpdate(UserInfo user) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
    }
}
