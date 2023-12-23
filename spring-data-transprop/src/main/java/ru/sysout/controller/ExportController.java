package ru.sysout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.sysout.model.Proto;
import ru.sysout.model.ProtoItem;
import ru.sysout.service.ProviderExampleService;

import java.util.Map;

@RestController
public class ExportController {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private ProviderExampleService service;

    @GetMapping("/beans")
    @ResponseStatus(value = HttpStatus.OK)
    int registeredBeans() {
        return printBeans();
    }

    private int printBeans() {
        String[] beanNamesForType = applicationContext.getBeanNamesForType(Proto.class);
        service.getItems().forEach(ProtoItem::display);
            return beanNamesForType.length;
    }
}
