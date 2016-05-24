create sequence usuario_seq increment by 1 start with 1 nocache nocycle;

create table usuario
  (
    id number(8) primary key not null,
    nome VARCHAR2(200),
    login varchar2(12),
    senha varchar2(6)
  
  );
  
select * from usuario;

