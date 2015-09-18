package toursite.model;

import javax.persistence.*;

/**
 * Created by Vasyl on 29.05.2015.
 */
@Entity
public class Tourday {
    private Tour tour;
    private int tourdayId;
    private int dayNumber;
    private String description;

    @ManyToOne
    @JoinColumn(name = "tour_id", referencedColumnName = "tour_id", nullable = false)
    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    @Id
    @Column(name = "tourday_id")
    public int getTourdayId() {
        return tourdayId;
    }

    public void setTourdayId(int tourdayId) {
        this.tourdayId = tourdayId;
    }

    @Basic
    @Column(name = "day_number")
    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
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

        Tourday tourday = (Tourday) o;

        if (dayNumber != tourday.dayNumber) return false;
        if (tourdayId != tourday.tourdayId) return false;
        if (description != null ? !description.equals(tourday.description) : tourday.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tourdayId;
        result = 31 * result + dayNumber;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
