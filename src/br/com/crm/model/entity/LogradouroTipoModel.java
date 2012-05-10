package br.com.crm.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TB_LOGRADOURO_TIPO database table.
 * 
 */
@Entity
@Table(name="TB_LOGRADOURO_TIPO")
public class LogradouroTipoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_LOGRADOURO_TIPO_ID_GENERATOR", sequenceName="SQ_LOGRADOURO_TIPO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_LOGRADOURO_TIPO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=18)
	private long id;

	@Column(name="IN_LOGRADOURO_TIPO_ABREV", length=5)
	private char inLogradouroTipoAbrev;

	@Column(name="TX_LOGRADOURO_TIPO", nullable=false, length=60)
	private String txLogradouroTipo;

	//bi-directional many-to-one association to LogradouroModel
	@OneToMany(mappedBy="tbLogradouroTipo")
	private List<LogradouroModel> tbLogradouros;

    public LogradouroTipoModel() {
    }

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public char getInLogradouroTipoAbrev() {
		return this.inLogradouroTipoAbrev;
	}

	public void setInLogradouroTipoAbrev(char inLogradouroTipoAbrev) {
		this.inLogradouroTipoAbrev = inLogradouroTipoAbrev;
	}

	public String getTxLogradouroTipo() {
		return this.txLogradouroTipo;
	}

	public void setTxLogradouroTipo(String txLogradouroTipo) {
		this.txLogradouroTipo = txLogradouroTipo;
	}

	public List<LogradouroModel> getTbLogradouros() {
		return this.tbLogradouros;
	}

	public void setTbLogradouros(List<LogradouroModel> tbLogradouros) {
		this.tbLogradouros = tbLogradouros;
	}
	
}