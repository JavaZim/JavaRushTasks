package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/**
 * Created by jdk on 14.03.2017.
 */
public class UsersView implements View {
    @Override
    public void refresh(ModelData modelData) {

        if(modelData.isDisplayDeletedUserList()){
            System.out.println("All deleted users:");
            for (User user :modelData.getUsers()) {
                System.out.println("\t" + user);
            }
        }else {
            System.out.println("All users:");
            for (User user :modelData.getUsers()) {
                System.out.println("\t" + user);
            }
        }

        System.out.println("===================================================");

    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }

    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }

    private Controller controller;
}
