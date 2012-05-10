package br.com.crm.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TB_REGIAO database table.
 * 
 */
@Entity
@Table(name="TB_REGIAO")
public class RegiaoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_REGIAO_ID_GENERATOR", sequenceName="SQ_REGIAO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_REGIAO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=18)
	private long id;

	@Column(name="TX_REGIAO", nullable=false, length=20)
	private String txRegiao;

	//bi-directional many-to-one association to EstadoModel
	@OneToMany(mappedBy="tbRegiao")
	private List<EstadoModel> tbEstados;

    public RegiaoModel() {
    }

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTxRegiao() {
		return this.txRegiao;
	}

	public void setTxRegiao(String txRegiao) {
		this.txRegiao = txRegiao;
	}

	public List<EstadoModel> getTbEstados() {
		return this.tbEstados;
	}

	public void setTbEstados(List<EstadoModel> tbEstados) {
		this.tbEstados = tbEstados;
	}
	
}