create schema data;

create table data.some_data {
    id serial primary key,
    nome varchar(50) not null,
    email varchar(100) not null,
    created_at timestamp default current_timestamp
};

insert into data.some_data (nome, email) values ('nome 1', 'nome1@email.com');
insert into data.some_data (nome, email) values ('nome 2', 'nome2@email.com');
insert into data.some_data (nome, email) values ('nome 3', 'nome3@email.com');
insert into data.some_data (nome, email) values ('nome 4', 'nome4@email.com');
insert into data.some_data (nome, email) values ('nome 5', 'nome5@email.com');
insert into data.some_data (nome, email) values ('nome 6', 'nome6@email.com');
insert into data.some_data (nome, email) values ('nome 7', 'nome7@email.com');
insert into data.some_data (nome, email) values ('nome 8', 'nome8@email.com');
insert into data.some_data (nome, email) values ('nome 9', 'nome9@email.com');
insert into data.some_data (nome, email) values ('nome 10', 'nome10@email.com');
insert into data.some_data (nome, email) values ('nome 11', 'nome11@email.com');
