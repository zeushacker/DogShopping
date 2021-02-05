package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import vo.ActionForward;
import svc.DogCartListService;
import vo.Cart;


public class DogCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		DogCartListService dogCartListService = new DogCartListService();
		
		ArrayList<Cart> cartList = dogCartListService.getCartList(request);
		
		// 토탈 금액 계산
		int totalMoney = 0;
		int money = 0;
		
		for(int i = 0; i < cartList.size(); i++) {
			money = cartList.get(i).getPrice() * cartList.get(i).getQty();
			totalMoney += money;
		}
		
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("cartList", cartList);
		
		ActionForward forward = new ActionForward("dogCartList.jsp", false);
		return forward;
	}

}
