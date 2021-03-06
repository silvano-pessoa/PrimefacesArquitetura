package br.com.crm.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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
	
	public String salvar(){
		if(nome.equals("silvano")&& senha.equals("admin")){
			return "pages/autenticacao/esqueceuSenha.jsf";
		}
		return null;
	}
	
	private int count;  
	  
    public int getCount() {  
        return count;  
    }  
	  
    public void setCount(int count) {  
        this.count = count;  
    }  
    
	public void increment() {  
	        count++;  
	}  

}
