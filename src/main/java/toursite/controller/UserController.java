package toursite.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import toursite.model.Image;
import toursite.model.NotConfirmedUser;
import toursite.model.User;
import toursite.service.*;

import java.io.IOException;
import java.math.BigInteger;
import java.security.Principal;
import java.security.SecureRandom;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;


@Controller
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    FileUploadService fileUploadService;

    @Autowired
    ImageService imageService;

    @Autowired
    RoleService roleService;


    @RequestMapping("/users")
	public String users(@RequestParam(defaultValue = "1", value="page") int page, ModelMap model) {
        model.addAttribute("users", userService.findAllNotConfirmedUser(0, 8));
		return "users/list";
	}

    @RequestMapping("/users/view")
    public String view(Principal principal, ModelMap model) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "users/view";
    }

    @RequestMapping(value="/registration")
    public String registration(ModelMap model) {
        return "users/registration";
    }

    @RequestMapping(value="/activate")
    public String activate(@RequestParam("activation_code") String activationCode) {
        userService.activate(activationCode);

        return "redirect:/users";
    }

    @RequestMapping("/users/register")
    public String register(ModelMap model) {
        NotConfirmedUser user = new NotConfirmedUser();
        user.setImage(imageService.getDefaultUserImage());
        user.setRole(roleService.findById(4));
        model.addAttribute("user", user);
        userService.register(user);
        return "users/edit";
    }

    @RequestMapping("/users/edit")
    public String edit(Principal principal, ModelMap model) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "users/edit";
    }

    @RequestMapping("/users/update")
    public String update(Principal principal,
                          @RequestParam("file") MultipartFile file,
                          @RequestParam("last_name") String lastName,
                          @RequestParam("first_name") String firstName,
                          @RequestParam("username") String username,
                          @RequestParam("email") String email,
                          @RequestParam("phone") String phone,
                          @RequestParam("birth_date") String birthDateSt,
                          @RequestParam("address") String address,
                          @RequestParam("password1") String password1,
                          @RequestParam("password2") String password2) {
        Date birthDate;
        try {
            birthDate = new Date(new SimpleDateFormat("yyyy-MM-dd").parse(birthDateSt).getTime());
        } catch (ParseException e) {
            return "redirect:/users/edit";
        }
        User user = userService.findByUsername(principal.getName());
        user.setLastName(lastName);
        user.setFirstName(firstName);
        user.setUsername(username);
        user.setEmail(email);
        user.setPhone(phone);
        user.setBirthDate(birthDate);
        user.setAddress(address);
        if(!password1.isEmpty()) {
            user.setPassword(password1);
        }

        try {
            if(!file.isEmpty()) {
                //String filename = fileUploadService.upload(file, "D:/toursite_upload/images/");
                Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                        "cloud_name", "khomko-v",
                        "api_key", "668656986683845",
                        "api_secret", "30HP9RuWbfQ60wrmaGHtgM-Xu_o"));

                Map uploadResult = cloudinary.uploader()
                        .upload(file.getBytes(), ObjectUtils.emptyMap());
                Image image = new Image();
                System.out.println("url: " + uploadResult.get("url"));
                image.setFileName((String) uploadResult.get("url"));
                user.setImage(image);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        userService.update(user);
        return "redirect:/users/view";
    }

    @RequestMapping("/users/confirm-registration")
    public String confirmRegistration(@RequestParam("user_id") int user_id, ModelMap model) {
        userService.findAllNotConfirmedUser(0, 8);
        model.addAttribute("users", userService.findAllNotConfirmedUser(0, 8));
        return "users/list";
    }

    @RequestMapping("/users/reject-registration")
    public String rejectRegistration(@RequestParam("user_id") int user_id, ModelMap model) {
        userService.findAllNotConfirmedUser(0, 8);
        model.addAttribute("users", userService.findAllNotConfirmedUser(0, 8));
        return "users/list";
    }
}