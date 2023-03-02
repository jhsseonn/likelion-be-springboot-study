package com.example.bespringbootshop.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = 538894918L;

    public static final QPost post = new QPost("post");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath postContent = createString("postContent");

    public final StringPath postTitle = createString("postTitle");

    public final NumberPath<Integer> postView = createNumber("postView", Integer.class);

    public final NumberPath<Integer> postWishes = createNumber("postWishes", Integer.class);

    public final StringPath postWriter = createString("postWriter");

    public final DateTimePath<java.time.LocalDateTime> regTime = createDateTime("regTime", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> updateTime = createDateTime("updateTime", java.time.LocalDateTime.class);

    public QPost(String variable) {
        super(Post.class, forVariable(variable));
    }

    public QPost(Path<? extends Post> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPost(PathMetadata metadata) {
        super(Post.class, metadata);
    }

}

