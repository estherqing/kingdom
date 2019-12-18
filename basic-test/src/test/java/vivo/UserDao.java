package vivo;

public class UserDao extends AbstractDao<SimpleTest> {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        Class<SimpleTest> actualType = userDao.getActualType();
        System.out.println(actualType.getName());
        System.out.println(SimpleTest.class.getCanonicalName());
    }
}
