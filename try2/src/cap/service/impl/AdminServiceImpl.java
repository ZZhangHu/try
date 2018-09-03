package cap.service.impl;

import java.util.List;

import cap.bean.Admin;
import cap.dao.AdminDAO;
import cap.service.AdminService;
import cap.util.PageBean;

public class AdminServiceImpl implements AdminService {
	private AdminDAO adminDAO;
	

	public AdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(AdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	@Override
	public List<Admin> findAdmins() {
		// TODO Auto-generated method stub
		return adminDAO.findAdmins();
	}

	@Override
	public Admin findById(Integer id) {
		// TODO Auto-generated method stub
		return adminDAO.findById(id);
	}

	@Override
	public void addAdmin(Admin admin) {
		adminDAO.addAdmin(admin);

	}
	@Override
	public PageBean findForPage(int pageSize, int currentPage) {
		final String hsql = "from Admin";
		int allRow = adminDAO.getTotalCount("select count(*) from Admin");
		int totalPage = PageBean.countTotalPage(pageSize, allRow);
		final int offset = PageBean.countOffset(pageSize, currentPage);
		int length = pageSize;
		final int page = PageBean.countCurrentPage(currentPage); 
		List list = adminDAO.findByPage(hsql, offset, length);
		PageBean pageBean = new PageBean();
		pageBean.setAllRow(allRow);
		pageBean.setCurrentPage(page);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(list);
		pageBean.init();
		return pageBean;

	}

}
