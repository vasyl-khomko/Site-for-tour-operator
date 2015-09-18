package toursite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Vasyl on 10.06.2015.
 */

@Controller
public class ConversationController {
    public String login(String username, ModelMap model) {
        return "login";
    }
}
