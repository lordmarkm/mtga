package com.mtga.model.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mtga.model.Binder;
import com.mtga.model.BinderPage;
import com.mtga.model.mtg.MtgaPlayer;

@Entity
@Table(name="binders")
public class JpaBinder implements Binder {

    @Id
    @GeneratedValue
    private long id;
    
    @OneToOne
    @JoinColumn(name="ownerId")
    private JpaMtgaPlayer owner;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="binder")
    private List<JpaBinderPage> pages;

    public static JpaBinder create() {
        JpaBinder binder = new JpaBinder();
        binder.pages = new ArrayList<JpaBinderPage>();
        return binder;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MtgaPlayer getOwner() {
        return owner;
    }

    public void setOwner(MtgaPlayer owner) {
        this.owner = (JpaMtgaPlayer) owner;
    }

    public void setPages(List<JpaBinderPage> pages) {
        this.pages = pages;
    }

    @Override
    public void addPage(BinderPage binderPage) {
        pages.add((JpaBinderPage) binderPage);
    }

    @Override
    public List<? extends BinderPage> getPages() {
       return pages;
    }

}
