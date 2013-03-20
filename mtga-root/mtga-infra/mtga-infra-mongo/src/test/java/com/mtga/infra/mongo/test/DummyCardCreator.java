package com.mtga.infra.mongo.test;


import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.mtga.model.MtgaImage;
import com.mtga.model.mongo.MongoCard;
import com.mtga.model.mongo.MongoCastingCost;
import com.mtga.model.mongo.MongoExpansion;
import com.mtga.model.mongo.MongoMtgaImage;
import com.mtga.model.mtg.Card;
import com.mtga.model.mtg.CastingCost;
import com.mtga.model.mtg.Expansion;

public class DummyCardCreator {

    public static Card wog() throws IOException {
        CastingCost cc = new MongoCastingCost();
        cc.setString("2WW");
        
        Expansion e = new MongoExpansion();
        e.setAbbreviation("10th");
        e.setName("10th Edition");
        
        MtgaImage img = new MongoMtgaImage();
        img.setImage(loadWogImage());
        
        MongoCard card = new MongoCard();
        card.setName("Wrath of God");
        card.setText("Destroy all creatures. They can't be regenerated.");
        card.setCastingCost(cc);
        card.setExpansion(e);
        card.setImage(img);
        
        return card;
    }
    
    private static byte[] loadWogImage() throws IOException {
        Resource img = new ClassPathResource("images/61.jpg");
        return IOUtils.toByteArray(img.getInputStream());
    }
    
}
