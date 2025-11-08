package com.ogoma.blog.iam.entities;

import com.ogoma.blog.setup.BaseEntity;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;


@Getter
@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity implements GrantedAuthority {

    @EmbeddedId
    private RoleID id;

    private String name;

    @Override
    public String getAuthority() {
        return null;
    }

    protected RoleEntity() {
        super();
        id = new RoleID();
    }
}
