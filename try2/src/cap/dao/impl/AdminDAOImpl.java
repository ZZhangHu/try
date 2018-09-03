package cap.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cap.bean.Admin;
import cap.dao.AdminDAO;

public class AdminDAOImpl implements AdminDAO{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
		}

	@Override
	public List<Admin> findAdmins() {
		String hql="from hello morder by m.id";
		return (List<Admin>)getSession().createQuery(hql).list();
	}

	@Override
	public Admin findById(Integer id) {

		return (Admin)getSession().get(Admin.class, id);
	}

	@Override
	public void addAdmin(Admin admin) {
		getSession().save(admin);
		
	}

	@Override
	public List<Admin> findByPage(String hsql, int offset, int length) {
		Query query=getSession().createQuery(hsql);
		query.setFirstResult(offset);
		query.setMaxResults(length);
		List<Admin>list=query.list();
		return list;
	}

	@Override
	public int getTotalCount(String hql) {
		String count=getSession().createQuery(hql).uniqueResult().toString();
		return Integer.parseInt(count);
	}
	
	}
