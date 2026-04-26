<div align="center">

<img src="https://img.shields.io/badge/status-em%20desenvolvimento-yellow?style=for-the-badge" />
<img src="https://img.shields.io/badge/java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
<img src="https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring&logoColor=white" />
<img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" />
<img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white" />
<img src="https://img.shields.io/badge/Cloudinary-3448C5?style=for-the-badge&logo=cloudinary&logoColor=white" />

<br/>
<br/>

# 🎉 A-Boa

### Plataforma de cadastro e gerenciamento de eventos culturais

*Shows • Festivais • Pagodes • Feiras • e muito mais*

</div>

---

## 📌 Sobre o projeto

**A-Boa** é uma API REST para cadastro e gerenciamento de eventos. A plataforma permite que usuários criem, editem, listem e removam eventos de diversas categorias, além de fazer upload do banner do evento.

---

## 🚀 Tecnologias

| Tecnologia | Versão | Uso |
|---|---|---|
| Java | 17 | Linguagem principal |
| Spring Boot | 3.x | Framework web |
| Spring Data JPA | — | Persistência de dados |
| PostgreSQL | latest | Banco de dados |
| Flyway | — | Versionamento do banco |
| Docker | — | Containerização |
| Cloudinary | — | Upload de imagens |

---

## 🎭 Categorias de Eventos

```
SHOW • FESTIVAL • SAMBA • PAGODE • AFTER
CULTURAL • ESPORTIVO • GASTRONOMICO • FEIRA • OUTROS
```

---

## ⚙️ Como rodar

### Pré-requisitos

![Git](https://img.shields.io/badge/Git-F05032?style=flat&logo=git&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat&logo=docker&logoColor=white)
![Java](https://img.shields.io/badge/Java_17-ED8B00?style=flat&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apache-maven&logoColor=white)

### 1. Clone o repositório

```bash
git clone git@github.com:cauacouto/a-boa.git
cd a-boa
```

### 2. Gere o `.jar`

```bash
./mvnw clean package -DskipTests
```

### 3. Suba os containers

```bash
docker-compose up --build
```

> API disponível em `http://localhost:8080` 🟢

---

## 🔌 Endpoints

### Eventos

| Método | Endpoint | Descrição |
|---|---|---|
| ![GET](https://img.shields.io/badge/GET-61AFFE?style=flat) | `/eventos` | Lista todos os eventos |
| ![GET](https://img.shields.io/badge/GET-61AFFE?style=flat) | `/eventos/{id}` | Busca evento por ID |
| ![POST](https://img.shields.io/badge/POST-49CC90?style=flat) | `/eventos` | Cadastra um novo evento |
| ![PUT](https://img.shields.io/badge/PUT-FCA130?style=flat) | `/eventos/{id}` | Atualiza um evento |
| ![DELETE](https://img.shields.io/badge/DELETE-F93E3E?style=flat) | `/eventos/{id}` | Remove um evento |
| ![POST](https://img.shields.io/badge/POST-49CC90?style=flat) | `/eventos/{id}/imagem` | Upload do banner do evento |

### Exemplo — Criar evento

```json
{
  "nome": "Planeta Brasil 10 Anos",
  "tipo": "FESTIVAL",
  "data": "2025-01-26T20:00:00",
  "local": "Mineirão, Belo Horizonte",
  "descricao": "Festival de música com grandes atrações nacionais e internacionais",
  "organizador": "Planeta Brasil Produções"
}
```

### Exemplo — Upload de imagem

```bash
curl -X POST http://localhost:8080/eventos/1/imagem \
  -F "file=@banner.jpg"
```

> Formatos aceitos: `jpeg`, `png`, `webp` — tamanho máximo: `5MB`

---

## 🌱 Variáveis de Ambiente

Crie um arquivo `.env` na raiz do projeto (ou configure no `docker-compose.yml`):

```env
SPRING_DATASOURCE_URL=jdbc:postgresql://postgres:5432/aboa
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=postgres
```

---

## 🐳 Docker

```bash
# Subir projeto completo
docker-compose up --build

# Parar containers
docker-compose down

# Imagem no Docker Hub
docker pull cauacouto/aboa-app:latest
```

---

## 📁 Estrutura do Projeto

```
a-boa/
├── src/
│   └── main/
│       ├── java/com/coutodev/a/boa/
│       │   ├── controller/
│       │   ├── service/
│       │   ├── repository/
│       │   ├── model/
│       │   └── dto/
│       └── resources/
│           ├── application.yml
│           └── db/migration/
│               ├── V1__create_tables.sql
│               └── V2__add_image_url.sql
├── Dockerfile
├── docker-compose.yml
└── pom.xml
```

---

## 🗺️ Roadmap

- [x] CRUD de eventos
- [x] Upload de imagem via Cloudinary
- [x] Containerização com Docker
- [ ] Autenticação com JWT
- [ ] Filtros por categoria e data
- [ ] Paginação nas listagens
- [ ] Testes unitários e de integração

---

<div align="center">

Feito com 💛 por [cauacouto](https://github.com/cauacouto)

![GitHub followers](https://img.shields.io/github/followers/cauacouto?style=social)
![GitHub stars](https://img.shields.io/github/stars/cauacouto/a-boa?style=social)

</div>
