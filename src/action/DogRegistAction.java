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
		
		// ������ ���ε� �� �������� �������� ���
		String realFolder="";
		
		// ������ ���ε� �� ������ ���丮 �̸��� ����
		String saveFolder="/images";
		
		// MultipartRequest �Ӽ� ����
		String encType="UTF-8";
		
		int maxSize = 5 * 1024 * 1024;//5Mbyte
		// �ѹ��� ���ε� �Ҽ� �ִ� ������ �ִ� ũ��
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		
		MultipartRequest multi = new MultipartRequest(request,
				realFolder,  maxSize,encType, new DefaultFileRenamePolicy());
		
		// ������ ���ε�� �̹����� ������
		String image = multi.getFilesystemName("image");
		
		// ��������׼� ���۵� �Ķ���� �����͵��� ����ؼ� 
		// ���� ����� ��ǰ������ �����ϴ� ��ü����
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
		
		// ��ǰ ��� �۾��� ���������� ó���Ǿ����� �����̷�Ʈ ������� ��� ���� ��û�� �� ����
		ActionForward forward = null;
		if( isRegistSuccess) {
			forward = new ActionForward("dogList.dog", true); 
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('��Ͻ���');");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}
