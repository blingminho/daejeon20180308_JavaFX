package mvc.homework.dao;


import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import mvc.homework.vo.MemberVO;


public class MemberDao implements MemberDaoInf{
	// 자기 참조 변수 선언 및 초기화
	private static MemberDao dao = new MemberDao();
	
	// ibatis용 객체 변수 선언
	private SqlMapClient smc;
	
	// 생성자
	private MemberDao(){
		System.out.println("DAO 싱글톤 적용");
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 자기 참조값을 반환하는 메서드
	public static MemberDao getInstance(){
		return dao;
	}

	@Override
	public int insert(MemberVO memberVO) {
		int result = 0;
		try {
			Object obj = smc.insert("member.insert", memberVO);
			if (obj == null) {// insert메서드는 자료 추가가 성공하였을때 null값 반환함
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(MemberVO memberVO) {
		int result = 0;
		try {
			result = smc.update("member.update", memberVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(MemberVO memberVO) {
		int result = 0;
		try {
			result = smc.delete("member.delete", memberVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<MemberVO> getMemberAll() {
		List<MemberVO> memList = null;
		try {
			memList = smc.queryForList("member.getMemberAll");
		} catch (SQLException e) {
			memList = null;
			e.printStackTrace();
		}
		return memList;
	}

	@Override
	public int getMember(String mem_id) {
		int result = 0;
		try {
			result = (int)smc.queryForObject("member.getMember", mem_id);
			System.out.println("result  : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
