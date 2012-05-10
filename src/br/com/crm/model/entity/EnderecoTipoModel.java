package br.com.crm.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TB_ENDERECO_TIPO database table.
 * 
 */
@Entity
@Table(name="TB_ENDERECO_TIPO")
public class EnderecoTipoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_ENDERECO_TIPO_ID_GENERATOR", sequenceName="SQ_ENDERECO_TIPO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_ENDERECO_TIPO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=18)
	private long id;

	@Column(name="TX_ENDERECO_TIPO", nullable=false, length=50)
	private String txEnderecoTipo;

    public EnderecoTipoModel() {
    }

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTxEnderecoTipo() {
		return this.txEnderecoTipo;
	}

	public void setTxEnderecoTipo(String txEnderecoTipo) {
		this.txEnderecoTipo = txEnderecoTipo;
	}

}