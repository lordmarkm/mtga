package com.mtga.model.mongo;

import org.bson.types.ObjectId;
import org.springframework.core.style.ToStringCreator;

import com.github.jmkgreen.morphia.annotations.Embedded;
import com.github.jmkgreen.morphia.annotations.Entity;
import com.github.jmkgreen.morphia.annotations.Id;
import com.github.jmkgreen.morphia.annotations.Property;
import com.mtga.model.mtg.Card;
import com.mtga.model.mtg.CastingCost;
import com.mtga.model.mtg.Expansion;

@Entity(value = "cards", noClassnameStored = true)
public class MongoCard implements Card {

    @Id
    private ObjectId id;
    
    @Property("name")
    private String name;
    
    @Property(value="exp", concreteClass=MongoExpansion.class)
    private Expansion expansion;
    
    @Embedded(value="cc", concreteClass=MongoCastingCost.class)
    private CastingCost castingCost;
    
    @Property(value="img")
    private byte[] image;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("name", name)
            .append("expansion", expansion)
            .append("castingCost", castingCost)
            .toString();
    }
    
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

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
    
}
