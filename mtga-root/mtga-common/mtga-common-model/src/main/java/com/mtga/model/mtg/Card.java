package com.mtga.model.mtg;

import com.mtga.model.Sellable;

public interface Card extends Sellable {

    public String getName();
    public Expansion getExpansion();
    public CastingCost getCastingCost();
    public void setName(String name);
    public void setExpansion(Expansion expansion);
    public void setCastingCost(CastingCost castingCost);
    
}
