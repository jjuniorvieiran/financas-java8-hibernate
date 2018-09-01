package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setTitular("Leonardo");
		conta.setBanco("Caixa Economica");
		conta.setAgencia("123");
		conta.setNumero("54321");

		/**
		 * Usando HSQLDB
		 */

		// EntityManagerFactory emf = Persistence
		// 		.createEntityManagerFactory("contas-hsqldb");

		/**
		 * Usando PostgreSQL
		 */
		// EntityManagerFactory emf = Persistence
		// 		.createEntityManagerFactory("contas-postgres");

		/**
		 * Usando MySQL
		 */
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		em.persist(conta);

		em.getTransaction().commit();
		em.close();
	}
}
