CREATE TABLE inquiry (
                           `id`	int	NOT NULL AUTO_INCREMENT,
                           `customer_id`	varchar(100)	NULL,
                           `title`	varchar(200)	NULL,
                           `contents`	text	NULL,
                           `status`	tinyint	NULL	COMMENT '0 : 답변대기
1 : 답변완료',
                           `reg_date`	datetime	NULL,
                           `update_date`	datetime	NULL
);

CREATE TABLE counselor (
                             `id`	int	NOT NULL AUTO_INCREMENT,
                             `counselor_id`	varchar(100)	NULL,
                             `counselor_password`	varchar(200)	NULL,
                             `counselor_name`	varchar(100)	NULL,
                             `reg_date`	datetime	NULL,
                             `update_date`	datetime	NULL
);

CREATE TABLE inquiry_answer (
                                  `id`	int	NOT NULL AUTO_INCREMENT,
                                  `counselor_id`	int	NOT NULL,
                                  `inquiry_id`	int	NOT NULL,
                                  `contents`	text	NULL,
                                  `reg_date`	datetime	NULL,
                                  `update_date`	datetime	NULL
);

ALTER TABLE inquiry ADD CONSTRAINT `PK_INQUIRY` PRIMARY KEY (
                                                               `id`
    );

ALTER TABLE counselor ADD CONSTRAINT `PK_COUNSELOR` PRIMARY KEY (
                                                                   `id`
    );

ALTER TABLE inquiry_answer ADD CONSTRAINT `PK_INQUIRY_ANSWER` PRIMARY KEY (
                                                                             `id`,
                                                                             `counselor_id`
    );

ALTER TABLE inquiry_answer ADD CONSTRAINT `FK_counselor_TO_inquiry_answer_1` FOREIGN KEY (
                                                                                            `counselor_id`
    )
    REFERENCES counselor (
                            `id`
        );

