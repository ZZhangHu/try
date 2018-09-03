package cap.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.swing.JButton;

import org.junit.Test;

import cab.db.JDBCTrans;

public class JTransTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		System.out.println("junit");
	}
	@Test
	public void testTrans() throws SQLException {
		JDBCTrans jt=new JDBCTrans();
		jt.trans();
	}

}