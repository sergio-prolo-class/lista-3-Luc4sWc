<h1> Diagrama </h1>
  
![Image](https://github.com/user-attachments/assets/56083f98-954f-42aa-894a-ce1e1523d15f)

_____________________________________________________________________________________________
<h1>📚 Sistema de Gestão Modular (Login, Atendimento e Biblioteca)</h1>

Este projeto Java é organizado em três pacotes principais com funcionalidades independentes, mas que podem ser integradas. Cada pacote contém classes com responsabilidade única e uma classe main que demonstra suas respectivas funcionalidades.

<h1>📦 Estrutura do Projeto

```
src/
├── ifsc/
│   └── poo/
│       ├── login/
│       │   ├── Usuario.java
│       │   └── Login.java           <- Classe principal (main)
│       ├── atendimento/
│       │   ├── Cliente.java
│       │   ├── Solicitacao.java
│       │   └── Atendimento.java     <- Classe principal (main)
│       └── biblioteca/
│           ├── Autor.java
│           ├── Emprestimos.java
│           ├── Leitores.java
│           ├── Livro.java
│           └── Sistema.java        <- Classe principal (main)
```
___________________________________________________________________________

<h1>🔐 Pacote login</h1>

Gerencia usuários do sistema.
Principais classes:

    Usuario: Representa um usuário com login e senha, sobrescrevendo ```equals()``` e ```hashCode()``` para autenticação.
    
    Login (classe principal):
        Cadastra usuários.
        Lista todos os logins e senhas.
        Remove logins pelo nome.
        Autentica usuários.
____________________________________________________________________________

```
Exemplo de uso (em main):

cadastrarLogin("João", "12345678");
listarLogin();
autenticarLogin("João", "12345678");
```
____________________________________________________________________________

<h1>🧾 Pacote atendimento</h1>

Gerencia solicitações de atendimento feitas por clientes.
Principais classes:

    Cliente: Armazena dados básicos como nome e telefone.

    Solicitacao: Representa uma solicitação feita por um cliente.

    Atendimento (classe principal):
        Registra solicitações em uma fila.
        Atende solicitações em ordem.
        Lista clientes atendidos ou em espera.
        Gera relatório por categoria.
_____________________________________________________________________________
```
Exemplo de uso (em main):

registrarSolicitacao("Zanildo", "555-445-655", "Não consigo sacar meu FGTS", "Atendimento Financeiro");
atenderProximoCliente();
gerarRelatorio();
```
_____________________________________________________________________________

<h1>📖 Pacote biblioteca</h1>

Simula o controle de uma biblioteca, incluindo leitores, autores, livros e empréstimos.
Principais classes:

    Autor: Representa um autor e permite ordenação por nome.

    Livro: Contém título, ISBN e um conjunto de autores.

    Leitores: Representa um leitor e contém ID único, nome, endereço e telefone.

    Emprestimos: Associa um leitor a um livro com uma data de empréstimo.

    Sistema (classe principal):
        Cadastra leitores e livros.
        Registra empréstimos (limitado a 5 por leitor).
        Lista dados organizados por data, título, ID, etc.
______________________________________________________________________________
```
Exemplo de uso (em main):

cadastrarLeitor("Maria", "Rua X", "99999-9999");
cadastrarLivro("Aventuras de Java", 1234, 3, autores);
registrarEmprestimos(1, 1234, "2025-05-21");
listarEmprestimosPorData();
```
______________________________________________________________________________

<h1>✅ Funcionalidades Extras e Validações</h1>
    
- Validação de entradas nulas ou vazias.
- Controle de limite de empréstimos por leitor (máx. 5).
- Cópias disponíveis por livro.
- Relatórios percentuais por categoria de atendimento.
- Impressões organizadas e ordenadas com uso de Collections.
