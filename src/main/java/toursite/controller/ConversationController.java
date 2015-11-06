package toursite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import toursite.model.User;
import toursite.service.ConversationService;
import toursite.service.UserService;

import java.security.Principal;

/**
 * Created by Vasyl on 10.06.2015.
 */

@Controller
public class ConversationController {
    @Autowired
    ConversationService conversationService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/conversations", method = RequestMethod.GET)
    public String conversations(Principal principal, ModelMap model) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("conversations",
                conversationService.findByUserIdOne(user.getUserId()));
        return "conversations/list";
    }
}
