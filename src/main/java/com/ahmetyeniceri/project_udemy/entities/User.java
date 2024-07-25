package com.ahmetyeniceri.project_udemy.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String userName;
}
