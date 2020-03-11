package iunsuccessful.demo.patterns.convertor;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;

/**
 * 依韵 2020/3/7
 */
public class UserConverter extends Converter<UserDTO, User> {


    public UserConverter() {
        super(UserConverter::convertToEntity, UserConverter::convertToDto);
    }

    private static UserDTO convertToDto(User user) {
        UserDTO userDTO = new UserDTO();
        try {
            BeanUtils.copyProperties(userDTO, user);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return userDTO;
    }

    private static User convertToEntity(UserDTO dto) {
        User user = new User();
        try {
            BeanUtils.copyProperties(user, dto);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return user;

    }

}
