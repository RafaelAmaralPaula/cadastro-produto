package com.lovelacetecnologia.service;

import java.util.List;

import com.lovelacetecnologia.model.Produto;
import com.lovelacetecnologia.model.daol.ProdutoDataBase;

public class ProdutoService implements IProdutoService {

	private ProdutoDataBase db = ProdutoDataBase.getInstance();

	@Override
	public void criar(Produto produto) {
		db.getLista().add(produto);
	}

	@Override
	public void alterar(Produto param) {

		for (Produto p : listarTodos()) {

			if (p.getId().equals(param.getId())) {

				p.setDecricao(param.getDecricao());
				p.setPreco(param.getPreco());
				break;
			}
		}
	}

	@Override
	public void remover(Integer id) {
		Produto produto = buscar(id);

		if (produto != null) {

			db.getLista().remove(produto);
			if (!db.getLista().contains(produto)) {
				System.out.println("Removido Com Sucesso");
			} else {
				System.out.println("Falha Na Remoção ");
			}

		} else {
			System.out.println("Produto Não Encontrado0");
		}
	}

	@Override
	public Produto buscar(Integer id) {

		for (Produto produto : listarTodos()) {
			if (produto.getId().equals(id)) {
				return produto;
			}
		}

		System.out.println("Produto Não Encontrado ! ");
		return null;
	}

	@Override
	public List<Produto> listarTodos() {
		return db.getLista();
	}

}
