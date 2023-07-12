-- Criação das Relações

CREATE TABLE Departamento
(
    id    INT            NOT NULL,
    sigla CHAR(3) UNIQUE NOT NULL,
    nome  VARCHAR(100)   NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE PouD
(
    id INT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Professor
(
    id        INT            NOT NULL,
    matricula CHAR(9) UNIQUE NOT NULL,
    nome      VARCHAR(100)   NOT NULL,
    email     VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE Disciplina
(
    id              INT          NOT NULL,
    codigo          INT UNIQUE   NOT NULL,
    nome            VARCHAR(100) NOT NULL,
    descricao       VARCHAR,
    id_departamento INT          NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_departamento) REFERENCES Departamento (id)
);

CREATE TABLE Curso
(
    id              INT          NOT NULL,
    nome            VARCHAR(100) NOT NULL,
    id_departamento INT          NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_departamento) REFERENCES Departamento (id)
);

CREATE TABLE Estudante
(
    matricula CHAR(9)             NOT NULL,
    nome      VARCHAR(100)        NOT NULL,
    email     VARCHAR(100) UNIQUE NOT NULL,
    senha     VARCHAR(100)        NOT NULL,
    admin     BIT                 NOT NULL,
    id_curso  INT,
    PRIMARY KEY (matricula),
    FOREIGN KEY (id_curso) REFERENCES Curso (id)
);

CREATE TABLE Avaliacao
(
    id_p_ou_d           INT           NOT NULL,
    id                  INT           NOT NULL,
    nota                DECIMAL(2, 2) NOT NULL,
    comentario          VARCHAR,
    matricula_estudante CHAR(9)       NOT NULL,
    PRIMARY KEY (id_p_ou_d, id),
    FOREIGN KEY (matricula_estudante) REFERENCES Estudante (matricula)
);

CREATE TABLE Denuncia
(
    id_p_ou_d           INT     NOT NULL,
    id_avaliacao        INT     NOT NULL,
    id                  INT     NOT NULL,
    comentario          VARCHAR,
    matricula_estudante CHAR(9) NOT NULL,
    matricula_avaliador CHAR(9),
    PRIMARY KEY (id_p_ou_d, id_avaliacao, id),
    FOREIGN KEY (id_p_ou_d, id_avaliacao) REFERENCES Avaliacao (id_p_ou_d, id),
    FOREIGN KEY (matricula_estudante) REFERENCES Estudante (matricula),
    FOREIGN KEY (matricula_avaliador) REFERENCES Estudante (matricula)
);

CREATE TABLE ProfessorDepartamento
(
    id_professor    INT NOT NULL,
    id_departamento INT NOT NULL,
    PRIMARY KEY (id_professor, id_departamento),
    FOREIGN KEY (id_professor) REFERENCES Professor (id),
    FOREIGN KEY (id_departamento) REFERENCES Departamento (id)
);

CREATE TABLE ProfessorDisciplina
(
    id_professor  INT NOT NULL,
    id_disciplina INT NOT NULL,
    PRIMARY KEY (id_professor, id_disciplina),
    FOREIGN KEY (id_professor) REFERENCES Professor (id),
    FOREIGN KEY (id_disciplina) REFERENCES Disciplina (id)
);

CREATE TABLE Turma
(
    id_professor  INT NOT NULL,
    id_disciplina INT NOT NULL,
    id            INT NOT NULL,
    horario       VARCHAR(30),
    PRIMARY KEY (id_professor, id_disciplina, id),
    FOREIGN KEY (id_professor, id_disciplina) REFERENCES ProfessorDisciplina (id_professor, id_disciplina)
);

-- Criação das Views

CREATE VIEW Perfil AS
SELECT E.matricula, E.nome, E.email, E.admin, C.nome AS curso
FROM Estudante E
         INNER JOIN Curso C on C.id = E.id_curso;

-- Inserção de Dados

INSERT INTO Estudante
VALUES ('000000000', 'Admin', 'admin@unb.br', '0000', 1, NULL);

INSERT INTO Departamento
VALUES (1, 'MAT', 'Departamento de Matemática'),
       (2, 'CIC', 'Depto. Ciências da Computação'),
       (3, 'FDD', 'Faculdade de Direito'),
       (4, 'IFD', 'Instituto de Física');

INSERT INTO Curso
VALUES (1, 'Matemática', 1),
       (2, 'Ciência da Computação', 2),
       (3, 'Computação', 2),
       (4, 'Engenharia da Computação', 2),
       (5, 'Direito', 3),
       (6, 'Física', 4),
       (7, 'Física Computacional', 4);