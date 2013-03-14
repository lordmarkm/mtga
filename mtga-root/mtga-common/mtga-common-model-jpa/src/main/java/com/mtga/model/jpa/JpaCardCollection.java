package com.mtga.model.jpa;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.mtga.model.CardCollection;
import com.mtga.model.mtg.Card;

@Entity
@Table(name="cardcollections")
public class JpaCardCollection implements CardCollection {

    @Id
    @GeneratedValue
    private long id;
    
    @ManyToMany
    @JoinTable(
      name="cardcollectionmappings",
      joinColumns={@JoinColumn(name="collectionId")},
      inverseJoinColumns={@JoinColumn(name="cardId")}
    )
    private List<JpaCard> cards;

    @Override
    public List<JpaCard> getCards() {
        return cards;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setCards(List<? extends Card> cards) {
        this.cards = (List<JpaCard>) cards;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
