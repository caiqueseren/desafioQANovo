package br.com.brasilprev.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features= "/brasilprev-qa-test/src/test/java/br/com/brasilprev/features", tags="@CadastraPessoa, @BuscaPessoa", plugin = "pretty")
public class Runner {



}
