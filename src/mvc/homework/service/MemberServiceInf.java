package mvc.homework.service;


import java.util.List;

import mvc.homework.vo.MemberVO;

/**
 * Service객체는 DAO에 설정된 메서드를 원하는 작업에 맞게 호출하여
 * 실행한 후 결과를 받아오고, 받아온 자료를 Controller에 보내주는 역할을 수행한다
 * 보통 DAO의 메서드와 같은 구조를 갖는다.
 * @author SangJun
 *
 */
public interface MemberServiceInf {
	public int insert(MemberVO memberVO);
	public int update(MemberVO memberVO);
	public int delete(MemberVO memberVO);
	public List<MemberVO> getMemberAll();
	public int getMember(String mem_id);
}
