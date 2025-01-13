package com.dinh.networth.ViewModels;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.time.LocalDateTime;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UserViewModel {

    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdAt;

    public UserViewModel() {}

    public UserViewModel(Long id, String name, String email, LocalDateTime createdAt) {
        this.id= id;
        this.name= name;
        this.email= email;
        this.createdAt= createdAt;
    }
}
