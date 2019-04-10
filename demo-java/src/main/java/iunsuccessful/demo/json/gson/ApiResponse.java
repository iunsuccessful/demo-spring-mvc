package iunsuccessful.demo.json.gson;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * <p/>
 *
 * @author Created by 依韵 on 2019/4/10 .
 */
public class ApiResponse<T> {

    private String code;

    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> T fromJson(String json, final Type... args) {
        Gson gson = new Gson();
        Type objectType = type(ApiResponse.class, args);
        return gson.fromJson(json, objectType);
    }


    static ParameterizedType type(final Class raw, final Type... args) {

        return new ParameterizedType() {

            @Override
            public Type getRawType() {
                return raw;
            }

            @Override
            public Type[] getActualTypeArguments() {
                return args;
            }



            @Override
            public Type getOwnerType() {
                return null;
            }
        };
    }

}


