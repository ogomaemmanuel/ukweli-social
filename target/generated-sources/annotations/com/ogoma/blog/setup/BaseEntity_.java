package com.ogoma.blog.setup;

import com.ogoma.blog.iam.entities.UserEntity;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.MappedSuperclassType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;

@StaticMetamodel(BaseEntity.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class BaseEntity_ {

	public static final String CREATED_AT = "createdAt";
	public static final String SYSTEM_GENERATED_ID = "systemGeneratedId";
	public static final String CREATED_BY = "createdBy";
	public static final String LAST_MODIFIED_BY = "lastModifiedBy";
	public static final String ID = "id";
	public static final String VERSION = "version";
	public static final String UPDATED_AT = "updatedAt";

	
	/**
	 * @see com.ogoma.blog.setup.BaseEntity#createdAt
	 **/
	public static volatile SingularAttribute<BaseEntity, LocalDateTime> createdAt;
	
	/**
	 * @see com.ogoma.blog.setup.BaseEntity#systemGeneratedId
	 **/
	public static volatile SingularAttribute<BaseEntity, String> systemGeneratedId;
	
	/**
	 * @see com.ogoma.blog.setup.BaseEntity#createdBy
	 **/
	public static volatile SingularAttribute<BaseEntity, UserEntity> createdBy;
	
	/**
	 * @see com.ogoma.blog.setup.BaseEntity#lastModifiedBy
	 **/
	public static volatile SingularAttribute<BaseEntity, UserEntity> lastModifiedBy;
	
	/**
	 * @see com.ogoma.blog.setup.BaseEntity#id
	 **/
	public static volatile SingularAttribute<BaseEntity, Long> id;
	
	/**
	 * @see com.ogoma.blog.setup.BaseEntity
	 **/
	public static volatile MappedSuperclassType<BaseEntity> class_;
	
	/**
	 * @see com.ogoma.blog.setup.BaseEntity#version
	 **/
	public static volatile SingularAttribute<BaseEntity, Long> version;
	
	/**
	 * @see com.ogoma.blog.setup.BaseEntity#updatedAt
	 **/
	public static volatile SingularAttribute<BaseEntity, LocalDateTime> updatedAt;

}

