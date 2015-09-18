package toursite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toursite.dao.RoleDAO;
import toursite.model.Role;

import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDAO roleDAO;

    @Transactional
    public void save(Role role) {
        roleDAO.save(role);
    }

    @Transactional
    public Role findById(int roleId) {
        return roleDAO.findById(roleId);
    }

    @Transactional
    public List<Role> findAll() {
        return roleDAO.findAll();
    }
}
