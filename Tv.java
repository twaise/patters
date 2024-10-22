interface Command {
    void execute();
    void undo();
}

class TV {
    public void on() {
        System.out.println("TV is ON");
    }

    public void off() {
        System.out.println("TV is OFF");
    }
}

class TurnTVOn implements Command {
    private TV tv;

    public TurnTVOn(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.on();
    }

    public void undo() {
        tv.off();
    }
}

class TurnTVOff implements Command {
    private TV tv;

    public TurnTVOff(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.off();
    }

    public void undo() {
        tv.on();
    }
}

class RemotesControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

    public void pressUndo() {
        command.undo();
    }
}

public class Tv {
    public static void main(String[] args) {
        RemotesControl remote = new RemotesControl();
        TV tv = new TV();

        Command turnOn = new TurnTVOn(tv);
        Command turnOff = new TurnTVOff(tv);

        remote.setCommand(turnOn);
        remote.pressButton();
        remote.pressUndo();

        remote.setCommand(turnOff);
        remote.pressButton();
        remote.pressUndo();
    }
}
