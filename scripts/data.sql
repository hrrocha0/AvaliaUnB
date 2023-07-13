-- Inserção de Dados

INSERT INTO Estudante
VALUES ('000000000', 'Admin', 'admin@unb.br', '0000', 1, 2);

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
