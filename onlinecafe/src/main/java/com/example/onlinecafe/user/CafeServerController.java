package com.example.onlinecafe.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("server")
public class CafeServerController {
    private final CafeServerService serverService; //Injected the cafeServerService
    public CafeServerController(CafeServerService serverService){
        this.serverService = serverService;
    }
}
//TO BE EDITED