package common.stream.clone;

import utils.JsonUtil;

public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        User user = new User();

        user.setId(1000L);
        user.setName("test");

        User clone = (User) user.cloneBySerializable();

        System.out.println(JsonUtil.convertToJson(clone));
    }
}
