package iunsuccessful.demo.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import iunsuccessful.demo.json.jackson.DateBean;

import java.util.Date;

/**
 * <p/>
 *
 * @author Created by 依韵 on 2019/4/19 .
 */
public class DateDemo {

    public static void main(String[] args) {
        // {"createTime":"Apr 19, 2019 3:14:05 PM"}
//        Gson gson = new Gson();
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        DateBean bean = new DateBean();
        bean.setCreateTime(new Date());
        String json = gson.toJson(bean);
        System.out.println(json);
    }

}
