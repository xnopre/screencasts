package xnopre;

import lib.Connector;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class DriverTest {

    @Test
    public void should_send_frame_to_open_gate_2() {
        Encoder encoder = mock(Encoder.class);
        when(encoder.buildFrameToOpenGate(2)).thenReturn("OG2");
        Connector connector = mock(Connector.class);
        Driver driver = new Driver(connector, encoder);

        driver.openGate(2);

        verify(connector).sendFrame("OG2");
    }

    @Test
    public void should_throw_Driver_Exception() {
        Encoder encoder = mock(Encoder.class);
        when(encoder.buildFrameToOpenGate(2)).thenReturn("OG2");
        Connector connector = mock(Connector.class);
        doThrow(new NullPointerException()).when(connector).sendFrame(anyString());
        Driver driver = new Driver(connector, encoder);

        try {
            driver.openGate(2);
            fail("Devrait déclencher une exception");
        } catch (DriverException e) {
            assertThat(e.getMessage()).isEqualTo("Erreur de transmission de la trame");
        }

    }
}

