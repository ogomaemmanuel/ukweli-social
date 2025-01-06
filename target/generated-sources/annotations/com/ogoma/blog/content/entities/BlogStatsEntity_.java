package com.ogoma.blog.content.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(BlogStatsEntity.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class BlogStatsEntity_ extends com.ogoma.blog.setup.BaseEntity_ {

	public static final String SHARE_COUNT = "shareCount";
	public static final String LIKE_COUNT = "likeCount";
	public static final String COMMENT_COUNT = "commentCount";

	
	/**
	 * @see com.ogoma.blog.content.entities.BlogStatsEntity#shareCount
	 **/
	public static volatile SingularAttribute<BlogStatsEntity, Long> shareCount;
	
	/**
	 * @see com.ogoma.blog.content.entities.BlogStatsEntity#likeCount
	 **/
	public static volatile SingularAttribute<BlogStatsEntity, Long> likeCount;
	
	/**
	 * @see com.ogoma.blog.content.entities.BlogStatsEntity
	 **/
	public static volatile EntityType<BlogStatsEntity> class_;
	
	/**
	 * @see com.ogoma.blog.content.entities.BlogStatsEntity#commentCount
	 **/
	public static volatile SingularAttribute<BlogStatsEntity, Long> commentCount;

}

