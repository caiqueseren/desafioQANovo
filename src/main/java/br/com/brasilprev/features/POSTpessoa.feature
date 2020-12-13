@CadastraPessoa
Feature: Cadastra pessoa

Scenario Outline: Deve salvar uma pessoa nova no sistema

	Given seto o endpoint de pessoa
	When envio os valores "<codigo>" e "<cpf>" e "<ddd>" e "<telefone>"
	Then a pessoa deve ser salva no sistema
	
		Examples:
		| codigo | cpf         | ddd | telefone  |
		| 1      | 47978825817 | 11  | 22545502  |
		| 2      | 36517871712 | 11  | 27496547  |
	
Scenario Outline: Não deve ser possível salvar duas pessoas com o mesmo CPF 

	Given seto o endpoint de pessoa
	When envio os valores "<codigo>" e "<cpf>" e "<ddd>" e "<telefone>"
	Then deve retornar erro de CPF duplicado
	
		Examples:
		| codigo | cpf         | ddd | telefone  |
		| 1      | 47978825817 | 11  | 22545503  |
		| 2      | 36517871712 | 11  | 27496543  |
	
Scenario Outline: Não deve ser possível salvar duas pessoas com o mesmo telefone

	Given seto o endpoint de pessoa
	When envio os valores "<codigo>" e "<cpf>" e "<ddd>" e "<telefone>"
	Then deve retornar erro de Telefone duplicado	
	
	Examples:
		| codigo | cpf         | ddd | telefone  |
		| 1      | 47978825816 | 11  | 22545502  |
		| 2      | 36517871714 | 11  | 27496547  |