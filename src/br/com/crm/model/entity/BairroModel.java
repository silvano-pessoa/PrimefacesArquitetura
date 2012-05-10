package br.com.crm.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TB_BAIRRO database table.
 * 
 */
@Entity
@Table(name="TB_BAIRRO")
public class BairroModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_BAIRRO_ID_GENERATOR", sequenceName="SQ_BAIRRO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_BAIRRO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=18)
	private long id;

	@Column(name="IN_OFICIAL", nullable=false, precision=1)
	private boolean inOficial;

	@Column(name="TX_BAIRRO", nullable=false, length=200)
	private String txBairro;

	//bi-directional many-to-one association to CidadeModel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CIDADE", nullable=false)
	private CidadeModel tbCidade;

	//bi-directional many-to-one association to CepModel
	@OneToMany(mappedBy="tbBairro")
	private List<CepModel> tbCeps;

    public BairroModel() {
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

	public String getTxBairro() {
		return this.txBairro;
	}

	public void setTxBairro(String txBairro) {
		this.txBairro = txBairro;
	}

	public CidadeModel getTbCidade() {
		return this.tbCidade;
	}

	public void setTbCidade(CidadeModel tbCidade) {
		this.tbCidade = tbCidade;
	}
	
	public List<CepModel> getTbCeps() {
		return this.tbCeps;
	}

	public void setTbCeps(List<CepModel> tbCeps) {
		this.tbCeps = tbCeps;
	}
	
}