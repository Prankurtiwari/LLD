package SOLID.depedencyInversion.without;

public interface IKeyboard {
    void connect();
}
class WiredKeyboard implements  IKeyboard{

    @Override
    public void connect() {
        // using wire
    }
}

class BluetoothKeyboard implements  IKeyboard{

    @Override
    public void connect() {
        // using freq
    }
}
