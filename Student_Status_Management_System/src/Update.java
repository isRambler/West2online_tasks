import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {
    public void reStudent(){
        Connection conn=null;
        PreparedStatement st=null;
        String judge=null;
        int id=0;
        String up=null;
        try {
            conn= JdbcUtils.getConnection();
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入想要更改的选项（name,sex,birthday,academy,class）：");
            judge=scanner.next();
            String sql ="update student set "+judge+"=? where id=?";
            st=conn.prepareStatement(sql);
            System.out.println("请输入想更改的学生的id：");
            id=scanner.nextInt();
            System.out.println("请输入想要更改的"+judge+"的值：");
            up=scanner.next();
            st.setInt(2,id);
            st.setString(1,up);
            int i=st.executeUpdate();
            if(i>0){
                System.out.println("更新成功！");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(conn,st,null);
        }
    }
    public void reClass(){
        Connection conn=null;
        PreparedStatement st=null;
        String judge=null;
        String id=null;
        String up=null;
        try {
            conn= JdbcUtils.getConnection();
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入想要更改的选项（name,monitor,department_id）：");
            judge=scanner.next();
            String sql ="update class set "+judge+"=? where id=?";
            st=conn.prepareStatement(sql);
            System.out.println("请输入想更改的班级的编码：");
            id=scanner.next();
            System.out.println("请输入想要更改的"+judge+"的值：");
            up=scanner.next();
            st.setString(2,id);
            st.setString(1,up);
            int i=st.executeUpdate();
            if(i>0){
                System.out.println("更新成功！");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(conn,st,null);
        }
    }
    public void reDepartment(){
        Connection conn=null;
        PreparedStatement st=null;
        String judge=null;
        String id=null;
        String up=null;
        try {
            conn= JdbcUtils.getConnection();
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入想要更改的选项（name）：");
            judge=scanner.next();
            String sql ="update department set "+judge+"=? where id=?";
            st=conn.prepareStatement(sql);
            System.out.println("请输入想更改的学院的代码：");
            id=scanner.next();
            System.out.println("请输入想要更改的"+judge+"的值：");
            up=scanner.next();
            st.setString(2,id);
            st.setString(1,up);
            int i=st.executeUpdate();
            if(i>0){
                System.out.println("更新成功！");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(conn,st,null);
        }
    }
}
