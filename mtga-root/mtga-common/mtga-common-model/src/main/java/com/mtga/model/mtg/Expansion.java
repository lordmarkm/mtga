package com.mtga.model.mtg;

import com.mtga.model.MtgaEntity;

public interface Expansion extends MtgaEntity {
    
    public String getName();
    public void setName(String name);
    public String getAbbreviation();
    public void setAbbreviation(String abbreviation);
    public byte[] getLogo();
    public void setLogo(byte[] logo);
    
}
