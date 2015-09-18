package toursite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

/**
 * Created by Vasyl on 10.06.2015.
 */

@Controller
public class BookingController {
    public String login(String username, ModelMap model) {
        return "login";
    }
}
