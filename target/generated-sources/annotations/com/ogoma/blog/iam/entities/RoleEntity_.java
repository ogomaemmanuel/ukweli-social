package com.ogoma.blog.iam.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(RoleEntity.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class RoleEntity_ extends com.ogoma.blog.setup.BaseEntity_ {

	public static final String NAME = "name";

	
	/**
	 * @see com.ogoma.blog.iam.entities.RoleEntity#name
	 **/
	public static volatile SingularAttribute<RoleEntity, String> name;
	
	/**
	 * @see com.ogoma.blog.iam.entities.RoleEntity
	 **/
	public static volatile EntityType<RoleEntity> class_;

}

