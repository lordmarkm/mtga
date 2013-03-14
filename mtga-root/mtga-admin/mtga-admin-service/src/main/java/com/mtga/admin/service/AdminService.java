//package com.mtga.admin.service;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.mtga.common.service.CardRepo;
//import com.mtga.model.mtg.Card;
//
//@Service
//public class AdminService {
//
//    private static Logger log = LoggerFactory.getLogger(AdminService.class);
//    
//    @Autowired
//    private CardRepo cards;
//    
//    /**
//     * Create a new card
//     */
//    public Card create(String name) {
//        return cards.create(name);
//    }
//    
//    /**
//     * Retrieve card by name
//     */
//    public Iterable<Card> findByName(String name) {
//        log.info("About to search by name {}", name);
//        
//        Iterable<Card> results = cards.findByNameLike(name);
//        return results;
//    }
//    
//    /**
//     * Update a card
//     */
//    public Card update(Card toSave) {
//        log.info("About to save or update {}", toSave);
//        
//        Card card = cards.update(toSave);
//        return card;
//    }
//
//    /**
//     * Delete card
//     */
//    public void delete(Card card) {
//        log.info("About to delete {}", card);
//        
//        cards.delete(card);
//    }
//}
