-- V1__create-table-evento.sql
CREATE TABLE evento (
                        id BIGSERIAL PRIMARY KEY,
                        nome VARCHAR(100) NOT NULL,
                        tipo_do_evento VARCHAR(50) NOT NULL,
                        data TIMESTAMP NOT NULL,
                        local VARCHAR(255),
                        descricao TEXT NOT NULL,
                        organizador VARCHAR(100) NOT NULL
);