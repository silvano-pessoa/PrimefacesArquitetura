package br.com.crm.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TB_CEP database table.
 * 
 */
@Entity
@Table(name="TB_CEP")
public class CepModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_CEP_ID_GENERATOR", sequenceName="SQ_CEP")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_CEP_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=18)
	private long id;

	@Column(name="IN_LADO_RUA", nullable=false, length=1)
	private char inLadoRua;

	@Column(name="IN_OFICIAL", nullable=false, precision=1)
	private boolean inOficial;

	@Column(name="NR_FAIXA_FINAL", nullable=false, length=5)
	private String nrFaixaFinal;

	@Column(name="NR_FAIXA_INICIAL", nullable=false, length=5)
	private String nrFaixaInicial;

	@Column(name="TX_CEP", nullable=false, length=8)
	private String txCep;

	//bi-directional many-to-one association to BairroModel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_BAIRRO", nullable=false)
	private BairroModel tbBairro;

	//bi-directional many-to-one association to LogradouroModel
	@OneToMany(mappedBy="tbCep")
	private List<LogradouroModel> tbLogradouros;

    public CepModel() {
    }

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public char getInLadoRua() {
		return this.inLadoRua;
	}

	public void setInLadoRua(char inLadoRua) {
		this.inLadoRua = inLadoRua;
	}

	public boolean getInOficial() {
		return this.inOficial;
	}

	public void setInOficial(boolean inOficial) {
		this.inOficial = inOficial;
	}

	public String getNrFaixaFinal() {
		return this.nrFaixaFinal;
	}

	public void setNrFaixaFinal(String nrFaixaFinal) {
		this.nrFaixaFinal = nrFaixaFinal;
	}

	public String getNrFaixaInicial() {
		return this.nrFaixaInicial;
	}

	public void setNrFaixaInicial(String nrFaixaInicial) {
		this.nrFaixaInicial = nrFaixaInicial;
	}

	public String getTxCep() {
		return this.txCep;
	}

	public void setTxCep(String txCep) {
		this.txCep = txCep;
	}

	public BairroModel getTbBairro() {
		return this.tbBairro;
	}

	public void setTbBairro(BairroModel tbBairro) {
		this.tbBairro = tbBairro;
	}
	
	public List<LogradouroModel> getTbLogradouros() {
		return this.tbLogradouros;
	}

	public void setTbLogradouros(List<LogradouroModel> tbLogradouros) {
		this.tbLogradouros = tbLogradouros;
	}
	
}