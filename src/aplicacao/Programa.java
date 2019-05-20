package aplicacao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.cliente;

public class Programa {

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
				System.out.println();listarRegistro(entityManager);
				
				break;
			case "3":
				alterarRegistro();
				
				break;
			case "4":
				removerRegistro();
			
				break;
			case "5":
				sairDoPrograma();
				
				break;
				
		    default:
		    	break;
			}
		}while(op != "0");
		entityManager.close();
		entityManagerFactory.close();
		}

	private static void sairDoPrograma() {
	
		
	}

	private static void removerRegistro() {

		
	}

	private static void alterarRegistro() {
	
		
	}

	private static List<cliente> listarRegistro(EntityManager entityManager) {
		String jpql = "SELECT c from cliente c";
		return entityManager.createQuery(jpql, cliente.class ).getResultList();
		
	}

	private static void inserirRegistro(EntityManager entityManager) {
		String jpql = "SELECT c from cliente c";
		
		
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
