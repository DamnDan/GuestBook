package com.guest.webapp.GuestBook.entities;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Entity
@Table(name = "guestbook_table")
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    @NotBlank(message = "Email is mandatory")
    private String name;

    @Column(name = "text")
    @NotBlank(message = "Email is mandatory")
    private String text;

    @Column(name = "created_on")
    @CreationTimestamp
    private Date createdOn;

    

    public Entry() {
    }

    public Entry(@NotBlank(message = "Email is mandatory") String name, @NotBlank(message = "Email is mandatory") String text) {
        this.name = name;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
