package br.com.crm.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TB_LOGRADOURO database table.
 * 
 */
@Entity
@Table(name="TB_LOGRADOURO")
public class LogradouroModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_LOGRADOURO_ID_GENERATOR", sequenceName="SQ_LOGRADOURO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_LOGRADOURO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=18)
	private long id;

	@Column(name="IN_OFICIAL", nullable=false, precision=1)
	private boolean inOficial;

	@Column(name="TX_LOGRADOURO", nullable=false, length=200)
	private String txLogradouro;

	//bi-directional many-to-one association to EnderecoModel
	@OneToMany(mappedBy="tbLogradouro")
	private List<EnderecoModel> tbEnderecos;

	//bi-directional many-to-one association to CepModel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CEP", nullable=false)
	private CepModel tbCep;

	//bi-directional many-to-one association to LogradouroTipoModel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_LOGRADOURO_TIPO", nullable=false)
	private LogradouroTipoModel tbLogradouroTipo;

    public LogradouroModel() {
    }

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean getInOficial() {
		return this.inOficial;
	}

	public void setInOficial(boolean inOficial) {
		this.inOficial = inOficial;
	}

	public String getTxLogradouro() {
		return this.txLogradouro;
	}

	public void setTxLogradouro(String txLogradouro) {
		this.txLogradouro = txLogradouro;
	}

	public List<EnderecoModel> getTbEnderecos() {
		return this.tbEnderecos;
	}

	public void setTbEnderecos(List<EnderecoModel> tbEnderecos) {
		this.tbEnderecos = tbEnderecos;
	}
	
	public CepModel getTbCep() {
		return this.tbCep;
	}

	public void setTbCep(CepModel tbCep) {
		this.tbCep = tbCep;
	}
	
	public LogradouroTipoModel getTbLogradouroTipo() {
		return this.tbLogradouroTipo;
	}

	public void setTbLogradouroTipo(LogradouroTipoModel tbLogradouroTipo) {
		this.tbLogradouroTipo = tbLogradouroTipo;
	}
	
}