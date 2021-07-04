package com.herenpeng.json.test;

import com.herenpeng.json.JsonHelper;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class JsonHelperTest {

    private static final JsonHelper jsonHelper = new JsonHelper();

    @Test
    public void test01() {
        System.out.println(jsonHelper.toJson("json serializable"));
        User user = new User();
        user.setUsername("池总");
        user.setPassword("111111");
        user.setMoney(new BigDecimal(1000000));
        System.out.println(jsonHelper.toJson(user));
    }

    @Test
    public void test02() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6};
        String[] strArr = new String[]{"111", "222", "333", "444", "555"};
        System.out.println(jsonHelper.toJson(arr));
        System.out.println(jsonHelper.toJson(strArr));
    }

    @Test
    public void test03() {
        List<Object> list = new ArrayList<>();
        list.add(new User("池总", "111111", new BigDecimal(999999)));
        list.add(new User("李总", "222222", new BigDecimal(888888)));
        list.add(new User("肖总", "333333", new BigDecimal(777777)));
        System.out.println(jsonHelper.toJson(list));
    }


    @Test
    public void test04() {
        Map<String, Object> map = new HashMap<>();
        map.put("user1", new User("池总", "111111", new BigDecimal(999999)));
        map.put("user2", new User("李总", "222222", new BigDecimal(888888)));
        map.put("user3", new User("肖总", "333333", new BigDecimal(777777)));
        map.put("car1", new Car("奔驰"));
        System.out.println(jsonHelper.toJson(map));
    }


}
