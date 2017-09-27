package com.lovelacetecnologia.service;

import java.util.List;

import com.lovelacetecnologia.model.Produto;

public interface IProdutoService {
	
	public void criar(Produto produto);
	public void alterar(Produto produto);
	public void remover(Integer id);
	public Produto buscar(Integer id);
	public List<Produto> listarTodos();

}
