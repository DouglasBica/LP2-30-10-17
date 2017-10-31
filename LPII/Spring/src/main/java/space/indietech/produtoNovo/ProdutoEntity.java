package space.indietech.produtoNovo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


public class ProdutoEntity {

	@Id
	@Column(name = "code")
	@GeneratedValue
	protected Long codigo;

	@Column(name = "name")
	protected String nome;

	@Column(name = "custo")
	protected double custo;

	@Column(name = "perc_lucro")
	protected double perc_lucro;

	@Column(name = "quantidade")
	protected double quantidade;

	@Column(name = "data_compra")
	protected Date dataCompra;

	@Column(name = "ativo")
	protected boolean ativo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	public double getPerc_lucro() {
		return perc_lucro;
	}

	public void setPerc_lucro(double perc_lucro) {
		this.perc_lucro = perc_lucro;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
