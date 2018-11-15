package Classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ListaLivros implements Iterable<Livro>,Serializable{

	/**
	 * 
	 */
	private ArrayList<Livro> lc;
	
	public void SERIALIZARLIVROS(){
		 try{
	         FileOutputStream fos= new FileOutputStream("LISTALIVROS");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(lc);
	         oos.close();
	         fos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
	   }
	
	public void SERIALIZARLIVROSPEDIDOS(){
		 try{
	         FileOutputStream fos= new FileOutputStream("LISTALIVROSPEDIDOS");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(lc);
	         oos.close();
	         fos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
	   }
	
	@SuppressWarnings("unchecked")
	public void DESERIALIZARLIVROS(){
		try{
            FileInputStream fis = new FileInputStream("LISTALIVROS");
            ObjectInputStream ois = new ObjectInputStream(fis);
            lc = (ArrayList<Livro>) ois.readObject();
            ois.close();
            fis.close();
         }catch(IOException ioe){
        	 System.out.println("N�o existe livros salvos no sistema!\n");
             return;
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return;
          }
	}
	
	@SuppressWarnings("unchecked")
	public void DESERIALIZARLIVROSDOPEDIDO(){
		try{
            FileInputStream fis = new FileInputStream("LISTALIVROSPEDIDOS");
            ObjectInputStream ois = new ObjectInputStream(fis);
            lc = (ArrayList<Livro>) ois.readObject();
            ois.close();
            fis.close();
         }catch(IOException ioe){
             return;
          }catch(ClassNotFoundException c){
             return;
          }
	}
	
	public void ListalimpaArraylistL(){
		lc.clear();
	}
	
	public ListaLivros() {
		lc = new ArrayList<Livro>();
	}
	
	public void addLivro (Livro livro) {
		lc.add(livro);
	}

	public Livro getLivro (int indice) {
		return lc.get(indice);
	}
	
	public void removeLivro (Livro livro) {
		lc.remove(livro);
	}
	
	public void removeLivro (int indice) {
		lc.remove(indice);
	}
	
	public int size() {
		return lc.size();
	}
	
	// ordenação natural, usando o compareTo da Contato
	public void ordenaNomeAZ() {
		Collections.sort(lc);
	}
	
	
	// interface Iterable demanda implementação do método iterator
	// como ArrayList já tem iterator implementado, devolve
	// se fosse outra comnfiguração, poderia fazer uma inner class
	// para implementar a interface Iterator, contendo os métodos
	// hasNext e next (opcionalmente, remove)
	public Iterator<Livro> iterator() {
		return lc.iterator();
	}
}