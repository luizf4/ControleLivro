drop table usuario;
drop table livro;
drop table emprestimo;

create sequence usuario_seq increment by 1 start with 1 nocache nocycle;

create table usuario
  (
    id number(8) primary key not null,
    nome VARCHAR2(200),
    login varchar2(12) unique,
    senha varchar2(6)
  
  );

select * from usuario;

create sequence livro_seq increment by 1 start with 1 nocache nocycle;

create table livro

  (
    id number(8) primary key not null,
    titulo VARCHAR(200) not null,
    autor  VARCHAR(200) not null,
    isbn varchar(13) not null,
    paginas INT not null,
    edicao int not null,
    emprestado NUMBER(1) DEFAULT 0 NOT NULL
  
  );
  

select * from livro;

create sequence emprestimo_seq increment by 1 start with 1 nocache nocycle;

create table Emprestimo 
  (
    id number(8) primary key not null,
    idUsuario number(8) not null,
    idLivro number (8) not null,
    dataEmprestimo date not null,
    dataDevolucao date

  );
  
alter table Emprestimo
  add constraint fk_usuario_emprestimo 
  FOREIGN key (idUsuario) references usuario(id);

alter table Emprestimo
  add constraint fk_livro_emprestimo 
  FOREIGN key (idLivro) references livro(id);

  
select  liv.titulo, liv.autor, liv.isbn, liv.paginas, liv.edicao, us.ID, us.LOGIN, liv.emprestado
  
  from livro liv
  
  left outer join emprestimo emp
  on (liv.ID = emp.IDLIVRO)
  
  left outer join usuario us
  on (emp.IDUSUARIO = us.id and emp.DATADEVOLUCAO is null)
  
  order by liv.TITULO;
  
  select * from livro
  order by livro.titulo;
  select * from emprestimo;
  
  
  select * from emprestimo
    WHERE IDLIVRO = 2 and DATADEVOLUCAO is null;
    
 select  liv.titulo, liv.autor, liv.isbn, liv.paginas, liv.edicao, us.ID, 
 us.LOGIN, liv.emprestado, emp.DATAEMPRESTIMO, emp.DATADEVOLUCAO
  
  from livro liv
  
  left outer join emprestimo emp
  on (liv.ID = emp.IDLIVRO)
  
  left outer join usuario us
  on (emp.IDUSUARIO = us.id)
  
  order by liv.TITULO;  
  


select liv.id, liv.titulo, us.LOGIN from emprestimo emp
  inner join livro liv
  on (emp.IDLIVRO = liv.ID)
  
  inner join usuario us
  on (emp.IDUSUARIO = us.id)  
  WHERE emp.datadevolucao is not null;

