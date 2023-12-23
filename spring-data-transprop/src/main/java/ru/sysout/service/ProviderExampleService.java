package ru.sysout.service;

import lombok.Getter;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import ru.sysout.model.Proto;
import ru.sysout.model.ProtoItem;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class ProviderExampleService {

    private final ObjectFactory<Proto> factory;
    List<ProtoItem> items = new ArrayList<>();

    public ProviderExampleService(ObjectFactory<Proto> factory) {
        this.factory = factory;

    }

    private Proto createItem() {
        return factory.getObject();
    }

    public String bf1(int i){
        ProtoItem item = (ProtoItem) createItem();
        items.add(item);
        item.setValue(i);
        item.display();
        return "success";
    }
    @PostConstruct
    public void init(){
        bf1(1);
        bf1(2);
        bf1(3);
    }
}
