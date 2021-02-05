package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;
import vo.Cart;
import svc.DogCartSearchService;

public class DogCartSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
		// 가격으로 장바구니 항목을 검색하는 서비스 로직이 구현되있는
		// 객체를 생성함
		DogCartSearchService dogCartSearchService =
				new DogCartSearchService();
		
		// 검색에 사용할 시작값과 마지막값을 파라미터로 얻어옴
		int startMoney = Integer.parseInt(request.getParameter("startMoney"));
		int endMoney = Integer.parseInt(request.getParameter("endMoney"));
		
		// 시작값과 끝값 사이에 존재하는 금액을 가지고 있는 상품의 장바구니 항목을 
		// 검색하는 메소드 호출		
		ArrayList<Cart> cartList =
		dogCartSearchService.getCartSearchList(startMoney,
				endMoney, request);
		
		// 검색한 항목
		request.setAttribute("cartList", cartList);
		request.setAttribute("startMoney", startMoney);// 검색에 사용한 시작값
		request.setAttribute("endMoney", endMoney);// 검색에 사용한 끝값
		
		int totalMoney = 0;
		int money = 0;
		
		for(int i = 0; i < cartList.size(); i++) {
			money = cartList.get(i).getPrice() * cartList.get(i).getQty();
			totalMoney += money;
		}
		
		request.setAttribute("totalMoney", totalMoney);
		
		ActionForward forward = new ActionForward("dogCartList.jsp", false);
				
		return forward;
	}

}
