package xnopre;

import lib.Connector;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DriverTest {

    private String frameSent;

    @Test
    public void should_send_frame_to_open_gate_2() {
        Connector connector = new Connector() {
            @Override
            public void sendFrame(String frame) {
                frameSent = frame;
            }
        };
        Driver driver = new Driver(connector);

        driver.openGate(2);

        assertThat(frameSent).isEqualTo("OG2");
    }
}
