-- Insere Tamanhos
INSERT INTO TAMANHO (descricao, tempo_preparo, valor) VALUES ('Pequena', 15, 20);
INSERT INTO TAMANHO (descricao, tempo_preparo, valor) VALUES ('Média', 20, 30);
INSERT INTO TAMANHO (descricao, tempo_preparo, valor) VALUES ('Pequena', 25, 40);

-- Insere Sabores
INSERT INTO SABOR (descricao, tempo_adicional) VALUES ('Calabresa', 0);
INSERT INTO SABOR (descricao, tempo_adicional) VALUES ('Marguerita', 0);
INSERT INTO SABOR (descricao, tempo_adicional) VALUES ('Portuguesa', 5);

-- Insere Adicionais
INSERT INTO ADICIONAL (descricao, tempo_preparo, valor) VALUES ('Extra Bacon', 0, 3);
INSERT INTO ADICIONAL (descricao, tempo_preparo, valor) VALUES ('Sem Cebola', 0, 0);
INSERT INTO ADICIONAL (descricao, tempo_preparo, valor) VALUES ('Borda Recheada', 5, 5);