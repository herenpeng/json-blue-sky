package com.herenpeng.json.test;

import com.herenpeng.json.JsonHelper;
import org.junit.Test;

public class JsonHelperTest {

    private static final JsonHelper jsonHelper = new JsonHelper();

    @Test
    public void test01() {
        System.out.println(jsonHelper.toJson("json serializable"));

        User user = new User();
        user.setUsername("池总");
        user.setPassword("111111");
        System.out.println(jsonHelper.toJson(user));
    }
}
