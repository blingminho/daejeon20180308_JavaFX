package chartAndDialog.service;

import java.io.IOException;
import java.util.List;

import chartAndDialog.dao.StudentDAO;
import chartAndDialog.dao.StudentDAOInf;
import chartAndDialog.vo.StudentVO;

public class StudentService implements StudentServiceInf {
	private static StudentService service;
	private static StudentDAOInf dao;
	
	private StudentService() {
		try {
			dao = StudentDAO.getInstance();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static StudentService getInstance() {
		if (service == null) {
			service = new StudentService();
		}
		return service;
	}
	
	
	@Override
	public int insert(StudentVO studentVO) {
		return dao.insert(studentVO);
	}

	@Override
	public List<StudentVO> getStudentAll() {
		return dao.getStudentAll();
	}

	@Override
	public int checkedStudent(String stu_name) {
		return dao.checkedStudent(stu_name);
	}

}
