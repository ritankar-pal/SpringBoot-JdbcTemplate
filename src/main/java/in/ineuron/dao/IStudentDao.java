package in.ineuron.dao;
import java.util.List;
import in.ineuron.bo.StudentBO;
import in.ineuron.dto.StudentDto;


public interface IStudentDao {
	public StudentBO getStudentByNo(int sno);
	public List<StudentBO> fetchStudentByName(String name1, String name2);
	public List<StudentBO> fetchStudentByCities(String city1, String city2, String city3);
}
