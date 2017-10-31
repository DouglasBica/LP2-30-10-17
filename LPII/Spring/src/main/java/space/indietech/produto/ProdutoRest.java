package space.indietech.produto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.indietech.produtoNovo.ProdutoBO;
import space.indietech.produtoNovo.ProdutoDTO;
import space.indietech.produtoNovo.ProdutoEntity;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoRest {

	private ProdutoService produtoService;

	@Autowired
	public ProdutoRest(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping
	public ResponseEntity<List<ProdutoBO>> getAll() {
		return ResponseEntity.ok(this.produtoService.getLista());
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<ProdutoEntity> getProdutoPelocodigo(@PathVariable("codigo") long codigo) {
		try {
			return ResponseEntity.ok(this.produtoService.getProdutoPeloCodigo(codigo));
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<ProdutoDTO> delete(@PathVariable("codigo") long codigo) {
		this.produtoService.deleteProduto(codigo);
		return ResponseEntity.noContent().build();
	}
}
