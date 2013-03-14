package com.mtga.web.controller.search.test;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.servlet.ModelAndView;

import com.mtga.common.service.CardRepo;
import com.mtga.model.jpa.JpaCard;
import com.mtga.model.mtg.Card;
import com.mtga.web.controller.search.SearchBrowseController;
import com.mtga.web.controller.search.SearchBrowseControllerImpl;

@RunWith(MockitoJUnitRunner.class)
public class SearchControllerTest {

    @InjectMocks
    private SearchBrowseController controller = new SearchBrowseControllerImpl();

    @Mock
    private Principal principal;
    
    @Mock
    private HttpServletRequest request;
    
    @Mock
    private CardRepo cards;
    
    @SuppressWarnings("rawtypes")
    @Mock
    private Page response;
    
    @SuppressWarnings("unchecked")
    @Test
    public void testController() {
        when(cards.findAll(anyInt(), anyInt())).thenReturn(response);
        ModelAndView mav = controller.searchBrowse(request, principal);
        assertFalse("Cards not added to model", mav.getModel().isEmpty());
    }
    
}
