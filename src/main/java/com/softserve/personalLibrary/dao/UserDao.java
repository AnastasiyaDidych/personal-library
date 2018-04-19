package com.softserve.personalLibrary.dao;




import com.softserve.personalLibrary.entity.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends A_DaoCRUD<UserEntity> {
    @Override
    public UserEntity createEntity(ResultSet resultSet) throws SQLException {
        //in brackets I set column indexes where the data is stored
        return new UserEntity(
                resultSet.getString(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getLong(5));

    }

    @Override
    public List<Object> getEntityData(UserEntity userEntity) {
        List<Object> userData = new ArrayList<>();

        userData.add(userEntity.getLogin());     //0
        userData.add(userEntity.getEmail());     //1
        userData.add(userEntity.getLastName());  //2
        userData.add(userEntity.getPassword());  //3
        userData.add(userEntity.getId());        //4
        return userData;
    }

    @Override
    public String selectByIdQuery() {
        return "sql.user.selectById";

    }

    @Override
    public List<String> selectByFieldQuery() {
        List<String> userSelectByFieldQuery = new ArrayList<>();
        userSelectByFieldQuery.add("sql.user.selectByField");
        userSelectByFieldQuery.add("sql.question.mark");
        return userSelectByFieldQuery;
    }

    @Override
    public String selectAllQuery() {
        return "sql.user.selectAll";
    }

    @Override
    public String updateByIdQuery() {
        return "sql.user.updateById";
    }

    @Override
    public List<String> updateByFieldQuery() {
        List<String> userUpdateByFieldQuery = new ArrayList<>();
        userUpdateByFieldQuery.add("sql.user.updateByFieldPart1");
        userUpdateByFieldQuery.add("sql.user.updateByFieldPart2");
        userUpdateByFieldQuery.add("sql.question.mark");
        return userUpdateByFieldQuery;
    }

    @Override
    public String deleteByIdQuery() {
        return "sql.user.deleteById";
    }

    @Override
    public List<String> deleteByFieldQuery() {
        List<String> userDeleteByFieldQuery = new ArrayList<>();
        userDeleteByFieldQuery.add("sql.user.deleteByField");
        userDeleteByFieldQuery.add("sql.question.mark");
        return userDeleteByFieldQuery;
    }

    @Override
    public String insertQuery() {
        return "sql.user.insert";
    }
}
