# Projeto Testes de Caixa Branca - ETAPA 3

## Descrição
Esta branch implementa a **ETAPA 3** do projeto, onde foram realizados os seguintes passos:

- Criado o grafo de fluxo com a identificação dos nós e arestas do código.
- Calculada a complexidade ciclomática do código (resultado: 3).
- Identificados e descritos os 4 caminhos independentes que o código pode percorrer.

# Grafo de fluxo com a identificação dos nós e arestas do código

![Grafo teste cx branca](https://github.com/user-attachments/assets/1ae5eb63-8895-4360-9d68-9bb655068c74)

# Calculada a complexidade ciclomática do código

Complexidade Ciclomática
A complexidade ciclomática é calculada pela fórmula:

𝑀 = 𝐸 − 𝑁 +2𝑃

E: Número de arestas (conexões entre os nós).
N: Número de nós.
P: Número de componentes conexos (neste caso, é 1, pois temos um único grafo).

Com base no grafo:
Número de Nós (N): 12.
Número de Arestas (E): 13.
Número de Componentes Conexos (P): 1.

M =  E - N + 2P
M = 13 - 12 + 2 x 1
M = 13 - 12 + 2
M = 1 + 2
M = 3

 # 𝑀 = 13 − 12 + 2 × 1 = 3
A complexidade ciclomática do código é 3.

# Identificação e descrição dos 3 caminhos independentes que o código pode percorrer
 - Caminho 1, percorre todo o fluxo até o tratamento da exceção (caso de falha na conexão):
   
(1)Início → (2)Declara conexão → (3)Tenta conectar → (4)Exceção conectar → (3)Tenta conectar → (5)Retorna conexão → (6)Declara Query → (7)Chama conectarBD → (8)Monta query SQL → (9)Criação de Statement e execução da query → (10)Verifica se a query retornou resultados → (11)Tratamento de Exceção → (10)Verifica se a query retornou resultados → (12)Retorna resultado.

- Caminho 2, segue o fluxo em que a consulta retorna um nome válido:
  
(1)Início → (2)Declara conexão → (3)Tenta conectar → (5)Retorna conexão → (6)Declara Query → (7)Chama conectarBD → (8)Monta query SQL → (9)Criação de Statement e execução da query → (10)Verifica se a query retornou resultados → (12)Retorna resultado.

- Caminho 3, segue o fluxo onde a consulta não retorna nenhum resultado:
  
(1)Início → (2)Declara conexão → (3)Tenta conectar → (5)Retorna conexão → (6)Declara Query → (7)Chama conectarBD → (8)Monta query SQL → (9)Criação de Statement e execução da query → (10)Verifica se a query retornou resultados →  Não entra no if  → (12)Retorna resultado.







