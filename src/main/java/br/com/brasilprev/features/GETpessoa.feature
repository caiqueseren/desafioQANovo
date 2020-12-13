@BuscaPessoa
Feature: Buscar pessoa


Scenario Outline: Deve procurar uma pessoa por DDD e telefone existentes

	Given seto o endpoint de pessoa
	When passando os valores "<ddd>" e "<telefone>"
	Then um resultado deve ser exibido
	
	Examples:
		| ddd | telefone  |
		| 11  | 22545502  |
		| 11  | 27496547  |
	
Scenario Outline: Deve procurar uma pessoa por DDD

	Given seto o endpoint de pessoa
	When busco por uma pessoa por DDD "<ddd>"
	Then os resultados devem ser exibidos
		
	Examples:
		| ddd |
		| 11  |
		| 11  |
	
	
Scenario Outline: Pesquisar por um telefone inexistente

	Given seto o endpoint de pessoa
	When buscar por uma pessoa por um numero inexistente "<ddd>" e "<telefone>"
	Then deve retornar o erro telefone inexistente
	
	Examples:
		| ddd | telefone  |
		| 11  | 23232323  |
		| 11  | 34343434  |