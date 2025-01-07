package com.ogoma.blog.content.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(BlogEntity.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class BlogEntity_ extends com.ogoma.blog.setup.BaseEntity_ {

	public static final String COMMENTS = "comments";
	public static final String VISIBILITY = "visibility";
	public static final String STATS = "stats";
	public static final String DESCRIPTION = "description";
	public static final String TITLE = "title";
	public static final String CONTENT = "content";
	public static final String LIKES = "likes";

	
	/**
	 * @see com.ogoma.blog.content.entities.BlogEntity#comments
	 **/
	public static volatile SetAttribute<BlogEntity, BlogCommentsEntity> comments;
	
	/**
	 * @see com.ogoma.blog.content.entities.BlogEntity#visibility
	 **/
	public static volatile SingularAttribute<BlogEntity, PostVisibility> visibility;
	
	/**
	 * @see com.ogoma.blog.content.entities.BlogEntity#stats
	 **/
	public static volatile SingularAttribute<BlogEntity, BlogStatsEntity> stats;
	
	/**
	 * @see com.ogoma.blog.content.entities.BlogEntity#description
	 **/
	public static volatile SingularAttribute<BlogEntity, String> description;
	
	/**
	 * @see com.ogoma.blog.content.entities.BlogEntity#title
	 **/
	public static volatile SingularAttribute<BlogEntity, String> title;
	
	/**
	 * @see com.ogoma.blog.content.entities.BlogEntity
	 **/
	public static volatile EntityType<BlogEntity> class_;
	
	/**
	 * @see com.ogoma.blog.content.entities.BlogEntity#content
	 **/
	public static volatile SingularAttribute<BlogEntity, String> content;
	
	/**
	 * @see com.ogoma.blog.content.entities.BlogEntity#likes
	 **/
	public static volatile SetAttribute<BlogEntity, BlogLike> likes;

}

