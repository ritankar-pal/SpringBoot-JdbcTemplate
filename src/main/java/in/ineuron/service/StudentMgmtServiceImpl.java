package in.ineuron.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.ineuron.bo.StudentBO;
import in.ineuron.dao.IStudentDao;
import in.ineuron.dto.StudentDto;


@Service
public class StudentMgmtServiceImpl implements IStudentMgmtService {
	
	@Autowired
	private IStudentDao dao;
	
	@Override
	public StudentDto fetchStudentByNo(int no) {
		
		StudentBO bo = dao.getStudentByNo(no);
		
		StudentDto dto = new StudentDto();
		
		BeanUtils.copyProperties(bo, dto);
		
		if(bo.getSavg() < 60) {
			dto.setGrade("C");
		}
		else if(bo.getSavg() < 75) {
			dto.setGrade("B");			
		}
		else {
			dto.setGrade("A");			
		}
		
		return dto;
	}

	@Override
	public List<StudentDto> fetchStudentByName(String name1, String name2) {
		
		List<StudentBO> listBO = dao.fetchStudentByName(name1, name2);
		
		List<StudentDto> listDTO = new ArrayList<>();
		
		listBO.forEach(stuBO ->{
			
			StudentDto dto = new StudentDto();
			
			BeanUtils.copyProperties(stuBO, dto);
			
			if(stuBO.getSavg() < 60) {
				dto.setGrade("C");
			}
			else if(stuBO.getSavg() < 75) {
				dto.setGrade("B");			
			}
			else {
				dto.setGrade("A");			
			}
			
			listDTO.add(dto);
		});
		
		return listDTO;
	}

	@Override
	public List<StudentDto> fetchStudentByCities(String city1, String city2, String city3) {
		
		List<StudentBO> stdBO = dao.fetchStudentByCities(city1, city2, city3);
		
		ArrayList<StudentDto> listDTO = new ArrayList<>();
		
		stdBO.forEach(std -> {
			
			StudentDto stdDTO = new StudentDto();
			
			BeanUtils.copyProperties(std, stdDTO);
			
			if(std.getSavg() < 60) {
				stdDTO.setGrade("C");
			}
			else if(std.getSavg() < 75) {
				stdDTO.setGrade("B");			
			}
			else {
				stdDTO.setGrade("A");			
			}
			
			listDTO.add(stdDTO);
			
		});
		
		return listDTO;
	}

}
