package org.serf.magazineshop.service;

import org.serf.magazineshop.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> userList = new ArrayList<>();
    private static UserService userService;

    private UserService() {
    }

    public static UserService getUserService(){
        if(userService == null){
            userService = new UserService();
        }
        return userService;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void saveUser(User user){
        userList.add(user);
    }

    public User getUser(String email){
       return userList.stream().filter(user -> user.getEmail().equals(email)).findFirst().get();
    }
}
