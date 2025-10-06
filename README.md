# 🍻 A Boa

**A Boa** é uma aplicação backend desenvolvida em **Java 17 com Spring Boot**, criada para facilitar a **divulgação e o gerenciamento de eventos**.  
A API segue o padrão **RESTful**, com endpoints para **criar, listar, atualizar e deletar** eventos.  
O banco de dados **PostgreSQL** roda via **Docker Compose**, garantindo praticidade no setup e isolamento do ambiente.

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
  - Spring Web
  - Spring Data JPA
  - Spring Validation
- **PostgreSQL (via Docker Compose)**
- **Maven**
- **Swagger / OpenAPI** (para documentação dos endpoints)
- **Docker**

---



A-Boa/
│
├── src/

│ ├── main/

│ │ ├── java/

│ │ │ └── com/

│ │ │ └── aboa/

│ │ │ ├── controller/

│ │ │ ├── model/

│ │ │ ├── repository/

│ │ │ ├── service/

│ │ │ └── AboaApplication.java

│ │ └── resources/

│ │ ├── application.properties

│ │ └── data.sql

│ └── test/
│
├── Dockerfile

├── docker-compose.yml

├── pom.xml

└── README.md





---

## ⚙️ Endpoints da API

| Método | Endpoint         | Descrição                          | Corpo da Requisição | Retorno |
|--------|------------------|-------------------------------------|---------------------|----------|
| **POST** | `/eventos`       | Cria um novo evento                 | `EventoRequest`     | `200 OK` |
| **PUT**  | `/eventos`       | Atualiza um evento existente        | `AtualizacaoEvento` | `200 OK` ou `404 Not Found` |
| **GET**  | `/eventos`       | Lista todos os eventos cadastrados  | —                   | Lista de `EventoResponse` |
| **DELETE** | `/eventos/{id}` | Remove um evento pelo ID            | —                   | `204 No Content` |

---

### 🧾 Exemplo de Requisições

#### ➕ Criar Evento (`POST /eventos`)
```json
{
  "nome": "Festival de Música",
  "local": "Rio de Janeiro",
  "data": "2025-11-20",
  "descricao": "Evento com várias atrações musicais",
  "preco": 50.0
}


git clone https://github.com/cauacouto/a-boa.git
cd a-boa

http://localhost:8080/swagger-ui.html
