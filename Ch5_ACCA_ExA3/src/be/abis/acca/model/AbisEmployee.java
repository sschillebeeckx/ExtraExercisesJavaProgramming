package be.abis.acca.model;

public class AbisEmployee extends Person {

    private int startAge;
    private double startSalary;
    private double grossSalary;
    private Address homeAddress;
    private Role[] roles = new Role[3];

    public AbisEmployee(String firstName, String lastName, int age, double salary, Address homeAddress) {
        super(firstName, lastName, age);
        Address a = new Address("Diestsevest","32 bus 4B","3000","Leuven","Belgium","BE");
        Company c = new Company("Abis",a);
        this.setCompany(c);
        this.grossSalary = salary;
        this.homeAddress = homeAddress;
    }

    public AbisEmployee(String firstName, String lastName, int age, int startAge, double startSalary, double salary, Address homeAddress) {
        this(firstName, lastName, age, salary, homeAddress);
        this.startAge=startAge;
        this.startSalary=startSalary;
    }

    public int getStartAge() {
        return startAge;
    }

    public void setStartAge(int startAge) {
        this.startAge = startAge;
    }

    public double getStartSalary() {
        return startSalary;
    }

    public void setStartSalary(double startSalary) {
        this.startSalary = startSalary;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Role[] getRoles() {
        return roles;
    }

    public void setRoles(Role[] roles) {
        this.roles = roles;
    }

    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("The employee lives in " + this.getHomeAddress().getTown() + " and earns " + grossSalary + " per month.");
    }

    public double calculateNetSalary(){
        return this.calculateNetSalary(grossSalary);
    }

    public double calculateNetSalary(double salaryInput){
        double grossYearlySalary=salaryInput*12;
        double taxRate=0;
        if (grossYearlySalary<15200){
            taxRate=25;
        } else if (grossYearlySalary>=15200 && grossYearlySalary<26830){
            taxRate=40;
        } else if (grossYearlySalary>=26830 && grossYearlySalary<46440){
            taxRate=45;
        } else {
            taxRate=50;
        }
        return salaryInput*(1-taxRate/100.);
    }



    public void printSalaryHistory(){
        int loopAge=startAge;
        double loopSalary=startSalary;
        double netSalary=0;

        while (loopAge<=this.getAge() && loopAge<=startAge+35){
            if (loopAge!=startAge){ loopSalary=loopSalary*1.05;}
            netSalary =this.calculateNetSalary(loopSalary);
            System.out.println(this.getFirstName() + "'s net salary at " + loopAge + " is " + netSalary );
            loopAge+=2;
        }

    }

    public  Role findRole(String type){
        Role foundRole =null;
        for (Role r : roles){
            if (r!=null) {
                String roleType = r.getType();
                if (roleType.equals(type)) {
                    foundRole = r;
                }
            }
        }
        return foundRole;
    }


}
