package org.example.TaskOne;

import java.io.IOException;

public class MyJsonTest {
    public static void main(String[] args) throws IOException, InterruptedException {

        String jsonUserId = "src/main/resources/user_id_JPH.json";
        String jsonUserName = "src/main/resources/user_name_JPH.json";
        String jsonAllUsers = "src/main/resources/all_users_JPH.json";
        String jsonUserNew = "src/main/resources/new_user_JPH.json";
        String jsonUserUpdated = "src/main/resources/updated_user_JPH.json";

        MyJson myJPh = new MyJson();

        //4
        System.out.println("List with all users:\n" + myJPh.getAllUsers());
        myJPh.createJsonWithUsers(myJPh.getAllUsers(), jsonAllUsers);

        //5
        int userId = 2;
        String user = myJPh.getUserById(userId);
        System.out.println("User " + userId + ":\n" + user);
        myJPh.createJsonWithUser(user, jsonUserId);

        //6
        String userName = "Karianne";
        String userUsername = myJPh.getUserByName(userName);
        System.out.println("User with name \"" + userName + "\":\n" + userUsername);
        myJPh.createJsonWithUsers(userUsername, jsonUserName);

        //1
        String userNew = myJPh.createUser(jsonUserId);
        System.out.println("New user:\n" + userNew);
        myJPh.createJsonWithUser(userNew, jsonUserNew);

        //2
        int updatedUserId = 5;
        String UpdatedUser = myJPh.updateUserById(updatedUserId, jsonUserId);
        System.out.println("Updated user:\n" + UpdatedUser);
        myJPh.createJsonWithUser(UpdatedUser, jsonUserUpdated);

        //3
        int deleteUserId = 7;
        System.out.println("User with id = " + deleteUserId + "; delete status - " + myJPh.deleteUserById(deleteUserId));

    }
}
