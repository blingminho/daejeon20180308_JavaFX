package chartAndDialog.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import chartAndDialog.vo.StudentVO;

public class StudentDAO implements StudentDAOInf{
	private static StudentDAO dao;
	private StudentDAO() throws IOException {
		Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
		smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		rd.close();
	}
	
	private SqlMapClient smc;
	
	public static StudentDAO getInstance() throws IOException {
		if (dao == null) {
			dao = new StudentDAO();
		}
		return dao;
	}

	@Override
	public int insert(StudentVO studentVO) {
		int result = 0;
		try {
			if (smc.insert("student.insert", studentVO) == null) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentVO> getStudentAll() {
		List<StudentVO> list = null;
		try {
			list = smc.queryForList("student.getStudentAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int checkedStudent(String stu_name) {
		int result = 0;
		try {
			if (smc.queryForObject("student.checkedStudent", stu_name) != null) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


}
