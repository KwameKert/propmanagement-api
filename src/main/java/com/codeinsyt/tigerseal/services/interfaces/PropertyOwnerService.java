package com.codeinsyt.tigerseal.services.interfaces;

import com.codeinsyt.tigerseal.models.PropertyOwner;
import org.springframework.stereotype.Service;

import java.util.HashMap;


public interface PropertyOwnerService {

    public HashMap<String, Object> createOwner(PropertyOwner propertyOwner);

    public HashMap<String, Object> updateOwner(PropertyOwner propertyOwner);

    public HashMap<String, Object> listOwners();

    public HashMap<String, Object> softDelete(Long id);



}
