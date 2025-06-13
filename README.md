# Uniclinica Vet

Pequeno sistema em Java para gerenciar uma clínica veterinária. A interface gráfica é feita com Swing e o armazenamento utiliza MySQL.

## Requisitos
- JDK 17 ou superior
- Banco MySQL configurado

Crie um arquivo `.env` na raiz com as variáveis `DB_URL`, `DB_USER` e `DB_PASS` (existe um arquivo `.env.example` como modelo).

## Como executar

Abra um terminal na pasta do projeto e execute:

```bash
./run_swing_nomaven.sh
```

O script baixa as dependências necessárias, compila os fontes e inicia a interface Swing para cadastro de tutores, animais, consultas e exames.
