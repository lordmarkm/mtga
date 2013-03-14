package com.mtga.infra.jpa;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.mtga.model.jpa.JpaCard;

/**
 * @author mbmartinez
 */
public interface JpaCardDao extends PagingAndSortingRepository<JpaCard, Serializable>, CustomJpaCardDao {

    Page<JpaCard> findByNameLike(Pageable page, String name);
    
}
