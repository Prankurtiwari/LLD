package SOLID.depedencyInversion.without;

public class MacBook {
    private final WiredMouse mouse;
    private final WiredKeyboard keyboard;


    public MacBook() {
        this.mouse = new WiredMouse();
        this.keyboard = new WiredKeyboard();
    }
}
