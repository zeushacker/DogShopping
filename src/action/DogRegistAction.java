package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.DogRegistService;
import vo.ActionForward;
import vo.Dog;

public class DogRegistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		DogRegistService DogRegistService = new DogRegistService();
		
		// 파일이 업로드 될 서버상의 물리적인 경로
		String realFolder="";
		
		// 파일이 업로드 될 논리적인 디렉토리 이름의 정의
		String saveFolder="/images";
		
		// MultipartRequest 속성 지정
		String encType="UTF-8";
		
		int maxSize = 5 * 1024 * 1024;//5Mbyte
		// 한번에 업로드 할수 있는 파일을 최대 크기
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		
		MultipartRequest multi = new MultipartRequest(request,
				realFolder,  maxSize,encType, new DefaultFileRenamePolicy());
		
		// 서버상에 업로드될 이미파일 가져옴
		String image = multi.getFilesystemName("image");
		
		// 사용자한테서 전송된 파라미터 데이터들을 사용해서 
		// 새로 등록할 상품정보를 저장하는 객체생성
		Dog dog = new Dog(0,
				multi.getParameter("kind"),
				Integer.parseInt(multi.getParameter("price")),
				image,
				multi.getParameter("nation"),
				Integer.parseInt(multi.getParameter("height")),
				Integer.parseInt(multi.getParameter("weight")),
				multi.getParameter("content"),
				0);
		
		boolean isRegistSuccess = DogRegistService.registDog(dog);
		
		// 상품 등록 작업이 성공적으로 처리되었을때 리다이렉트 방식으로 목록 보기 요청을 할 거임
		ActionForward forward = null;
		if( isRegistSuccess) {
			forward = new ActionForward("dogList.dog", true); 
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}
