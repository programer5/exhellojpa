package jpabasic.exhellojpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jpabasic.exhellojpa.domain.Member;

@SpringBootApplication
public class ExhellojpaApplication {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			
			Member findMember = em.find(Member.class, 1L);
			List<Member> result = em.createQuery("select m from Member m", Member.class)
									.setFirstResult(1)
									.setMaxResults(100)
									.getResultList();
			
			for (Member member : result) {
				System.out.println("member = " + member.getName());
			}

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}

		emf.close();
		
		SpringApplication.run(ExhellojpaApplication.class, args);
	}

}
