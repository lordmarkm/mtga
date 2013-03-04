package com.mtga.model.jpa;

import javax.persistence.Embeddable;

import com.mtga.model.mtg.Expansion;

@Embeddable
public class JpaExpansion implements Expansion {

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setName(String name) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String getAbbreviation() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setAbbreviation(String abbreviation) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public byte[] getLogo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setLogo(byte[] logo) {
        // TODO Auto-generated method stub
        
    }

}
