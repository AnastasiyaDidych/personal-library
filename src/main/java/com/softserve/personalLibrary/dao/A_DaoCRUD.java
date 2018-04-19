package com.softserve.personalLibrary.dao;



import com.softserve.personalLibrary.dbConnection.ConnectionManager;
import com.softserve.personalLibrary.entity.ItemEntity;
import com.softserve.personalLibrary.entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

abstract class A_DaoCRUD<TEntity> implements I_DaoCRUD<TEntity> {
    /*
    specify abstract methods that I need to override in UserDao and ItemDao
    also specify some non-abstract methods with body that is general for both subclasses*/

    private Connection getConnectToDb() {
        return ConnectionManager.getConnectionManager().createConnection(
                ConnectionManager.prop.getProperty("dbURL"),
                ConnectionManager.prop.getProperty("dbUser"),
                ConnectionManager.prop.getProperty("dbPassword"));
    }

    // insert
    public void insert(TEntity entity) {
        Connection connectToDb = getConnectToDb();

        if (connectToDb != null) {
            try (PreparedStatement preparedStatement = connectToDb.prepareStatement
                    (ConnectionManager.prop.getProperty(insertQuery()))) {
                List<Object> entityData = getEntityData(entity);
                for (int i = 1; i <= entityData.size() - 1; i++) {
                    preparedStatement.setObject(i, entityData.get(i - 1));
                }
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("A_DaoCRUD, insert1");
            } finally {
                try {
                    connectToDb.close();
                } catch (SQLException e) {
                    System.out.println("A_DaoCRUD, insert2");
                }
            }

        }
    } //done and works

