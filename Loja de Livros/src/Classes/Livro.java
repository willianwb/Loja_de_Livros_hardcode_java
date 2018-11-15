package Classes;

import java.io.Serializable;

/**
 * 
 */

/**
 * @author willian
 *
 */
public class Livro implements Comparable<Livro>,Serializable{
	private String titulo;
	private String autor;
	private float valor;

	public Livro(String titulo, String autor, float valor) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.valor = valor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Livro() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Livro c) {
		return titulo.compareToIgnoreCase(c.getTitulo());
	}



}
