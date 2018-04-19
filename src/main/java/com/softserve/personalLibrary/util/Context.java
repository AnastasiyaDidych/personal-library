package com.softserve.personalLibrary.util;

import com.softserve.personalLibrary.dao.ItemDao;
import com.softserve.personalLibrary.dao.UserDao;
import com.softserve.personalLibrary.service.ConjointService;
import com.softserve.personalLibrary.service.ItemService;
import com.softserve.personalLibrary.service.UserService;

public class Context {

    private static volatile Context instance = null;

    //
    UserDao userDao;
    ItemDao itemDao;
    //
    UserService userService;
    ItemService itemService;
    ConjointService conjointService;

    public UserService getUserService() {
        return userService;
    }

    public ItemService getItemService() {
        return itemService;
    }

    public ConjointService getConjointService() {
        return conjointService;
    }

    private Context() {
        initComponents();

    }

    public static Context getInstance() {
        if (instance == null) {
            synchronized (Context.class) {
                if (instance == null) {
                    instance = new Context();
                }
            }
        }
        return instance;
    }

    private void initComponents() {
        userDao = new UserDao();
        itemDao = new ItemDao();
        userService = new UserService();
        conjointService = new ConjointService();
        itemService = new ItemService();

    }
}
