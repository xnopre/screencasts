package xnopre;

import lib.Connector;

public class Driver {

    private Connector connector;
    private Encoder encoder;

    public Driver(Connector connector, Encoder encoder) {
        this.connector = connector;
        this.encoder = encoder;
    }

    public void openGate(int gateNumber) {
        try {
            connector.sendFrame(encoder.buildFrameToOpenGate(gateNumber));
        } catch (Exception e) {
            throw new DriverException("Erreur de transmission de la trame");
        }
    }
}
