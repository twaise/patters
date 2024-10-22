class ExpenseRequest {
    private double amount;
    private String purpose;

    public ExpenseRequest(double amount, String purpose) {
        this.amount = amount;
        this.purpose = purpose;
    }

    public double getAmount() {
        return amount;
    }

    public String getPurpose() {
        return purpose;
    }
}

abstract class Approver {
    protected Approver next;

    public void setNext(Approver next) {
        this.next = next;
    }

    public abstract void processRequest(ExpenseRequest request);
}

class TeamLead extends Approver {
    public void processRequest(ExpenseRequest request) {
        if (request.getAmount() < 1000) {
            System.out.println("Team Lead approved $" + request.getAmount() + " for " + request.getPurpose());
        } else if (next != null) {
            next.processRequest(request);
        }
    }
}

class Manager extends Approver {
    public void processRequest(ExpenseRequest request) {
        if (request.getAmount() < 5000) {
            System.out.println("Manager approved $" + request.getAmount() + " for " + request.getPurpose());
        } else if (next != null) {
            next.processRequest(request);
        }
    }
}

class Director extends Approver {
    public void processRequest(ExpenseRequest request) {
        if (request.getAmount() < 10000) {
            System.out.println("Director approved $" + request.getAmount() + " for " + request.getPurpose());
        } else if (next != null) {
            next.processRequest(request);
        }
    }
}

class CEO extends Approver {
    public void processRequest(ExpenseRequest request) {
        System.out.println("CEO approved $" + request.getAmount() + " for " + request.getPurpose());
    }
}

public class Chain {
    public static void main(String[] args) {
        Approver teamLead = new TeamLead();
        Approver manager = new Manager();
        Approver director = new Director();
        Approver ceo = new CEO();

        teamLead.setNext(manager);
        manager.setNext(director);
        director.setNext(ceo);

        ExpenseRequest request1 = new ExpenseRequest(500, "Office Supplies");
        ExpenseRequest request2 = new ExpenseRequest(3000, "Conference Travel");
        ExpenseRequest request3 = new ExpenseRequest(7000, "New Equipment");
        ExpenseRequest request4 = new ExpenseRequest(15000, "Company Party");

        teamLead.processRequest(request1);
        teamLead.processRequest(request2);
        teamLead.processRequest(request3);
        teamLead.processRequest(request4);
    }
}
