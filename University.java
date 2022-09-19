import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class student
{
    int id;
    String name;

    student(int id, String name)
    {
        this.id = id;
        this.name = name;

    }
    student(student origstudent)
    {
        this.id = origstudent.id;
        this.name = origstudent.name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

}

class department
{
    String depname;
    public List<student> students = new ArrayList<student>();

    public department(String depname)
    {
        this.depname = depname;
    }
    public String getDepname() {
        return depname;
    }
    public List<student> getStudents() {
        return students;
    }
    public void setDepname(String depname) {
        this.depname = depname;
    }
    public void setStudents(List<student> students) {
        this.students = students;
    }
    public String toString()
    {
        String result = "";
        for(Iterator it = students.iterator() ; it.hasNext();)
        {
            student stud = (student) it.next();
            result += " Name" + " " + stud.name + " " + "ID" + " " + stud.id + "\n";
        }

        return result;
    }

}
class university
{
    String uniname;
    public department department;
    public List<department> departments = new ArrayList<department>();

  

    public university(String uniname)
    {
        this.uniname = uniname;
    }
    public String getUniname() {
        return uniname;
    }
    public department getDepartment() {
        return department;
    }
    public List<department> getDepartments() {
        return departments;
    }
    public void setUniname(String uniname) {
        this.uniname = uniname;
    }
    public void setDepartment(department department) {
        this.department = department;
    }
    public void add_dept(String name)
    {
        department  = new department(name);
        departments.add(department);
        
    }
    public String toString()
    {
        String result = "";
       for (int i = 0; i < departments.size(); i++) {
           result += i + " " + departments.get(i).depname + "\n";
       }
       return result;
    }
   
}
class admin 
{
     boolean application_running = true;
     university Uni = new university("University of Karachi");

    public  void run()
    {
        Scanner scanner = new Scanner(System.in);

        while(application_running){
        System.out.println("Select \n 1. To Add a department \n 2. To Add student \n 3.Display Students \n 0. To stop the application");
            int result = scanner.nextInt();
            Scanner newscan = new Scanner(System.in);

            // scanner.close();
            if(result == 1)
            {
                System.out.println("Enter the Name of the department you want to add");
                String depname = newscan.nextLine();
                Uni.add_dept(depname);
            }
            if(result == 2)
            {
                System.out.println("Enter the name of the student you want to add");
                String name = newscan.nextLine();
                System.out.println("Enter the ID of the student you want to add");
                int id = scanner.nextInt();
                student std = new student(id, name);
                System.out.println("Select the department you want to enroll this student in" + "\n" + Uni);
                int dep = scanner.nextInt();
                Uni.getDepartments().get(dep).students.add(std);
            }
            if(result == 3)
            {
                System.out.println("Select the department you want to display this students of " + "\n" + Uni);
                int dep = scanner.nextInt();   
                System.out.println(Uni.getDepartments().get(dep));
            }
            else if(result == 0)
            {
                application_running = false;
                scanner.close();
                newscan.close();
            }   
        }        
    }
}

public class University
{
    public static void main(String[] args) {
        admin Admin = new admin();
        Admin.run();
    }
}
