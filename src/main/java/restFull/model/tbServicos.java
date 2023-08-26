package restFull.model;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name = "SERVICOS")
public class tbServicos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	
	@Column(name = "Descricao", nullable=false, length = 50)  
	private String descricao; 
	
	@Column(name = "Tipo", nullable=false, length = 20)  
	private String tipo; 

	@Column(name = "Renovacao", nullable=false, columnDefinition = "DATE")  
	private Date   dtinirenovacao; 

	@Column(name = "Expiracao", nullable=false, columnDefinition = "DATE")  
	private Date   dtexpiracao;
	
	@Column(name = "Risco", nullable=false, length = 5)       
	private String risco; 

	@Column(name = "Info",  length = 500)  
	private String info; 

	@Column(name = "Status")   
	private int status;

	public tbServicos() {
		super(); 
	}

	public tbServicos(long id, String descricao, String tipo, Date dtinirenovacao, Date dtexpiracao, String risco,
			String info, int status) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.tipo = tipo;
		this.dtinirenovacao = dtinirenovacao;
		this.dtexpiracao = dtexpiracao;
		this.risco = risco;
		this.info = info;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getDtinirenovacao() {
		return dtinirenovacao;
	}

	public void setDtinirenovacao(Date dtinirenovacao) {
		this.dtinirenovacao = dtinirenovacao;
	}

	public Date getDtexpiracao() {
		return dtexpiracao;
	}

	public void setDtexpiracao(Date dtexpiracao) {
		this.dtexpiracao = dtexpiracao;
	}

	public String getRisco() {
		return risco;
	}

	public void setRisco(String risco) {
		this.risco = risco;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "tbServicos [id=" + id + ", descricao=" + descricao + ", tipo=" + tipo + ", dtinirenovacao="
				+ dtinirenovacao + ", dtexpiracao=" + dtexpiracao + ", risco=" + risco + ", info=" + info + ", status="
				+ status + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, dtexpiracao, dtinirenovacao, id, info, risco, status, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		tbServicos other = (tbServicos) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(dtexpiracao, other.dtexpiracao)
				&& Objects.equals(dtinirenovacao, other.dtinirenovacao) && id == other.id
				&& Objects.equals(info, other.info) && Objects.equals(risco, other.risco) && status == other.status
				&& Objects.equals(tipo, other.tipo);
	}

	
	
	
}
