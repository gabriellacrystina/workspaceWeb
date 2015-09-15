package Modelo;

import java.util.ArrayList;

public class Vendedor {

	private int codigoVendedor;
	private String nomeVendedor;
	private ArrayList<Venda> vendas = new ArrayList<Venda>();
	
	
	public int getCodigo() {
		return codigoVendedor;
	}
	public void setCodigo(int codigo) {
		this.codigoVendedor = codigo;
	}
	public String getNome() {
		return nomeVendedor;
	}
	public void setNome(String nome) {
		this.nomeVendedor = nome;
	}
	public ArrayList<Venda> getVendas() {
		return vendas;
	}
	public void setVendas(ArrayList<Venda> vendas) {
		this.vendas = vendas;
	}
}