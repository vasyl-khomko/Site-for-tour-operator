package toursite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import toursite.model.*;
import toursite.service.*;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Joiner;

/**
 * Created by Vasyl on 29.05.2015.
 */
@Controller
@Scope("session")
public class TourController {
    @Autowired
    private TourService tourService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private UserService userService;

    @Autowired
    private TourdayService tourdayService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CountryService countryService;

    private Tour editedTour;

    @RequestMapping(value = {"/","/tours"})
    public String tours(@RequestParam(defaultValue = "1", value="page") int page, ModelMap model) {
        model.addAttribute("tours", tourService.listTours(page));
        model.addAttribute("page", page);
        model.addAttribute("pagesCount", tourService.pagesCount());
        return "tours/list";
    }

    @RequestMapping("/tours/view")
    public String view(@RequestParam(defaultValue = "1", value="tour_id") int tourId, ModelMap model) {
        Tour tour = tourService.findById(tourId);
        model.addAttribute("tour", tour);
        model.addAttribute("reviews", reviewService.findByTourId(tour.getTourId()));
        model.addAttribute("review", new Review());

        return "tours/view";
    }

    @RequestMapping("/tours/view-current-tour")
    public String viewCurrentTour() {
        return "redirect:/tours/view?tour_id=" + editedTour.getTourId();
    }

    private String joinDates(List<Date> dates) {
        String[] datesStr = new String[dates.size()];
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        for (int i = 0; i < dates.size(); i++) {
            datesStr[i] = df.format(new java.util.Date(dates.get(i).getTime()));
        }
        Joiner joiner = Joiner.on(",").skipNulls();
        String joinedDates =  joiner.join(datesStr);
        return joinedDates;
    }

    @RequestMapping("/tours/create-tour")
    public String create() {
        editedTour = new Tour();
        editedTour.setUser(userService.findByUsername("vasyl"));
        editedTour.setServices(new ArrayList<Service>());
        editedTour.setTourdays(new ArrayList<Tourday>());
        editedTour.setCategories(new ArrayList<Category>());
        editedTour.setDates(new ArrayList<Date>());
        return "redirect:/tours/edit-current-tour";
    }

    @RequestMapping("/tours/edit-tour")
    public String edit(@RequestParam(value="tour_id") int tourId) {
        editedTour = tourService.findById(tourId);
        return "redirect:/tours/edit-current-tour";
    }

    @RequestMapping("/tours/edit-current-tour")
    public String editCurrentTour(Model model) {
        model.addAttribute("tour", editedTour);
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("joinedDates", joinDates(editedTour.getDates()));
        return "tours/create-or-edit";
    }

    @RequestMapping("/tours/delete-tour")
    public String delete(@RequestParam(value="tour_id") int tourId) {
        editedTour = tourService.findById(tourId);
        return "redirect:/tours/edit-current-tour";
    }

    @RequestMapping("/tours/save-or-update-tour")
    public String saveOrUpdateTour(@RequestParam("name") String name,
                                   @RequestParam("duration") int duration,
                                   @RequestParam("price") int price,
                                   @RequestParam("description") String description,
                                   @RequestParam("dates") String datesStr,
                                   @RequestParam(value = "categories", required = false) int[] categories,
                                   @RequestParam(value = "countries", required = false) int[] countries) {
        String[] dates = datesStr.split(",");

        editedTour.setName(name);
        editedTour.setDuration(duration);
        editedTour.setPrice(price);
        editedTour.setDescription(description);
        tourService.saveOrUpdate(editedTour);

        editedTour.setDates(new ArrayList<Date>());

        for(int i = 0; i < dates.length; i++) {
            try {
                if(!dates[i].isEmpty()) {
                    Date date = new Date(new SimpleDateFormat("dd.MM.yyyy").parse(dates[i]).getTime());
                    editedTour.getDates().add(date);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        editedTour.setCategories(new ArrayList<Category>());
        if(categories != null) {
            for (int i = 0; i < categories.length; i++) {
                editedTour.getCategories().add(categoryService.findById(categories[i]));
            }
        }

        editedTour.setCountries(new ArrayList<Country>());
        if(countries != null) {
            for (int i = 0; i < countries.length; i++) {
                editedTour.getCountries().add(countryService.findById(countries[i]));
            }
        }
        tourService.saveOrUpdate(editedTour);

        return "redirect:/tours/create-or-edit-tourdays";
    }

    @RequestMapping("/tours/create-or-edit-tourdays")
    public String createOrEditTourdays(ModelMap model) {
        List<Tourday> tourdays = editedTour.getTourdays();

        if(editedTour.getDuration() > tourdays.size()) {
            for(int i = tourdays.size(); i < editedTour.getDuration(); i++) {
                Tourday tourday = new Tourday();
                tourday.setDayNumber(i + 1);
                tourday.setTour(editedTour);
                tourdays.add(tourday);
            }
        }
        else {
            for(int i = tourdays.size(); i > editedTour.getDuration(); i--) {
                tourdayService.delete(tourdays.remove(i - 1));
            }
        }
        model.addAttribute("tourdays", tourdays);
        return "tours/create-or-edit-tourdays";
    }

    @RequestMapping("/tours/save-or-update-tourdays")
    public String saveOrUpdateTourdays(@RequestParam(value = "descriptions") String[] descriptions) {
        List<Tourday> tourdays = editedTour.getTourdays();
        for(int i = 0; i < descriptions.length; i++) {
            Tourday tourday = tourdays.get(i);
            tourday.setDescription(descriptions[i]);
            tourdayService.saveOrUpdate(tourday);
        }
        return "redirect:/tours/create-or-edit-services";
    }

    @RequestMapping("/tours/create-or-edit-services")
    public String services(ModelMap model) {
        model.addAttribute("services", editedTour.getServices());
        return "tours/create-or-edit-services";
    }

    @RequestMapping("/tours/add-service")
    public String addService(@RequestParam("description") String description,
                             @RequestParam("price") int price) {
        Service service = new Service();
        service.setDescription(description);
        service.setPrice(price);
        service.setTour(editedTour);
        editedTour.getServices().add(service);
        serviceService.add(service);

        return "redirect:/tours/create-or-edit-services";
    }

    @RequestMapping("/tours/view/add-review")
    public String addReview(@RequestParam(defaultValue = "1", value="tour_id") int tourId,
                            @ModelAttribute Review review) {
        User user = userService.findByUsername("vasyl");
        review.setTourId(tourId);
        review.setUser(user);
        reviewService.save(review);
        return "redirect:tours/view?tour_id="+tourId+"#reviews";
    }
}
