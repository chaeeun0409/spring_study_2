package kr.hs.study.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.hs.study.bean.TestBean;

@Component
public class TestDAO {
	//실제 쿼리를 날리는 곳
	// 쿼리 날리는 애: JdbcTemplate
	//여기에 jdbcTemplate이 있어야 한다.
	@Autowired
	JdbcTemplate db;
	
	 // insert
	 public void insert_data(TestBean bean) {
	    String sql = "insert into dbtest values(?, ?)";
	    db.update(sql, bean.getData1(), bean.getData2());
	  }
	 
	//update
		public void update_data(TestBean bean) {
			String sql = "update test set data2 = ? where data1 = ?";
			db.update(sql, bean.getData2(), bean.getData1());
			
			//sql: update test set data=? where data1=?
			//data1이 100인 data2값을 test test로 변경
		}
		
		//delete
		public void delete_data(TestBean bean) {
			String sql = "delete test where data1 = ?";
			db.update(sql, bean.getData1());
		}
}