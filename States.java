interface State {
    void payOrder();
    void shipOrder();
    void deliverOrder();
    void cancelOrder();
}

class Order {
    private State currentState;

    public Order() {
        currentState = new NewState(this);
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void payOrder() {
        currentState.payOrder();
    }

    public void shipOrder() {
        currentState.shipOrder();
    }

    public void deliverOrder() {
        currentState.deliverOrder();
    }

    public void cancelOrder() {
        currentState.cancelOrder();
    }
}

class NewState implements State {
    private Order order;

    public NewState(Order order) {
        this.order = order;
    }

    public void payOrder() {
        System.out.println("Order paid.");
        order.setState(new PaidState(order));
    }

    public void shipOrder() {
        System.out.println("Cannot ship. Order not paid.");
    }

    public void deliverOrder() {
        System.out.println("Cannot deliver. Order not paid.");
    }

    public void cancelOrder() {
        System.out.println("Order canceled.");
    }
}

class PaidState implements State {
    private Order order;

    public PaidState(Order order) {
        this.order = order;
    }

    public void payOrder() {
        System.out.println("Order already paid.");
    }

    public void shipOrder() {
        System.out.println("Order shipped.");
        order.setState(new ShippedState(order));
    }

    public void deliverOrder() {
        System.out.println("Cannot deliver. Order not shipped.");
    }

    public void cancelOrder() {
        System.out.println("Order canceled.");
    }
}

class ShippedState implements State {
    private Order order;

    public ShippedState(Order order) {
        this.order = order;
    }

    public void payOrder() {
        System.out.println("Order already paid.");
    }

    public void shipOrder() {
        System.out.println("Order already shipped.");
    }

    public void deliverOrder() {
        System.out.println("Order delivered.");
        order.setState(new DeliveredState(order));
    }

    public void cancelOrder() {
        System.out.println("Cannot cancel. Order already shipped.");
    }
}

class DeliveredState implements State {
    private Order order;

    public DeliveredState(Order order) {
        this.order = order;
    }

    public void payOrder() {
        System.out.println("Order already paid.");
    }

    public void shipOrder() {
        System.out.println("Order already shipped.");
    }

    public void deliverOrder() {
        System.out.println("Order already delivered.");
    }

    public void cancelOrder() {
        System.out.println("Cannot cancel. Order already delivered.");
    }
}

public class States {
    public static void main(String[] args) {
        Order order = new Order();
        order.payOrder();
        order.shipOrder();
        order.deliverOrder();
        order.cancelOrder();
    }
}
