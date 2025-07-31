INSERT INTO empresa (
    cnpj,
    email,
    nome_fantasia,
    razao_social,
    senha,
    telefone,
    tipo,
    natureza_juridica,
    capital_social,
    abertura,
    situacao_empresa
) VALUES (
    '12345678000199',
    'empresa@email.com',
    'Empresa XYZ',
    'Empresa XYZ LTDA',
    '$2a$10$rP1Ock2q2aNcUG.ZSpPe3OgXeAXUb1VmGRTG5epTjXhZu9f/EzPei',
    '(11) 98765-4321',
    'MATRIZ',
    '213-5 - Empresário (Individual)',
    10.00,
    '2025-07-30',
    1
),(
      '98765432000188',
      'contato@empresaabc.com',
      'Empresa ABC',
      'Empresa ABC S.A.',
      '$2a$10$abc123456789xyz09876543uU1AxYn2PLM9qZV2ZspPeOck2GRTG5e', -- senha fictícia
      '(21) 99876-5432',
      'MATRIZ',
      '213-5 - Empresário (Individual)',
      10.00,
      '2025-07-30',
      1
  ),
  (
      '11222333000144',
      'suporte@tecnologia.com',
      'Tecno Solutions',
      'Tecno Solutions ME',
      '$2a$10$123senha456cript789zxyabcdEfghPQrsLMnoTUVwxYZ/1HgG1z', -- senha fictícia
      '(31) 91234-5678',
      'MATRIZ',
      '213-5 - Empresário (Individual)',
      10.00,
      '2025-07-30',
      1
  );

insert into cargo (nome, ativo) values
('capinteiro', true),
('analista de sistemas', true),
('gerente de projetos', true),
('desenvolvedor backend', true),
('auxiliar administrativo', true);


INSERT INTO horario_trabalho (
    id, created_at, updated_at
) VALUES (
    1, '2025-07-19', '2025-07-19'
),(2, '2025-07-20', '2025-07-20'),
      (3, '2025-07-21', '2025-07-21'),
      (4, '2025-07-22', '2025-07-22');

insert into role (name) values ('ROLE_ADMINISTRATOR')
