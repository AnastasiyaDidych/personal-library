package com.softserve.personalLibrary.service;

import com.softserve.personalLibrary.constant.Attribute;
import com.softserve.personalLibrary.dao.UserDao;
import com.softserve.personalLibrary.entity.UserEntity;
import javax.servlet.http.HttpServletRequest;


public class UserService {

    public boolean isLogged(HttpServletRequest request) {
        boolean result = false;
        String loginR = request.getParameter(Attribute.LOGIN);
        String passwordR = request.getParameter(Attribute.PASSWORD);
        UserDao userDao = new UserDao();
        UserEntity user = userDao.selectByField(Attribute.LOGIN, loginR);
        System.out.println(user);

        if (user != null && passwordR.equals(user.getPassword())) {
            result = true;
        }
        return result;
    }

    public boolean createUser(HttpServletRequest request) {
        boolean result = false;
        UserDao userDao = new UserDao();
        if (request.getParameter(Attribute.LOGIN) != null
                && request.getParameter(Attribute.PASSWORD)!= null)
        {
            UserEntity user = new UserEntity(request.getParameter(Attribute.LOGIN),
                    request.getParameter(Attribute.EMAIL),
                    request.getParameter(Attribute.NAME),
                    request.getParameter(Attribute.PASSWORD), -1L);
            userDao.insert(user);
            result = true;

        }
        return result;
    }

    public boolean updateUser(HttpServletRequest request) {
        boolean result = false;
        if (request.getSession().getAttribute(Attribute.LOGIN) != null) {
            String login = request.getSession().getAttribute(Attribute.LOGIN).toString();
            UserDao userDao = new UserDao();
            UserEntity userEntity = userDao.selectByField(Attribute.LOGIN, login);
            userEntity.setLastName(request.getParameter(Attribute.NAME));
            userEntity.setPassword(request.getParameter(Attribute.PASSWORD));
            userDao.updateById(userEntity);
            result = true;
        }
        return result;
    }


    public UserEntity getUser(HttpServletRequest request) {
        UserDao userDao = new UserDao();

        if (request.getSession().getAttribute(Attribute.LOGIN) != null) {
            String login = (request.getSession().getAttribute(Attribute.LOGIN).toString());
            return userDao.selectByField(Attribute.LOGIN, login);
        }
        return null;
    }

    public boolean checkData(String login) {
        boolean result = false;
        UserDao userDao = new UserDao();
        UserEntity user = userDao.selectByField(Attribute.LOGIN, login);
        if (user == null) {
            result = true;
        }
        return result;
    }
}
