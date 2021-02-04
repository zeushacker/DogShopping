package svc;

import java.sql.Connection;
import java.util.ArrayList;
import static db.JdbcUtil.*;
import dao.DogDAO;
import vo.Dog;

public class DogListService {

	public ArrayList<Dog> getDogList() {
		
		DogDAO dogDAO = DogDAO.getInstance();
		Connection con = getConnection();
		dogDAO.setConnection(con);
		ArrayList<Dog> dogList = dogDAO.selectDogList();
		close(con);
		return dogList;
	}
}
