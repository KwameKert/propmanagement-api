package com.codeinsyt.tigerseal.repositories;

import com.codeinsyt.tigerseal.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository  extends JpaRepository<Property, Long> {
}
