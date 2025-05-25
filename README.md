# DSList(Intensivão Java Spring) - Sistema de Gerenciamento de Jogos

Um projeto Spring Boot para gerenciamento de listas de jogos, desenvolvido com arquitetura REST e boas práticas de desenvolvimento.

## 🚀 Sobre o Projeto

O DSList é uma aplicação web desenvolvida durante o Intensivão Java Spring do professor Nelio Alves, que permite gerenciar coleções de jogos, organizando-os em diferentes listas e categorias. O sistema oferece funcionalidades de reordenação de elementos nas listas.

## 🛠️ Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Spring Web**
- **H2 Database** (ambiente de teste)
- **PostgreSQL** (ambiente de desenvolvimento)
- **Maven** (gerenciamento de dependências)
- **Docker Compose** (ambiente local)

## 📋 Funcionalidades

### Endpoints Disponíveis

- `GET /games` - Lista todos os jogos
- `GET /games/{id}` - Busca jogo por ID
- `GET /lists` - Lista todas as listas de jogos
- `GET /lists/{id}/games` - Busca jogos de uma lista específica
- `POST /lists/{id}/replacement` - Reordena jogos dentro de uma lista

### Características Técnicas

- **Arquitetura em Camadas**: Controller, Service, Repository
- **Padrão DTO**: Transferência otimizada de dados
- **Relacionamentos N-N**: Gestão de associações complexas
- **Embedded ID**: Chaves compostas para relacionamentos
- **Projections**: Consultas SQL otimizadas
- **Database Seeding**: Dados iniciais para desenvolvimento

## 🏗️ Estrutura do Projeto

```
src/main/java/com/example/dslist/
├── config/           # Configurações (CORS, etc.)
├── controllers/      # Camada de apresentação
├── dto/             # Objetos de transferência de dados
├── entities/        # Entidades JPA
├── projections/     # Interfaces de projeção
├── repositories/    # Camada de acesso a dados
└── services/        # Regras de negócio
```

## 🔧 Configuração do Ambiente

### Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- Docker e Docker Compose (opcional)
- PostgreSQL (para ambiente de desenvolvimento)

### Variáveis de Ambiente

```bash
# Ambiente de Desenvolvimento
DB_URL=jdbc:postgresql://localhost:5433/mydatabase
DB_USERNAME=postgres
DB_PASSWORD=1234567
```

## 🚀 Como Executar

### Ambiente Local (H2)

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/dslist.git
cd dslist

# Execute a aplicação
mvn spring-boot:run

# A aplicação estará disponível em http://localhost:8080
# Console do H2: http://localhost:8080/h2-console
```

### Ambiente de Desenvolvimento (PostgreSQL)

```bash
# Inicie o banco com Docker Compose
docker-compose up -d

# Execute com perfil de desenvolvimento
mvn spring-boot:run -Dspring-boot.run.profiles=dev

# Acesse o PgAdmin em http://localhost:5050
# Email: me@example.com
# Senha: 1234567
```

### Docker Compose

```yaml
version: "3.7"
services:
  # POSTGRES SERVER
  pg-docker:
    image: postgres:14-alpine
    container_name: dev-postgresql
    environment:
      POSTGRES_DB: mydatabase
      POSTGRES_PASSWORD: 1234567
    ports:
      - 5433:5432
    volumes:
      - ./data/postgresql/data:/var/lib/postgresql/data
    networks:
      - dev-network

  # PGADMIN
  pgadmin-docker:
    image: dpage/pgadmin4
    container_name: dev-pgadmin
    environment:
      PGADMIN_DEFAULT_EMAIL: me@example.com
      PGADMIN_DEFAULT_PASSWORD: 1234567
    ports:
      - 5050:80
    volumes:
      - ./data/pgadmin:/var/lib/pgadmin
    depends_on:
      - pg-docker
    networks:
      - dev-network

# REDE
networks:
  dev-network:
    driver: bridge
```

## 📊 Modelo de Dados

### Entidades Principais

- **Game**: Representa um jogo no sistema
- **GameList**: Lista/categoria de jogos
- **Belonging**: Relacionamento N-N entre Game e GameList
- **BelongingPK**: Chave composta para Belonging

### Relacionamentos

- Um jogo pode pertencer a múltiplas listas
- Uma lista pode conter múltiplos jogos
- Cada associação possui uma posição específica

## 🔍 Exemplos de Uso

### Listar todos os jogos
```http
GET http://localhost:8080/games
```

### Buscar jogo específico
```http
GET http://localhost:8080/games/1
```

### Reordenar jogos em uma lista
```http
POST http://localhost:8080/lists/1/replacement
Content-Type: application/json

{
  "sourceIndex": 0,
  "destinationIndex": 2
}
```

## 🛡️ Configuração de CORS

O projeto inclui configuração de CORS para desenvolvimento local e produção:

```java
@Configuration
public class WebConfig {

    @Value("${cors.origins}")
    private String corsOrigins;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("*").allowedOrigins(corsOrigins);
            }
        };
    }
}
```

## 🤝 Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request


## 👥 Autor

Jhonata Andrade - [@Jhonata02](https://github.com/Jhonata02)

---

⭐ Se este projeto te ajudou, não esqueça de dar uma estrela!
