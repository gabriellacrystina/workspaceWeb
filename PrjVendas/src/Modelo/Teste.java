package Modelo;

public class Teste {
	static void main(String [] args){
		
		Vendedor v1 = new Vendedor();
		v1.setCodigo(1);
		v1.setNome("Maria");
		
		Vendedor v2 = new Vendedor();
		v1.setCodigo(2);
		v1.setNome("Joao");
		
		
		Venda venda1 = new Venda();
		venda1.setNumeroVenda(1);
		venda1.setValorVenda(123.90);
		venda1.setRegiao(Regiao.LESTE);
		
		v1.getVendas().add(venda1);
		venda1.setVendedor(v1);	
		
		/**Teste utilizado para desenvolver o pensamento sobre o relacionamento de dois objetos*/
	}
}
