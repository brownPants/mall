package cafe.jjdev.mall.service;
//자바 클래스들
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MemberDao {
	// 공통 사용 코드 메서드화
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn=null;
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=utf8", "root", "java0000");
        return conn;
    }
    private void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
        if(rs!=null) {
            try {rs.close();} catch(Exception e){e.printStackTrace();}
        }
        if(stmt!=null) {
            try {stmt.close();} catch(Exception e){e.printStackTrace();}
        }
        if(conn!=null) {
            try {conn.close();} catch(Exception e){e.printStackTrace();}
        }
    }
    private void close(Connection conn, PreparedStatement stmt) {
        if(stmt!=null) {
            try {stmt.close();} catch(Exception e){e.printStackTrace();}
        }
        if(conn!=null) {
            try {conn.close();} catch(Exception e){e.printStackTrace();}
        }
    }
	// 회원가입 입력처리
	public int insertMember(Member member) {
		System.out.println("MemberDao insertMember");
		Connection conn=null;
        PreparedStatement stmt=null;
        int row=0;
        try {
        	conn= this.getConnection();
        	stmt=conn.prepareStatement("INSERT INTO member VALUES (?, ? ,?)");
        	stmt.setString(1, member.getId());
    		stmt.setString(2, member.getPw());
    		stmt.setInt(3, member.getLevel());
    		row=stmt.executeUpdate();
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
        	this.close(conn, stmt);
        }
		return row;
	}
}
