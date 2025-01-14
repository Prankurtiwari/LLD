package SOLID.depedencyInversion.with;

public interface IMouse {
    void connect();
}

class WiredMouse implements IMouse {

    @Override
    public void connect() {
        // using wire
    }
}

class BluetoothMouse implements IMouse {

    @Override
    public void connect() {
        // using radio
    }
}
