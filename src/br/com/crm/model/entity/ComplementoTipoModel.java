package br.com.crm.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TB_COMPLEMENTO_TIPO database table.
 * 
 */
@Entity
@Table(name="TB_COMPLEMENTO_TIPO")
public class ComplementoTipoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_COMPLEMENTO_TIPO_ID_GENERATOR", sequenceName="SQ_COMPLEMENTO_TIPO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_COMPLEMENTO_TIPO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=18)
	private long id;

	@Column(name="TX_COMPLEMENTO_TIPO", nullable=false, length=200)
	private String txComplementoTipo;

	//bi-directional many-to-one association to EnderecoModel
	@OneToMany(mappedBy="tbComplementoTipo")
	private List<EnderecoModel> tbEnderecos;

    public ComplementoTipoModel() {
    }

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTxComplementoTipo() {
		return this.txComplementoTipo;
	}

	public void setTxComplementoTipo(String txComplementoTipo) {
		this.txComplementoTipo = txComplementoTipo;
	}

	public List<EnderecoModel> getTbEnderecos() {
		return this.tbEnderecos;
	}

	public void setTbEnderecos(List<EnderecoModel> tbEnderecos) {
		this.tbEnderecos = tbEnderecos;
	}
	
}