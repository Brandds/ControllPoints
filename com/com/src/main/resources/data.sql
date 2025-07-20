INSERT INTO empresa (
    cnpj,
    email,
    nome_fantasia,
    razao_social,
    senha,
    telefone
) VALUES (
    '12345678000199',
    'empresa@email.com',
    'Empresa XYZ',
    'Empresa XYZ LTDA',
    '$2a$10$rP1Ock2q2aNcUG.ZSpPe3OgXeAXUb1VmGRTG5epTjXhZu9f/EzPei',
    '(11) 98765-4321'
);

insert into cargo (nome) values ('capinteiro');

INSERT INTO horario_trabalho (
    id, created_at, updated_at
) VALUES (
    1, '2025-07-19', '2025-07-19'
);

insert into role (name) values ('ROLE_ADMINISTRATOR')
