package space.indietech.produto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import space.indietech.produtoNovo.ProdutoEntity;

@Component
public class ProdutoDao {

	private EntityManager em;

	@Autowired
	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public void adicionaProduto(ProdutoEntity produto) {
		em.merge(produto);
	}

	public List<ProdutoEntity> getListaProdutos() {
		Long codigo = 20L;
		em.find(ProdutoEntity.class, codigo);
		Query Query = em.createQuery("from Produto");
		List<ProdutoEntity> produto = Query.getResultList();
		return produto;
	}

	@Transactional
	public void delete(Long codigo) {
		ProdutoEntity produto = new ProdutoEntity();
		produto.setCodigo(codigo);
		produto = em.find(ProdutoEntity.class, codigo);
		em.remove(produto);
		// tenho que criar o produto para depois eu excluir
	}
}
