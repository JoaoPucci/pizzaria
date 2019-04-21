# Pizzaria UDS
Teste para avaliação de candidato UDS\
API básica para simulação de criação de pedido em uma pizzaria.

Utiliza: Spring Boot, JPA, Hibernate, H2, Lombok.

__Como o banco de dados utilizado é o H2, os dados são mantidos em memória até o shutdown do server.__

# Métodos:

**CRIAR PEDIDO**

**__POST Request: http://localhost:8080/api/v1/pedidos/__**
```javascript
{
    "tamanho": {
        "id": id,
    },
    "sabor": {
        "id": id
    },
    "adicionais": [
        {
            "id": id
        },
        {
            "id": id
        }
        ...
    ]
}
```
*-tamanho*: Representa o tamanho da pizza.\
*-sabor*: Representa o sabor da pizza.\
*-adicionais*: representa uma lista com os adicionais. É possível adicionar vários ou nenhum. Para indicar uma pizza sem adicionais, enviar o campo vazio.

Exemplo de pizza sem adicionais:
```javascript
{
    "tamanho": {
        "id": id,
    },
    "sabor": {
        "id": id
    },
    "adicionais": []
}
```

**__Response (201 - CREATED)__**

\
\
**RESUMO DO PEDIDO**

**__GET Request: http://localhost:8080/api/v1/pedidos/{id}__**

*id*: identificador do pedido

**__Response (200 - OK):__**
```javascript
{
    "id": id,
    "tamanho": {
        "id": id,
        "descricao": descricao,
        "valor": valor
    },
    "sabor": {
        "id": id,
        "descricao": descricao
    },
    "adicionais": [
        {
            "id": id,
            "descricao": descricao,
            "valor": valor
        },
        {
            "id": id,
            "descricao": descricao,
            "valor": valor
        }
        ...
    ],
    "tempoPreparo": tempoPreparo,
    "valor": valor
}
```
*-tempoPreparo*: Representa o tempo total de preparo do pedido.\
*-valor:* Representa o valor total do pedido.

