package ru.sysout.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.sysout.dao.AddressRepository;
import ru.sysout.dao.ReportRepository;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private AddressRepository addressRepository;

    public void magic(){
        System.out.println("magic");
    }
    @Transactional
    public void sendReport(long id) {
        addressRepository.addAddress(id, "addr1");

        System.out.println(id + " sent");
        reportRepository.updatePublished(id);
        //исключение заставит транзакцию откатиться:
        //throw new RuntimeException();
    }
}
