package com.xt.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void add() {
        userDao.insert();
        System.out.println("添加完成。。。");
        int i = 10 / 0;
    }
}
