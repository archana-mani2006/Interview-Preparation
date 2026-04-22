import java.util.*;
class Consumer {
    private int consumerId;
    private String name;
    private String address;
    private String connectionType; 
    private String password;

    public Consumer(int consumerId, String name, String address, String connectionType, String password) {
        this.consumerId = consumerId;
        this.name = name;
        this.address = address;
        this.connectionType = connectionType;
        this.password = password;
    }

    public int getConsumerId() { return consumerId; }
    public String getName() { return name; }
    public String getPassword() { return password; }
    public String getConnectionType() { return connectionType; }
    
    public void showProfile() {
        System.out.println("ID: " + consumerId + " | Name: " + name + " | Type: " + connectionType + " | Address: " + address);
    }
}

class Bill {
    private int billId;
    private int consumerId;
    private double unitsConsumed;
    private double totalAmount;
    private String month;
    private boolean isPaid;

    public Bill(int billId, int consumerId, double unitsConsumed, double totalAmount, String month) {
        this.billId = billId;
        this.consumerId = consumerId;
        this.unitsConsumed = unitsConsumed;
        this.totalAmount = totalAmount;
        this.month = month;
        this.isPaid = false;
    }

    public int getBillId() { return billId; }
    public int getConsumerId() { return consumerId; }
    public boolean isPaid() { return isPaid; }
    public void setPaid(boolean paid) { isPaid = paid; }

    public void showBill() {
        String status = isPaid ? "PAID" : "PENDING";
        System.out.println("Bill ID: " + billId + " | Month: " + month + " | Units: " + unitsConsumed + 
         " | Amount: ₹" + totalAmount + " | Status: " + status);
    }
}



public class EBBillingApp {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Consumer> consumers = new ArrayList<>();
    static ArrayList<Bill> bills = new ArrayList<>();
    static Consumer currentConsumer = null;

    static final double DOMESTIC_RATE = 5.50;
    static final double COMMERCIAL_RATE = 9.00;

    static void login() {
        System.out.print("Enter Consumer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Password: ");
        String pass = scanner.nextLine();

        for (Consumer c : consumers) {
            if (c.getConsumerId() == id && c.getPassword().equals(pass)) {
                System.out.println("Welcome back, " + c.getName() + "!");
                currentConsumer = c;
                return;
            }
        }
        System.out.println("Invalid credentials.");
    }

    static void generateBill() {
        System.out.print("Enter Month: ");
        String month = scanner.next();
        System.out.print("Enter Units Consumed: ");
        double units = scanner.nextDouble();

        double rate = currentConsumer.getConnectionType().equalsIgnoreCase("Domestic") ? DOMESTIC_RATE : COMMERCIAL_RATE;
        double total = units * rate;

        Bill newBill = new Bill(bills.size() + 101, currentConsumer.getConsumerId(), units, total, month);
        bills.add(newBill);
        System.out.println("Bill generated successfully for " + month);
    }

    static void viewMyBills() {
        System.out.println("\n--- Your Billing History ---");
        boolean found = false;
        for (Bill b : bills) {
            if (b.getConsumerId() == currentConsumer.getConsumerId()) {
                b.showBill();
                found = true;
            }
        }
        if (!found) System.out.println("No bills found.");
    }

    static void payBill() {
        System.out.print("Enter Bill ID to pay: ");
        int bId = scanner.nextInt();

        for (Bill b : bills) {
            if (b.getBillId() == bId && b.getConsumerId() == currentConsumer.getConsumerId()) {
                if (b.isPaid()) {
                    System.out.println("This bill is already paid.");
                } else {
                    b.setPaid(true);
                    System.out.println("Payment of ₹" + bId + " successful!");
                }
                return;
            }
        }
        System.out.println("Bill ID not found.");
    }

    static void viewTariff() {
        System.out.println("\n--- Current Tariff Rates ---");
        System.out.println("Domestic: ₹" + DOMESTIC_RATE + " per unit");
        System.out.println("Commercial: ₹" + COMMERCIAL_RATE + " per unit");
    }

    public static void main(String[] args) {
        
        consumers.add(new Consumer(1, "Alice", "123 Maple St", "Domestic", "pass123"));
        consumers.add(new Consumer(2, "Tech Corp", "456 Industrial Hub", "Commercial", "admin789"));

        while (true) {
            if (currentConsumer == null) {
                System.out.println("\n--- EB Billing System ---");
                System.out.println("1. Login");
                System.out.println("2. View Tariff Rates");
                System.out.println("3. Exit");
                System.out.print("Option: ");
                int choice = scanner.nextInt();

                if (choice == 1) login();
                else if (choice == 2) viewTariff();
                else System.exit(0);
            } else {
                System.out.println("\n---------------");
                System.out.println("1. View Profile");
                System.out.println("2. Generate New Bill (Self-Service)");
                System.out.println("3. View Billing History");
                System.out.println("4. Pay Bill");
                System.out.println("5. Logout");
                System.out.print("Choose option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> currentConsumer.showProfile();
                    case 2 -> generateBill();
                    case 3 -> viewMyBills();
                    case 4 -> payBill();
                    case 5 -> currentConsumer = null;
                    default -> System.out.println("Invalid Option");
                }
            }
        }
    }
}