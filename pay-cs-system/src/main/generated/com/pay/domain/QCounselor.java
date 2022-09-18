package com.pay.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCounselor is a Querydsl query type for Counselor
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCounselor extends EntityPathBase<Counselor> {

    private static final long serialVersionUID = 1138927841L;

    public static final QCounselor counselor = new QCounselor("counselor");

    public final StringPath counselorId = createString("counselorId");

    public final StringPath counselorName = createString("counselorName");

    public final StringPath counselorPassword = createString("counselorPassword");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> regDate = createDateTime("regDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> updateDate = createDateTime("updateDate", java.time.LocalDateTime.class);

    public QCounselor(String variable) {
        super(Counselor.class, forVariable(variable));
    }

    public QCounselor(Path<? extends Counselor> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCounselor(PathMetadata metadata) {
        super(Counselor.class, metadata);
    }

}

