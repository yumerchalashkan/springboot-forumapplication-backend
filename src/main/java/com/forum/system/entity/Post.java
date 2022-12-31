package com.forum.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "POSTS")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    User user;

    @Column(name = "TITLE")
    String title;

    @Lob
    @Column(columnDefinition = "text")
    String text;
}
