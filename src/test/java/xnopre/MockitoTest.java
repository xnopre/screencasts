package xnopre;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class MockitoTest {

    private static class Helper {
        public int getStatus() { return 200; }
        public String getInfo() { return "OK"; }
        public void send(String message) {
            System.out.println(message);
        }
    }

    private class HelperException extends RuntimeException {
        public HelperException(String message) {
            super(message);
        }
    }

    private Helper helper = mock(Helper.class);

    @Test
    public void test_default_behaviour() {
        assertThat(helper.getStatus()).isEqualTo(0);
        assertThat(helper.getInfo()).isNull();
        helper.send("Coucou");
    }

    @Test
    public void test_specific_behaviour() {
        verifyZeroInteractions(helper);
        when(helper.getStatus()).thenReturn(404);
        assertThat(helper.getStatus()).isEqualTo(404);
        assertThat(helper.getStatus()).isEqualTo(404);
        verify(helper, times(2)).getStatus();
    }

    @Test
    public void test_exception() {
        when(helper.getStatus()).thenThrow(new HelperException("Error !"));
        try {
            helper.getStatus();
            fail("Devrait déclencher une exception !");
        } catch (HelperException e) {
            assertThat(e.getMessage()).isEqualTo("Error !");
        }
    }

    @Test
    public void test_exception2() {
        doThrow(new HelperException("Error !")).when(helper).send(anyString());
        try {
            helper.send("test");
            fail("Devrait déclencher une exception !");
        } catch (HelperException e) {
            assertThat(e.getMessage()).isEqualTo("Error !");
        }
    }
}
