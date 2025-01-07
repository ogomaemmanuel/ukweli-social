package com.ogoma.blog.groups.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(GroupEntity.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class GroupEntity_ extends com.ogoma.blog.setup.BaseEntity_ {

	public static final String VIEW_ONLY = "viewOnly";
	public static final String MEMBERS = "members";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String PRIVACY = "privacy";

	
	/**
	 * @see com.ogoma.blog.groups.entities.GroupEntity#viewOnly
	 **/
	public static volatile SingularAttribute<GroupEntity, Boolean> viewOnly;
	
	/**
	 * @see com.ogoma.blog.groups.entities.GroupEntity#members
	 **/
	public static volatile SetAttribute<GroupEntity, GroupMemberEntity> members;
	
	/**
	 * @see com.ogoma.blog.groups.entities.GroupEntity#name
	 **/
	public static volatile SingularAttribute<GroupEntity, String> name;
	
	/**
	 * @see com.ogoma.blog.groups.entities.GroupEntity#description
	 **/
	public static volatile SingularAttribute<GroupEntity, String> description;
	
	/**
	 * @see com.ogoma.blog.groups.entities.GroupEntity#privacy
	 **/
	public static volatile SingularAttribute<GroupEntity, GroupPrivacy> privacy;
	
	/**
	 * @see com.ogoma.blog.groups.entities.GroupEntity
	 **/
	public static volatile EntityType<GroupEntity> class_;

}

