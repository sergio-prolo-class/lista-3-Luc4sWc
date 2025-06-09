# Correção

| Questão     | Legibilidade | Diagramas | P1 | P2 | P3 | Total |
|-------------|--------------|-----------|----|----|----|-------|
| Nota máxima | 10           | 10        | 20 | 25 | 35 | 100   |
| Nota        | 8            | 5         | 18 | 25 | 30 |       |

## Diagramas

- imagem difícil de ler... tive que ir atrás do link.
- associações sem multiplicidade, sem as setas corretas
- métodos sem tipo de retorno
- alguns atributos escritos com tipo e nome invertidos

## P1

- muito perto de fazer o conjunto de usuários correto. só faltou a parte de ignorar maiúsculas!
- listar usuários com ambos login e senha é uma falha de segurança

### Requisitos Funcionais
- [x] Cadastrar novos usuários
- [x] Remover usuários
- [x] Listar os logins
- [x] Autenticar usuários

## P2

- informação duplicada: clientes com atributo telefone armazenados em um mapa de telefone -> cliente
- usar Deque.remove() pode gerar uma exceção! é melhor usar .poll()
- mesma coisa com .getFirst(), melhor usar .peek()
- no construtor da Solicitacao, não entendi os assert client != null.

### Requisitos Funcionais
- [x] Registrar novas solicitações
- [x] Listar os telefones dos clientes registrados
- [x] Imprimir o nome do próximo cliente
- [x] Atender o próximo cliente
- [x] Listar os nomes dos clientes já atendidos
- [x] Listar os telefones dos clientes em espera
- [x] Gerar um relatório estatístico
- [x] ... total de solicitações registradas, atendidas, em espera
- [x] ... distribuição percentual das solicitações por categoria

## P3

- Leitores
  - deveria ser Leitor, nome de classe é sempre no singular
  - fornecer um método público que altera o ID de um objeto não é uma boa ideia
- Autor
  - como objetos Autor são usados em um Set, Autor.equals() e hashCode() devem ser sobrescritos
- Sistema
  - informações duplicadas
    - Livros com atributo isbn armazenados em um mapa de isbn -> Livro
    - Leitor com atributo id armazenado em um mapa de id -> Leitor
  - listagens
    - livros deixa a ordem natural do HashMap
    - para usar a solução do .compareTo, deveria ser um TreeMap
    - Leitores por ID você só imprime os Ids, mas não muda a ordem... vai ficar na ordem do mapa

### Requisitos Funcionais
- [x] Cadastrar autores
- [x] Cadastrar livros
- [x] Cadastrar leitores
- [x] Registrar empréstimos de livros para leitores
- [x] ... pelo menos uma cópia
- [ ] ... leitor não tenha esse livro
- [x] ... leitor possua no máximo 5 livros emprestados
- [x] Listar autores em ordem alfabética
- [x] Listar leitores em ordem alfabética
- [ ] Listar leitores por id
- [ ] Listar livros por título
- [x] Listar livros por autor
- [ ] Listar livros por ISBN
- [x] Listar empréstimos por data
- [x] Listar empréstimos de um leitor, por data