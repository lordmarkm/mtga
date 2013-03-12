package com.mtga.model.jpa;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.core.style.ToStringCreator;

import com.mtga.model.MtgaImage;
import com.mtga.model.mtg.Card;
import com.mtga.model.mtg.CastingCost;
import com.mtga.model.mtg.Expansion;

@Entity
public class JpaCard implements Card {
    
    @Id
    @GeneratedValue
    private long id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="text")
    private String text;
    
    @Embedded
    private JpaExpansion expansion;
    
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name="string", column=@Column(name="cc_string"))
    })
    private JpaCastingCost castingCost;
    
    @Embedded
    @Column(name="img")
    @Fetch(FetchMode.SELECT)
    private MtgaImage image;

    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("name", name)
            .append("expansion", expansion)
            .append("castingCost", castingCost)
            .toString();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JpaExpansion getExpansion() {
        return expansion;
    }

    public void setExpansion(Expansion expansion) {
        this.expansion = (JpaExpansion) expansion;
    }

    public JpaCastingCost getCastingCost() {
        return castingCost;
    }

    public void setCastingCost(CastingCost castingCost) {
        this.castingCost = (JpaCastingCost) castingCost;
    }

    public MtgaImage getImage() {
        return image;
    }

    public void setImage(MtgaImage image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
}
