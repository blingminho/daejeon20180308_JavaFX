package mvc.zipSearch.dao;

import java.util.List;

import mvc.zipSearch.vo.ZipVO;

public interface ZipSearchDaoInf {
	/**
	 * 동이름으로 검색하는 메서드
	 * @param dong
	 * @return 검색된 결과를 List로 반환
	 */
	public List<ZipVO> zipSearchDong(String dong);
	
	/**
	 * 우편번호로 검색하는 메서드
	 * @param zipCode
	 * @return 검색된 결과를 List로 반환
	 */
	public List<ZipVO> zipSearchZipCode(String zipCode);
	
}
