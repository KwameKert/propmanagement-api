package com.codeinsyt.tigerseal.services.interfaces;

import java.util.HashMap;

public interface DashboardService {

    public HashMap<String, Object> adminDashboard();
    public HashMap<String, Object> collectorDashboard();
    public HashMap<String, Object> auditorDashboard();
}
