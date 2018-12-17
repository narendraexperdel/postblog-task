package com.example.post.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.example.post.model.Post;

public class PostCustomRepositoryImpl implements PostCustomRepository {
    
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Post> gettopfivePost() {
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Post.class);
		criteria.addOrder(Order.desc("id"));
		criteria.add(Restrictions.eq("poststatus", 1));
		criteria.setMaxResults(5);
		return criteria.list();
	}
    
	@Transactional
	@Override
	public List<Post> postbySearch(String search) {
		/*Query query = null;
		String hqlselect;
		hqlselect = "select * from Post p where p.posttitle Like '%?%'";
		
		List<Post> posts = (List<Post>) entityManager.unwrap(Session.class).createQuery("SELECT  p FROM PostDetail p where p.PostTitle Like '%search%'");*/
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Post.class);
		criteria.add(Restrictions.ilike("posttitle", search, MatchMode.ANYWHERE));
		criteria.add(Restrictions.eq("poststatus", 1));
		return criteria.list();
	}

	@Override
	public List<Post> findAllPostByuserId(Integer userid) {
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Post.class);
		criteria.add(Restrictions.eq("postuserid.id", userid));
		criteria.add(Restrictions.ne("poststatus", 4));
		return criteria.list();
	}

}
