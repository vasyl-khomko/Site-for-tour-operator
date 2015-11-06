package toursite;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import toursite.config.DataConfig;
import toursite.dao.TourDAO;
import toursite.model.Tour;
import toursite.model.User;
import toursite.service.UserService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class AppTests {
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    UserService userService;

    @Autowired
    TourDAO tourDAO;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void simple() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("tours/list"));
    }

    @Test
    public void listUsers() {
        assert(userService.findAllNotConfirmedUser(0, 100).getContent().size() > 0);
        }

    @Test
    public void tourCategories() {
        assertTrue(true);
        System.out.println("BEGIN tourCategories");
        //Tour tour  = tourDAO.findByTourIdAndLoadAllAttributess(1);
        //Tour tour  = tourDAO.findByTourIdAndLoadCountries(1);
        //Tour tour = tourDAO.findOne(1);

        //Tour tour = tourDAO.findByTourIdAndLoadServicesAndTourdays(1);
//        tour.getUser();
//        tour.getTourdays().get(0);
//        tour.getDates().get(0);
//        tour.getServices().get(0);
//        tour.getCategories().get(0);
        //tour.getCountries().get(0);
        System.out.println("END tourCategories");
    }


    @Test
    public void restClient() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.headForHeaders()
    }
}
