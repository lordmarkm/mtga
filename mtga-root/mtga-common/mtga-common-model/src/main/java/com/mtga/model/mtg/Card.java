package com.mtga.model.mtg;

import com.mtga.model.MtgaImage;
import com.mtga.model.Sellable;

public interface Card extends Sellable {

    public static final String NAME = "name";
    public static final String EXP_ABBR = "expansion.abbreviation";
    
    public String getName();
    public String getText();
    public Expansion getExpansion();
    public CastingCost getCastingCost();
    public MtgaImage getImage();
    public void setImage(MtgaImage image);

}