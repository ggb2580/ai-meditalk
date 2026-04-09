package com.hrbu.meditalk;

import com.hrbu.meditalk.entity.Appointment;
import com.hrbu.meditalk.service.AppointmentService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MysqlCrudTest {
    @Resource
    private AppointmentService appointmentService;
    @Test
    public void test(){
        Appointment appointment = new Appointment();
        appointment.setUsername("张三");
        appointment.setIdCard("123456789012345678");
        appointment.setDepartment("内科");
        appointment.setDate("2026-03-16");
        appointment.setTime("上午");

        Appointment appointmentDB = appointmentService.getOne(appointment);
        System.out.println(appointmentDB);


    }

    @Test
    public void test02(){
        Appointment appointment = new Appointment();
        appointment.setDepartment("妇科");
        appointment.setUsername("李晓梅");
        appointment.setIdCard("34123243421213211X");
        appointment.setDoctor_name("王医生");
        appointment.setTime("8:30 - 9:00");
        appointment.setDate("2026-03-20");
        appointmentService.save(appointment);
    }

}
