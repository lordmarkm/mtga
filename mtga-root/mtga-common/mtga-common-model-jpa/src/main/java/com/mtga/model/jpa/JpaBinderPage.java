package com.mtga.model.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mtga.model.Binder;
import com.mtga.model.BinderPage;
import com.mtga.model.CardCollection;

@Entity
@Table(name="binderpages")
public class JpaBinderPage implements BinderPage {

    @Id
    @GeneratedValue
    private long id;
    
    @ManyToOne
    @JoinColumn(name="binderId")
    private JpaBinder binder;

    @OneToMany(mappedBy="page", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<JpaCardCollection> collections;

    public static JpaBinderPage create() {
        JpaBinderPage page = new JpaBinderPage();
        page.collections = new ArrayList<JpaCardCollection>();
        return page;
    }
    
    @Override
    public void addCards(int index, CardCollection cards) {
        collections.add(index, (JpaCardCollection) cards);
    }

    @Override
    public Binder getBinder() {
        return (Binder) binder;
    }

    @Override
    public void setBinder(Binder binder) {
        this.binder = (JpaBinder) binder;
    }

    @Override
    public CardCollection getCollection(int index) {
        return collections.get(index);
    }

    @Override
    public List<? extends CardCollection> getCollections() {
        if(null == collections) {
            collections = new ArrayList<JpaCardCollection>();
        }
        return collections;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setCollections(List<? extends CardCollection> collections) {
        this.collections = (List<JpaCardCollection>)collections;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
