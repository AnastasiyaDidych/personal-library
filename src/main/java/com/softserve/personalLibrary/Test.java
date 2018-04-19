package com.softserve.personalLibrary;


import com.softserve.personalLibrary.dao.ItemDao;
import com.softserve.personalLibrary.dao.UserDao;
import com.softserve.personalLibrary.entity.UserEntity;


public class Test {

//    private  String LOGINN = "didych_a";
//
//    public String getLOGINN() {
//        return LOGINN;
//    }
//
//    public String getPASSWORDDD() {
//        return PASSWORDDD;
//    }
//
//    public void setLOGINN(String LOGINN) {
//        this.LOGINN = LOGINN;
//    }
//
//    public void setPASSWORDDD(String PASSWORDDD) {
//        this.PASSWORDDD = PASSWORDDD;
//    }
//
//    private  String PASSWORDDD = "11111";
//
//
//    public Test() {
//    }

//    public static void check(Test test) {
//
//        String loginR = test.getLOGINN();
//        String passwordR = test.getPASSWORDDD();
//        UserDao userDao = new UserDao();
//
//        UserEntity user = userDao.selectByField("login", loginR);
//        System.out.println(user);
//        if (loginR != null &&
//                !loginR.isEmpty() &&
//                passwordR != null &&
//                !passwordR.isEmpty() &&
//                loginR.equals(test.getLOGINN()) &&
//                passwordR.equals(test.getPASSWORDDD())) {
//            System.out.println("result = true");
//        } else {
//            System.out.println("result = false");
//        }
//    }



    public static void main(String[] args) {

//        Test test = new Test();
//        test.setLOGINN("didcyh_a");
//        test.setPASSWORDDD("11111");
//
//        check(test);

//        System.out.println(UserService.checkData("didych_a"));

        UserDao userDao = new UserDao();
//        UserDao userDao = new UserDao();
//        UserEntity userEntity = userDao.selectByField("login", "dcdscs");
//        System.out.println(userEntity);

//        UserEntity userEntity= new UserEntity("A", "A@gmail.com", "A", "A", 79L);
//        userDao.insert(userEntity);

//        System.out.println(userDao.selectAll());
//        System.out.println(userDao.selectById(2L));
//        System.out.println(userDao.selectByField("login", "didych_a"));
//        System.out.println(userDao.selectByField("login", "didych_a"));

//        userDao.updateById(userEntity);
//        userDao.updateByField("last_name", "TR", "login", "tr");

//        userDao.deleteById(79L);
//        userDao.deleteByField("login", "tr");

//        ItemDao itemDao = new ItemDao();
//        ItemEntity itemEntity = new ItemEntity("feedBack", "", "r", 52L);
//        itemDao.insert(itemEntity);

//        System.out.println(itemDao.selectAll());
//        System.out.println(itemDao.selectById(4L));
//        System.out.println(itemDao.selectByField("title", "The lord of the rings"));

//        itemDao.updateById(itemEntity);
//        itemDao.updateByField("description", "My favorite book", "title", "Love in the time of Cholera");

//        itemDao.deleteById(51L);
//        itemDao.deleteByField("title", "The three musketeers");


    }
}
