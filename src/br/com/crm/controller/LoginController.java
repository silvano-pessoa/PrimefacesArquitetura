package br.com.crm.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.component.UIViewRoot;

import org.springframework.stereotype.Controller;

import br.com.crm.annotation.FlexViewScope;

@Controller("loginController")
@FlexViewScope
public class LoginController implements Serializable {
	
	
	@PostConstruct
	public void init() {
		System.out.println("INITTTTTTTTTTTTTTTTT");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("DESTROYYYYYYYYYYYYYYYYYYYYYY");
	}
	
	private String nome;
	
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void salvar(){
		System.out.println(nome);
	}
}
