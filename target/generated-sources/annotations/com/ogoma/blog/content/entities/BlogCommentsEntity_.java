package com.ogoma.blog.content.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(BlogCommentsEntity.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class BlogCommentsEntity_ extends com.ogoma.blog.setup.BaseEntity_ {

	public static final String PARENT = "parent";
	public static final String COMMENT = "comment";
	public static final String PARENT_ID = "parentId";

	
	/**
	 * @see com.ogoma.blog.content.entities.BlogCommentsEntity#parent
	 **/
	public static volatile SingularAttribute<BlogCommentsEntity, BlogCommentsEntity> parent;
	
	/**
	 * @see com.ogoma.blog.content.entities.BlogCommentsEntity#comment
	 **/
	public static volatile SingularAttribute<BlogCommentsEntity, String> comment;
	
	/**
	 * @see com.ogoma.blog.content.entities.BlogCommentsEntity
	 **/
	public static volatile EntityType<BlogCommentsEntity> class_;
	
	/**
	 * @see com.ogoma.blog.content.entities.BlogCommentsEntity#parentId
	 **/
	public static volatile SingularAttribute<BlogCommentsEntity, Long> parentId;

}

