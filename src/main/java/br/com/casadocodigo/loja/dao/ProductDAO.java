package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Product;

@Repository
public class ProductDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(Product product) {
		entityManager.persist(product);
	}

	public List<Product> list() {
		return entityManager.createQuery("select distinct(p) from Product p join fetch p.prices", Product.class)
				.getResultList();
	}

	public Product find(Integer id) {
		return entityManager.createQuery("from Product p join fetch p.prices where p.id = :id", Product.class) //
				.setParameter("id", id) //
				.getSingleResult();

	}

}
