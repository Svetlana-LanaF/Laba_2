package humanResources;

public class Employee
{
    private String firstName;
    private String secondName;
    private String JobTitle;
    private int salary;
    public Employee(String FirstName, String SecondName)
    {
        this.firstName=FirstName;
        this.secondName=SecondName;
        this.JobTitle="";
        this.salary=0;
    }
    public Employee(String FirstName, String SecondName,String JobTitle, int Salary)
    {
        this.firstName=FirstName;
        this.secondName=SecondName;
        this.JobTitle=JobTitle;
        this.salary=Salary;
    }
    public String GetFirstName()
    {
        return this.firstName;
    }
    public void SetFirstName(String FirstName)
    {
        this.firstName=FirstName;
    }
    public String GetSecondName()
    {
        return this.secondName;
    }
    public void SetSecondName(String SecondName)
    {
        this.secondName=SecondName;
    }
    public String GetJobTitle()
    {
        return this.JobTitle;
    }
    public void SetJobTitle(String JobTitle)
    {
        this.JobTitle=JobTitle;
    }
    public int GetSalary()
    {
        return this.salary;
    }
    public void SetSalary(int Salary)
    {
        this.salary=Salary;
    }
}
