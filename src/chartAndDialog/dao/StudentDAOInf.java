package chartAndDialog.dao;

import java.util.List;

import chartAndDialog.vo.StudentVO;

public interface StudentDAOInf {
	int insert(StudentVO studentVO);
	List<StudentVO> getStudentAll();
	int checkedStudent(String stu_name);
}
