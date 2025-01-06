package com.ogoma.blog.iam.entities;

import com.ogoma.blog.content.entities.FollowerEntity;
import com.ogoma.blog.content.entities.UserProfileStats;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(UserEntity.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class UserEntity_ extends com.ogoma.blog.setup.BaseEntity_ {

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";
	public static final String PASSWORD = "password";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String FOLLOWERS = "followers";
	public static final String ROLES = "roles";
	public static final String EMAIL = "email";
	public static final String USERNAME = "username";
	public static final String PROFILE_STATS = "profileStats";

	
	/**
	 * @see com.ogoma.blog.iam.entities.UserEntity#firstName
	 **/
	public static volatile SingularAttribute<UserEntity, String> firstName;
	
	/**
	 * @see com.ogoma.blog.iam.entities.UserEntity#lastName
	 **/
	public static volatile SingularAttribute<UserEntity, String> lastName;
	
	/**
	 * @see com.ogoma.blog.iam.entities.UserEntity#password
	 **/
	public static volatile SingularAttribute<UserEntity, String> password;
	
	/**
	 * @see com.ogoma.blog.iam.entities.UserEntity#phoneNumber
	 **/
	public static volatile SingularAttribute<UserEntity, String> phoneNumber;
	
	/**
	 * @see com.ogoma.blog.iam.entities.UserEntity#followers
	 **/
	public static volatile SetAttribute<UserEntity, FollowerEntity> followers;
	
	/**
	 * @see com.ogoma.blog.iam.entities.UserEntity#roles
	 **/
	public static volatile SetAttribute<UserEntity, RoleEntity> roles;
	
	/**
	 * @see com.ogoma.blog.iam.entities.UserEntity
	 **/
	public static volatile EntityType<UserEntity> class_;
	
	/**
	 * @see com.ogoma.blog.iam.entities.UserEntity#email
	 **/
	public static volatile SingularAttribute<UserEntity, String> email;
	
	/**
	 * @see com.ogoma.blog.iam.entities.UserEntity#username
	 **/
	public static volatile SingularAttribute<UserEntity, String> username;
	
	/**
	 * @see com.ogoma.blog.iam.entities.UserEntity#profileStats
	 **/
	public static volatile SingularAttribute<UserEntity, UserProfileStats> profileStats;

}

