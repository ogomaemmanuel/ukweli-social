package com.ogoma.blog.content.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(UserProfileStats.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class UserProfileStats_ {

	public static final String ROLE_COUNT = "roleCount";
	public static final String AVERAGE_RATING = "averageRating";
	public static final String POST_COUNT = "postCount";
	public static final String NOTICATION_COUNT = "noticationCount";
	public static final String ID = "id";
	public static final String PROFILE_VIEW_COUNT = "profileViewCount";
	public static final String RATING_COUNT = "ratingCount";
	public static final String FOLLOWER_COUNT = "followerCount";
	public static final String FOLLOWING_COUNT = "followingCount";
	public static final String COMMENT_COUNT = "commentCount";

	
	/**
	 * @see com.ogoma.blog.content.entities.UserProfileStats#roleCount
	 **/
	public static volatile SingularAttribute<UserProfileStats, Long> roleCount;
	
	/**
	 * @see com.ogoma.blog.content.entities.UserProfileStats#averageRating
	 **/
	public static volatile SingularAttribute<UserProfileStats, Long> averageRating;
	
	/**
	 * @see com.ogoma.blog.content.entities.UserProfileStats#postCount
	 **/
	public static volatile SingularAttribute<UserProfileStats, Long> postCount;
	
	/**
	 * @see com.ogoma.blog.content.entities.UserProfileStats#noticationCount
	 **/
	public static volatile SingularAttribute<UserProfileStats, Long> noticationCount;
	
	/**
	 * @see com.ogoma.blog.content.entities.UserProfileStats#id
	 **/
	public static volatile SingularAttribute<UserProfileStats, Long> id;
	
	/**
	 * @see com.ogoma.blog.content.entities.UserProfileStats#profileViewCount
	 **/
	public static volatile SingularAttribute<UserProfileStats, Long> profileViewCount;
	
	/**
	 * @see com.ogoma.blog.content.entities.UserProfileStats#ratingCount
	 **/
	public static volatile SingularAttribute<UserProfileStats, Long> ratingCount;
	
	/**
	 * @see com.ogoma.blog.content.entities.UserProfileStats
	 **/
	public static volatile EntityType<UserProfileStats> class_;
	
	/**
	 * @see com.ogoma.blog.content.entities.UserProfileStats#followerCount
	 **/
	public static volatile SingularAttribute<UserProfileStats, Long> followerCount;
	
	/**
	 * @see com.ogoma.blog.content.entities.UserProfileStats#followingCount
	 **/
	public static volatile SingularAttribute<UserProfileStats, Long> followingCount;
	
	/**
	 * @see com.ogoma.blog.content.entities.UserProfileStats#commentCount
	 **/
	public static volatile SingularAttribute<UserProfileStats, Long> commentCount;

}

