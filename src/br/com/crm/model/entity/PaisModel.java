package br.com.crm.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TB_PAIS database table.
 * 
 */
@Entity
@Table(name="TB_PAIS")
public class PaisModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_PAIS_ID_GENERATOR", sequenceName="SQ_PAIS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_PAIS_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=18)
	private long id;

	@Column(name="IN_SIGLA2", nullable=false, length=2)
	private String inSigla2;

	@Column(name="IN_SIGLA3", nullable=false, length=3)
	private String inSigla3;

	@Column(name="TX_PAIS", nullable=false, length=20)
	private String txPais;

	//bi-directional many-to-one association to EstadoModel
	@OneToMany(mappedBy="tbPais")
	private List<EstadoModel> tbEstados;

    public PaisModel() {
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

	public String getInSigla3() {
		return this.inSigla3;
	}

	public void setInSigla3(String inSigla3) {
		this.inSigla3 = inSigla3;
	}

	public String getTxPais() {
		return this.txPais;
	}

	public void setTxPais(String txPais) {
		this.txPais = txPais;
	}

	public List<EstadoModel> getTbEstados() {
		return this.tbEstados;
	}

	public void setTbEstados(List<EstadoModel> tbEstados) {
		this.tbEstados = tbEstados;
	}
	
}