import humanResources.Department;
import humanResources.Employee;
import humanResources.Organization;

public class Main
{
    public static void main(String[] argv)
    {
        Employee[] mas0=new Employee[5];
        mas0[0]=new Employee("Степан","Пафнутьев","Директор",45000);
        mas0[1]=new Employee("Акулина","Чистюлина","Прачка",12000);
        mas0[2]=new Employee("Зинаида","Петрова","Прачка",12000);
        mas0[3]=new Employee("Людмила","Иванова","Прачка",12000);
        mas0[4]=new Employee("Богдан","Козлов","Подсобный рабочий",10000);
        Department dep0=new Department("Прачечная",mas0);
        Employee[] mas1=new Employee[5];
        mas1[0]=new Employee("Сергей","Петров","Директор",60000);
        mas1[1]=new Employee("Мария","Цифиркина","Бухгалтер",30000);
        mas1[2]=new Employee("Анна","Семенович","Секретарь",29000);
        mas1[3]=new Employee("Валик","Карданов","Теплотехник",40000);
        mas1[4]=new Employee("Антон","Чумазов","Кочегар",22000);
        Department dep1=new Department("Котельная",mas1);
        Employee str1=new Employee("Сергей","Петров", "Теплотехник",40000);
        Employee str2=new Employee("Петр","Сергеев", "Теплотехник",40000);
        Employee str3=new Employee("Арнольд","Чумазов", "Кочегар",22000);
        Employee str4=new Employee("Артур","Чумазов", "Кочегар",22000);
        Employee str5=new Employee("Алевтина","Иванова","Уборщица",18000);
        dep1.add(str1);
        dep1.add(str2);
        dep1.add(str3);
        dep1.add(str4);
        dep1.add(str5);
        System.out.println("Количество человек в котельной: "+dep1.size());
        Employee[] mas2=new Employee[5];
        mas2[0]=new Employee("Наталья","Самаркина","Директор",70000);
        mas2[1]=new Employee("Джордж","Голубикин","Визажист",35000);
        mas2[2]=new Employee("Дмитрий","Лиманов","Секретарь",40000);
        mas2[3]=new Employee("Валентина","Изюмова","Парикмахер",37000);
        mas2[4]=new Employee("Антон","Метёлкин","Сторож",20000);
        Department dep2=new Department("Парикмахерская",mas2);
        Employee st1=new Employee("Иван","Петров", "Парикмахер",37000);
        Employee st2=new Employee("Надежда","Сергеева", "Парикмахер",37000);
        Employee st3=new Employee("Регина","Мустафина","Уборщица",18000);
        dep2.add(st1);
        dep2.add(st2);
        dep2.add(st3);
        System.out.println("Число сотрудников в котельной: "+dep1.size());
        System.out.println();
        if(!dep1.remove("Антон","Чумазов"))
        {
            System.out.println("Такого сотрудника не существует");
        }
        System.out.println("Число сотрудников в котельной, после удаления: "+dep1.size());
        System.out.println();
        if(!dep0.remove("Богдан","Козлов"))
        {
            System.out.println("Такого сотрудника не существует");
        }
        System.out.println("Число сотрудников в прачечной, после удаления: "+dep0.size());
        System.out.println();
        if(!dep2.remove("Регина","Мустафина"))
        {
            System.out.println("Такого сотрудника не существует");
        }
        System.out.println("Число сотрудников в парикмахерской после удаления: "+dep2.size());
        System.out.println();
        Employee[] tmp0=dep2.getEmployees();
        for (int i=0; i<tmp0.length;i++)
        {
            System.out.println(tmp0[i].GetFirstName()+" "+ tmp0[i].GetSecondName());
        }
        System.out.println();
        Employee[] tmp1=dep2.getEmployees("Парикмахер");
        for (int i=0; i<tmp1.length;i++)
        {
            System.out.println(tmp1[i].GetFirstName()+" "+ tmp1[i].GetSecondName()+" "+tmp1[i].GetJobTitle());
        }
        System.out.println();
        Employee[] tmp2=dep1.employeesSortedBySalary();
        for (int i=0; i<tmp2.length;i++)
        {
            System.out.println(tmp2[i].GetFirstName()+" "+ tmp2[i].GetSecondName()+" "+tmp2[i].GetSalary());
        }
        System.out.println();
        Department[] dp=new Department[1];
        dp[0]=dep0;
        Organization org1=new Organization("Дом быта",dp);
        org1.add(dep1);
        org1.add(dep2);
        Department[] mas_d=org1.getDepartments();
        System.out.println("Все отделы в организации: ");
        for (int i=0; i<mas_d.length;i++)
        {
            System.out.println(mas_d[i].GetNameDepartment());
        }
        System.out.println();
        System.out.println("Общее число отделов: "+org1.size());
        System.out.println();
        System.out.println("Общее число сотрудников в организации: "+org1.employeesQuantity());
        System.out.println();
        System.out.println("Количество парикмахеров: "+org1.employeesQuantity("Парикмахер"));
        System.out.println();
        Employee sotrudnik=org1.bestEmployee();
        System.out.println(sotrudnik.GetFirstName()+" "+sotrudnik.GetSecondName()+" "+sotrudnik.GetJobTitle()+" "+sotrudnik.GetSalary());
        System.out.println();
        Department otdel=org1.getEmployeesDepartment("Антон","Метёлкин");
        System.out.println(otdel.GetNameDepartment());
        System.out.println();
        Department rr=org1.getDepartment("Котельная");
        Employee[] mm=rr.getEmployees();
        for(int i=0;i<mm.length;i++)
        {
            System.out.println(mm[i].GetFirstName()+" "+mm[i].GetSecondName()+" "+mm[i].GetJobTitle());
        }
        System.out.println();
        org1.remove("Прачечная");
        Department[] otd=org1.getDepartments();
        System.out.println("Отделы в организации после удаления: ");
        for (int i=0; i<otd.length;i++)
        {
            System.out.println(otd[i].GetNameDepartment());
        }
        System.out.println();
        System.out.println(org1.size());
    }
}
