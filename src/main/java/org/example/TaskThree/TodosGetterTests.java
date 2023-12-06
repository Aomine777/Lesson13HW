package org.example.TaskThree;

import java.io.IOException;

public class TodosGetterTests {
    public static void main(String[] args) throws IOException, InterruptedException {
        TodosGetter src = new TodosGetter();
        int userId = 8;
        src.createJsonWithAllOpenToDosByUserId(userId);
    }
}
