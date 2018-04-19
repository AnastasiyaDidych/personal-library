package com.softserve.personalLibrary.dao;


import java.util.List;

public interface I_DaoCRUD<TEntity> {

    //create
    void insert(TEntity entity);


    //read
    List<TEntity> selectAll();
    TEntity selectByField(String column, String text);
    TEntity selectById(Long id);


    //update
    void updateById(TEntity entity);
    void updateByField(String column1, String newContent, String column2, String condition);


    //delete
    void deleteById(Long id);
    void deleteByField(String column, String text);

}
