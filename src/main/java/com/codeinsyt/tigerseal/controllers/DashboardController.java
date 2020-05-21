package com.codeinsyt.tigerseal.controllers;

import com.codeinsyt.tigerseal.services.interfaces.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/dashboard/")
public class DashboardController {

    private DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("admin")
    public ResponseEntity<?> getAdminDashboard(){
        return new ResponseEntity<>(this.dashboardService.adminDashboard(), HttpStatus.OK);
    }
}
