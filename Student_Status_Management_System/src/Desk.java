import java.util.Objects;
import java.util.Scanner;

public class Desk {
    public void show(){
        String judge_1=null;
        String judge_2=null;
        String judge_3=null;
        String judge_4=null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("======学生信息管理系统======");
        System.out.println("      1.新增信息");
        System.out.println("      2.查询信息");
        System.out.println("      3.删除信息");
        System.out.println("      4.修改信息");
        while (true){
            System.out.println("请输入你想进行的操作的编号：");
            judge_1=scanner.next();
            if (judge_1.equals("1")){
                Insert insert = new Insert();
                while(true){
                    System.out.println("======你有如下选择======");
                    System.out.println("      1.新增学生信息");
                    System.out.println("      2.新增班级信息");
                    System.out.println("      3.新增学院信息");
                    System.out.println("请输入你想进行的操作的编号：");
                    judge_2=scanner.next();
                    if (judge_2.equals("1")){
                        insert.addStudent();
                    }else if (judge_2.equals("2")){
                        insert.addClass();
                    }else if (judge_2.equals("3")) {
                        insert.addDepartment();
                    }else {
                        System.out.println("输入有误，请重新输入");
                        continue;
                    }
                    System.out.println("是否想继续操作（y/n）");
                    judge_3=scanner.next();
                    if(judge_3.equals("y")){
                        continue;
                    } else if (judge_3.equals("n")) {
                        break;
                    }
                }
            }
            if (judge_1.equals("2")){
                Select select = new Select();
                while(true){
                    System.out.println("======你有如下选择======");
                    System.out.println("      1.查询学生信息");
                    System.out.println("      2.查询班级信息");
                    System.out.println("      3.查询学院信息");
                    System.out.println("请输入你想进行的操作的编号：");
                    judge_2=scanner.next();
                    if (judge_2.equals("1")){
                        select.findStudent();
                    }else if (judge_2.equals("2")){
                        select.findClass();
                    } else if (judge_2.equals("3")) {
                        select.findDepartment();
                    }else {
                        System.out.println("输入有误，请重新输入");
                        continue;
                    }
                    System.out.println("是否想继续操作（y/n）");
                    judge_3=scanner.next();
                    if(judge_3.equals("y")){
                        continue;
                    } else if (judge_3.equals("n")) {
                        break;
                    }
                }
            }
            if (judge_1.equals("3")){
                Delete delete = new Delete();
                while(true){
                    System.out.println("======你有如下选择======");
                    System.out.println("      1.删除学生信息");
                    System.out.println("      2.删除班级信息");
                    System.out.println("      3.删除学院信息");
                    System.out.println("请输入你想进行的操作的编号：");
                    judge_2=scanner.next();
                    if (judge_2.equals("1")){
                        delete.delStudent();
                    }else if (judge_2.equals("2")){
                        delete.delClass();
                    } else if (judge_2.equals("3")) {
                        delete.delDepartment();
                    }else {
                        System.out.println("输入有误，请重新输入");
                        continue;
                    }
                    System.out.println("是否想继续操作（y/n）");
                    judge_3=scanner.next();
                    if(judge_3.equals("y")){
                        continue;
                    } else if (judge_3.equals("n")) {
                        break;
                    }
                }
            }
            if (judge_1.equals("4")){
                Update update = new Update();
                while(true){
                    System.out.println("======你有如下选择======");
                    System.out.println("      1.修改学生信息");
                    System.out.println("      2.修改班级信息");
                    System.out.println("      3.修改学院信息");
                    System.out.println("请输入你想进行的操作的编号：");
                    judge_2=scanner.next();
                    if (judge_2.equals("1")){
                        update.reStudent();
                    }else if (judge_2.equals("2")){
                        update.reClass();
                    } else if (judge_2.equals("3")) {
                        update.reDepartment();
                    }else {
                        System.out.println("输入有误，请重新输入");
                        continue;
                    }
                    System.out.println("是否想继续操作（y/n）");
                    judge_3=scanner.next();
                    if(judge_3.equals("y")){
                        continue;
                    } else if (judge_3.equals("n")) {
                        break;
                    }
                }
            }
            System.out.println("是否想要继续使用本系统（y/n）");
            judge_4=scanner.next();
            if(judge_4.equals("y")){
                System.out.println("======学生信息管理系统======");
                System.out.println("      1.新增信息");
                System.out.println("      2.查询信息");
                System.out.println("      3.删除信息");
                System.out.println("      4.修改信息");
                continue;
            }else {
                System.out.println("很高兴为你提供服务，再见！");
                break;
            }
        }
    }
}
