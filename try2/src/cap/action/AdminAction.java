package cap.action;

import java.util.List;

import cap.bean.Admin;
import cap.service.AdminService;
import cap.util.PageBean;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {
	private List<Admin> adminList;
	private Integer id;
	private Admin admin;
	private AdminService adminService;
	private PageBean pageBean;
	private int page=1;
	
	
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	public List<Admin> getAdminList() {
		return adminList;
	}
	public void setAdminList(List<Admin> adminList) {
		this.adminList = adminList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String list()
	{
		pageBean=adminService.findForPage(5, page);
		return SUCCESS;
	}
	public String add()
	{
		adminService.addAdmin(admin);
		return SUCCESS;
	}


}