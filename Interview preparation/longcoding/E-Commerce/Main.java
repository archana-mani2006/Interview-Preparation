class Product{
    String Name;
    int Price;
    int quantity;
    Product(String Name,int Price ,int quantity){
        this.Name=Name;
        this.Price=Price;
        this.quantity=quantity;
    }
    void addProduct(){
        System.out.println("Product Name: "+Name);
        System.out.println("Product Price: "+Price);
    }

    void CalculateTotalPrice(){
        int totalPrice=Price*quantity;
        System.out.println("Total Price: "+totalPrice);
    }
}
class Customer{
    String CustomerName;
    int orderCount=0;
    
    Customer(String CustomerName){
        this.CustomerName=CustomerName;
    }
}
class Order{
    Customer c;
    Product p;
    int orderCount=0;
   
    Order(Customer c,Product p){
        this.c=c;
        this.p=p;
        c.orderCount++;
        
    }
    void displayOrderDetails(){
        System.out.println("Customer Name: "+c.CustomerName);
        p.addProduct();
        System.out.println("Order Count: "+c.orderCount);
        p.CalculateTotalPrice();

    }
}
public class Main{
    public static void main(String[] args){
        Customer c1=new Customer("Joe");
        
        Product p1=new Product("Laptop",100000,1);
        Customer c2=new Customer("Alice");
        Product p2=new Product("Phone",50000,1);
        Order o1=new Order(c1,p1);
        Order o2=new Order(c1,p2);
        
        o1.displayOrderDetails();
        o2.displayOrderDetails();
        Customer c3=new Customer("Bob");
        Product p3=new Product("Tablet",30000,2);   
        Order o3=new Order(c3,p3);
        o3.displayOrderDetails();
    }
}