package Classes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class ListaPedidos implements Iterable<Pedido>{

	private ArrayList<Pedido> lc;
	
	public void SERIALIZARPEDIDOS(){
		 try{
	         FileOutputStream fos= new FileOutputStream("LISTAPEDIDOS");
	         ObjectOutputStream oos= new ObjectOutputStream(fos);
	         oos.writeObject(lc);
	         oos.close();
	         fos.close();
	       }catch(IOException ioe){
	            ioe.printStackTrace();
	        }
	   }
	
	@SuppressWarnings("unchecked")
	public void DESERIALIZARPEDIDOS(){
		try{
            FileInputStream fis = new FileInputStream("LISTAPEDIDOS");
            ObjectInputStream ois = new ObjectInputStream(fis);
            lc = (ArrayList<Pedido>) ois.readObject();
            ois.close();
            fis.close();
         }catch(IOException ioe){
        	 System.out.println("N�o existe pedidos salvos no sistema!\n");
             return;
          }catch(ClassNotFoundException c){
             System.out.println("Class not found");
             c.printStackTrace();
             return;
          }
	}
	
	public void ListalimpaArraylist(){
		lc.clear();
	}
	
	public ListaPedidos() {
		lc = new ArrayList<Pedido>();
	}
	
	public void addPedido (Pedido pedido) {
		lc.add(pedido);
	}

	public Pedido getPedido (int indice) {
		return lc.get(indice);
	}
	
	public void removePedido (Pedido pedido) {
		lc.remove(pedido);
	}
	
	public void removePedido (int indice) {
		lc.remove(indice);
	}
	
	public int size() {
		return lc.size();
	}
	
	// ordenação natural, usando o compareTo da Contato
	public void ordenaPedidoNum() {
		Collections.sort(lc);
	}
	
	// ordem reversa da ordem natural
	
	// usando interface Comparator com classe anônima
	public void ordenaDataPed() {
		Collections.sort(lc, new Comparator<Pedido>(){
			public int compare(Pedido c1, Pedido c2) {
				return c1.getPdata().compareTo(c2.getPdata());
			}
		});
	}
	
	//usando DAY_OF_YEAR ao invés de separar o mês = identico ao acima
	public void ordenaPedidosTempo() {
		Collections.sort(lc, new Comparator<Pedido>(){
			public int compare(Pedido c1, Pedido c2) {
					return  Integer.compare(
							c1.getPdata().get(Calendar.DAY_OF_YEAR), 
							c2.getPdata().get(Calendar.DAY_OF_YEAR));
			}
		});
	}
	
	// interface Iterable demanda implementação do método iterator
	// como ArrayList já tem iterator implementado, devolve
	// se fosse outra comnfiguração, poderia fazer uma inner class
	// para implementar a interface Iterator, contendo os métodos
	// hasNext e next (opcionalmente, remove)
	public Iterator<Pedido> iterator() {
		return lc.iterator();
	}
}