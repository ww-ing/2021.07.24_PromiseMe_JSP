package common.controller;

public abstract class AbstractAction implements Action{
	
	//execute()추상메소드를 상속받아서 가지고 있음
	private String viewPage; //보여줄 뷰페이지 이름
	private boolean isRedirect=false;
	//페이지 이동방식이 redirect방식이면 true, forward방식이면 false를 줄 예정
	public String getViewPage() {
		return viewPage;
	}
	public void setViewPage(String viewPage) {
		this.viewPage = viewPage;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	
}
