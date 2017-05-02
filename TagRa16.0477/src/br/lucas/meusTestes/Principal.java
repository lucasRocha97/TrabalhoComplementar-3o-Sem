package br.lucas.meusTestes;

import java.math.BigDecimal;
import java.util.List;

import br.lucas.minhaArvore.UniArvore;
import br.lucas.minhaArvore.UniArvoreImpl;
import br.lucas.minhaArvore.UniNode;
import br.lucas.minhaArvore.UniNodeImpl;

public class Principal {
	public Principal() {
		Conta contaAgua = new Conta(1, "Água", new BigDecimal(120));
		UniNode<Conta> nodeAgua = new UniNodeImpl<>(contaAgua);

		Conta contaAluguel = new Conta(2, "Aluguel", new BigDecimal(840));
		UniNode<Conta> nodeAluguel = new UniNodeImpl<>(contaAluguel);

		Conta contaInterTele = new Conta(3, "Internet Telefone", new BigDecimal(325));
		UniNode<Conta> nodeInterTele = new UniNodeImpl<>(contaInterTele);

		Conta contaEnergia = new Conta(4, "Energia Eletrica", new BigDecimal(460));
		UniNode<Conta> nodeEnergia = new UniNodeImpl<>(contaEnergia);

		Conta despesasAdm = new Conta(1, "Despesas Administrativas", new BigDecimal(0));
		UniNode<Conta> nodeAdm = new UniNodeImpl<>(despesasAdm);

		nodeAdm.addFilhos(nodeAgua);
		nodeAdm.addFilhos(nodeAluguel);
		nodeAdm.addFilhos(nodeInterTele);
		nodeAdm.addFilhos(nodeEnergia);

		Conta contaServLimp = new Conta(1, "Serviço de Limpeza", new BigDecimal(439.00));
		UniNode<Conta> nodeServLimp = new UniNodeImpl<>(contaServLimp);

		Conta contaServManu = new Conta(2, "Serviços de Manutenção", new BigDecimal(1800.00));
		UniNode<Conta> nodeSerManu = new UniNodeImpl<>(contaServManu);

		Conta manuLimp = new Conta(2, "Manutenção e Limpeza", new BigDecimal(0));
		UniNode<Conta> nodeManuLimp = new UniNodeImpl<>(manuLimp);
		nodeManuLimp.addFilhos(nodeServLimp);
		nodeManuLimp.addFilhos(nodeSerManu);

		Conta contaBeneficios = new Conta(1, "Beneficios", new BigDecimal(900.00));
		UniNode<Conta> nodeBeneficios = new UniNodeImpl<>(contaBeneficios);

		Conta contaEncargos = new Conta(2, "Encargos", new BigDecimal(1200.00));
		UniNode<Conta> nodeEncargos = new UniNodeImpl<>(contaEncargos);

		Conta contaSalarios = new Conta(3, "Salários", new BigDecimal(4100.00));
		UniNode<Conta> nodeSalarios = new UniNodeImpl<>(contaSalarios);

		Conta gastosPessoais = new Conta(3, "Gastos com Pessoal", new BigDecimal(0));
		UniNode<Conta> nodeGastosP = new UniNodeImpl<>(gastosPessoais);
		nodeGastosP.addFilhos(nodeBeneficios);
		nodeGastosP.addFilhos(nodeEncargos);
		nodeGastosP.addFilhos(nodeSalarios);

		Conta contaMat = new Conta(1, "Materiais de Escritórios", new BigDecimal(990.00));
		UniNode<Conta> nodeMat = new UniNodeImpl<>(contaMat);

		Conta contaMatLimp = new Conta(2, "Materiais de limpeza", new BigDecimal(430.50));
		UniNode<Conta> nodeMatLimp = new UniNodeImpl<>(contaMatLimp);

		Conta materiais = new Conta(4, "Matériais", new BigDecimal(0));
		UniNode<Conta> nodeMateriais = new UniNodeImpl<>(materiais);
		nodeMateriais.addFilhos(nodeMat);
		nodeMateriais.addFilhos(nodeMatLimp);

		Conta despesasOper = new Conta(1, "Despesas Operacionais", new BigDecimal(0));
		UniNode<Conta> nodeOper = new UniNodeImpl<>(despesasOper);
		nodeOper.addFilhos(nodeAdm);
		nodeOper.addFilhos(nodeManuLimp);
		nodeOper.addFilhos(nodeGastosP);
		nodeOper.addFilhos(nodeMateriais);

		UniArvore<UniNode<Conta>> planoContas = new UniArvoreImpl(nodeOper);
		mostrarTodosConsole(planoContas.getRaiz(), " , ");
		somarFilhos(planoContas.getRaiz()); 
		System.out.println("\nSoma dos gastos  R$: " + planoContas.getRaiz().getConteudo().getValor());

	}
	
	public void somarFilhos(UniNode<Conta> noRaiz) {
		List<UniNode<Conta>> filhos = noRaiz.getFilhos();

		for (int i = 0; i < filhos.size(); i++) {
			
			if (filhos.get(i).isLeaf()) {
				
				noRaiz.getConteudo().setValor(noRaiz.getConteudo().getValor().add(filhos.get(i)
						.getConteudo().getValor()));
			} 
			else {
				
				somarFilhos(filhos.get(i));
				noRaiz.getConteudo().setValor(noRaiz.getConteudo().getValor()
						.add(filhos.get(i).getConteudo().getValor()));
			}
		}

	}

	public void mostrarTodosConsole(UniNode<Conta> noRaiz, String tabulacao) {
		List<UniNode<Conta>> filhos = noRaiz.getFilhos();

		if(noRaiz.isLeaf()){
			System.out.println(tabulacao.split(",")[0] + tabulacao.split(",")[1] +String.format("%02d", noRaiz.getConteudo().getId()) + "\t\t\t" + 
					tabulacao.split(",")[0] + noRaiz.getConteudo().getNome() +
					": R$" + noRaiz.getConteudo().getValor());
		}
		else{
			System.out.println(tabulacao.split(",")[0] + tabulacao.split(",")[1] +String.format("%02d", noRaiz.getConteudo().getId()) + "\t\t\t" + 
					tabulacao.split(",")[0] + noRaiz.getConteudo().getNome());
			tabulacao = " " + tabulacao + String.format("%02d", noRaiz.getConteudo().getId()) + ".";
			for(int i = 0; i < filhos.size(); i++){	
				mostrarTodosConsole(filhos.get(i), tabulacao);
				
			}
		}

	}

	public static void main(String[] args) {
		new Principal();
	}

}
