package com.example.onlinecafe.user;

import org.springframework.stereotype.Service;

@Service
public class CafeServerService {
    private final CafeServerRepository serverRepo; //Injected the cafeServerRepository

    public CafeServerService(CafeServerRepository serverRepo){
        this.serverRepo = serverRepo;
    }

    public CafeServerModel createServer(String fName, String lName, String emailId, String authToken, String imageURL){
        CafeServerModel cafeServer = CafeServerModel.builder()
                .firstName(fName)
                .lastName(lName)
                .emailId(emailId)
                .authToken(authToken)
                .imageURL(imageURL)
                .build();
        CafeServerModel createServer = serverRepo.save(cafeServer);
        return createServer;
    }
}
