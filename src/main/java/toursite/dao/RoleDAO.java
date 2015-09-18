package toursite.dao;

import toursite.model.Role;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
public interface RoleDAO {
    public void save(Role role);
    public Role findById(int roleId);
    public List<Role> findAll();
}
