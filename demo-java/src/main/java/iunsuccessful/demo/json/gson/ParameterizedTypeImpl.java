package iunsuccessful.demo.json.gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * <p/>
 *
 * @author Created by 依韵 on 2019/4/10 .
 */
public class ParameterizedTypeImpl implements ParameterizedType {

    private final Class raw;
    private final Type[] args;

    public ParameterizedTypeImpl(Class raw, Type[] args) {
        this.raw = raw;
        this.args = args != null ? args : new Type[0];
    }

    @Override
    public Type[] getActualTypeArguments() {
        return args;
    }

    @Override
    public Type getRawType() {
        return raw;
    }

    @Override
    public Type getOwnerType() {return null;}
}
