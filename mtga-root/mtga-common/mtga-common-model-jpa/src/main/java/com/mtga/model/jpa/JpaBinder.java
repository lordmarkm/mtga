package com.mtga.model.jpa;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="binders")
public class JpaBinder {

    @Id
    @GeneratedValue
    private long id;
    
    @OneToOne
    @JoinColumn(name="ownerId")
    private JpaMtgaPlayer owner;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="binder")
    private List<JpaBinderPage> pages;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public JpaMtgaPlayer getOwner() {
        return owner;
    }

    public void setOwner(JpaMtgaPlayer owner) {
        this.owner = owner;
    }

    public List<JpaBinderPage> getPages() {
        return pages;
    }

    public void setPages(List<JpaBinderPage> pages) {
        this.pages = pages;
    }

}
