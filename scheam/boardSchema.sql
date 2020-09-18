drop table board;

create table board(
	board_no int primary key,--글번호
	subject varchar2(30) not null,--제목
	writer varchar2(20) not null,--작성자
	content varchar2(50) not null,--내용
	board_date date not null--등록일
); 

create table reboard(
 board_no int primary key,
 content varchar2(50) not null,
 pri_no int references board(board_no),
 board_date date not null
);

select*from reboard where pri_no=?

--시퀀스 만들기 전에 권한 부여(system계정에서만 가능)
grant  create sequence  to scott;

  
--시퀀스 만들기
create sequence board_seq nocache; 
create sequence reboard_seq nocache;
insert into reboard values(reboard_seq.nextval,?,?,sysdate)
select*from reboard;
select * from board;

commit

insert into board (board_no, subject, writer, content, board_date) 
values (board_seq.nextval, 'db수업', '장희정', '잼난다', sysdate)

/**
 * 댓글테이블생성(댓글번호,내용,부모글번호,등록일)
 * -댓글번호는 시퀀스로 만든다.
 *  
 * 자바기능
 * 1)글번호에 해당하는 댓글정보 검색하기
 * 2)댓글등록
 * */




