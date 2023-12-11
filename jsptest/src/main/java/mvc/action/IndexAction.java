package mvc.action;

import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvc.control.ActionForward;

public class IndexAction implements Action {
//액션 포워드

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//DAO CURD 일을 처리한다 : 로직(팀에서 정한다.) 검색하는 기능을 진행한다. request에서 얻어온다.
		//request를 ActionForward 넣어준다.
		System.out.println("indexAction execute 실행");
		return new ActionForward("index.jsp", false); // 트루=리다이렉트 폴스=포워드
	}

}
