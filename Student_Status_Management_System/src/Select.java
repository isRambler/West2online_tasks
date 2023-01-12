import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Select {
    public void findStudent(){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        int id=0;
        try {
            conn=JdbcUtils.getConnection();
            String sql="select * from student where id=?";
            st=conn.prepareStatement(sql);
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入想要查询的学生的id：");
            id=scanner.nextInt();
            st.setInt(1,id);
            rs= st.executeQuery();
            if(rs.next()){
                System.out.println("id="+rs.getObject("id")+" "+
                                    "name="+rs.getObject("name")+" "+
                                    "sex="+rs.getObject("sex")+" "+
                                    "birthday="+rs.getObject("birthday")+" "+
                                    "academy="+rs.getObject("academy")+" "+
                                    "class="+rs.getObject("class")
                                    );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
    public void findClass(){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        String id=null;
        try {
            conn=JdbcUtils.getConnection();
            String sql="select * from class where id=?";
            st=conn.prepareStatement(sql);
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入想要查询的班级的编码：");
            id=scanner.next();
            st.setString(1,id);
            rs= st.executeQuery();
            if(rs.next()){
                System.out.println("id="+rs.getObject("id")+" "+
                        "name="+rs.getObject("name")+" "+
                        "monitor="+rs.getObject("monitor")+" "+
                        "department_id="+rs.getObject("department_id")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
    public void findDepartment(){
        Connection conn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        String id=null;
        try {
            conn=JdbcUtils.getConnection();
            String sql="select * from department where id=?";
            st=conn.prepareStatement(sql);
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入想要查询的学院的代码：");
            id=scanner.next();
            st.setString(1,id);
            rs= st.executeQuery();
            if(rs.next()){
                System.out.println("id="+rs.getObject("id")+" "+
                                  "name="+rs.getObject("name")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(conn,st,rs);
        }
    }
}