    // select
    public List<TEntity> selectAll() {
        Connection connectToDb = getConnectToDb();
        List<TEntity> entityList = new ArrayList<>();
        String[] query;
        if (connectToDb != null) {
            try (PreparedStatement preparedStatement = connectToDb.prepareStatement(
                    ConnectionManager.prop.getProperty(selectAllQuery()));
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    query = new String[resultSet.getMetaData().getColumnCount()];
                    entityList.add(createEntity(resultSet));

                }

            } catch (SQLException e) {
                System.out.println("A_DaoCRUD, selectAll1");

            } finally {
                try {
                    connectToDb.close();
                } catch (SQLException e) {
                    System.out.println("A_DaoCRUD, selectAll2");
                }
            }

        }
        return entityList;

    }  //done and works

    public TEntity selectById(Long id) {
        Connection connectToDb = getConnectToDb();
        ResultSet resultSet = null;
        if (connectToDb != null) {
            try (PreparedStatement preparedStatement = connectToDb.prepareStatement
                    (ConnectionManager.prop.getProperty(selectByIdQuery()))) {
                preparedStatement.setLong(1, id);
                resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return createEntity(resultSet);
                }
            } catch (SQLException e) {
                System.out.println("A_DaoCRUD, selectById1");
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    connectToDb.close();
                } catch (SQLException e) {
                    System.out.println("A_DaoCRUD, selectById2");
                }

            }
        }
        return null;
    }  //done and works

    public TEntity selectByField(String column, String text) {
        Connection connectToDb = getConnectToDb();
        ResultSet resultSet = null;
        if (connectToDb != null) {
            try (PreparedStatement preparedStatement = connectToDb.prepareStatement
                    (ConnectionManager.prop.getProperty(selectByFieldQuery().get(0))
                            + column + " "
                            + ConnectionManager.prop.getProperty(selectByFieldQuery().get(1)))) {
                preparedStatement.setString(1, text);

                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    return createEntity(resultSet);
                }
            } catch (SQLException e) {
                System.out.println("A_DaoCRUD, selectByField1");
            } finally {
                try {
                    resultSet.close();
                    connectToDb.close();

                } catch (SQLException e) {
                    System.out.println("A_DaoCRUD, selectByField2");
                }

            }
        }
        return null;
    }  //done and works

    // update
    public void updateById(TEntity entity) {
        Connection connectToDb = getConnectToDb();
        if (connectToDb != null) {
            try (PreparedStatement preparedStatement =
                         connectToDb.prepareStatement(ConnectionManager.prop.getProperty(updateByIdQuery()))) {

                List<Object> entityData = getEntityData(entity);
                if (entity instanceof UserEntity) {
                    preparedStatement.setObject(1, entityData.get(2));
                    preparedStatement.setObject(2, entityData.get(3));
                    preparedStatement.setLong(3, Long.parseLong(entityData.get(4).toString()));
                    preparedStatement.executeUpdate();

                } else if (entity instanceof ItemEntity) {
                    preparedStatement.setObject(1, entityData.get(0));
                    preparedStatement.setObject(2, entityData.get(1));
                    preparedStatement.setLong(3, Long.parseLong(entityData.get(3).toString()));
                    preparedStatement.executeUpdate();
                }

            } catch (SQLException e) {
                System.out.println("A_DaoCRUD, updateById1");
            } finally {
                try {
                    connectToDb.close();
                } catch (SQLException e) {
                    System.out.println("A_DaoCRUD, updateById2");
                }
            }
        }
    } //done and works

    public void updateByField(String column1, String newContent, String column2, String condition) {
        Connection connectToDb = getConnectToDb();
        if (connectToDb != null) {
            try (PreparedStatement preparedStatement =
                         connectToDb.prepareStatement(ConnectionManager.prop.getProperty(
                                 updateByFieldQuery().get(0))
                                 + " " + column1
                                 + ConnectionManager.prop.getProperty(updateByFieldQuery().get(1))
                                 + " " + column2
                                 + ConnectionManager.prop.getProperty(updateByFieldQuery().get(2)))) {

                preparedStatement.setString(1, newContent);
                preparedStatement.setString(2, condition);
                preparedStatement.executeUpdate();


            } catch (SQLException e) {
                System.out.println("A_DaoCRUD, updateByField1");

            } finally {
                try {
                    connectToDb.close();
                } catch (SQLException e) {
                    System.out.println("A_DaoCRUD, updateByField2");
                }
            }
        }
    }  //done and works


    // delete
    public void deleteById(Long id) {
        Connection connectToDb = getConnectToDb();
        if (connectToDb != null) {
            try (PreparedStatement preparedStatement = connectToDb.prepareStatement(ConnectionManager.prop.getProperty(deleteByIdQuery()))) {
                preparedStatement.setLong(1, id);
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                System.out.println("A_DaoCRUD, deleteById1");

            } finally {
                try {
                    connectToDb.close();
                } catch (SQLException e) {
                    System.out.println("A_DaoCRUD, deleteById2");

                }
            }
        }
    } //done and works

    public void deleteByField(String column, String text) {
        Connection connectToDb = getConnectToDb();

        if (connectToDb != null) {
            try (PreparedStatement preparedStatement = connectToDb.prepareStatement
                    (ConnectionManager.prop.getProperty(deleteByFieldQuery().get(0))
                            + " " + column
                            + ConnectionManager.prop.getProperty(deleteByFieldQuery().get(1)))) {

                preparedStatement.setString(1, text);
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                System.out.println("A_DaoCRUD, deleteByField1");

            } finally {
                try {
                    connectToDb.close();
                } catch (SQLException e) {
                    System.out.println("A_DaoCRUD, deleteByField2");

                }
            }
        }
    } //done and works


    // util methods

    public abstract TEntity createEntity(ResultSet resultSet) throws SQLException;

    public abstract List<Object> getEntityData(TEntity entity);

    public abstract String insertQuery();

    public abstract String selectAllQuery();

    public abstract String selectByIdQuery();

    public abstract String updateByIdQuery();

    public abstract List<String> updateByFieldQuery();

    public abstract List<String> selectByFieldQuery();

    public abstract String deleteByIdQuery();

    public abstract List<String> deleteByFieldQuery();


}

