package com.mtga.infra.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mtga.model.jpa.JpaExpansion;

public interface JpaExpansionDao extends JpaRepository<JpaExpansion, Long> {

    @Query("from JpaExpansion where abbreviation = ?1")
    public JpaExpansion findByAbbr(String abbr);
    
}
