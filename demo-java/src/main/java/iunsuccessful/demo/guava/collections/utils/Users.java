package iunsuccessful.demo.guava.collections.utils;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author LiQZ on 2016/6/7.
 */
class Users {

    public Users() {
    }

    public Users(int id, String username) {
        this.id = id;
        this.username = username;
    }

    private int id;
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static List<Users> getList() {
        List<Users> users = Lists.newArrayList();
        users.add(new Users(1, "li"));
        users.add(new Users(2, "zhang"));
        users.add(new Users(3, "wang"));
        return users;
    }

    public static List<Users> getMulitList() {
        List<Users> users = Lists.newArrayList();
        users.add(new Users(1, "li"));
        users.add(new Users(2, "zhang"));
        users.add(new Users(2, "zhang"));
        users.add(new Users(3, "wang"));
        users.add(new Users(2, "zhang"));
        return users;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Users{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
