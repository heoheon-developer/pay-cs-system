package com.pay.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInquiry is a Querydsl query type for Inquiry
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QInquiry extends EntityPathBase<Inquiry> {

    private static final long serialVersionUID = 614758928L;

    public static final QInquiry inquiry = new QInquiry("inquiry");

    public final StringPath contents = createString("contents");

    public final StringPath customerId = createString("customerId");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final SetPath<InquiryAnswer, QInquiryAnswer> inquiryAnswer = this.<InquiryAnswer, QInquiryAnswer>createSet("inquiryAnswer", InquiryAnswer.class, QInquiryAnswer.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> regDate = createDateTime("regDate", java.time.LocalDateTime.class);

    public final EnumPath<com.pay.enums.InquiryStatus> status = createEnum("status", com.pay.enums.InquiryStatus.class);

    public final StringPath title = createString("title");

    public final DateTimePath<java.time.LocalDateTime> updateDate = createDateTime("updateDate", java.time.LocalDateTime.class);

    public QInquiry(String variable) {
        super(Inquiry.class, forVariable(variable));
    }

    public QInquiry(Path<? extends Inquiry> path) {
        super(path.getType(), path.getMetadata());
    }

    public QInquiry(PathMetadata metadata) {
        super(Inquiry.class, metadata);
    }

}

