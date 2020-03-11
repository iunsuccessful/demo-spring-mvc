package iunsuccessful.demo.patterns.convertor;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 依韵 2020/3/5
 */
public class ConverterApp {

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("hao123");
        user.setPassword("123456");
        UserConverter userConverter = new UserConverter();
        UserDTO userDTO = userConverter.convertFromEntity(user);
        System.out.println(userDTO);

        List<User> userList = Lists.newArrayList(user);
        List<UserDTO> userDTOS = userConverter.createFromEntities(userList);
        System.out.println(userDTOS);

    }

}
