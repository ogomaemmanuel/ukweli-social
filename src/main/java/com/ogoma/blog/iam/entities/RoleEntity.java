package com.ogoma.blog.iam.entities;

import com.ogoma.blog.setup.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;


@Getter
@Setter
@Entity
public class RoleEntity extends BaseEntity implements GrantedAuthority {

    private String name;
    @Override
    public String getAuthority() {
        return null;
    }
}
