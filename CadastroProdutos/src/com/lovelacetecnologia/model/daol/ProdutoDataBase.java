package com.lovelacetecnologia.model.daol;

import java.util.ArrayList;
import java.util.List;

import com.lovelacetecnologia.model.Produto;

public class ProdutoDataBase {
	
	private static final ProdutoDataBase INSTANCE = new ProdutoDataBase();

	private List<Produto> lista;
	
	private ProdutoDataBase() {
		lista = new ArrayList<>();
	}
	
	public static ProdutoDataBase getInstance() {
		return INSTANCE;
	}
	
	public List<Produto> getLista() {
		return lista;
	}
	
}
