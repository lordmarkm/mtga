package com.mtga.model.mongo;

import com.github.jmkgreen.morphia.annotations.Entity;
import com.github.jmkgreen.morphia.annotations.Property;
import com.mtga.model.mtg.Card;
import com.mtga.model.mtg.CastingCost;
import com.mtga.model.mtg.Expansion;

@Entity(value = "cards", noClassnameStored = true)
public class MongoCard implements Card {

    @Property("name")
    private String name;
    
    @Property(value="exp", concreteClass=MongoExpansion.class)
    private Expansion expansion;
    
    @Property(value="cc", concreteClass=MongoCastingCost.class)
    private CastingCost castingCost;
    
    @Property(value="img")
    private byte[] image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Expansion getExpansion() {
        return expansion;
    }

    public void setExpansion(Expansion expansion) {
        this.expansion = expansion;
    }

    public CastingCost getCastingCost() {
        return castingCost;
    }

    public void setCastingCost(CastingCost castingCost) {
        this.castingCost = castingCost;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
}
