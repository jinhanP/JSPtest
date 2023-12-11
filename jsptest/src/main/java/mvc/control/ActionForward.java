package mvc.control;

public class ActionForward {
	private String url; // 어디 페이지를 보여줄지 결정
	private boolean redirect; // 트루=리다이렉트 폴스=포워드 방식
	
	
	public ActionForward() {
		
		
	}

	//액션에서 포워드 전달하기 위해 만들어줬다.
	public ActionForward(String url) {
		super();
		this.url = url;
	}


	public ActionForward(String url, boolean redirect) {
		super();
		this.url = url;
		this.redirect = redirect;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public boolean isRedirect() {
		return redirect;
	}


	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	} 
	
	
}
