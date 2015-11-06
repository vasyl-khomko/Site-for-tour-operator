package toursite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import toursite.model.Role;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface RoleDAO extends JpaRepository<Role, Integer> {
}
