package com.softserve.personalLibrary.service;

import com.softserve.personalLibrary.constant.Attribute;
import com.softserve.personalLibrary.dao.ItemDao;
import com.softserve.personalLibrary.dao.UserDao;
import com.softserve.personalLibrary.entity.ItemEntity;
import com.softserve.personalLibrary.entity.UserEntity;


import java.util.ArrayList;
import java.util.List;

public class ConjointService {
    private List<ItemEntity> itemList = new ArrayList<>();


    public List<ItemEntity> fullItemList(String login) {
        UserDao userDao = new UserDao();
        ItemDao itemDao = new ItemDao();
        UserEntity userEntity = userDao.selectByField(Attribute.LOGIN,login);

        for (ItemEntity itemEntity : itemDao.selectAll()) {
            if (itemEntity.getUserLogin().equals(userEntity.getLogin())){
                itemList.add(itemDao.selectById(itemEntity.getId()));
            }
        }
        return itemList;
    }

}
