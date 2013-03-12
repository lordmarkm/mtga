package com.mtga.model.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.springframework.core.style.ToStringCreator;

import com.mtga.model.mtg.Expansion;

@Embeddable
public class JpaExpansion implements Expansion {

    @Column(name="exp_name")
    private String name;
    
    @Column(name="exp_abbr")
    private String abbreviation;
    
    @Column(name="exp_logo")
    private byte[] logo;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("name", name)
            .append("abbr", abbreviation)
            .toString();
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAbbreviation() {
        return abbreviation;
    }

    @Override
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public byte[] getLogo() {
        return logo;
    }

    @Override
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

}
