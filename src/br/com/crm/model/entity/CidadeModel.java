package br.com.crm.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TB_CIDADE database table.
 * 
 */
@Entity
@Table(name="TB_CIDADE")
public class CidadeModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_CIDADE_ID_GENERATOR", sequenceName="SQ_CIDADE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_CIDADE_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=18)
	private long id;

	@Column(name="TX_CIDADE", nullable=false, length=100)
	private String txCidade;

	//bi-directional many-to-one association to BairroModel
	@OneToMany(mappedBy="tbCidade")
	private List<BairroModel> tbBairros;

	//bi-directional many-to-one association to EstadoModel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_ESTADO", nullable=false)
	private EstadoModel tbEstado;

    public CidadeModel() {
    }

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTxCidade() {
		return this.txCidade;
	}

	public void setTxCidade(String txCidade) {
		this.txCidade = txCidade;
	}

	public List<BairroModel> getTbBairros() {
		return this.tbBairros;
	}

	public void setTbBairros(List<BairroModel> tbBairros) {
		this.tbBairros = tbBairros;
	}
	
	public EstadoModel getTbEstado() {
		return this.tbEstado;
	}

	public void setTbEstado(EstadoModel tbEstado) {
		this.tbEstado = tbEstado;
	}
	
}