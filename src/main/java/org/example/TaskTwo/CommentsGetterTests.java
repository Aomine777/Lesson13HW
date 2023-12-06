package org.example.TaskTwo;

import java.io.IOException;

public class CommentsGetterTests {
    public static void main(String[] args) throws IOException, InterruptedException {
        CommentsGetter comments = new CommentsGetter();
        int userId = 1;
        comments.createJsonWithAllCommentsFromLastPostByUserId(userId);
    }
}
