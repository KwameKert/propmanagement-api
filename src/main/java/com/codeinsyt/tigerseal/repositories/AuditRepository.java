package com.codeinsyt.tigerseal.repositories;

import com.codeinsyt.tigerseal.models.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AuditRepository extends JpaRepository<Audit, Long> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Audit e SET e.stat = ?2 WHERE e.id = ?1")
    @Transactional
    int softDelete(Long id, String status);

    List<Audit> findAllByStatOrderByIdAsc(String status);
}
