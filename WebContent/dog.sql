-- �ֿϰ� ���θ����
create table dog (
id number primary key,
kind varchar2(12) not null,
price number not null,
image varchar2(20) not null,
country varchar2(12) not null,
height number,
weight number,
content varchar2(400),
readcount number
);

create SEQUENCE dog_seq;
select * from dog;
insert into dog values(dog_seq.nextval, 'Ǫ��', 1000, 'pu.jpg', '������', 1, 20, '����� Ȱ����', 0);
insert into dog values(dog_seq.nextval, '�ҵ���', 2000, 'bul.jpg', '����', 1, 20, '����� �߻���', 0);
insert into dog values(dog_seq.nextval, '������', 3000, 'jin.jpg', '���ѹα�', 1, 20, '����� ����ϰ� �ʶ���', 0);
insert into dog values(dog_seq.nextval, '�㽺Ű', 4000, 'h.jpg', '�ϱ�', 1, 20, '���� ������', 0);
