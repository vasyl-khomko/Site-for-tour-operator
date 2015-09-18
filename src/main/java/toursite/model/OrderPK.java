package toursite.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Vasyl on 21.05.2015.
 */
public class OrderPK implements Serializable {
    private int userId;
    private int tourId;
    private Date tourDate;

    @Column(name = "user_id")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "tour_id")
    @Id
    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    @Column(name = "tour_date")
    @Id
    public Date getTourDate() {
        return tourDate;
    }

    public void setTourDate(Date tourDate) {
        this.tourDate = tourDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderPK orderPK = (OrderPK) o;

        if (tourId != orderPK.tourId) return false;
        if (userId != orderPK.userId) return false;
        if (tourDate != null ? !tourDate.equals(orderPK.tourDate) : orderPK.tourDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + tourId;
        result = 31 * result + (tourDate != null ? tourDate.hashCode() : 0);
        return result;
    }
}
