package com.mtga.model.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;

import org.hibernate.annotations.Cascade;

import com.mtga.model.BinderPage;
import com.mtga.model.CardCollection;
import com.mtga.model.mtg.Card;

@Entity
@Table(name="cardcollections")
public class JpaCardCollection implements CardCollection {

    @Id
    @GeneratedValue
    private long id;
    
    @ManyToOne
    @JoinColumn(name="pageId")
    private JpaBinderPage page;
    
    @ManyToMany(cascade=CascadeType.PERSIST)
    @JoinTable(
      name="cardcollectionmappings",
      joinColumns={@JoinColumn(name="collectionId")},
      inverseJoinColumns={@JoinColumn(name="cardId")}
    )
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<JpaCard> cards;

    
    public static JpaCardCollection create(Card... cards) {
        JpaCardCollection collection = new JpaCardCollection();
        collection.cards = new ArrayList<JpaCard>();
        for(Card card : cards) {
            collection.cards.add((JpaCard) card);
        }
        return collection;
    }
    
    @Override
    public List<JpaCard> getCards() {
        if(null == cards) {
            cards = new ArrayList<JpaCard>();
        }
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

    public JpaBinderPage getPage() {
        return page;
    }

    @Override
    public void setPage(BinderPage page) {
        this.page = (JpaBinderPage) page;
    }

}
