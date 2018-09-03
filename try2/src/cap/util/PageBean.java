package cap.util;

import java.util.List;

public class PageBean {
	private List list;	
	private int allRow;
	private int totalPage;
	private int currentPage;
	private int pageSize;	
	private boolean isFirstPage;
	private boolean isLastPage;
	private boolean hasPreviewPage;
	private boolean hasNextPage;
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getAllRow() {
		return allRow;
	}
	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 * initialize page information 
	 */
	public void init(){
		this.isFirstPage = isFirstPage();
		this.isLastPage = isLastPage();
		this.hasPreviewPage = isHasPreviewPage();
		this.hasNextPage = isHasNextPage();
	}
	
	public boolean isFirstPage() {
		return currentPage == 1;
	}
 
	public boolean isLastPage() {
		return currentPage == totalPage;
	}
 
	public boolean isHasPreviewPage() {
		return currentPage !=1;
	}
 
	public boolean isHasNextPage() {
		return currentPage != totalPage;
	}
	
	public static int countTotalPage(final int pageSize,final int allRows){
		return allRows%pageSize == 0 ? allRows/pageSize : allRows/pageSize + 1;
	}
	
	public static int countOffset(final int pageSize, final int currentPage){
		return pageSize*(currentPage-1);
	}
	
	public static int countCurrentPage(int page){
		return page==0?1:page;
	}


}
