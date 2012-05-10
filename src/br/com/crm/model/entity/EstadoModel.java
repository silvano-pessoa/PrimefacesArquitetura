package br.com.crm.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TB_ESTADO database table.
 * 
 */
@Entity
@Table(name="TB_ESTADO")
public class EstadoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_ESTADO_ID_GENERATOR", sequenceName="SQ_ESTADO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_ESTADO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=18)
	private long id;

	@Column(name="IN_SIGLA2", nullable=false, length=2)
	private String inSigla2;

	@Column(name="TX_ESTADO", nullable=false, length=100)
	private String txEstado;

	//bi-directional many-to-one association to CidadeModel
	@OneToMany(mappedBy="tbEstado")
	private List<CidadeModel> tbCidades;

	//bi-directional many-to-one association to PaisModel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PAIS", nullable=false)
	private PaisModel tbPais;

	//bi-directional many-to-one association to RegiaoModel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_REGIAO", nullable=false)
	private RegiaoModel tbRegiao;

    public EstadoModel() {
    }

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInSigla2() {
		return this.inSigla2;
	}

	public void setInSigla2(String inSigla2) {
		this.inSigla2 = inSigla2;
	}

	public String getTxEstado() {
		return this.txEstado;
	}

	public void setTxEstado(String txEstado) {
		this.txEstado = txEstado;
	}

	public List<CidadeModel> getTbCidades() {
		return this.tbCidades;
	}

	public void setTbCidades(List<CidadeModel> tbCidades) {
		this.tbCidades = tbCidades;
	}
	
	public PaisModel getTbPais() {
		return this.tbPais;
	}

	public void setTbPais(PaisModel tbPais) {
		this.tbPais = tbPais;
	}
	
	public RegiaoModel getTbRegiao() {
		return this.tbRegiao;
	}

	public void setTbRegiao(RegiaoModel tbRegiao) {
		this.tbRegiao = tbRegiao;
	}
	
}