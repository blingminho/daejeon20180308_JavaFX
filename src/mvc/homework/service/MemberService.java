package mvc.homework.service;


import java.util.List;

import mvc.homework.dao.MemberDao;
import mvc.homework.dao.MemberDaoInf;
import mvc.homework.vo.MemberVO;


public class MemberService implements MemberServiceInf {
	private MemberDaoInf memDao;
	
	// 자기 참조 변수
	private static MemberService service = new MemberService();
	
	// 생성자
	private MemberService() {
		// Service객체는 DAO객체를 사용해야 하기 때문에 DAO객체를 생성해야 한다.
		// 싱글턴이 적용된 DAO객체를 받아온다
		memDao = MemberDao.getInstance();
		System.out.println("Service 싱글턴 적용");
	}
	
	// 객체 반환 메서드
	public static MemberService getInstance(){
		return service;
	}

	@Override
	public int insert(MemberVO memberVO) {
		return memDao.insert(memberVO);
	}

	@Override
	public int update(MemberVO memberVO) {
		return memDao.update(memberVO);
	}

	@Override
	public int delete(MemberVO memberVO) {
		return memDao.delete(memberVO);
	}

	@Override
	public List<MemberVO> getMemberAll() {
		return memDao.getMemberAll();
	}

	@Override
	public int getMember(String mem_id) {
		return memDao.getMember(mem_id);
	}
	

}
