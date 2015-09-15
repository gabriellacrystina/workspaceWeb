package Modelo;

public class Venda {

	private int numeroVenda;
	private double valorVenda;
	private Vendedor vendedor;
	private Regiao regiao;
	
	public int getNumeroVenda() {
		return numeroVenda;
	}
	public void setNumeroVenda(int numeroVenda) {
		this.numeroVenda = numeroVenda;
	}
	public double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Regiao getRegiao() {
		return regiao;
	}
	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}	
}
