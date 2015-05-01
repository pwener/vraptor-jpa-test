package br.com.caelum.vraptor.dao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.vraptor.models.Notice;

@RequestScoped
public class NoticeDAO implements NoticeWorks, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;

	/**
	 * @deprecated
	 */
	@Deprecated
	public NoticeDAO() {
		this(null);
	}
	
	public NoticeDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void insert(Notice notice) {
		manager.persist(notice);
	}

	@Override
	public void delete(int id) {
		manager.remove(manager.find(Notice.class, id));
	}

	@Override
	public Notice getNotice(String title) {
		String sql = "SELECT notice FROM " + Notice.class.getName() + " WHERE notice.title = :title";
		Query query = manager.createQuery(sql);
		return (Notice) query.getSingleResult();
	}
	
	
}
