package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;
import svc.DogCartQtyDownService;

public class DogCartQtyDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String kind = request.getParameter("kind");
		
		DogCartQtyDownService dogCartQtyDownService = 
				new DogCartQtyDownService();
		dogCartQtyDownService.downCartQty(kind, request);
		
		ActionForward forward = new ActionForward("dogCartList.dog", true);
			
		return forward;
	}

}
