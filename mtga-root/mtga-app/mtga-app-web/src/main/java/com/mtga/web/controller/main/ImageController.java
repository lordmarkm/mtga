package com.mtga.web.controller.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mtga.common.service.CardRepo;
import com.mtga.common.service.ExpansionRepo;
import com.mtga.web.utils.ControllerUtils;

/**
 * Separate controller for returning image names. There has to be a
 * better way :)
 * @author mbmartinez
 */

@Controller
@RequestMapping(ImageController.domain)
public class ImageController {

//    private static Logger log = LoggerFactory.getLogger(ImageController.class);

    public static final String domain = "img";
    
    @Autowired
    private CardRepo cards;
    
    @Autowired
    private ExpansionRepo expansions;
    
    @RequestMapping("/logo/{abbr}")
    public ResponseEntity<byte[]> getExpansionImage(@PathVariable String abbr) {
        byte[] logo = expansions.getLogo(abbr);
        return new ResponseEntity<byte[]>(logo, ControllerUtils.imageHeader(), HttpStatus.CREATED);
    }
    
    @RequestMapping("/{exp}/{cardName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String exp, @PathVariable String cardName) {
        byte[] img = cards.getImage(exp, cardName);
        return new ResponseEntity<byte[]>(img, ControllerUtils.imageHeader(), HttpStatus.CREATED);
    }
    
}
