package com.codeinsyt.tigerseal.services.interfaces;

import com.codeinsyt.tigerseal.models.Audit;

import java.util.HashMap;

public interface AuditService {


    public HashMap<String, Object> createAudit(Audit audit);

    public HashMap<String, Object> updateAudit(Audit audit);

    public HashMap<String, Object> listAudits();

    public HashMap<String, Object> softDelete(Long id);
}
