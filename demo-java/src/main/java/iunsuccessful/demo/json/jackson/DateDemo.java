package iunsuccessful.demo.json.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p/>
 *
 * @author Created by 依韵 on 2019/4/19 .
 */
public class DateDemo {

    public static void main(String[] args) {

        DateBean db = new DateBean();

        db.setCreateTime(new Date());

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 不加的话 {"createTime":1555657166335}
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(formatter);
        try {
            String jsonStr =  mapper.writeValueAsString(db);
            System.out.println(jsonStr);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
