package com.ogoma.blog.content.entities;

import com.ogoma.blog.iam.entities.UserEntity;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(FollowerEntity.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class FollowerEntity_ extends com.ogoma.blog.setup.BaseEntity_ {

	public static final String FOLLOWER = "follower";

	
	/**
	 * @see com.ogoma.blog.content.entities.FollowerEntity#follower
	 **/
	public static volatile SingularAttribute<FollowerEntity, UserEntity> follower;
	
	/**
	 * @see com.ogoma.blog.content.entities.FollowerEntity
	 **/
	public static volatile EntityType<FollowerEntity> class_;

}

