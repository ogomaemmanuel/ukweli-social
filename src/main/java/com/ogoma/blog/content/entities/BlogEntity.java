package com.ogoma.blog.content.entities;

import com.ogoma.blog.setup.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Entity
@Table(name = "blogs")
public class BlogEntity extends BaseEntity {
    @Setter
    private String title;
    @Setter
    private String content;
    @Setter
    private PostVisibility visibility;
    @JdbcTypeCode(SqlTypes.JSON)
    @Setter
    private Set<String> medialUrls;
    @Setter
    private String description;
    @OneToMany
    @Cascade({CascadeType.MERGE, CascadeType.PERSIST})
    private Set<BlogLike> likes = new HashSet<>();
    @OneToMany(orphanRemoval = true)
    @Cascade({CascadeType.MERGE, CascadeType.PERSIST})
    private Set<BlogCommentsEntity> comments = new HashSet<>();
    @OneToOne
    @Cascade({CascadeType.MERGE, CascadeType.PERSIST})
    private BlogStatsEntity stats;
    @Setter
    private boolean forGroup;

    public void addComment(BlogCommentsEntity comment) {
        this.comments.add(comment);
        if (this.stats == null) {
            stats = new BlogStatsEntity();
        }
        stats.incrementCommentCount();
    }

    public void removeComment(BlogCommentsEntity comment) {
        this.comments.remove(comment);
        if (this.stats != null) {
            stats.decrementCommentCount();
        }
    }

    public void addLike(BlogLike like) {
        likes.add(like);
        if (this.stats == null) {
            stats = new BlogStatsEntity();
        }
        stats.incrementLikeCount();
    }

    public void removeLike(BlogLike like) {
        likes.remove(like);
        if (this.stats != null) {
            stats.decrementLikeCount();
        }
    }


}
