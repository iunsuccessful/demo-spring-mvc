package iunsuccessful.demo.json.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import iunsuccessful.demo.common.domain.Fighter;

import java.lang.reflect.Type;
import java.util.List;

/**
 * <p/>
 *
 * @author Created by 依韵 on 2019/4/10 .
 */
public class GsonDemo {

    public static void main(String[] args) {

        String json = "{\"code\": \"200\", \"data\": { \"name\": \"test\", \"signDate\": \"2019-04-10 14:19:59\" }}\n";
//        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
//
//
        ApiResponse<Fighter> response = ApiResponse.fromJson(json, Fighter.class);

        System.out.println(response.getData().getName());

        String jsonArray = "{\"code\": \"200\", \"data\": [{ \"name\": \"test\", \"signDate\": \"2019-04-10 14:19:59\" }]}\n";

        Type objectType = new TypeToken<List<Fighter>>() {}.getType();

        ApiResponse<List<Fighter>> response2 = ApiResponse.fromJson(jsonArray, objectType);

        System.out.println(response2.getData().get(0).getName());

    }

}
