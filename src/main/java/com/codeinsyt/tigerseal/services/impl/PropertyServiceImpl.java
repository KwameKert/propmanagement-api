package com.codeinsyt.tigerseal.services.impl;

import com.codeinsyt.tigerseal.DTO.PropertyDTO;
import com.codeinsyt.tigerseal.models.Property;
import com.codeinsyt.tigerseal.repositories.PropertyRepository;
import com.codeinsyt.tigerseal.repositories.UserRepository;
import com.codeinsyt.tigerseal.services.interfaces.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    private PropertyRepository propertyRepository;
    private UserRepository userRepository;


    @Autowired
    public PropertyServiceImpl(PropertyRepository propertyRepository, UserRepository userRepository) {
        this.propertyRepository = propertyRepository;
        this.userRepository = userRepository;
    }



    public HashMap<String, Object> responseAPI(Object data, String message, HttpStatus status){
        HashMap<String, Object> responseData = new HashMap<>();
        responseData.put("data",data);
        responseData.put("message",message);
        responseData.put("status", status.value());

        return responseData;
    }

    @Override
    public HashMap<String, Object> createProperty(PropertyDTO propertyDTO) {

        try{
            Property property = new Property();
            property.setPropCat(propertyDTO.getPropCat());
            property.setElectoralArea(propertyDTO.getElectoralArea());
            property.setPropNo(propertyDTO.getPropNo());
            property.setLatitude(propertyDTO.getLatitude());
            property.setLongitude(propertyDTO.getLongitude());
            property.setRate(propertyDTO.getRate());
            property.setUser(this.userRepository.findById(propertyDTO.getUserId()).get());
            property.setStat(propertyDTO.getStat());
            property.setValue(propertyDTO.getValue());

           Property newProperty = propertyRepository.save(property);
            return responseAPI(newProperty, "New Property added", HttpStatus.OK);

        }catch(Exception e){
            e.printStackTrace();
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    public Property isProperty(Long id){
        try{
            Property property =  this.propertyRepository.findById(id).get();

            return property;
        }catch(Exception e){
            return null;
        }
    }



    @Override
    public HashMap<String, Object> updateProperty(PropertyDTO propertyDTO) {

        try{

            if(isProperty(propertyDTO.getId()) != null){

                Property property = new Property();
                property.setId(propertyDTO.getId());
                property.setPropCat(propertyDTO.getPropCat());
                property.setElectoralArea(propertyDTO.getElectoralArea());
                property.setPropNo(propertyDTO.getPropNo());
                property.setLatitude(propertyDTO.getLatitude());
                property.setLongitude(propertyDTO.getLongitude());
                property.setRate(propertyDTO.getRate());
                property.setUser(this.userRepository.findById(propertyDTO.getUserId()).get());
                property.setStat(propertyDTO.getStat());
                property.setValue(propertyDTO.getValue());

                Property updatedProperty = propertyRepository.save(property);
                return responseAPI(updatedProperty, "New Property updated", HttpStatus.OK);
            }else{
                return responseAPI(null, "No Property found", HttpStatus.NOT_FOUND);
            }

        }catch(Exception e){
            e.printStackTrace();
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }

    }

    @Override
    public HashMap<String, Object> listProperties() {
        try{
            List<Property> properties = this.propertyRepository.findAllByStatNotOrderByIdAsc("deleted");
            if(properties.isEmpty()){
                return responseAPI(null, "No Property found", HttpStatus.NO_CONTENT);
            }else{
                return responseAPI(properties,"Listing Properties ", HttpStatus.FOUND);
            }

        }catch(Exception e){
            e.printStackTrace();
            return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }

    @Override
    public HashMap<String, Object> softDelete(Long id) {
       try{

           if(isProperty(id) != null){

               this.propertyRepository.softDelete(id,"deleted");
               return this.listProperties();

           }else{
               return responseAPI(null, "No Property found", HttpStatus.NOT_FOUND);
           }

       }catch(Exception e){
           e.printStackTrace();
           return responseAPI(null,e.getMessage(),HttpStatus.EXPECTATION_FAILED);
       }
    }



}
