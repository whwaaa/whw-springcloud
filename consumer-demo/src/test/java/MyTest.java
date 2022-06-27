import com.whw.consumer.ConsumerApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) // 作用就是可注入类,例如@Autowried
@SpringBootTest(classes = ConsumerApplication.class) // 作用类上,它主要是用来启动本地的SpringBoot环境
public class MyTest {
    @Autowired
    RibbonLoadBalancerClient client;
    @Test
    public void myTest() {
        for (int i=0; i<100; i++) {
            ServiceInstance instance = client.choose("user-service");
            System.out.println(instance.getHost() + ":" + instance.getPort());
        }
    }
}
