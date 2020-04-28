package com.codeinsyt.tigerseal.services.interfaces;


import com.codeinsyt.tigerseal.models.Property;
import org.springframework.stereotype.Service;

import java.util.HashMap;


public interface PropertyService {

    public HashMap<String, Object> createProperty(Property property);

    public HashMap<String, Object> updateOwner(Property property);

    public HashMap<String, Object> listProperties();

    public HashMap<String, Object> softDelete(Long id);
}
