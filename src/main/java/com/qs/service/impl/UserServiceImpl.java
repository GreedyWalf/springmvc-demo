package com.qs.service.impl;

import com.qs.entity.user.UserInfo;
import com.qs.service.UserService;
import org.hibernate.Query;
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


    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void saveOrUpdate(UserInfo user) {
        Session session = sessionFactory.getCurrentSession();
//        Transaction tx = session.beginTransaction();
        session.save(user);
//        tx.commit();
    }

    public void delete(int userId) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        UserInfo user = (UserInfo) session.get(UserInfo.class, userId);
        if (user != null) {
            session.delete(user);
        }

        transaction.commit();
    }

    public void deleteByUserId(int userId) {
        Session session = this.getSession();
        Query query = session.createQuery("delete from UserInfo where userId=?");
        query.setParameter(0, userId);
        query.executeUpdate();
    }

    public UserInfo load(int userId) {
        Session session = sessionFactory.getCurrentSession();
        return (UserInfo) session.load(UserInfo.class, userId);
    }

    public UserInfo getEntity(int userId) {
        Session session = sessionFactory.getCurrentSession();
        return (UserInfo) session.get(UserInfo.class, userId);
    }
}
