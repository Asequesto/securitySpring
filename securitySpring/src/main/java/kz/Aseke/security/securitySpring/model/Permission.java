package kz.Aseke.security.securitySpring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

@Entity
@Table(name = "t_permission")
@Getter
@Setter
public class Permission extends BaseModel implements GrantedAuthority{


    @Column(name = "role")
    private String role;


    @Override
    public String getAuthority() {
        return this.role;
    }
}
