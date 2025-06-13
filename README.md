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

### 📂 Gerenciamento de Usuários (`GerenciamentoUsuarios.java`)

Esta classe centraliza o controle de **cadastro**, **remoção** e **persistência** de dados de **clientes** e **funcionários**, incluindo a criação automática de um usuário administrador padrão (`admin`). Ela utiliza **serialização em arquivos (`.txt`)** para salvar e carregar os dados.

**Principais responsabilidades:**

- Carregar e salvar os dados de clientes e funcionários via arquivos (`Clientes.txt`, `Funcionarios.txt`).
- Garantir que um funcionário administrador (`CPF = "admin"`) esteja presente.
- Métodos para adicionar, remover e listar clientes e funcionários.
- Verificação de privilégios de administrador.

### 🎟️ Controle ingressos (`ControleIngressos.java`)

Este controlador é responsável pela venda, cancelamento e verificação de ingressos das sessões de cinema. Ele interage com as classes ControleSessao, Sala e Sessao.

**Métodos principais**

- **venderIngresso(...)**  
  Realiza a venda de um ingresso para um cliente:  
  - Verifica se a sessão e o assento existem e estão disponíveis;  
  - Reserva o assento;  
  - Cria o ingresso e o adiciona à sessão;  
  - Diminui a contagem de ingressos disponíveis.
- **cancelarIngresso(...)**  
  Permite ao cliente cancelar o ingresso caso já tenha um para a sessão indicada.
- **clienteTemIngresso(...)**  
  Verifica se o cliente já possui um ingresso para uma determinada sessão.

### 🎬 Controle de sessão (`ControleSessao.java`)

Esta classe é responsável por gerenciar as sessões de filmes, como cadastrar, listar e recuperar sessões específicas.

*Métodos principais*

- **criarComSessoesPadrao()**  
  Cria um controle de sessões com três salas e filmes pré-definidos, em horários diferentes. Usa os filmes do catálogo existente (`Catalogo.getFilmes()`).
  
- **listarSessoes()**  
  Retorna todas as sessões cadastradas.
  
- **listarSessoesPorFilme(String nomeFilme)**  
  Retorna todas as sessões que estão exibindo um filme com o título correspondente.
  
- **exibirSessoes()**  
  Exibe todas as sessões formatadas, mostrando o nome do filme, sala, horário e quantidade de assentos livres.
- **verificaSessao(int idSessao)**
  Verifica se a sessão com o ID especificado existe.
  
- **adicionarSessao(Sessao sessao)**  
  Adiciona uma nova sessão ao sistema.
  
- **getSessaoPorId(int id)**  
  Retorna a sessão com base no ID informado, se existir.

## Considerações finais
O CinemaJava é um projeto desenvolvido para a faculdade, no qual cinco amigos se uniram para criar um sistema completo para um cinema. Foi um desafio, mas também uma ótima oportunidade de aprendizado. Utilizamos o ChatGPT e o Gemini para ajudar no tratamento de erros e para deixar a interface mais atraente e funcional.

Esse projeto pode e deve receber atualizações no futuro, com novas funcionalidades e melhorias constantes.


## 👨‍💻 Autores

Desenvolvido por: 
- [Eduardo Alves](https://github.com/eduaki) 
- [Alex Silva](https://github.com/alexhonorato) 
- [Tainara Lashowski](https://github.com/tailachowski) 
- [Bruna Dadona](https://github.com/BrunaDadona) 
- [Michelle Bornes](https://github.com/MichelleBornes)
