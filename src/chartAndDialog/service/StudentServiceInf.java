package chartAndDialog.service;

import java.util.List;

import chartAndDialog.vo.StudentVO;

public interface StudentServiceInf {
	int insert(StudentVO studentVO);
	List<StudentVO> getStudentAll();
	int checkedStudent(String stu_name);
}
