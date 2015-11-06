package toursite.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import toursite.model.Tour;
import java.util.List;

/**
 * Created by Vasyl on 26.05.2015.
 */

public interface TourDAO extends JpaRepository<Tour, Integer> {///, TourDAOCustom {
    //@EntityGraph(value = "graph.Tour.allAttributes", type = EntityGraph.EntityGraphType.LOAD)
    @Query("select t from Tour t left outer join fetch t.categories where t.tourId = :tourId")
    public Tour findByTourIdAndLoadAllAttributess(@Param("tourId") Integer tourId);

    //@EntityGraph(value = "graph.Tour.countries")
    @Query("select t from Tour t left join fetch t.countries where t.tourId = :tourId")
    public Tour findByTourIdAndLoadCountries(@Param("tourId") Integer tourId);

    @EntityGraph(value = "graph.Tour.servicesAndTourdays", type = EntityGraph.EntityGraphType.LOAD)
    @Query("select t from Tour t where t.tourId = :tourId")
    public Tour findByTourIdAndLoadServicesAndTourdays(@Param("tourId") Integer tourId);
}
