package Main;

import java.text.SimpleDateFormat;
import java.util.*;

import Classes.*;

public class Menus {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		String nome,autor,senha,email,titulo,nomecliente;
		float preco,precototal =0;
		int op=1,opfinal=1,oplivro=1,menuadm=1,opcompras=1,opl=1,w,ped =0, posClientelogado=0;
		
		// criação da lista de livros
		ListaLivros minhaListaLivros = new ListaLivros();
		// criação da lista de livros de pedidos
		ListaLivros listaparabranco = new ListaLivros();
		// criação da lista de clientes
		ListaClientes minhaListaClientes = new ListaClientes();
		// criação da lista de pedidos
		ListaPedidos minhaListaPedidos = new ListaPedidos();
		// criação da lista de pedidos totais
		ListaPedidos minhaListaPedidosTOTAIS = new ListaPedidos();
		
		minhaListaLivros.DESERIALIZARLIVROS();
		minhaListaClientes.DESERIALIZARCLIENTES();
		minhaListaPedidos.DESERIALIZARPEDIDOS();
		minhaListaPedidosTOTAIS.DESERIALIZARPEDIDOS();
		
		do{
			exibeMenuINICIAL();
			op = teclado.nextInt();
		switch(op)
		{
		    case 0:
		            opfinal = 0; // seta 0 opção de sair do programa
		            break;
		    
		    case 1:
		    		do{
		    	    exibeMenuADM();
		    	    op = teclado.nextInt();
		    	    switch(op)
		    	    {
		    	        case 0:
		    	                menuadm=0;
		    	                break;
		    	        
		    	        case 1:
		    	                //cadastrando livro
		    	        		do{
		    	        		System.out.println("Cadastrando Livro");
		    	        		System.out.println("Digite Titulo:");
		    	        		nome = teclado.nextLine();
		    	        		nome = teclado.nextLine();
		    	        		System.out.println("Digite Autor:");
		    	        		autor = teclado.nextLine();
		    	        		System.out.println("Digite Valor:");
		    	        		preco = teclado.nextFloat();
		    	        		Livro l1 = new Livro(nome,autor,preco);
		    	        		minhaListaLivros.addLivro(l1);
		    	        		System.out.println("Digite 0 para sair!");
		    	        		oplivro = teclado.nextInt();
		    	        		}while(oplivro != 0);
		    	        		minhaListaLivros.SERIALIZARLIVROS();
		    	        		menuadm=1;
		    	        		break;
		    	        
		    	        case 2:
		    	                //listar todos os livros  ordem alfabetica AZ
		    	        	minhaListaLivros.ordenaNomeAZ();
		    	    		System.out.println("\n>>> Lista de Livros de A - Z:");
		    	    		listaTodososLivros(minhaListaLivros);
		    	    		menuadm=1;
		    	        	break;
		    	          
		    	        case 3:
	    	                // listar todos os clientes ordem alfabetica AZ
		    	        	minhaListaClientes.ordenaNomeAZ();
		    	    		System.out.println("\n>>> Lista de Clientes de A - Z:");
		    	    		listaTodososClientes(minhaListaClientes);
		    	    		menuadm=1;
	    	                break;
	    	                
		    	        case 4:
	    	                // listar todos os pedidos em ordem cronológica
		    	        	minhaListaPedidos.ordenaPedidosTempo();
		    	    		System.out.println("\n>>> Lista de Pedidos por ordem cronológica:");
		    	    		listaTodososPedidosADM1(minhaListaPedidosTOTAIS);
		    	    		System.out.println("VALOR TOTAL DOS PEDIDOS: R$" + listaTodososPedidosADM2(minhaListaPedidosTOTAIS));
		    	    		menuadm=1;
	    	                break;
		    	        
		    	        default:
		    	        	menuadm=1;
		    	    }
		    		}while(menuadm != 0);
		            break;
		    
		    case 2:
		    		do{
		    	    exibeMenuCLIENTE();
		    	    op = teclado.nextInt();
		    	    
		    	    switch(op)
		    	    {
		    	        case 0://sair do menu cliente
		    	                menuadm=0;
		    	                break;
		    	        
		    	        case 1: //cadastrar cliente
		    	        	do{
	    	        		System.out.println("Cadastrando Cliente");
	    	        		System.out.println("Digite Nome:");
	    	        		nome = teclado.nextLine();
	    	        		nome = teclado.nextLine();
	    	        		System.out.println("Digite Senha:");
	    	        		senha = teclado.nextLine();
	    	        		System.out.println("Digite Email:");
	    	        		email = teclado.nextLine();
	    	        		Cliente c1 = new Cliente(nome,senha,email);
	    	        		minhaListaClientes.addCliente(c1);
	    	        		System.out.println("Digite 0 para sair!");
	    	        		oplivro = teclado.nextInt();
		    	        	}while(oplivro !=0);
		    	        	minhaListaClientes.SERIALIZARCLIENTES();
		    	                menuadm=1;
		    	                break;
		    	        
		    	        case 2: //logar cliente e abrir menu de compras
	    	        		boolean a = false;
						do{
		    	        		System.out.println("Logando na conta Cliente");
		    	                System.out.println("Digite email");
		    	                email = teclado.nextLine();
		    	                email = teclado.nextLine();
		    	                System.out.println("Digite senha");
		    	                senha = teclado.nextLine();
		    	            	for (int i = 0; i < minhaListaClientes.size(); i++) {
		    	            		Cliente c = minhaListaClientes.getCliente(i);
		    	            		if(senha.equals(c.getSenha())){
		    	            			a = true;
		    	            			System.out.println("Usuario: " + c.getNome() + " - Logado com Sucesso!");
		    	            			nomecliente = c.getNome();
		    	            			posClientelogado = i;
		    	            		}
		    	            	}
		    	        		}while(a == false);
								// criação da lista de livros de pedidos
								ListaLivros minhaListaLivrosPedidos = new ListaLivros();
								minhaListaLivrosPedidos.DESERIALIZARLIVROSDOPEDIDO();
		    	                do{
								exibeMenuCOMPRAS();
								opcompras =1;
								op = teclado.nextInt();
								switch(op)
								{
								    case 0:
								            //volta menu cliente
								    		opcompras =0;
								            break;
								    
								    case 1:
								            // procura livros por titulo
								    	do{
				    	                System.out.println("Digite Titulo do Livro");
				    	                titulo = teclado.nextLine();
				    	                titulo = teclado.nextLine();
				    	            	for (int i = 0; i < minhaListaLivros.size(); i++) {
				    	            		Livro c = minhaListaLivros.getLivro(i);
				    	            		if(titulo.equalsIgnoreCase(c.getTitulo())){
				    	            			System.out.println("Livro encontrado");
				    	            			System.out.println("Nome livro: " + c.getTitulo());
				    	            			System.out.println("Autor do Livro: " + c.getTitulo());
				    	            			System.out.println("Preço do Livro: " + c.getValor());
				    	            			System.out.println("Livro adicionado a lista de livros");
				    	            			minhaListaLivrosPedidos.addLivro(c);
				    	            			precototal = precototal + c.getValor();
				    	            		}
				    	            	}
				    	            	System.out.println("Para sair digite 0");
				    	            	opl = teclado.nextInt();
								    	}while(opl !=0);
								    	minhaListaLivrosPedidos.SERIALIZARLIVROSPEDIDOS();
								    	opcompras=1;
								    		menuadm=1;
								            break;
								    
								    case 2:
								            // procurar livros lista geral
								    		do{
								    		System.out.println("Lista de Livros:");
								    		minhaListaLivros.ordenaNomeAZ();
								    		listaTodososcomordemLivros(minhaListaLivros);
								    		System.out.println("Escolha Por ordem que aparece na tela");
								    		w = teclado.nextInt()-1;
								    		Livro c = minhaListaLivros.getLivro(w);
			    	            			System.out.println("Livro encontrado");
			    	            			System.out.println("Nome livro: " + c.getTitulo());
			    	            			System.out.println("Autor do Livro: " + c.getTitulo());
			    	            			System.out.println("Preço do Livro: " + c.getValor());
			    	            			System.out.println("Livro adicionado a lista de livros");
								    		minhaListaLivrosPedidos.addLivro(c);
								    		precototal = precototal + c.getValor();
								    		
					    	            	System.out.println("Para sair digite 0");
					    	            	opl = teclado.nextInt();
								    		}while(opl !=0);
								    		minhaListaLivrosPedidos.SERIALIZARLIVROSPEDIDOS();;
								    		opcompras=1;
								    		menuadm=1;
								            break;
								            
								    case 3:
							            //Fechar pedido
								    	System.out.println("Fechando Pedido");
								    	ped = minhaListaPedidosTOTAIS.size()+1;
								    	listaTodososcomordemLivros(minhaListaLivrosPedidos);
								    	System.out.println("VALOR: R$" + listaTodososLIVROSADM2(minhaListaLivrosPedidos));
								    	precototal = listaTodososLIVROSADM2(minhaListaLivrosPedidos);
								    	System.out.println("Deseja finalizar pedidod?");
								    	System.out.println("0-Não");
								    	System.out.println("1-Sim");
								    	op = teclado.nextInt();
								    	if(op == 1){
								    	System.out.println("Digite Numero de Cartão de Crédito");
								    	String cart = teclado.nextLine();
								    	cart = teclado.nextLine();
							   			GregorianCalendar dateA = new GregorianCalendar();
							   			Cliente c = minhaListaClientes.getCliente(posClientelogado);
								    	Pedido pedido1 = new Pedido(ped,c,minhaListaLivrosPedidos,dateA,precototal,cart,c.getNome());
								    	minhaListaPedidos.addPedido(pedido1);
								    	minhaListaPedidosTOTAIS.addPedido(pedido1);
								    	System.out.println("PEDIDO REALIZADO COM SUCESSO!");
								    	minhaListaPedidos.ListalimpaArraylist();
								    	minhaListaPedidosTOTAIS.SERIALIZARPEDIDOS();
								    	listaparabranco.SERIALIZARLIVROSPEDIDOS();
								    	minhaListaLivrosPedidos = new ListaLivros();
								    	precototal =0;
								    	}
								    	opcompras=1;
								    	menuadm=1;
							            break;
							        
								    case 4:
								    	nomecliente = minhaListaClientes.getCliente(posClientelogado).getNome();
								    	listaTodososPedidosUSUARIO2(minhaListaPedidosTOTAIS,nomecliente);
								    	menuadm=1;
								    	opcompras=1;
							            break;
								    
								    default:
								    menuadm=1;
								    opcompras=1;
								}
								
		    	                }while(opcompras != 0);
		    	                menuadm=1;
		    	                opcompras=1;
		    	                break;
		    	        
		    	        default:
		    	                menuadm=1;
		    	    }
		    	    }while(menuadm != 0);
		            break;
		    
		    default:
		}
		}while(opfinal != 0);

	}

