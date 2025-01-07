package com.ogoma.blog.groups.entities;

import com.ogoma.blog.iam.entities.UserEntity;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(GroupMemberEntity.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class GroupMemberEntity_ extends com.ogoma.blog.setup.BaseEntity_ {

	public static final String USER_ENTITY = "userEntity";
	public static final String MEMBERSHIP_ROLE = "membershipRole";

	
	/**
	 * @see com.ogoma.blog.groups.entities.GroupMemberEntity#userEntity
	 **/
	public static volatile SingularAttribute<GroupMemberEntity, UserEntity> userEntity;
	
	/**
	 * @see com.ogoma.blog.groups.entities.GroupMemberEntity#membershipRole
	 **/
	public static volatile SingularAttribute<GroupMemberEntity, GroupRole> membershipRole;
	
	/**
	 * @see com.ogoma.blog.groups.entities.GroupMemberEntity
	 **/
	public static volatile EntityType<GroupMemberEntity> class_;

}

