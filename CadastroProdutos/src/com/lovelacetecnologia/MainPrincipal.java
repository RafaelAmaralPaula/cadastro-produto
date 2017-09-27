package com.lovelacetecnologia;

import java.util.Random;
import java.util.Scanner;

import com.lovelacetecnologia.model.Produto;
import com.lovelacetecnologia.service.IProdutoService;
import com.lovelacetecnologia.service.ProdutoService;

public class MainPrincipal {

	public static void main(String[] args) {

		IProdutoService servico = new ProdutoService();
		Scanner teclado = new Scanner(System.in);

		Random random = new Random();

		boolean continua = true;

		while (continua) {

			System.out.println("O que deseja fazer: [0]Incluir [1]Alterar [2]Remover [3]Lista Todos [4]Buscar");
			Integer escolha = teclado.nextInt();

			Produto produto = new Produto();

			switch (escolha) {

			case 0:

				System.out.println("Nome Do Produto: ");
				produto.setId(random.nextInt(100));
				produto.setDecricao(teclado.next());

				System.out.println("Preço:");
				produto.setPreco(teclado.nextDouble());

				servico.criar(produto);

				break;

			case 1:

				System.out.println("Qual Id:");

				Produto encontrado = servico.buscar(teclado.nextInt());
				
				System.out.println("Nome Do Produto: ");
				encontrado.setDecricao(teclado.next());

				System.out.println("Preço:");
				encontrado.setPreco(teclado.nextDouble());
				
				servico.alterar(encontrado);
				break;

			case 2:
				
				System.out.println("Qual Id:");
				servico.remover(teclado.nextInt());
				
				break;

			case 3:
				
				for (Produto p : servico.listarTodos()) {

					System.err.println(
							"ID: " + p.getId() + " | " + "Nome:" + p.getDecricao() + " | " + " Preço: " + p.getPreco());

				}
				break;

				
			case 4:

				System.out.println("Qual Id:");
				Produto p = servico.buscar(teclado.nextInt());
				
				if(p != null ){
					System.out.println("Encontrado: Descrição - " + p.getDecricao() + " Preço - " + p.getPreco());
				}
				
				break;	
			
			default:

				System.err.println("Erro !");

				break;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Deseja continuar?[S/N]: ");
			String s = teclado.next();
			continua = s.equalsIgnoreCase("S") ? true : false;
		}

		teclado.close();

	}

}