public static void listaTodososClientes (ListaClientes ml ) {
		for (Cliente c : ml) {
			System.out.println("NOME:" + c.getNome() + " ( email: " + c.getEmail() + " )");
		}
	}

public static void listaTodososPedidosADM1 (ListaPedidos ml ) {
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	for (Pedido c : ml) {
		System.out.println("Numero do Pedido: " + c.getNumped() + ". (" + c.getCliente().getNome() + " - " + sdf.format(c.getPdata().getTime()) + ")");
		listaTodososLivros(c.getLivros());
		System.out.println("NUMERO DE CARTAO DE CREDITO:" + c.getCartao());
		System.out.println("Valor Total do Pedido: R$" + c.getPrecototal());
		System.out.println("");
	}
}

public static float listaTodososPedidosADM2 (ListaPedidos ml ) {
	float a =0;
	for (Pedido c : ml) {
		a = a + c.getPrecototal();
	}
	return a;
}

public static float listaTodososLIVROSADM2 (ListaLivros ml ) {
	float a =0;
	for (Livro c : ml) {
		a = a + c.getValor();
	}
	return a;
}

public static void listaTodososPedidosUSUARIO (ListaPedidos ml ) {
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	for (Pedido c : ml) {
		System.out.println("Numero do Pedido: " + c.getNumped() + ". (" + 
				c.getCliente().getNome() + " - " + sdf.format(c.getPdata().getTime()) + ")");
		System.out.println("Livros Pedidos");
		listaTodososLivros(c.getLivros());
		System.out.println("Valor Total do Pedido: R$" + c.getPrecototal());
		System.out.println("");
	}
}
public static void listaTodososPedidosUSUARIO2 (ListaPedidos ml,String nome) {
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	for (Pedido c : ml) {
		if(c.getNomep() ==nome){
		System.out.println("Numero do Pedido: " + c.getNumped() + ". (" + 
				c.getCliente().getNome() + " - " + sdf.format(c.getPdata().getTime()) + ")");
		System.out.println("Livros Pedidos");
		listaTodososLivros(c.getLivros());
		System.out.println("Valor Total do Pedido: R$" + c.getPrecototal());
		System.out.println("");
		}
	}
}


