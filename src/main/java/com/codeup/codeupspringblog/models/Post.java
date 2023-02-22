package com.codeup.codeupspringblog.models;

public class Post {
    private String title;
    private String body;
    private long postId;


    public Post() {
    }

    public Post(String title, String body, long postId) {
        this.title = title;
        this.body = body;
        this.postId = postId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }
}
