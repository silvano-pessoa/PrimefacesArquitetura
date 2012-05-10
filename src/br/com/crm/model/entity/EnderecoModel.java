package br.com.crm.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TB_ENDERECO database table.
 * 
 */
@Entity
@Table(name="TB_ENDERECO")
public class EnderecoModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_ENDERECO_ID_GENERATOR", sequenceName="SQ_ENDERECO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_ENDERECO_ID_GENERATOR")
	@Column(unique=true, nullable=false, precision=18)
	private long id;

    @Temporal( TemporalType.DATE)
	@Column(name="DT_CREATE", nullable=false)
	private Date dtCreate;

    @Temporal( TemporalType.DATE)
	@Column(name="DT_UPDATE")
	private Date dtUpdate;

	@Column(name="ID_ENDERECO_TIPO", nullable=false, precision=18)
	private long idEnderecoTipo;

	@Column(name="ID_FUNCIONARIO", nullable=false, precision=18)
	private long idFuncionario;

	@Column(name="ID_PESSOA", nullable=false, precision=18)
	private long idPessoa;

	@Column(name="ID_UNIDADE", nullable=false, precision=18)
	private long idUnidade;

	@Column(name="TX_COMPLEMENTO", length=200)
	private String txComplemento;

	@Column(name="TX_PONTO_REFERENCIA", length=200)
	private String txPontoReferencia;

	@Column(name="TX_TRAVESSA_1", length=200)
	private String txTravessa1;

	@Column(name="TX_TRAVESSA_2", length=200)
	private String txTravessa2;

	@Column(name="VL_BLOCO", precision=8)
	private Integer vlBloco;

	@Column(name="VL_NUMERO", nullable=false, precision=8)
	private Integer vlNumero;

	//bi-directional many-to-one association to ComplementoTipoModel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_COMPLEMENTO_TIPO", nullable=false)
	private ComplementoTipoModel tbComplementoTipo;

	//bi-directional many-to-one association to LogradouroModel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_LOGRADOURO", nullable=false)
	private LogradouroModel tbLogradouro;

    public EnderecoModel() {
    }

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDtCreate() {
		return this.dtCreate;
	}

	public void setDtCreate(Date dtCreate) {
		this.dtCreate = dtCreate;
	}

	public Date getDtUpdate() {
		return this.dtUpdate;
	}

	public void setDtUpdate(Date dtUpdate) {
		this.dtUpdate = dtUpdate;
	}

	public long getIdEnderecoTipo() {
		return this.idEnderecoTipo;
	}

	public void setIdEnderecoTipo(long idEnderecoTipo) {
		this.idEnderecoTipo = idEnderecoTipo;
	}

	public long getIdFuncionario() {
		return this.idFuncionario;
	}

	public void setIdFuncionario(long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public long getIdPessoa() {
		return this.idPessoa;
	}

	public void setIdPessoa(long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public long getIdUnidade() {
		return this.idUnidade;
	}

	public void setIdUnidade(long idUnidade) {
		this.idUnidade = idUnidade;
	}

	public String getTxComplemento() {
		return this.txComplemento;
	}

	public void setTxComplemento(String txComplemento) {
		this.txComplemento = txComplemento;
	}

	public String getTxPontoReferencia() {
		return this.txPontoReferencia;
	}

	public void setTxPontoReferencia(String txPontoReferencia) {
		this.txPontoReferencia = txPontoReferencia;
	}

	public String getTxTravessa1() {
		return this.txTravessa1;
	}

	public void setTxTravessa1(String txTravessa1) {
		this.txTravessa1 = txTravessa1;
	}

	public String getTxTravessa2() {
		return this.txTravessa2;
	}

	public void setTxTravessa2(String txTravessa2) {
		this.txTravessa2 = txTravessa2;
	}

	public Integer getVlBloco() {
		return this.vlBloco;
	}

	public void setVlBloco(Integer vlBloco) {
		this.vlBloco = vlBloco;
	}

	public Integer getVlNumero() {
		return this.vlNumero;
	}

	public void setVlNumero(Integer vlNumero) {
		this.vlNumero = vlNumero;
	}

	public ComplementoTipoModel getTbComplementoTipo() {
		return this.tbComplementoTipo;
	}

	public void setTbComplementoTipo(ComplementoTipoModel tbComplementoTipo) {
		this.tbComplementoTipo = tbComplementoTipo;
	}
	
	public LogradouroModel getTbLogradouro() {
		return this.tbLogradouro;
	}

	public void setTbLogradouro(LogradouroModel tbLogradouro) {
		this.tbLogradouro = tbLogradouro;
	}
	
}