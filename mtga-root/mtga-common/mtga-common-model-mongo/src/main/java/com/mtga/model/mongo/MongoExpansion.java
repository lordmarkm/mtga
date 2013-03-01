package com.mtga.model.mongo;

import org.bson.types.ObjectId;
import org.springframework.core.style.ToStringCreator;

import com.github.jmkgreen.morphia.annotations.Entity;
import com.github.jmkgreen.morphia.annotations.Id;
import com.github.jmkgreen.morphia.annotations.Property;
import com.mtga.model.mtg.Expansion;

@Entity("expansion")
public class MongoExpansion implements Expansion {

    @Id
    private ObjectId id;
    
    @Property("name")
    private String name;
    
    @Property("abbr")
    private String abbreviation;
    
    @Property("logo")
    private byte[] logo;
    
    public String toString() {
        return new ToStringCreator(this)
            .append("name", name)
            .append("abbr", abbreviation)
            .toString();
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAbbreviation() {
        return abbreviation;
    }
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    public byte[] getLogo() {
        return logo;
    }
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

}
