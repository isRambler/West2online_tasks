import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {
//    增加学生表信息
    public void addStudent(){
        Connection conn=null;
        PreparedStatement st=null;
        int count=0;
        int id=0;
        String name=null;
        String sex=null;
        String birthday=null;
        String academy=null;
        String class_=null;

        try {
            conn=JdbcUtils.getConnection();
            String sql="INSERT INTO student(id,name,sex,birthday,academy,class) values(?,?,?,?,?,?)";
            st=conn.prepareStatement(sql);
            System.out.println("请按照以下提示依次输入学生相关信息：");
            Scanner scanner = new Scanner(System.in);
            while(count<=6){
                count+=1;
                if(count==1){
                    System.out.println("请输入学生id:");
                    id=scanner.nextInt();
                }
                if(count==2){
                    System.out.println("请输入学生姓名：");
                    name= scanner.next();
                }
                if(count==3){
                    System.out.println("请输入学生性别");
                    sex=scanner.next();
                }
                if(count==4){
                    System.out.println("请输入学生生日");
                    birthday= scanner.next();
                }
                if(count==5){
                    System.out.println("请输入学生所在学院代码");
                    academy= scanner.next();
                }
                if(count==6){
                    System.out.println("请输入学生所在班级编号");
                    class_=scanner.next();
                }
            }
            st.setInt(1,id);
            st.setString(2,name);
            st.setString(3,sex);
            st.setDate(4, Date.valueOf(birthday));
            st.setString(5,academy);
            st.setString(6,class_);
            int i=st.executeUpdate();
            if(i>0){
                System.out.println("增加学生信息成功！");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(conn,st,null);
        }
    }

//    增加班级表信息
    public void addClass(){
        Connection conn=null;
        PreparedStatement st=null;
        int count=0;
        String id=null;
        String name=null;
        String monitor=null;
        String department_id=null;

        try {
            conn=JdbcUtils.getConnection();
            String sql="INSERT INTO class(id,name,monitor,department_id) values(?,?,?,?)";
            st=conn.prepareStatement(sql);
            System.out.println("请按照以下提示依次输入班级相关信息：");
            Scanner scanner = new Scanner(System.in);
            while(count<=4){
                count+=1;
                if(count==1){
                    System.out.println("请输入班级编号:");
                    id=scanner.next();
                }
                if(count==2){
                    System.out.println("请输入班级名称：");
                    name= scanner.next();
                }
                if(count==3){
                    System.out.println("请输入班级负责人");
                    monitor=scanner.next();
                }
                if(count==4){
                    System.out.println("请输入班级所对应的学院代码");
                    department_id= scanner.next();
                }
            }
            st.setString(1,id);
            st.setString(2,name);
            st.setString(3,monitor);
            st.setString(4,department_id);
            int i=st.executeUpdate();
            if(i>0){
                System.out.println("增加班级信息成功！");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(conn,st,null);
        }

    }

//    增加年级信息
    public void addDepartment(){
        Connection conn=null;
        PreparedStatement st=null;
        int count=0;
        String id=null;
        String name=null;
        try {
            conn=JdbcUtils.getConnection();
            String sql="INSERT INTO department(id,name) values(?,?)";
            st=conn.prepareStatement(sql);
            System.out.println("请按照以下提示依次输入学院相关信息：");
            Scanner scanner = new Scanner(System.in);
            while(count<=2){
                count+=1;
                if(count==1){
                    System.out.println("请输入学院代码:");
                    id=scanner.next();
                }
                if(count==2){
                    System.out.println("请输入学院名称：");
                    name= scanner.next();
                }
            }
            st.setString(1,id);
            st.setString(2,name);
            int i=st.executeUpdate();
            if(i>0){
                System.out.println("增加学院信息成功！");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.release(conn,st,null);
        }
    }

}
