create table evento(

                       nome varchar(100) not null,
                       Tipo_Do_Evento varchar(50) not null,

                       date_inicial timestamp not null,
                       date_End timestamp not null,

                       local varchar(255),

                       descrição TEXT not null ,

                       organizador varchar(100) not null
);