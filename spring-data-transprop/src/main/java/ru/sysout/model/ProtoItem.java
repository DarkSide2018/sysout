package ru.sysout.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.sysout.service.ReportService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Setter
@Getter
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ProtoItem implements DisposableBean,Proto {
    private ReportService service;
    private int value;
    @PostConstruct
    public void init(){
        System.out.println("ProtoItem was built");
    }
    @Override
    public void display(){
        System.out.println(String.format("current value is %s",value));
    }
    @PreDestroy
    public void destroy(){
        System.out.println("ProtoItem was destroyed");
    }
}
