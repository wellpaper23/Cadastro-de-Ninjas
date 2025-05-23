-- V2: Migrations para adicionar RANK na tabela de cadastros
ALTER TABLE tb_cadastro
ADD COLUMN  rank VARCHAR(255);