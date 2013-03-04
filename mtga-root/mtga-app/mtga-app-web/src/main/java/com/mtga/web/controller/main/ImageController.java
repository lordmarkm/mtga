package com.mtga.web.controller.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mtga.common.service.CardRepo;

/**
 * Separate controller for returning image names. There has to be a
 * better way :)
 * @author mbmartinez
 */

@Controller
public class ImageController {

    private static Logger log = LoggerFactory.getLogger(ImageController.class);

    public static final String domain = "img";
    
    @Autowired
    private CardRepo cards;
    
    @RequestMapping(domain + "/{exp}/{name}")
    public ResponseEntity<byte[]> getImage(@PathVariable String exp, @PathVariable String name) {
        log.debug("Image requested for card from expansion [{}] with name [{}]", exp, name);
    
        byte[] img = cards.getImage(exp, name);
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        
        return new ResponseEntity<byte[]>(img, headers, HttpStatus.CREATED);
    }
    
}
