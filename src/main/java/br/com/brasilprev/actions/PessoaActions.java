package br.com.brasilprev.actions;

import io.restassured.response.Response;
import org.springframework.util.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static org.junit.Assert.assertEquals;
import static org.springframework.util.Assert.*;

public class PessoaActions  {

	private static Response response;
	private static final String BASE_URL = "http://localhost:8080";
	private static final String BASE_URL2 = "http://localhost:8080/pessoas/";
	
	@Given("^seto o endpoint de pessoa$") 
	public void setaEndPostPessoa() {
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
	}

	@When("^envio os valores \\\"([^\\\"]*)\\\" e \\\"([^\\\"]*)\\\" e \\\"([^\\\"]*)\\\" e \\\"([^\\\"]*)\\\"$") 
	public void enviaValoresPostPessoa(String cod, String cpf, String ddd, String tel) {
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		
		System.out.println("ddd:"+ddd+"  tel:" + tel);
		response = request.body("{\"codigo\": "+cod+",\"nome\": \"Rafael Teixeira\",\"cpf\": \""+cpf+"\","
				+ "\"enderecos\": [{\"logradouro\": \"Rua Alexandre Dumas\",\"numero\": 123,\"complemento\": \"Empresa\","
				+ "\"bairro\": \"Chacara Santo Antonio\",\"cidade\": \"São Paulo\",\"estado\": \"SP\"}]"
				+ ",\"telefones\": [{\"ddd\": \""+ddd+"\",\"numero\": \""+tel+"\"}]}")
				.post("/pessoas");
	}

	@Then("^a pessoa deve ser salva no sistema$") 
	public void confirmaResultadoSalvoPessoa() {
//		System.out.println(response.asString());
		assertEquals(201, response.getStatusCode());
	}
	
	@When("^busco por uma pessoa por DDD \\\"([^\\\"]*)\\\"$") 
	public void procuraPorDDD(String ddd) {
		RestAssured.baseURI = BASE_URL2;
		RequestSpecification request = RestAssured.given();
		response = request.get(ddd);
	}
	
	@When("^passando os valores \"([^\\\"]*)\\\" e \"([^\\\"]*)\\\"$") 
	public void procuraPorDDDTelefone(String ddd, String tel) {
		RestAssured.baseURI = BASE_URL2;
		RequestSpecification request = RestAssured.given();
		response = request.get(ddd+"/"+tel);
	}
	
	@When("^buscar por uma pessoa por um numero inexistente \"([^\\\"]*)\\\" e \"([^\\\"]*)\\\"$") 
	public void procuraPorDDDTelefoneInexistente(String ddd, String tel) {
		RestAssured.baseURI = BASE_URL2;
		RequestSpecification request = RestAssured.given();
		response = request.get(ddd+"/"+tel);
	}
	
	@Then("^os resultados devem ser exibidos$") 
	public void confirmaResultadosGet() {
		assertEquals(200, response.getStatusCode());
	}
	
	@Then("^um resultado deve ser exibido$") 
	public void confirmaResultadoGet() {
		assertEquals(200, response.getStatusCode());
	}
	
	@Then("^deve retornar o erro telefone inexistente$") 
	public void telefoneNaoEncontrado() {
		assertEquals(404, response.getStatusCode());
	}
	
	@Then("deve retornar erro de CPF duplicado")
	public void deve_retornar_erro_de_CPF_duplicado() {
		assertEquals(400, response.getStatusCode());
	}

	@Then("deve retornar erro de Telefone duplicado")
	public void deve_retornar_erro_de_Telefone_duplicado() {
		assertEquals(400, response.getStatusCode());
	}

}
