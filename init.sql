CREATE TABLE Avaliacao
(
    codigo_p_ou_d       INT     NOT NULL,
    codigo              INT     NOT NULL,
    nota                INT     NOT NULL,
    comentario          VARCHAR,
    matricula_estudante CHAR(9) NOT NULL,
    PRIMARY KEY (codigo_p_ou_d, codigo),
    FOREIGN KEY (codigo_p_ou_d) REFERENCES ProfessorOuDisciplina (codigo)
);

CREATE TABLE Curso
(
    codigo       INT     NOT NULL,
    nome         VARCHAR NOT NULL,
    codigo_depto INT     NOT NULL,
    PRIMARY KEY (codigo),
    FOREIGN KEY (codigo_depto) REFERENCES Departamento (codigo)
);

CREATE TABLE Denuncia
(
    codigo_p_ou_d           INT     NOT NULL,
    codigo_avaliacao        INT     NOT NULL,
    codigo                  INT     NOT NULL,
    comentario              VARCHAR,
    matricula_estudante     CHAR(9) NOT NULL,
    matricula_administrador CHAR(9),
    PRIMARY KEY (codigo_p_ou_d, codigo_avaliacao, codigo),
    FOREIGN KEY (codigo_p_ou_d, codigo_avaliacao) REFERENCES Avaliacao (codigo_p_ou_d, codigo),
    FOREIGN KEY (matricula_estudante) REFERENCES Estudante (matricula),
    FOREIGN KEY (matricula_administrador) REFERENCES Estudante (matricula)
);

CREATE TABLE Departamento
(
    codigo INT     NOT NULL,
    nome   VARCHAR NOT NULL,
    PRIMARY KEY (codigo)
);

CREATE TABLE Disciplina
(
    codigo_p_ou_d INT            NOT NULL,
    codigo        VARCHAR UNIQUE NOT NULL,
    nome          VARCHAR        NOT NULL,
    codigo_depto  INT            NOT NULL,
    PRIMARY KEY (codigo_p_ou_d),
    FOREIGN KEY (codigo_depto) REFERENCES Departamento (codigo),
    FOREIGN KEY (codigo_p_ou_d) REFERENCES ProfessorOuDisciplina (codigo)
);

CREATE TABLE Estudante
(
    matricula     CHAR(9) NOT NULL,
    nome          VARCHAR NOT NULL,
    email         VARCHAR NOT NULL,
    senha         VARCHAR NOT NULL,
    administrador BIT     NOT NULL,
    codigo_curso  INT     NOT NULL,
    PRIMARY KEY (matricula),
    FOREIGN KEY (codigo_curso) REFERENCES Curso (codigo)
);

CREATE TABLE Professor
(
    codigo_p_ou_d INT            NOT NULL,
    nome          VARCHAR UNIQUE NOT NULL,
    codigo_depto  INT            NOT NULL,
    PRIMARY KEY (codigo_p_ou_d),
    FOREIGN KEY (codigo_depto) REFERENCES Departamento (codigo),
    FOREIGN KEY (codigo_p_ou_d) REFERENCES ProfessorOuDisciplina (codigo)
);

CREATE TABLE ProfessorOuDisciplina
(
    codigo INT NOT NULL,
    PRIMARY KEY (codigo)
);

CREATE TABLE Turma
(
    codigo_disciplina VARCHAR NOT NULL,
    codigo            INT     NOT NULL,
    periodo           CHAR(6) NOT NULL,
    nome_professor    VARCHAR NOT NULL,
    horario           VARCHAR NOT NULL,
    vagas_ocupadas    INT     NOT NULL,
    total_vagas       INT     NOT NULL,
    local             VARCHAR NOT NULL,
    codigo_depto      INT     NOT NULL,
    PRIMARY KEY (codigo_disciplina, codigo, periodo),
    FOREIGN KEY (codigo_disciplina) REFERENCES Disciplina (codigo),
    FOREIGN KEY (nome_professor) REFERENCES Professor (nome),
    FOREIGN KEY (codigo_depto) REFERENCES Departamento (codigo)
);

CREATE VIEW Perfil AS
SELECT E.matricula, E.nome, E.email, E.administrador, C.nome AS nome_curso
FROM Estudante E
         INNER JOIN Curso C on C.codigo = E.codigo_curso;

INSERT INTO Curso
VALUES (1, 'Indefinido', 0),
       (2, 'Ciência da Computação', 508);

INSERT INTO Estudante
VALUES ('000000000', 'Admin', 'admin@unb.br', '0000', 1, 1);