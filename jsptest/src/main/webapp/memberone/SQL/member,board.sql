CREATE table "STUDENT" (
 "ID" VARCHAR2(12) NOT NULL,
 "PASS" VARCHAR2(12) NOT NULL,
 "NAME" VARCHAR2(10) NOT NULL,
 "PHONE1" VARCHAR2(3) NOT NULL,
 "PHONE2" VARCHAR2(4) NOT NULL,
 "PHONE3" VARCHAR2(4) NOT NULL,
 "EMAIL" VARCHAR2(30) NOT NULL,
 "ZIPCODE" VARCHAR2(7) NOT NULL,
 "ADDRESS1" VARCHAR2(120) NOT NULL,
 "ADDRESS2" VARCHAR2(50) NOT NULL,
 constraint "STUDENT_PK" primary key ("ID")
); 

SELECT*FROM STUDENT;


drop table STUDENT;

create table zipcode  (
   seq                  NUMBER(10)  not null,
   zipcode              VARCHAR2(50),
   sido                 VARCHAR2(50),
   gugun                VARCHAR2(50),
   dong                 VARCHAR2(50),
   ri                   VARCHAR2(80),
   bunji                VARCHAR2(100),
   constraint PK_ZIPCODE primary key (seq)
);

select * from zipcode where dong like '����%';
SELECT * from zipcode;
desc zipcode;

create table BOARD(
    "NUM" NUMBER(7,0) NOT NULL ENABLE,
    "WRITER" VARCHAR2(12) NOT NULL ENABLE,
    "EMAIL" VARCHAR2(30) NOT NULL ENABLE,
    "SUBJECT" VARCHAR2(50) NOT NULL ENABLE,
    "PASS" VARCHAR2(10) NOT NULL ENABLE,
    "READCOUNT" NUMBER(5,0) DEFAULT 0 NOT NULL ENABLE,
    "REF" NUMBER(5,0) DEFAULT 0 NOT NULL ENABLE,
    "STEP" NUMBER(3,0) DEFAULT 0 NOT NULL ENABLE,
    "DEPTH" NUMBER(3,0) DEFAULT 0 NOT NULL ENABLE,
    "REGDATE" TIMESTAMP (6) DEFAULT SYSDATE NOT NULL ENABLE,
    "CONTENT" VARCHAR2(4000) NOT NULL ENABLE,
    "IP" VARCHAR2(20) NOT NULL ENABLE,
     CONSTRAINT "BOARD_PK" PRIMARY KEY ("NUM") ENABLE
);

CREATE SEQUENCE board_seq 
 START WITH 1 
 INCREMENT BY 1 
 NOMAXVALUE 
 NOCACHE
 NOCYCLE;
 
 
 update board set readcount=readcount+1 where num = 7;
--  readcount +1 ���Ѱ��� �ٽ� �����ش�.
 SELECT * from BOARD;
 DROP table BOARD;