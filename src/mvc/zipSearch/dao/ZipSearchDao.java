package mvc.zipSearch.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import mvc.zipSearch.vo.ZipVO;

public class ZipSearchDao implements ZipSearchDaoInf {

	private static ZipSearchDao dao = new ZipSearchDao();
	private SqlMapClient smc;
	
	private ZipSearchDao() {
		try {
			Reader rd = Resources.getResourceAsReader("SqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static ZipSearchDao getInstance() {
		return dao;
	}
	
	@Override
	public List<ZipVO> zipSearchDong(String dong) {
		List<ZipVO> zipList = null;
		try {
			zipList = smc.queryForList("zipSearch.getSearchDong", dong);
		} catch (SQLException e) {
			zipList = null;
			e.printStackTrace();
		}
		return zipList;
	}

	@Override
	public List<ZipVO> zipSearchZipCode(String zipCode) {
		List<ZipVO> zipList = null;
		try {
			zipList = smc.queryForList("zipSearch.getSearchZipcode", zipCode);
		} catch (SQLException e) {
			zipList = null;
			e.printStackTrace();
		}
		return zipList;
	}

}
