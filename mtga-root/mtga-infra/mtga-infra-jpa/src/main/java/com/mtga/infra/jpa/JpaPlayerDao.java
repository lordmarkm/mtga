package com.mtga.infra.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mtga.model.jpa.JpaMtgaPlayer;

public interface JpaPlayerDao extends JpaRepository<JpaMtgaPlayer, Long> {

}