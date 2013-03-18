package com.mtga.infra.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtga.infra.jpa.custom.CustomJpaBinderDao;
import com.mtga.model.jpa.JpaBinder;

public interface JpaBinderDao extends JpaRepository<JpaBinder, Long>, CustomJpaBinderDao {

}