package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;


// Action Ŭ�������� ������ Action �������̽�
public interface Action {

	ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
	
}
