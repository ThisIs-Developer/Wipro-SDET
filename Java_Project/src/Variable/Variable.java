package Variable;

public class Variable {

    static String companyName = "Wipro";
    String name = "Baivab";
    int id = 101;
    String department = "SDET";
    String team = "RONE";

    void showEmpDetails() {
        System.out.println("Company: " + companyName);
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }

    void showWorkDetails() {
        System.out.println("Company: " + companyName);
        System.out.println("Department: " + department);
        System.out.println("Team: " + team);
    }

    public static void main(String[] args) {
        Variable v = new Variable();

        v.showEmpDetails();
        System.out.println("");
        v.showWorkDetails();
    }
}