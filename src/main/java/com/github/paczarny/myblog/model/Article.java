package com.github.paczarny.myblog.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue
    @Column(name = "id_article")
    private Long id;
    private String title;
    private String description;
    private Date creationDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany
    @JoinColumn(name = "article_id", referencedColumnName = "id_article")
    private List<Comment> commentList;
    public Article(){}

    public Article(String title, String description, Date creationDate) {
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }



}
