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
    
		// �������� ��ٱ��� �׸��� �˻��ϴ� ���� ������ �������ִ�
		// ��ü�� ������
		DogCartSearchService dogCartSearchService =
				new DogCartSearchService();
		
		// �˻��� ����� ���۰��� ���������� �Ķ���ͷ� ����
		int startMoney = Integer.parseInt(request.getParameter("startMoney"));
		int endMoney = Integer.parseInt(request.getParameter("endMoney"));
		
		// ���۰��� ���� ���̿� �����ϴ� �ݾ��� ������ �ִ� ��ǰ�� ��ٱ��� �׸��� 
		// �˻��ϴ� �޼ҵ� ȣ��		
		ArrayList<Cart> cartList =
		dogCartSearchService.getCartSearchList(startMoney,
				endMoney, request);
		
		// �˻��� �׸�
		request.setAttribute("cartList", cartList);
		request.setAttribute("startMoney", startMoney);// �˻��� ����� ���۰�
		request.setAttribute("endMoney", endMoney);// �˻��� ����� ����
		
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
