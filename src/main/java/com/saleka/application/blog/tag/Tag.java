package com.saleka.application.blog.tag;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.saleka.application.blog.comment.Comment;
import com.saleka.application.blog.post.Post;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String key;

    @ManyToMany(mappedBy = "tags")
    private Collection<Post> posts;

    public Tag() {
    }

    public Tag(Long id, String key) {
        this.id = id;
        this.key = key;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public void setPosts(Collection<Post> posts) {
        this.posts = posts;
    }

    public void setAllProperties(Tag tag , boolean withId){
        setKey(tag.getKey());
        if(withId){
            setId(tag.getId());
        }
    }
}
