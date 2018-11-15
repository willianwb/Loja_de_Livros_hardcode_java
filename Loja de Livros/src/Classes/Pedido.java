package Classes;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Pedido implements Comparable<Pedido>,Serializable{

	private int numped;
	private Cliente cliente;
	private ListaLivros livros;
	private GregorianCalendar pdata;
	private float precototal;
	private String Cartao;
	private String nomep;
	
	public String getCartao() {
		return Cartao;
	}

	public void setCartao(String cartao) {
		Cartao = cartao;
	}

	public Pedido(int numped, Cliente cliente, ListaLivros livros, GregorianCalendar pdata, float precototal, String cart,String nome) {
		super();
		this.numped = numped;
		this.cliente = cliente;
		this.livros = livros;
		this.pdata = pdata;
		this.precototal = precototal;
		this.Cartao = cart;
		this.nomep = nome;
	}

	public float getPrecototal() {
		return precototal;
	}

	public void setPrecototal(float precototal) {
		this.precototal = precototal;
	}

	public int getNumped() {
		return numped;
	}

	public void setNumped(int numped) {
		this.numped = numped;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ListaLivros getLivros() {
		return livros;
	}

	public void setLivros(ListaLivros livros) {
		this.livros = livros;
	}

	public GregorianCalendar getPdata() {
		return pdata;
	}

	public void setPdata(GregorianCalendar pdata) {
		this.pdata = pdata;
	}

	public int compareTo(Pedido c) {
		return ((Integer)numped).compareTo(c.getNumped());
	}

	public String getNomep() {
		return nomep;
	}

	public void setNomep(String nomep) {
		this.nomep = nomep;
	}
	
	
	
	
}
