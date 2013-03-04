package com.mtga.model.mtg;

import com.mtga.model.MtgaImage;
import com.mtga.model.Sellable;

public interface Card extends Sellable {

    public String getName();
    public String getText();
    public Expansion getExpansion();
    public CastingCost getCastingCost();
    public void setName(String name);
    public void setText(String text);
    public void setExpansion(Expansion expansion);
    public void setCastingCost(CastingCost castingCost);
    public MtgaImage getImage();
    public void setImage(MtgaImage image);

}