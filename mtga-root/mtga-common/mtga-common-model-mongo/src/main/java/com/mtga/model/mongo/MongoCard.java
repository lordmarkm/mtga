package com.mtga.model.mongo;

import org.bson.types.ObjectId;
import org.springframework.core.style.ToStringCreator;

import com.github.jmkgreen.morphia.annotations.Embedded;
import com.github.jmkgreen.morphia.annotations.Entity;
import com.github.jmkgreen.morphia.annotations.Id;
import com.github.jmkgreen.morphia.annotations.Property;
import com.github.jmkgreen.morphia.annotations.Reference;
import com.mtga.model.MtgaImage;
import com.mtga.model.mtg.Card;
import com.mtga.model.mtg.CastingCost;
import com.mtga.model.mtg.Expansion;

@Entity(value = "cards", noClassnameStored = true)
public class MongoCard implements Card {

    @Id
    private ObjectId id;
    
    @Property("name")
    private String name;
    
    @Property("text")
    private String text;
    
    @Property(value="exp")
    private MongoExpansion expansion;
    
    @Embedded(value="cc", concreteClass=MongoCastingCost.class)
    private CastingCost castingCost;
    
    @Reference(value="img", lazy=true, concreteClass=MongoMtgaImage.class)
    private MtgaImage image;

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
        this.expansion = (MongoExpansion) expansion;
    }

    public CastingCost getCastingCost() {
        return castingCost;
    }

    public void setCastingCost(CastingCost castingCost) {
        this.castingCost = castingCost;
    }

    public MtgaImage getImage() {
        return image;
    }

    public void setImage(MtgaImage image) {
        this.image = image;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
