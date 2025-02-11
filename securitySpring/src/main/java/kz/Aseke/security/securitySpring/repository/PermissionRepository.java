package kz.Aseke.security.securitySpring.repository;

import jakarta.transaction.Transactional;
import kz.Aseke.security.securitySpring.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
