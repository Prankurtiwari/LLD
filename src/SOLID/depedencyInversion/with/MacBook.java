package SOLID.depedencyInversion.with;

public class MacBook {
    private final IMouse mouse;
    private final IKeyboard keyboard;

    // Adding through constructor injection so it is defined at runtime.

    public MacBook(IKeyboard keyboard, IMouse mouse) {
        this.mouse = mouse;
        this.keyboard = keyboard;
    }
}
