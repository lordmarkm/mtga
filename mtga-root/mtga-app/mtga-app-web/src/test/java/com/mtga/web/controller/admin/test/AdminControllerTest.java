package com.mtga.web.controller.admin.test;

import static org.junit.Assert.*;

import java.security.Principal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import com.mtga.web.controller.admin.AdminController;
import com.mtga.web.controller.admin.AdminControllerImpl;

@RunWith(MockitoJUnitRunner.class)
public class AdminControllerTest {

    @InjectMocks
    private AdminController controller = new AdminControllerImpl();
    
    @Mock
    private Principal principal;
    
    @Test
    public void testAdminController() {
        
        ModelAndView nextpage = controller.admin(principal);
        assertEquals("Wrong view returned", nextpage.getViewName(), AdminController.VIEW_ADMIN);
        
    }
    
}
