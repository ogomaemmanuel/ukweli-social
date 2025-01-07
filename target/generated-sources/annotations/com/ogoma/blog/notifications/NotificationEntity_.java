package com.ogoma.blog.notifications;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(NotificationEntity.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class NotificationEntity_ extends com.ogoma.blog.setup.BaseEntity_ {

	public static final String IS_READ = "isRead";
	public static final String MESSAGE = "message";

	
	/**
	 * @see com.ogoma.blog.notifications.NotificationEntity#isRead
	 **/
	public static volatile SingularAttribute<NotificationEntity, Boolean> isRead;
	
	/**
	 * @see com.ogoma.blog.notifications.NotificationEntity#message
	 **/
	public static volatile SingularAttribute<NotificationEntity, String> message;
	
	/**
	 * @see com.ogoma.blog.notifications.NotificationEntity
	 **/
	public static volatile EntityType<NotificationEntity> class_;

}

