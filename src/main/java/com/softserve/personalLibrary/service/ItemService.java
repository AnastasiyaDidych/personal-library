package com.softserve.personalLibrary.service;

import com.softserve.personalLibrary.constant.Attribute;
import com.softserve.personalLibrary.dao.ItemDao;
import com.softserve.personalLibrary.entity.ItemEntity;

import javax.servlet.http.HttpServletRequest;


public class ItemService {

    public boolean createItem(HttpServletRequest request) {
        boolean result = false;
        if (request.getSession().getAttribute(Attribute.LOGIN) != null) {
            String login = (String) request.getSession().getAttribute(Attribute.LOGIN);
            String title = request.getParameter(Attribute.TITLE);
            String description = request.getParameter(Attribute.DESCRIPTION);
            if (title != null && !title.isEmpty()) {
                ItemDao itemDao = new ItemDao();
                ItemEntity itemEntity = new ItemEntity(title, description, login, -1L);
                itemDao.insert(itemEntity);
                result = true;
            }
        }
        return result;
    }

    public boolean updateItem(HttpServletRequest request) {
        boolean result = false;
        ItemDao itemDao = new ItemDao();

        if (request.getSession().getAttribute(Attribute.LOGIN) != null
                && request.getSession().getAttribute(Attribute.ITEM_ID) != null) {
            if (request.getParameter(Attribute.TITLE) != null) {
                Long id = Long.parseLong(request.getSession().getAttribute(Attribute.ITEM_ID).toString());
                ItemEntity itemEntity = itemDao.selectById(id);
                itemEntity.setTitle(request.getParameter(Attribute.TITLE));
                itemEntity.setDescription(request.getParameter(Attribute.DESCRIPTION));
                itemDao.updateById(itemEntity);
                result = true;
            }
        }
        return result;

    }


    public boolean deleteItem(HttpServletRequest request) {
        boolean result = false;
        ItemDao itemDao = new ItemDao();
        if (request.getParameter(Attribute.ID_RQ) != null && isExistItem(Long.parseLong(request.getParameter(Attribute.ID_RQ)))) {
            Long id = Long.parseLong(request.getParameter(Attribute.ID_RQ));
            itemDao.deleteById(id);
            result = true;
        }
        return result;

    }


    public ItemEntity getItem(HttpServletRequest request) {

        ItemDao itemDao = new ItemDao();
        if (request.getSession().getAttribute(Attribute.ITEM_ID) != null
                && request.getSession().getAttribute(Attribute.ITEM_ID) != null
                && isExistItem(Long.parseLong((String) request.getSession().getAttribute(Attribute.ITEM_ID)))) {

            Long id = Long.parseLong((String) request.getSession().getAttribute(Attribute.ITEM_ID));
            return itemDao.selectById(id);
        }
        return null;
    }


    private boolean isExistItem(Long id) {
        boolean result = false;
        try {
            ItemDao itemDao = new ItemDao();
            itemDao.selectById(id);
            result = true;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return result;
    }


}
