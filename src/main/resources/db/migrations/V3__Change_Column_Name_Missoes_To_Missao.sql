-- V3: Migration para alterar o nome da coluna missoes_id para missao_id com objetivo de melhor entendimento
ALTER TABLE TB_CADASTRO
RENAME COLUMN missoes_id
TO missao_id;
