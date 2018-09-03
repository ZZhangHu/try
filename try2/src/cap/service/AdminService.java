package cap.service;

import java.util.List;

import cap.bean.Admin;
import cap.util.PageBean;

public interface AdminService {
public List<Admin> findAdmins();
public Admin findById(Integer id);
public void addAdmin(Admin admin);
public PageBean findForPage(int pageSize,int  currentPage);
}
