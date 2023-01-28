
package cpit252project;

public class OrderCommands implements Icommand{
    Order order;

    public OrderCommands(Order order) {
        this.order = order;
    }
    
    @Override
    public void confirmOrder() {
        System.out.println("Order confirming...");
        this.order.finish();
    }

    @Override
    public void cancleOrder() {
        System.out.println("Deleting all Items...");
        this.order.DeleteOrder();
    }
    
}
