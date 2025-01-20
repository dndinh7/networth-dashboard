package com.dinh.networth.ViewModels;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.time.LocalDateTime;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UserViewModel {

    private String id;
    private String name;
    private String email;
    private LocalDateTime createdAt;

    public UserViewModel(String id, String name, String email, LocalDateTime createdAt) {
        this.id= id;
        this.name= name;
        this.email= email;
        this.createdAt= createdAt;
    }
}
