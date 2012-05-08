package br.com.crm.controller;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("esqueceuSenhaController")
@Scope("session")
public class EsqueceuSenhaController implements Serializable{
	
	private String email;

	
	public void enviar(){
		System.out.println("ENVIARRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
