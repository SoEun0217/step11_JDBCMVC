drop table board;

create table board(
	board_no int primary key,--�۹�ȣ
	subject varchar2(30) not null,--����
	writer varchar2(20) not null,--�ۼ���
	content varchar2(50) not null,--����
	board_date date not null--�����
); 

create table reboard(
 board_no int primary key,
 content varchar2(50) not null,
 pri_no int references board(board_no),
 board_date date not null
);

select*from reboard where pri_no=?

--������ ����� ���� ���� �ο�(system���������� ����)
grant  create sequence  to scott;

  
--������ �����
create sequence board_seq nocache; 
create sequence reboard_seq nocache;
insert into reboard values(reboard_seq.nextval,?,?,sysdate)
select*from reboard;
select * from board;

commit

insert into board (board_no, subject, writer, content, board_date) 
values (board_seq.nextval, 'db����', '������', '�볭��', sysdate)

/**
 * ������̺����(��۹�ȣ,����,�θ�۹�ȣ,�����)
 * -��۹�ȣ�� �������� �����.
 *  
 * �ڹٱ��
 * 1)�۹�ȣ�� �ش��ϴ� ������� �˻��ϱ�
 * 2)��۵��
 * */




