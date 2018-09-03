package cap.dao;

import java.util.List;

import cap.bean.Admin;

public interface AdminDAO {
	public List<Admin> findAdmins();
	public Admin findById(Integer id);
	public void addAdmin(Admin admin);
	public List<Admin> findByPage(final String hsql,final int offset,final int length);
	public int getTotalCount(String hql);
}
