create sequence usuario_seq increment by 1 start with 1 nocache nocycle;

create table usuario
  (
    id number(8) primary key not null,
    nome VARCHAR2(200),
    login varchar2(12) unique,
    senha varchar2(6)
  
  );
  

create table livro

  (
    id number(8) primary key not null,
    titulo VARCHAR(200) not null,
    autor  VARCHAR(200) not null,
    isbn varchar(13) not null,
    paginas INT not null,
    edicao int not null
  
  );

create sequence livro_seq increment by 1 start with 1 nocache nocycle;  
  

  
select * from usuario;
select login from usuario where login = 'luizfs';

alter table usuario

    add constraint login_un unique (login) ENABLE
;

update usuario set nome = 'maria abadia martins', senha = '123'
  where id= 12;
  
  
  DELETE FROM USUARIO
    WHERE id = 24;

drop table usuario;