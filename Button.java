interface Button {
    void render();
}
class DarkThemeButton implements Button {
    public void render() {
        System.out.println("Dark Theme Button");
    }
}
class LightThemeButton implements Button {
    public void render() {
        System.out.println("Light Theme Button");
    }
}
interface UIFactory {
    Button createButton();
}
class DarkThemeFactory implements UIFactory {
    public Button createButton() {
        return new DarkThemeButton();
    }
}
class LightThemeFactory implements UIFactory {
    public Button createButton() {
        return new LightThemeButton();
    }
}
