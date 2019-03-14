package br.com.softblue.loucademia.domain.acesso;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.com.softblue.loucademia.domain.aluno.Aluno;

@Stateless
public class AcessoRepository {

	@PersistenceContext
	private EntityManager em;
	
	public Acesso findUltimoAcesso(Aluno aluno) {
		try {
			return em.createQuery("SELECT a FROM Acesso a WHERE a.aluno.matricula = :matricula ORDER BY a.id DESC", Acesso.class)
					.setParameter("matricula", aluno.getMatricula())
					.setMaxResults(1)
					.getSingleResult();
		
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public void store(Acesso acesso) {
		em.persist(acesso);
	}
}
