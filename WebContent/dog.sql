-- ¾Ö¿Ï°ß ¼îÇÎ¸ôµðºñ
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
insert into dog values(dog_seq.nextval, 'Çªµé', 1000, 'pu.jpg', 'ÇÁ¶û½º', 1, 20, '¹«Àð°Ô È°´ÞÇÔ', 0);
insert into dog values(dog_seq.nextval, 'ºÒµµ±×', 2000, 'bul.jpg', 'µ¶ÀÏ', 1, 20, '¹«Àð°Ô Àß»ý±è', 0);
insert into dog values(dog_seq.nextval, 'Áøµ¾°³', 3000, 'jin.jpg', '´ëÇÑ¹Î±¹', 1, 20, '¹«Àð°Ô ¿ë¸ÍÇÏ°í ¶Ê¶ÊÇÔ', 0);
insert into dog values(dog_seq.nextval, 'Çã½ºÅ°', 4000, 'h.jpg', 'ºÏ±Ø', 1, 20, '°¡Àå ¸ÚÁö´Ù', 0);
