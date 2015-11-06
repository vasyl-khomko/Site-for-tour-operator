package toursite.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Vasyl on 21.05.2015.
 */
@Entity
@NamedEntityGraphs({
        @NamedEntityGraph(name = "graph.Tour.countries",
                attributeNodes = {@NamedAttributeNode("countries")}),
        @NamedEntityGraph(name = "graph.Tour.categories",
                attributeNodes = {@NamedAttributeNode("categories")}),
        @NamedEntityGraph(name = "graph.Tour.servicesAndTourdays",
                attributeNodes = {@NamedAttributeNode("services"),
                        @NamedAttributeNode("tourdays")}),
        @NamedEntityGraph(name = "graph.Tour.allAttributes",
                attributeNodes = {@NamedAttributeNode("countries"),
                        @NamedAttributeNode("categories")})
})
public class Tour {
    private int tourId;
    private String name;
    private int duration;
    private int price;
    private String description;
    private List<Service> services;
    private List<Tourday> tourdays;
    private User user;
    private List<Date> dates;
    private List<Category> categories;
    private List<Country> countries;
    private Image image;

    @OneToOne(cascade = javax.persistence.CascadeType.ALL)
    @JoinColumn(name = "image_id")
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @ManyToMany
    @Fetch(value = FetchMode.JOIN)
    @JoinTable(name="tour_has_country",
            joinColumns=@JoinColumn(name="tour_id"),
            inverseJoinColumns=@JoinColumn(name="country_id"))
    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    @ManyToMany
    @Fetch(value = FetchMode.JOIN)
    @JoinTable(name="tour_has_category",
            joinColumns=@JoinColumn(name="tour_id"),
            inverseJoinColumns=@JoinColumn(name="category_id"))
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }


    @ElementCollection
    @CollectionTable(name="tour_date", joinColumns=@JoinColumn(name="tour_id"))
    @Column(name="date")
    public List<Date> getDates() {
        return dates;
    }

    public void setDates(List<Date> dates) {
        this.dates = dates;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tour_id")
    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "duration")
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tour tour = (Tour) o;

        if (duration != tour.duration) return false;
        if (price != tour.price) return false;
        if (tourId != tour.tourId) return false;
        if (description != null ? !description.equals(tour.description) : tour.description != null) return false;
        if (name != null ? !name.equals(tour.name) : tour.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tourId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + duration;
        result = 31 * result + price;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(cascade = javax.persistence.CascadeType.REMOVE, mappedBy = "tour", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    @OneToMany(cascade = javax.persistence.CascadeType.REMOVE, mappedBy = "tour", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    public List<Tourday> getTourdays() {
        return tourdays;
    }

    public void setTourdays(List<Tourday> tourdays) {
        this.tourdays = tourdays;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
