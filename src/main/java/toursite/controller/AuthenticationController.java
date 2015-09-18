package toursite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import toursite.model.NotConfirmedUser;
import toursite.service.RoleService;
import toursite.service.UserService;

import java.sql.Date;

/**
 * Created by Vasyl on 10.06.2015.
 */

@Controller
public class AuthenticationController {
    @RequestMapping(value="/login")
    public String login(String username, ModelMap model) {
        return "login";
    }

}
