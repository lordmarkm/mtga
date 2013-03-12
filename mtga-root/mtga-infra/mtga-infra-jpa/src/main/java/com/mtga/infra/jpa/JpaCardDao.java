package com.mtga.infra.jpa;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.mtga.model.jpa.JpaCard;

/**
 * @author mbmartinez
 */
public interface JpaCardDao extends PagingAndSortingRepository<JpaCard, Serializable>, CustomJpaCardDao {

    Collection<JpaCard> findByNameLike(String name);

}
