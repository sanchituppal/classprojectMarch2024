package com.example.onlinecafe.user;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class CafeUserModel {
    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    UUID id;

    @Column(nullable = false)
    String firstName;

    @Column(nullable = false)
    String lastName;

    @CreationTimestamp
    @Column(nullable = false)
    Date dateOfJoining;

    @Column(nullable = false, unique = true, length = 30)
    String emailId;

    @Column(nullable = false)
    String password;        //TODO: Encrypted password

    @Column(nullable = false)
    String authToken;        //TODO: Encrypted password

    @Column(nullable = false)
    String ImageURL;
}
