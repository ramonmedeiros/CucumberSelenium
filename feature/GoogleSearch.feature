Feature: Testar as operacoes de busca do google 
	Eu como usuario gostaria de realizar operacoes de busca no [Google]
    1) Realizar busca "comum"
    2) Realizar buscar "Com sorte"


Background: 
	Given acessado o site do Google 
	
Scenario: Testar busca comum 
	When realizar uma busca usando palavra-chave 
		| Cachorro            |
	Then retorna resultados da pesquisa 
	
Scenario Outline: Testar busca comum em multiplos idiomas 
	When realizar uma busca usando "<palavra-chave>" 
	Then retorna resultados da pesquisa 
	
	Examples: 
		| palavra-chave |
		| Dog           |
		| 犬            |
		| light speed / 2 |
		
Scenario Outline: Testar busca comum com operacao aritimetica 
	When realizar uma busca usando "<palavra-chave>" 
	Then retorna calculadora Google 
	
	Examples: 
		| palavra-chave   |
		| 1 + 1           |
		| 99 – 73         |
		| 45 * 7          |
		| 89 / 3          |
		| 2^3             |
		| sqrt(9)         |
		| 18% of 999      |
		| pi ^ 2          |
