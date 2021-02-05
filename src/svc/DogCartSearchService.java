package svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

// �������� ��ٱ��� �׸��� �˻�
public class DogCartSearchService {

public ArrayList<Cart> getCartSearchList(
		int start_money, int end_money, HttpServletRequest request) {
	
	HttpSession session = request.getSession();
	
	ArrayList<Cart> oldCartList = 
			(ArrayList<Cart>)session.getAttribute("cartList");
	// ���ǿ� �����Ǿ� �ִ� ��ٱ��� ��� ��ü�� ����
	ArrayList<Cart> cartList = new ArrayList<Cart>();
	// �˻��� ��ٱ��� �׸��� ������ ���ο� ��ü�� ������
	
	// ��ٱ��� ����� �ݺ��ϸ鼭 �˻� ������ �ش��ϴ� ��ٱ��� �׸��� ã�Ƽ�
	// ���� ���� ��ü( cartList )�� �߰��� ��
	for(int i = 0; i < oldCartList.size(); i++) {
                   // ��ٱ��� �׸��� ������ �˻� ���ݿ� �ش��ϴ����� �˻���		
		if(oldCartList.get(i).getPrice() >= start_money && oldCartList.get(i).getPrice() <= end_money) {
		    cartList.add(oldCartList.get(i));	
		}
	}
	
	return cartList;
  }
}
