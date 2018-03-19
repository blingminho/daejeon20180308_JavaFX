package mvc.homework.dao;

import java.util.List;

import mvc.homework.vo.MemberVO;

/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성하여
 * Service에 전달하는 DAO의 Interface
 * 
 * @author SangJun
 *
 */
public interface MemberDaoInf {
	public int insert(MemberVO memberVO);
	public int update(MemberVO memberVO);
	public int delete(MemberVO memberVO);
	public List<MemberVO> getMemberAll();
	public int getMember(String mem_id);
}
