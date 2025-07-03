package problems.splitwise.controller;

import problems.splitwise.model.Group;
import problems.splitwise.model.User;

import java.util.ArrayList;
import java.util.List;

public class GroupController {

    List<Group> groupList;

    private static GroupController groupController;

    private GroupController(){
        groupList = new ArrayList<>();
    }

    public static GroupController getInstance() {
        if(groupController == null) {
            synchronized (GroupController.class) {
                if (groupController == null) {
                    groupController = new GroupController();
                }
            }
        }
        return groupController;
    }

    //create group
    public void createNewGroup(String groupId, String groupName, User createdByUser) {

        //create a new group
        Group group = new Group();
        group.setGroupId(groupId);
        group.setGroupName(groupName);

        //add the user into the group, as it is created by the USER
        group.addMember(createdByUser);

        //add the group in the list of overall groups
        groupList.add(group);
    }

    public Group getGroup(String groupId){

        for(Group group: groupList) {

            if(group.getGroupId().equals(groupId)){
                return group;
            }
        }
        return null;
    }

}