public static void listaTodososLivros (ListaLivros ml ) {
	for (Livro c : ml) {
		System.out.println("TITULO:" + c.getTitulo() + " (" + 
				"AUTOR:" + c.getAutor() + " - " + "R$" + c.getValor() + ")");
	}
}

public static void listaTodososcomordemLivros (ListaLivros ml ) {
	int i =1;
	for (Livro c : ml) {
		System.out.println((i) + ". TITULO:" + c.getTitulo() + " (" + 
				"AUTOR:" + c.getAutor() + " - " + c.getValor() + ")");
		i++;
	}
}

public static boolean ComparaSenha(String senha,ListaClientes ml ) {
	boolean a =false;
	for (int i = 0; i < ml.size(); i++) {
	Cliente c = ml.getCliente(i);
	if(senha.equals(c.getSenha())){
		a = true;
	}	
}
	return a;
}

public static void exibeMenuINICIAL(){
    System.out.println("Bem-vindo ao Menu Inicial! Escolha uma opção do Menu:\n\n"
            + "0. Sair\n"
            + "1. Menu Administrativo\n"
            + "2. Menu Cliente\n");

}

public static void exibeMenuADM(){
    System.out.println("Bem-vindo ao Menu Administrativo! Escolha uma opção do Menu:\n\n"
            + "0. Voltar Menu Inicial\n"
            + "1. Cadastrar Livro\n"
            + "2. Listar todos os livros\n"
            + "3. Listar todos os clientes\n"
            + "4. Listar todos os pedidos\n");

}
public static void exibeMenuCLIENTE(){
    System.out.println("Bem-vindo ao menu do Cliente! Escolha uma opção do Menu:\n\n"
            + "0. Voltar Menu Inicial\n"
            + "1. Cadastrar Cliente\n"
            + "2. Login do Cliente\n");

}

public static void exibeMenuCOMPRAS(){
    System.out.println("Bem-vindo ao menu de Compras! Escolha uma opção do Menu:\n\n"
            + "0. Logoff do cliente\n"//voltar menu inicial
            + "1. Procurar Livros por titulo\n"
            + "2. Procurar Livros Lista geral\n"
            + "3. Fechar pedido\n"
            + "4. Listar Pedidos de usuario\n");

}
}