package com.codeinsyt.tigerseal.repositories;


import com.codeinsyt.tigerseal.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PropertyRepository  extends JpaRepository<Property, Long> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Property e SET e.stat = ?2 WHERE e.id = ?1")
    @Transactional
    int softDelete(Long id, String status);

    List<Property> findAllByStatOrderByIdAsc(String status);
}
