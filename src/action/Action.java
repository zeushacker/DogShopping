package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;


// Action 클래스들의 정의한 Action 인터페이스
public interface Action {

	ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
	
}
