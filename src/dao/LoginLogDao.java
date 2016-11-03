package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import domain.LoginLog;

@Repository
public class LoginLogDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void insertLoging(LoginLog loginLog) {
		String sql = "Insert into t_login_log(user_id,ip, login_datetime) "
				+" values(?,?,?)";
		Object[] args = new Object[]{loginLog.getUserId(),loginLog.getIp(), loginLog.getLoginDate()};
		jdbcTemplate.update(sql, args);
	}
	
}
