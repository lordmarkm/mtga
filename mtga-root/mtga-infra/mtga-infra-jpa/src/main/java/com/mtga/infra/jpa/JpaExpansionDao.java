package com.mtga.infra.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mtga.model.jpa.JpaExpansion;

public interface JpaExpansionDao extends JpaRepository<JpaExpansion, Long> {

    @Query("FROM JpaExpansion WHERE abbreviation = ?1")
    public JpaExpansion findByAbbr(String abbr);

    @Query("SELECT DISTINCT exp FROM JpaExpansion exp LEFT JOIN FETCH exp.cards WHERE exp.abbreviation = ?1")
    public JpaExpansion findWithCards(String abbr);
    
}
