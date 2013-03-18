package com.mtga.infra.jpa.custom;

import com.mtga.model.jpa.JpaCard;

public interface CustomJpaCardDao {
    JpaCard findByNameAndExpansion(String name, String exp);
}
