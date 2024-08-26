package org.tc.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tc.backend.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
