package in.ineuron.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Repository;
import in.ineuron.bo.StudentBO;
import in.ineuron.dto.StudentDto;


@Repository
public class StudentDaoImpl implements IStudentDao {
	
	private static final String GET_STUDENT_BY_NO = "select sid, sname, sage, saddress, savg from student where sid = ?";
	private static final String GET_STUDENT_BY_NAME = "select sid, sname, sage, saddress, savg from student where sname in (?,?)";
	private static final String GET_STUDENT_BY_CITY = "select sid, sname, sage, saddress, savg from student where saddress in (?,?,?)";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public StudentBO getStudentByNo(int sno) {
		
//		StudentBO bo = jdbcTemplate.queryForObject(GET_STUDENT_BY_NO, new StudentMapper(), sno);
		
		//using the default implementation class expression::
		StudentBO stdBo = jdbcTemplate.queryForObject(GET_STUDENT_BY_NO, new BeanPropertyRowMapper<StudentBO>(StudentBO.class),sno);
		
		return stdBo;
	}
	

	@Override
	public List<StudentBO> fetchStudentByName(String name1, String name2){
			
		//Using the default implementation class i.e. BeanPropertyRowMapper::
//		return jdbcTemplate.query(GET_STUDENT_BY_NAME, new BeanPropertyRowMapper<StudentBO>(StudentBO.class), name1, name2);
		
		return jdbcTemplate.query(GET_STUDENT_BY_NAME, (rs, rowNum) -> {
			
			StudentBO studentBO = new StudentBO();
			studentBO.setSid(rs.getInt(1));
			studentBO.setSname(rs.getString(2));
			studentBO.setSage(rs.getInt(3));
			studentBO.setSaddress(rs.getString(4));
			studentBO.setSavg(rs.getFloat(5));
			
			return studentBO;
			
		}, name1, name2);
		
	}
	
	@Override
	public List<StudentBO> fetchStudentByCities(String city1, String city2, String city3) {
		
//		return jdbcTemplate.query(GET_STUDENT_BY_CITY, new ResultSetExtractor<List<StudentBO>>() {
//
//			@Override
//			public List<StudentBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
//				
//				List<StudentBO> listBO = new ArrayList<>();
//				
//				while(rs.next()) {
//					StudentBO stdBO = new StudentBO();
//					stdBO.setSid(rs.getInt(1));
//					stdBO.setSname(rs.getString(2));
//					stdBO.setSage(rs.getInt(3));
//					stdBO.setSaddress(rs.getString(4));
//					stdBO.setSavg(rs.getInt(5));
//					
//					listBO.add(stdBO);
//				}
//				
//				return listBO;
//			}
//			
//		}, city1, city2, city3);
		
		
		//using the default implementation class of:: ResultSetExtractor::
//		return jdbcTemplate.query(GET_STUDENT_BY_CITY, new RowMapperResultSetExtractor<StudentBO>
//			(new BeanPropertyRowMapper<StudentBO>(StudentBO.class)), city1, city2, city3 );
		
		
		//using RowCallBackHandler() interface::
		List<StudentBO> listBO = new ArrayList<>();
		
		jdbcTemplate.query(GET_STUDENT_BY_CITY, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				
				StudentBO stdBO = new StudentBO();
				stdBO.setSid(rs.getInt(1));
				stdBO.setSname(rs.getString(2));
				stdBO.setSage(rs.getInt(3));
				stdBO.setSaddress(rs.getString(4));
				stdBO.setSavg(rs.getInt(5));
				
				listBO.add(stdBO);
			}
		}, city1, city2, city3);
		
		return listBO;
	}
	
	
	
	private class StudentRowMapper implements RowMapper<StudentBO>{
				
		@Override
		public StudentBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			StudentBO studentBO = new StudentBO();
			studentBO.setSid(rs.getInt(1));
			studentBO.setSname(rs.getString(2));
			studentBO.setSage(rs.getInt(3));
			studentBO.setSaddress(rs.getString(4));
			studentBO.setSavg(rs.getInt(5));
			
			return studentBO;
		}
		
	}

	
	private class StudentMapper implements RowMapper<StudentBO>{
		
		@Override
		public StudentBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			System.out.println("StudentDaoImpl.StudentMapper.mapRow()");
			
			StudentBO bo = new StudentBO();
			
			bo.setSid(rs.getInt(1));
			bo.setSname(rs.getString(2));
			bo.setSage(rs.getInt(3));
			bo.setSaddress(rs.getString(4));
			bo.setSavg(rs.getFloat(5));
			
			return bo;
		}
		
		
	}




}
