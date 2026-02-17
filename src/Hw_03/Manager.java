import java.util.Scanner;

public class Manager extends Employee {
    protected int cashPosition;

    public Manager() {
        super();
        cashPosition = 0;
    }

    public Manager(String firstName, String lastName, int salary, String position, int cashPosition) {
        super(firstName, lastName, salary, position);
        this.cashPosition = cashPosition;
    }

    public int calculatePay() {
        return salary + cashPosition;
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
                } else if (type == 'M') {
                    int cashPosition = kb.nextInt();
                    employee[i] = new Manager(firstname, lastname, salary, position, cashPosition);
                }
            }
            for (int i = 0; i < employee.length; i++) {
                System.out.println(employee[i].toString());
            }

        }
    }
}

