package com.mtga.model.jpa;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.core.style.ToStringCreator;

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
    
    @Embedded
    @Column(name="expansion")
    private JpaExpansion expansion;
    
    @Embedded
    @Column(name="castingcost")
    private JpaCastingCost castingCost;
    
    @Lob @Basic(fetch=FetchType.LAZY)
    @Column(name="img")
    private byte[] image;

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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
}
