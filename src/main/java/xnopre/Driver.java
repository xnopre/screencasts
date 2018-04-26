package xnopre;

import lib.Connector;

public class Driver {
    private Connector connector;

    public Driver(Connector connector) {
        this.connector = connector;
    }

    public void openGate(int gateNumber) {
        connector.sendFrame("OG"+gateNumber);
    }
}
