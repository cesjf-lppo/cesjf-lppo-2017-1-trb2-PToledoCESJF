DROP TABLE Leitura;
DROP TABLE Coleta;

CREATE TABLE Coleta(
    idColeta INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    descricao VARCHAR(50) NOT NULL,
    dataColeta DATE);

CREATE TABLE Leitura(
    idLeitura INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    coleta INTEGER NOT NULL,
    localLeitura VARCHAR(50) NOT NULL,
    leitura REAL,
    unidade VARCHAR(50) NOT NULL,
    atualizacao TIMESTAMP,
    CONSTRAINT FK_Leitura_Cl FOREIGN KEY(coleta) REFERENCES Coleta(idColeta));

    

