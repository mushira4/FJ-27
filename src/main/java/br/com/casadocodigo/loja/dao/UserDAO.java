package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.User;

@Repository
public class UserDAO implements UserDetailsService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String jpql = "select u from User u where u.login = :login";
		TypedQuery<User> query = entityManager.createQuery(jpql, User.class);

		List<User> users = query.setParameter("login", username).getResultList();

		if (users.isEmpty())
			throw new UsernameNotFoundException(String.format("Usuário %s não encontrado", username));

		return users.get(0);
	}

}
