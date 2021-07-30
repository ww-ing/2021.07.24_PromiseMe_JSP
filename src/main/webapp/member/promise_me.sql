create table member(
    idx number(8) constraint member_pk primary key,
    name varchar2(30) not null,
    userid varchar2(20) constraint member_userid_uk unique,
    pwd varchar2(20) not null,
    hp1 char(3) not null, -- 연락처 앞자리
    hp2 char(4) not null,
    hp3 char(4) not null,
    zipcode char(5),
    addr1 varchar2(200),
    addr2 varchar2(200),
    indate date default sysdate, --등록일
    mileage number(10) default 1000,
    mstate number(1) default 0 --회원상태(활동회원:0, 정지회원:1, 탈퇴회원:-1)
    constraint member_mstate_ck check (mstate in (-1, 0, 1))
);

CREATE SEQUENCE member_seq
INCREMENT BY 1
START WITH 1
MINVALUE 1 
MAXVALUE 100
NOCYCLE;

create or replace view member_view
as
select * from member where mstate>-1;

select * from member order by idx asc;