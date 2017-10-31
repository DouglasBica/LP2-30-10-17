package space.indietech.produto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import space.indietech.produtoNovo.ProdutoBO;
import space.indietech.produtoNovo.ProdutoEntity;

@Component
public class ProdutoService {

	private ProdutoDao pDao;

	@Autowired
	public ProdutoService(ProdutoDao pDao) {
		this.pDao = pDao;
	}

	public List<ProdutoBO> getLista() {
		List<ProdutoEntity> entities = pDao.getListaProdutos();
		List<ProdutoBO> bos = new ArrayList<>();
		for (ProdutoEntity entity : entities) {
			ProdutoBO bo = new ProdutoBO();
			bo.setCodigo(entity.getCodigo());
			bo.setNome(entity.getNome());
			double lucro = entity.getPerc_lucro() / 100 * entity.getCusto();
			bo.setValorfinal(entity.getCusto() + lucro);
			bos.add(bo);

		}
		return bos;
	}

	public ProdutoEntity getProdutoPeloCodigo(long codigo) {
		List<ProdutoEntity> lista = pDao.getListaProdutos();
		for (ProdutoEntity produto : lista) {
			if (produto.getCodigo() == codigo) {
				return produto;
			}
		}
		throw new RuntimeException();
	}

	public void setNewProduto(ProdutoBO produto) {
		List<ProdutoEntity> lista = pDao.getListaProdutos();
		if (lista.size() == 0) {
			produto.setCodigo(1);
		} else {
			ProdutoEntity ultimoProdutoDaLista = lista.get(lista.size() - 1);
			produto.setCodigo(ultimoProdutoDaLista.getCodigo() + 1);
		}

	}

	public void deleteProduto(long codigo) {
		this.pDao.delete(codigo);
	}

}
