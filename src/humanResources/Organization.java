package humanResources;

import humanResources.Department;
import humanResources.Employee;

public class Organization
{
    private String name;
    private Department[] departments;
    public Organization(String Name)
    {
        this.name=Name;
        this.departments=new Department[8];
    }
    public Organization(String Name,Department[] department)
    {
        this.name=Name;
        this.departments=department;
    }
    public void add(Department department)
    {
       int l=this.departments.length;
       int count=0;
       for(int i=0;i<l;i++)
       {
           if(this.departments[i]==null)
           {
               this.departments[i]=department;
               break;
           }
           else
           {
               count++;
           }
       }
       if (count==l)
       {
           Department[] temp=new Department[l*2];
           for (int i=0;i<l;i++)
           {
               temp[i]=this.departments[i];
           }
           temp[l]=department;
           this.departments=temp;
       }
    }
    public boolean remove(String Name)
    {
        for(int i=0; i<this.departments.length;i++)
        {
            if(this.departments[i].GetNameDepartment()==Name)
            {
                if(i==this.departments.length-1)
                {
                    this.departments[i]=null;
                    return true;
                }
                else
                {
                    for(int j=i; j<this.departments.length-1;j++)
                    {
                        if (this.departments[j+1]!=null)
                        {
                            this.departments[j]=this.departments[j+1];
                        }
                        else
                        {
                           this.departments[j]=null;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
    public Department getDepartment(String name)
    {
        int index=0;
        for(int i=0; i<this.departments.length;i++)
        {
            if(this.departments[i].GetNameDepartment()==name)
            {
                index=i;
                break;
            }
        }
        return this.departments[index];
    }

    public Department[] getDepartments()
    {
        int count=0;
        for(int i=0;i<this.departments.length; i++)
        {
            if(this.departments[i]!=null)
            {
                count++;
            }
        }
        Department[] temp=new Department[count];
        for(int i=0;i<count;i++)
        {
            temp[i]=this.departments[i];
        }
        return temp;
    }
    public int size()
    {
        int count=0;
        for(int i=0;i<this.departments.length; i++)
        {
            if(this.departments[i]!=null)
            {
                count++;
            }
        }
        return count;
    }
    public int employeesQuantity()
    {
        int count=0;
        for(int i=0;i<this.departments.length;i++)
        {
            if(this.departments[i]!=null)
            {
                count+=this.departments[i].size();
            }
        }
        return count;
    }
    public int employeesQuantity(String jobTitle)
    {
        int count=0;
        Employee[] temp;
        for(int i=0;i<this.departments.length;i++)
        {
            if(this.departments[i]!=null)
            {
                temp=this.departments[i].getEmployees(jobTitle);
                count+=temp.length;
            }
        }
        return count;
    }
    public Employee bestEmployee()
    {
        Employee empl=null;
        Employee[] temp=null;
        if (this.departments[0] != null)
        {
            temp=this.departments[0].employeesSortedBySalary();
            empl=temp[0];
        }
        for(int i=1; i<this.departments.length;i++)
        {
            if(this.departments[i]!=null)
            {
                temp=null;
                temp=this.departments[i].employeesSortedBySalary();
                if(empl.GetSalary()<temp[0].GetSalary())
                {
                    empl=temp[0];
                }
            }
        }
        return empl;
    }
    public Department getEmployeesDepartment(String firstName,String secondName)
    {
        Department dep=null;
        for(int i=0;i<this.departments.length;i++)
        {
            if(this.departments[i]!=null)
            {
                Employee[] temp=this.departments[i].getEmployees();
                for(int j=0;j<temp.length;j++)
                {
                    if((temp[j].GetFirstName()==firstName) && (temp[j].GetSecondName()==secondName))
                    {
                        dep=this.departments[i];
                        return dep;
                    }
                }
            }
        }
        return dep;
    }
}
