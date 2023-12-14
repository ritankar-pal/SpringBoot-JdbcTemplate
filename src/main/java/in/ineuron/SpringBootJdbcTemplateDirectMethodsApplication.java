package in.ineuron;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.dto.StudentDto;
import in.ineuron.service.IStudentMgmtService;
import in.ineuron.service.StudentMgmtServiceImpl;

@SpringBootApplication
public class SpringBootJdbcTemplateDirectMethodsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootJdbcTemplateDirectMethodsApplication.class, args);
		
		
		IStudentMgmtService service = context.getBean(StudentMgmtServiceImpl.class);
		StudentDto stuDto = service.fetchStudentByNo(1);
		
		System.out.println();
		System.out.println(stuDto);
		System.out.println();
		
		List<StudentDto> studentByName = service.fetchStudentByName("Mohit", "Keshav");
		studentByName.forEach(std ->{
			System.out.println(std);
		});
		
		
		System.out.println();
		List<StudentDto> stdByCities = service.fetchStudentByCities("Neemrana", "Delhi", "Chennai");
		
		stdByCities.forEach(std -> {
			System.out.println(std);
		});
		System.out.println();
		
		
		System.out.println();
		((ConfigurableApplicationContext) context).close();
	}

}
