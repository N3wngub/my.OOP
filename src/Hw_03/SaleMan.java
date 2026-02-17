import java.util.Scanner;

public class SaleMan extends Employee {
    protected int saleAmount;

    public SaleMan() {
        super();
        saleAmount = 0;
    }

    public SaleMan(String firstname, String lastname, int salary, String position, int saleAmount) {
        super(firstname, lastname, salary, position);
        this.saleAmount = saleAmount;
    }

    public int calculatePay() {
        return salary + ((saleAmount * 5) / 100);
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        if (kb.hasNext()) {
            int n = kb.nextInt();
            Employee[] employee = new Employee[n];

            for (int i = 0; i < employee.length; i++) {
                //String typeStr = kb.next();
                char type = kb.next().charAt(0);

                String firstname = kb.next();
                String lastname = kb.next();
                int salary = kb.nextInt();
                String position = kb.next();

                if (type == 'E') {
                    employee[i] = new Employee(firstname, lastname, salary, position);
                } else if (type == 'S') {
                    int saleAmount = kb.nextInt();
                    employee[i] = new SaleMan(firstname, lastname, salary, position, saleAmount);
                }
            }
            for (int i = 0; i < employee.length; i++) {
                System.out.println(employee[i].toString());
            }

        }
    }
}

