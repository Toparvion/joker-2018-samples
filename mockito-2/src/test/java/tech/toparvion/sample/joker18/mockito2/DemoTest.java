package tech.toparvion.sample.joker18.mockito2;

import org.junit.Test;

import javax.swing.*;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class DemoTest {

  @Test(expected = SocketTimeoutException.class)
  public void tetsCheckedException() {
    MyService myServiceMock = mock(MyService.class);

    Class<? extends Throwable> exceptionClass = SocketTimeoutException.class;
    doThrow(exceptionClass).when(myServiceMock).callExternalSystem();

    myServiceMock.callExternalSystem();
  }

  @Test
   public void testAnyMatcher() {
     JButton buttonMock = mock(JButton.class);
     buttonMock.setName(null);
     verify(buttonMock).setName(anyString());
   }

  @Test
  public void testAnyStringMatcher() {
    MyService myServiceMock = mock(MyService.class);

    myServiceMock.setTarget(new JButton());

    verify(myServiceMock).setTarget(anyString());
  }

  @Test
  public void testAnyMatcher2() {
    ArrayList listMock = mock(ArrayList.class);

    listMock.add(new JButton());

    verify(listMock).add(anyList());
  }
}
