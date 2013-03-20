package com.mtga.model.jpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mtga.model.CardCollection;

@Entity
@Table(name="cardcollections")
public class JpaCardCollection implements CardCollection {

    @Id
    @GeneratedValue
    private long id;
    
    @ManyToOne
    @JoinColumn(name="pageId")
    private JpaBinderPage page;
    
    @ManyToMany
    @JoinTable(
      name="cardcollectionmappings",
      joinColumns={@JoinColumn(name="collectionId")},
      inverseJoinColumns={@JoinColumn(name="cardId")}
    )
    private List<JpaCard> cards;

    
    public static JpaCardCollection create(JpaCard... cards) {
        JpaCardCollection collection = new JpaCardCollection();
        collection.cards = Arrays.asList(cards);
        return collection;
    }
    
    @Override
    public List<JpaCard> getCards() {
        if(null == cards) {
            cards = new ArrayList<JpaCard>();
        }
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

    public JpaBinderPage getPage() {
        return page;
    }

    public void setPage(JpaBinderPage page) {
        this.page = page;
    }

}
