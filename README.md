# Projeto_POO2
--------------------------------------------------------------------------------
<details>
<summary> Equipe </summary>
  
## Alunos
|      Equipe      |              Email             |
| :---:       | :---:       |
| Samuel de Souza  | samueldesouza200512@gmail.com  |
| Caio de Souza    | caiodesouza.cds@gmail.com      |

</details>

--------------------------------------------------------------------------------
  
<details>
<summary> Detalhes </summary>
  
## Equipe
|      Item        |        Valor       |
| :---:       | :---:       |
| Banco de Dados   | MySQL              |
| Schema           | Imobiliaria        |
</details>

--------------------------------------------------------------------------------

<details>
  <summary> Diagramas </summary>
  
## Diagrama MER
![Diagrama MER](/MER3.jpg)

----------------------------------------------------------------------------------

## Diagrama UML
![Diagrama UML](/UML4.jpg)
</details>

----------------------------------------------------------------------------------

<details>
  <summary>Instruções SQL</summary>

  ```SQL
 
 -- Criação da Database

CREATE DATABASE Imobiliaria;
USE Imobiliaria;

-- Criação Tabela Clientes

 CREATE TABLE Cliente (
 IDCliente INT PRIMARY KEY AUTO_INCREMENT,
 Nome VARCHAR(255),
 Email VARCHAR(255),
 Idade INT,
 Sexo VARCHAR(255)
 );

 -- Criação Tabela Imóveis

 CREATE TABLE Imovel (
 IDImovel INT PRIMARY KEY AUTO_INCREMENT,
 Tipo VARCHAR(255),
 Tamanho FLOAT,
 Endereco VARCHAR(255)
 );

-- Criação Tabela ContratoAluguel

 CREATE TABLE ContratoAluguel(
 IDContrato INT PRIMARY KEY AUTO_INCREMENT,
 IDCliente int,
 IDImovel int,
 FOREIGN KEY (IDCliente) REFERENCES Cliente(IDCliente),
 FOREIGN KEY (IDImovel) REFERENCES Imovel(IDImovel),
 Valor FLOAT,
 DataInicio DATE,
 DataFinal DATE
 );
 

  ```
</details>

--------------------------------------------------------------------------------

Projeto avaliativo de integração de java com banco de dados.
