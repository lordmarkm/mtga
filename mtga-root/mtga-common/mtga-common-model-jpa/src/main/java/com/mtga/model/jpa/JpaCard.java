package com.mtga.model.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.core.style.ToStringCreator;

import com.mtga.model.CardCollection;
import com.mtga.model.MtgaImage;
import com.mtga.model.mtg.Card;
import com.mtga.model.mtg.CastingCost;
import com.mtga.model.mtg.Expansion;

@Entity
@Table(name="cards")
public class JpaCard implements Card {
    
    @Id
    @GeneratedValue
    private long id;
    
    @ManyToMany(mappedBy="cards")
    private List<JpaCardCollection> collections;
    
    @Column(name="name")
    private String name;
    
    @Column(name="text")
    private String text;
    
    @ManyToOne(optional=false, cascade=CascadeType.PERSIST)
    @JoinColumn(name="exp")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
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

    public static JpaCard create() {
        JpaCard card = new JpaCard();
        card.collections = new ArrayList<JpaCardCollection>();
        return card;
    }
    
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

    public List<JpaCardCollection> getCollections() {
        return collections;
    }

    public void setCollections(List<JpaCardCollection> collections) {
        this.collections = collections;
    }
    
    public void addToCollection(CardCollection collection) {
        this.collections.add((JpaCardCollection) collection);
    }
    
}
