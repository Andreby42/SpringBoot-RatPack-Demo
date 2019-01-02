package xyz.spacexplore.test;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import ratpack.test.MainClassApplicationUnderTest;
import xyz.spacexplore.SpringBootRatPackApplication;

public class RatPackTest {
MainClassApplicationUnderTest appUnderTest= new MainClassApplicationUnderTest(SpringBootRatPackApplication.class);

@Test
public void whenSayHello_thenGotWelcomeMessage() {
  assertEquals("hello baeldung!", appUnderTest
      .getHttpClient()
      .getText("/hello"));
}
 
@Test
public void whenRequestList_thenGotArticles()  {
    assertEquals(3, appUnderTest
      .getHttpClient()
      .getText("/list")
      .split(",").length);
}
 
@Test
public void whenRequestStaticResource_thenGotStaticContent() {
    assertThat(appUnderTest
      .getHttpClient()
      .getText("/"), 
      containsString("page is static"));
}
 
}
