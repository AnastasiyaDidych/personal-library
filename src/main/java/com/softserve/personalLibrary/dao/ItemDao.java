package com.softserve.personalLibrary.dao;


import com.softserve.personalLibrary.entity.ItemEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDao extends A_DaoCRUD<ItemEntity> {

    public ItemEntity createEntity(ResultSet resultSet) throws SQLException {
        return new ItemEntity(
                resultSet.getString(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getLong(4));
    }

    @Override
    public List<Object> getEntityData(ItemEntity itemEntity) {
        List<Object> itemData = new ArrayList<>();
        itemData.add(itemEntity.getTitle());        //0
        itemData.add(itemEntity.getDescription());  //1
        itemData.add(itemEntity.getUserLogin());    //2
        itemData.add(itemEntity.getId());           //3
        return itemData;
    }

    public String selectByIdQuery(){
        return "sql.item.selectById";
    }

    @Override
    public List<String> selectByFieldQuery() {
        List<String> itemSelectByFieldQuery = new ArrayList<>();
        itemSelectByFieldQuery.add("sql.item.selectByField");
        itemSelectByFieldQuery.add("sql.question.mark");
        return itemSelectByFieldQuery;
    }

    @Override
    public String selectAllQuery() {
        return "sql.item.selectAll";
    }

    @Override
    public String updateByIdQuery() {
        return "sql.item.updateById";
    }

    @Override
    public List<String> updateByFieldQuery() {
        List<String> itemUpdateByFieldQuery = new ArrayList<>();
        itemUpdateByFieldQuery.add("sql.item.updateByFieldPart1");
        itemUpdateByFieldQuery.add("sql.item.updateByFieldPart2");
        itemUpdateByFieldQuery.add("sql.question.mark");
        return itemUpdateByFieldQuery;
    }

    @Override
    public String deleteByIdQuery() {
        return "sql.item.deleteById";
    }

    @Override
    public List<String> deleteByFieldQuery() {
        List<String> itemDeleteByFieldQuery = new ArrayList<>();
        itemDeleteByFieldQuery.add("sql.item.deleteByField");
        itemDeleteByFieldQuery.add("sql.question.mark");
        return itemDeleteByFieldQuery;
    }

    @Override
    public String insertQuery() {
        return "sql.item.insert";
    }
}
