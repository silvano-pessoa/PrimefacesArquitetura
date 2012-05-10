package br.com.crm.model.dto;

import java.util.List;

public class UsuarioSistemaDTO {

	private List<String> permissoes;
	
	private String usuario;

	public List<String> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<String> permissoes) {
		this.permissoes = permissoes;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}
