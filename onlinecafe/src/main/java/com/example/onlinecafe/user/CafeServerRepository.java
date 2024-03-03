package com.example.onlinecafe.user;

import jakarta.persistence.Column;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

@Repository
public interface CafeServerRepository extends JpaRepository<CafeServerModel, UUID> {
}
    /***
    cafeServerModel findByFirstName(String firstName);
    cafeServerModel findByLastName(String lastName);
    cafeServerModel findByDateOfJoining(String dateOfJoining);
    cafeServerModel findByEmailId(String emailId);
    cafeServerModel findByPassword(String password);
    cafeServerModel findByAuthToken(String authToken);
    cafeServerModel findByImageURL(String ImageURL);
     ***/
