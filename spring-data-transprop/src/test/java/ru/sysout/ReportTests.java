package ru.sysout;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import ru.sysout.service.ProviderExampleService;
import ru.sysout.service.ReportService;

@SpringBootTest
class ReportTests {
@Autowired
private ReportService reportService;

    @Autowired
    private ProviderExampleService providerExampleService;
    @Autowired
    private ApplicationContext context;
    @Test
    void shouldSendReport()
    {
        reportService.sendReport(1l);
    }
    @Test
    void providerTest()
    {

        providerExampleService.bf1(1);
        providerExampleService.bf1(1);
        String[] allBeanNames = context.getBeanDefinitionNames();
        for(String beanName : allBeanNames) {
            System.out.println(beanName);
        }
    }


}
