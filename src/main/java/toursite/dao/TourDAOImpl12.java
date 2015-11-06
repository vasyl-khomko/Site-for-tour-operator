package toursite.dao;

import org.springframework.beans.factory.annotation.Autowired;
import toursite.model.Tour;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vasyl on 17.10.2015.
 */
public class TourDAOImpl12 implements TourDAOCustom {
    @PersistenceContext
    EntityManager em;

    @Override
    public Tour findOneNew(Integer tourId) {
        EntityGraph graph = em.getEntityGraph("graph.Tour.countries");

        Map hints = new HashMap();
        hints.put("javax.persistence.fetchgraph", graph);
        return em.find(Tour.class, tourId , hints);
    }
}
