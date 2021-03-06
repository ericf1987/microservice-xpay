package az.xpay;

import az.xpay.xweb.impl.XwebImplApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Eric F
 * @version 1.0
 * @date 2020/5/18 10:48
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = XwebImplApplication.class)
@TestPropertySource(locations = "classpath:application-base.yml")
@Slf4j
public class XwebImplBaseTest {
}
