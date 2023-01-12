import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
    public void delStudent(){
        Connection conn=null;
        PreparedStatement st=null;
        int id=0;
        try{
            conn=JdbcUtils.getConnection();
            String sql="delete from student where id=?";
            st=conn.prepareStatement(sql);
            System.out.println("请输入想要删除的学生的id：");
            Scanner scanner = new Scanner(System.in);
            id=scanner.nextInt();
            st.setInt(1,id);
            int i=st.executeUpdate();
            if(i>0){
                System.out.println("删除成功！");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(conn,st,null);
        }
    }
    public void delClass(){
        Connection conn=null;
        PreparedStatement st=null;
        int id=0;
        try{
            conn=JdbcUtils.getConnection();
            String sql="delete from class where id=?";
            st=conn.prepareStatement(sql);
            System.out.println("请输入想要删除的班级的编码：");
            Scanner scanner = new Scanner(System.in);
            id=scanner.nextInt();
            st.setInt(1,id);
            int i=st.executeUpdate();
            if(i>0){
                System.out.println("删除成功！");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(conn,st,null);
        }
    }
    public void delDepartment(){
        Connection conn=null;
        PreparedStatement st=null;
        int id=0;
        try{
            conn=JdbcUtils.getConnection();
            String sql="delete from department where id=?";
            st=conn.prepareStatement(sql);
            System.out.println("请输入想要删除的学院的代码：");
            Scanner scanner = new Scanner(System.in);
            id=scanner.nextInt();
            st.setInt(1,id);
            int i=st.executeUpdate();
            if(i>0){
                System.out.println("删除成功！");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(conn,st,null);
        }
    }
}
