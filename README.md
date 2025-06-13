# 🎬 CinemaJava

Um sistema completo de gerenciamento para cinemas, desenvolvido em Java, com
funcionalidades de cadastro, venda de ingressos, gerenciamento de sessões,
controle de usuários e pedidos de lanchonete — tudo em interface via terminal.

## 📌 Funcionalidades

- 📽 Cadastro de filmes, sessões e usuários
- 🎟 Venda e cancelamento de ingressos
- 🍿 Controle de produtos da lanchonete e pedidos
- 👥 Diferenciação entre usuários e funcionários
- 💾 Persistência simples com arquivos `.txt`
- 🎨 Mapa visual de assentos com cores no terminal (livre/ocupado)

## 🧱 Estrutura do Projeto

```
src/
├── controller/         # Lógicas de controle e navegação entre menus
├── model/              # Entidades do sistema (Filme, Sala, Sessão, etc.)
├── utilidades/         # Utilitários (ex: input helper)
├── view/               # Interfaces de menu exibidas ao usuário
├── App.java            # Ponto de entrada da aplicação
```

## 🚀 Como executar

1. Clone o repositório:

```bash
git clone https://github.com/eduaki/CinemaJava.git
```

2. Compile o projeto:

```bash
javac src/App.java
```

3. Execute:

```bash
java -cp src App
```

> **Obs:** Recomendado usar terminal com suporte a cores ANSI (como o do VSCode
> ou Git Bash) para melhor visualização dos assentos.

## 📁 Arquivos

- `Clientes.txt`, `Funcionarios.txt`, `Pedidos.txt` — simulação de persistência
- `.gitignore`, `.iml` — arquivos de configuração do projeto IntelliJ

## 💡 Tecnologias utilizadas

- Java 17
- Programação Orientada a Objetos (POO)
- Terminal ANSI para estilização
- Leitura e escrita em arquivos `.txt`

## 📷 Exemplo da interface (assentos coloridos)

```plaintext
A1 A2 A3 A4 A5 A6
B1 B2 B3 B4 B5 B6
...
```

🟩 = disponível  🟥 = ocupado

## 👨‍💻 Autores

Desenvolvido por: [Eduardo Alves](https://github.com/eduaki)
[Alex Silva](https://github.com/alexhonorato)
[Tainara Lashowski](https://github.com/tailachowski)
[Bruna dadona](https://github.com/BrunaDadona)
[Michelle Bornes](https://github.com/MichelleBornes)
