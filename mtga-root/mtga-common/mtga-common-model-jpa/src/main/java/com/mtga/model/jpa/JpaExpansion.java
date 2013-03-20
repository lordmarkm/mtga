package com.mtga.model.jpa;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.CascadeType;

import org.springframework.core.style.ToStringCreator;

import com.mtga.model.mtg.Expansion;

@Entity
@Table(name="expansions")
public class JpaExpansion implements Expansion {

    @Id
    @GeneratedValue
    private long id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="abbr")
    private String abbreviation;
    
    @Column(name="logo")
    @Lob @Basic(fetch=FetchType.EAGER)
    private byte[] logo;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="expansion", fetch=FetchType.LAZY)
    private List<JpaCard> cards;
    
    @Override
    public String toString() {
        return new ToStringCreator(this)
            .append("name", name)
            .append("abbr", abbreviation)
            .toString();
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAbbreviation() {
        return abbreviation;
    }

    @Override
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public byte[] getLogo() {
        return logo;
    }

    @Override
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public List<JpaCard> getCards() {
        return cards;
    }

    public void setCards(List<JpaCard> cards) {
        this.cards = cards;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
