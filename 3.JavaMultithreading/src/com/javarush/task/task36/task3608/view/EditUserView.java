package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/**
 * Created by jdk on 15.03.2017.
 */
public class EditUserView implements View{
    @Override
    public void refresh(ModelData modelData) {
        System.out.println("User to be edited:");
        System.out.println("\t" + modelData.getActiveUser());
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireEventUserDeleted(long id){
        controller.onUserDelete(id);
    }

    public void fireEventUserChanged(String name, long id, int level){
        controller.onUserChange(name, id, level);
    }

    private Controller controller;
}
