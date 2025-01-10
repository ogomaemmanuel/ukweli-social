package com.ogoma.blog.iam.entities;

import com.ogoma.blog.config.SecurityConfig;
import com.ogoma.blog.posts.entities.FollowerEntity;
import com.ogoma.blog.posts.entities.PostEntity;
import com.ogoma.blog.posts.entities.UserProfileStats;
import com.ogoma.blog.notifications.NotificationEntity;
import com.ogoma.blog.setup.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;


@Getter
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity implements UserDetails {
    @Setter
    private String username;
    @Setter
    private String password;
    @Setter
    private String email;
    @Setter
    private String firstName;
    @Setter
    private String lastName;
    @Setter
    private String phoneNumber;
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @Getter
    private UserProfileStats profileStats;
    @ManyToMany
    @Getter
    public Set<RoleEntity> roles = new HashSet<>();
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST},mappedBy = "user")
    @Getter
    List<FollowerEntity> followers = new ArrayList<>();
    @ManyToMany
    Set<NotificationEntity> notifications = new HashSet<>();

    @OneToMany
    Set<PostEntity> blogsCreated = new HashSet<>();

    @ManyToMany
    Set<PostEntity> likedBlogs = new HashSet<>();

//    Set<BlogEntity>


    public void addFollower(UserEntity follower) {
        if (profileStats == null) {
            profileStats = new UserProfileStats();
        }
        FollowerEntity followerEntity = new FollowerEntity();
        followerEntity.setUser(this);
        followerEntity.setFollower(follower);
        if (follower.profileStats == null) {
            follower.profileStats = new UserProfileStats();
        }
        follower.incrementFollowing();
        this.profileStats.incrementFollowerCount();
        this.followers.add(followerEntity);
    }


    public void addNotification(NotificationEntity notificationEntity) {
        this.notifications.add(notificationEntity);
        if (profileStats != null) {
            profileStats.incrementNoticationCount();
        }
    }

    public void markNotificationAsRead(NotificationEntity notificationEntity) {
        this.notifications.remove(notificationEntity);
        if (profileStats != null) {
            profileStats.decrementNoticationCount();
        }
    }

    private void incrementFollowing() {
        this.profileStats.incrementFollowing();
    }

    private void decrementFollowing() {
        this.profileStats.decrementFollowing();
    }

    public void removeFollower(UserEntity follower) {
        follower.decrementFollowing();
        this.followers.remove(follower);
        if (profileStats != null) {
            this.profileStats.decrementFollowerCount();
        }
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @PrePersist
    public void prePersist() {
        this.username = username.toUpperCase();
        this.password = SecurityConfig.passwordEncoder().encode(password);
    }
}
