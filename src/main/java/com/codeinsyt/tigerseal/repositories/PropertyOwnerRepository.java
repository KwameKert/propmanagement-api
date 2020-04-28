package com.codeinsyt.tigerseal.repositories;

import com.codeinsyt.tigerseal.models.PropertyOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Repository
public interface PropertyOwnerRepository extends JpaRepository<PropertyOwner, Long> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE PropertyOwner e SET e.stat = ?2 WHERE e.id = ?1")
    @Transactional
    int softDelete(Long id, String status);
}
