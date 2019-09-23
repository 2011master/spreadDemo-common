package pattern.proxy.jdk;

public class UserDao implements AbstractUserDao {
    @Override
    public String getNameById() {
        System.out.println("根据id查询");
        return "zhangsanfeng";
    }
}
