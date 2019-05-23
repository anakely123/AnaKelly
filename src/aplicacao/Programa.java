package aplicacao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.cliente;

public class Programa {

	private static String jpql;

	public static void main(String[] args) {
		Scanner scanner= new Scanner (System.in);
		String op;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		do {
			System.out.println(menu());
			op =  scanner.nextLine();
			switch (op) {
			case "1":
				inserirRegistro(entityManager);
			
				break;
			case "2":
				System.out.println(listarRegistro(entityManager));
				
				break;
			case "3":
				alterarRegistro(entityManager);
				
				break;
			case "4":
				System.out.println(removerRegistro(entityManager));
			
				break;
			
				

				
		    default:
		    	break;
			}
		}while(op != "0");
		entityManager.close();
		entityManagerFactory.close();
		}
	
		
	

	private static boolean removerRegistro(EntityManager entityManager) {
		cliente clienteFound = entityManager.find(cliente.class, 1);
		entityManager.getTransaction().begin();
		entityManager.remove(clienteFound);
		entityManager.getTransaction().commit();
		entityManager.close();
		Scanner entityManagerFactory = null;
		entityManagerFactory.close();
		
		
	}

	private static void alterarRegistro(EntityManager entityManager) {
		cliente clienteFound = entityManager.find(cliente.class, 1);
		clienteFound.setEndereco("Boa Hora");
		entityManager.getTransaction().begin();
		entityManager.persist(clienteFound);
		entityManager.getTransaction().commit();
		entityManager.close();
		Scanner entityManagerFactory = null;
		entityManagerFactory.close();
		
		
	}

	private static List<cliente> listarRegistro(EntityManager entityManager) {
		List<cliente> pessoas = entityManager.createQuery(jpql, cliente.class).getResultList();
		char[] cliente;
		System.out.println(cliente);
		entityManager.close();
		Scanner entityManagerFactory = null;
		entityManagerFactory.close();		
	}

	private static void inserirRegistro(EntityManager entityManager) {
		cliente clienteFound = entityManager.find(cliente.class, 1);
		clienteFound.setnome("nome");
		entityManager.getTransaction().begin();
		entityManager.persist(clienteFound);
		entityManager.getTransaction().commit();
		entityManager.close();
		Scanner entityManagerFactory;
		entityManagerFactory.close();
		
		
		
	}

	public static String menu() {
		String menu ="";
		menu += "Digite 1 para inserir os registros.\n";
		menu += "Digite 2 para listar os registros.\n";
		menu += "Digite 3 para alterar os registros.\n";
		menu += "Digite 4 para remover um registro;\n";
		menu += "Digite 0 para sair do programa.\n";
		
		return menu;
	}
	
}
