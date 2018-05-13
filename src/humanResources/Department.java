package humanResources;

public class Department
{
    private String name;
    private Employee[] employees;
    private int size;

    public Department(String Name)
    {
        this.name=Name;
        this.employees=new Employee[8];
    }
    public Department(String Name, int Size)
    {
        this.name=Name;
        this.employees=new Employee[Size];
    }
    public Department (String Name, Employee[] mas)
    {
        this.name=Name;
        this.employees=mas;
        this.size=mas.length;
    }
    public void add(Employee employee)
    {
        int count=0;
        int l=this.employees.length;
        for(int i=0;i<l;i++)
        {
            if (this.employees[i]==null)
            {
                this.employees[i]=employee;
                this.size++;
                break;
            }
            else
            {
                count++;
            }
        }
        if (count==l)
        {
            Employee[] temp= new Employee[l*2];
            for (int i=0;i<l;i++)
            {
                temp[i]=this.employees[i];
            }
            temp[l]=employee;
            this.size++;
            this.employees=temp;
        }
    }
         public boolean remove (String firstName, String secondName)
    {
        for (int i=0; i<this.employees.length; i++)
        {
            if (this.employees[i]!=null)
            {
                if (this.employees[i].GetFirstName()==firstName)
                {
                    if (this.employees[i].GetSecondName()==secondName)
                    {
                        //удаляем
                        if(i==this.employees.length-1)
                        {
                            this.employees[i]=null;
                            this.size--;
                            return true;
                        }
                        else
                        {
                            for (int j = i; j < this.employees.length; j++)
                            {
                                if (this.employees[j+1]!=null)
                                {
                                    if((j+1)!=this.employees.length-1)
                                    {
                                        this.employees[j]=this.employees[j+1];
                                    }
                                    else
                                    {
                                        this.employees[j]=this.employees[j+1];
                                        this.employees[j+1]=null;
                                        this.size--;
                                        return true;
                                    }
                                }
                                else
                                {
                                    this.employees[j]=this.employees[j+1];
                                    //this.employees[j+1]=null;
                                    this.size--;
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public int size()
    {
        return this.size;
    }

    public Employee[] getEmployees()
    {
        Employee[] mas=new Employee[this.size];
        for (int i=0; i<this.size;i++)
        {
            mas[i]=this.employees[i];
        }
        return mas;
    }
    public Employee[] getEmployees(String jobTitle)
    {
        int count=0;
        for(int i=0; i< this.employees.length; i++)
        {
            if(this.employees[i]!=null)
            {
                if (this.employees[i].GetJobTitle() == jobTitle) {
                    count++;
                }
            }
        }
        Employee[] temp=new Employee[count];
        int k=0;
        for(int i=0; i<this.employees.length;i++)
        {
            if(this.employees[i]!=null)
            {
                if (this.employees[i].GetJobTitle() == jobTitle) {
                    temp[k] = this.employees[i];
                    k++;
                }
            }
        }
        return  temp;
    }

    public Employee[] employeesSortedBySalary()
    {
        Employee[] temp=new Employee[this.size];
        int buf;
        for(int i=0;i<this.size;i++)
        {
            temp[i]=this.employees[i];
        }
        for(int i=1;i<this.size;i++)
        {
            for(int j=i;j>0;j--)
            {
                if (temp[j].GetSalary()>temp[j-1].GetSalary())
                {
                    buf=temp[j].GetSalary();
                    temp[j].SetSalary(temp[j-1].GetSalary());
                    temp[j-1].SetSalary(buf);
                }
            }
        }
        return temp;
    }
    public String GetNameDepartment()
    {
        return this.name;
    }
}
