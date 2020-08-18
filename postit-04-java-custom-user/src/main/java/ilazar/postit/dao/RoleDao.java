package ilazar.postit.dao;

import ilazar.postit.entity.Role;

public interface RoleDao {

	Role findRoleByName(String roleName);

}
