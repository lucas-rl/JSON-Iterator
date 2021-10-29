package com.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JsonIteratorApplication {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		SpringApplication.run(JsonIteratorApplication.class, args);

		Object obj = new JSONParser().parse(new FileReader("./src/main/java/dados.json"));
		JSONArray jsonzinho = (JSONArray) obj;

		System.out.println("Passando objeto por objeto, chave por chave, do arquivo JSON com while\nSabendo as chaves\n");
		int contador = 0;
		while (contador < jsonzinho.size()) {
			System.out.println("Objeto -> " + (contador + 1));
			JSONObject objJson = (JSONObject) jsonzinho.get(contador);
			System.out.println("Id: " + objJson.get("id"));
			System.out.println("Nome: " + objJson.get("Nome"));
			System.out.println("Sobrenome: " + objJson.get("Sobrenome"));
			System.out.println("Idade: " + objJson.get("Idade"));
			System.out.println();
			contador++;
		}

		System.out.println();
		System.out.println("-".repeat(20));
		System.out.println();

		System.out.println(
				"Passando objeto por objeto, chave por chave, do arquivo JSON com while\nSem saber as chaves\n");
		contador = 0;
		while (contador < jsonzinho.size()) {
			System.out.println("Objeto -> " + (contador + 1));
			JSONObject objJson = (JSONObject) jsonzinho.get(contador);
			Iterator<String> chaves = objJson.keySet().iterator();
			while (chaves.hasNext()) {
				String chave = chaves.next();
				System.out.println(chave + ": " + objJson.get(chave));
			}
			System.out.println();
			contador++;
		}
		
		System.out.println();
		System.out.println("-".repeat(20));
		System.out.println();

		System.out.println("Passando obejto por objeto do arquivo JSON com while\n");
		contador = 0;
		while (contador < jsonzinho.size()) {
			System.out.println("Objeto -> " + (contador + 1));
			JSONObject objJson = (JSONObject) jsonzinho.get(contador);
			System.out.println(objJson.toString());
			System.out.println();
			contador++;
		}

		System.out.println();
		System.out.println("-".repeat(20));
		System.out.println();

		System.out.println("Passando obejto por objeto do arquivo JSON com for e map\n");
		contador = 0;
		while (contador < jsonzinho.size()) {
			System.out.println("Objeto -> " + (contador + 1));
			JSONObject objJson = (JSONObject) jsonzinho.get(contador);
			Set<Map.Entry<String, String>> chavesValores = objJson.entrySet();
			for (Map.Entry<String, String> chaveValor : chavesValores) {
				System.out.println(chaveValor.getKey() + ": " + chaveValor.getValue());
			}
			System.out.println();
			contador++;
		}

	}

}
