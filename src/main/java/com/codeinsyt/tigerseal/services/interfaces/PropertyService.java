package com.codeinsyt.tigerseal.services.interfaces;


import com.codeinsyt.tigerseal.DTO.PropertyDTO;
import com.codeinsyt.tigerseal.models.Property;
import org.springframework.stereotype.Service;

import java.util.HashMap;


public interface PropertyService {

    public HashMap<String, Object> createProperty(PropertyDTO propertyDTO);

    public HashMap<String, Object> updateProperty(PropertyDTO propertyDTO);

    public HashMap<String, Object> listProperties();

    public HashMap<String, Object> softDelete(Long id);
}
