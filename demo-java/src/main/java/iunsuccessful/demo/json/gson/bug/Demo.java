package iunsuccessful.demo.json.gson.bug;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

/**
 * <p/>
 *
 * @author Created by 依韵 on 2019/4/11 .
 */
public class Demo {

    public static void main(String[] args) {
        Gson gson = new Gson();
        Son son = new Son();
        son.setPageSize(1);
        // gson 不支持父子字段相同的情况
        System.out.println(gson.toJson(son));
//        System.out.println(JSON.toJSONString(son));
    }

}
