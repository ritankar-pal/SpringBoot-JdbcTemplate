package in.ineuron.service;

import java.util.List;

import in.ineuron.dto.StudentDto;

public interface IStudentMgmtService {
	public StudentDto fetchStudentByNo(int no);
	public List<StudentDto> fetchStudentByName(String name1, String name2);
	public List<StudentDto> fetchStudentByCities(String city1, String city2, String city3);
}
