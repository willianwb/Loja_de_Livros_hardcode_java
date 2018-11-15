package Classes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class ListaClientes implements Iterable<Cliente>,Serializable{

	private ArrayList<Cliente> lc;
	
	public void SERIALIZARCLIENTES(){
		 try{
	         FileOutputStream fos= new FileOutputStream("LISTACLIENTES");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(lc);
	         oos.close();
	         fos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
	   }
	
	@SuppressWarnings("unchecked")
	public void DESERIALIZARCLIENTES(){
		try{
            FileInputStream fis = new FileInputStream("LISTACLIENTES");
            ObjectInputStream ois = new ObjectInputStream(fis);
            lc = (ArrayList<Cliente>) ois.readObject();
            ois.close();
            fis.close();
         }catch(IOException ioe){
        	 System.out.println("N�o existe cliente salvo no sistema!\n");
             return;
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return;
          }
	}
	
	public ListaClientes() {
		lc = new ArrayList<Cliente>();
	}
	
	public void addCliente (Cliente cliente) {
		lc.add(cliente);
	}

	public Cliente getCliente (int indice) {
		return lc.get(indice);
	}
	
	public void removeCliente (Cliente cliente) {
		lc.remove(cliente);
	}
	
	public void removeCliente (int indice) {
		lc.remove(indice);
	}
	
	public int size() {
		return lc.size();
	}
	
	// ordenação natural, usando o compareTo da Contato
	public void ordenaNomeAZ() {
		Collections.sort(lc);
	}
	
	public Iterator<Cliente> iterator() {
		return lc.iterator();
	}
}