package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import java.util.*;

/**
 * Created by jdk on 14.03.2017.
 */
public class ModelData {

    public List<User> getUsers() {
        return users;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public boolean isDisplayDeletedUserList() {
        return displayDeletedUserList;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public void setDisplayDeletedUserList(boolean displayDeletedUserList) {
        this.displayDeletedUserList = displayDeletedUserList;
    }

    private List<User> users;
    private User activeUser;
    private boolean displayDeletedUserList;
}
