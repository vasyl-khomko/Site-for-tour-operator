package toursite.model;

import javax.persistence.*;

/**
 * Created by Vasyl on 29.05.2015.
 */
@Entity
public class Service {
    private int serviceId;
    private String description;
    private int price;
    private Tour tour;

    @Id
    @Column(name = "service_id")
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service = (Service) o;

        if (price != service.price) return false;
        if (serviceId != service.serviceId) return false;
        if (description != null ? !description.equals(service.description) : service.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = serviceId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "tour_id", referencedColumnName = "tour_id", nullable = false)
    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
}
