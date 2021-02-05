package svc;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

// 가격으로 장바구니 항목을 검색
public class DogCartSearchService {

public ArrayList<Cart> getCartSearchList(
		int start_money, int end_money, HttpServletRequest request) {
	
	HttpSession session = request.getSession();
	
	ArrayList<Cart> oldCartList = 
			(ArrayList<Cart>)session.getAttribute("cartList");
	// 세션에 저정되어 있는 장바구니 목록 객체를 얻어옴
	ArrayList<Cart> cartList = new ArrayList<Cart>();
	// 검색된 장바구니 항목을 저장할 새로운 객체를 생성함
	
	// 장바구니 목록을 반복하면서 검색 범위에 해당하는 장바구니 항목을 찾아서
	// 새로 만든 객체( cartList )에 추가를 함
	for(int i = 0; i < oldCartList.size(); i++) {
                   // 장바구니 항목중 가격이 검색 가격에 해당하는지를 검사함		
		if(oldCartList.get(i).getPrice() >= start_money && oldCartList.get(i).getPrice() <= end_money) {
		    cartList.add(oldCartList.get(i));	
		}
	}
	
	return cartList;
  }
}
