INSERT INTO counselor(counselor_id, counselor_name, counselor_password, reg_date, update_date) values('counser-A','a','bbb','2020-09-15', '2022-09-15');

INSERT INTO inquiry(CUSTOMER_ID, TITLE, CONTENTS, STATUS, REG_DATE, UPDATE_DATE) VALUES ('HEOHEON','TEST','CONTENT TEST',0,'2022-09-15','2022-09-15');

INSERT INTO inquiry_answer(contents, reg_date, update_date, counselor_id, inquiry_id) values ('test','2022-09-19','2022-09-05',1,1)