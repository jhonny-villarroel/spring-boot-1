package com.dh.demo.service;

import com.dh.demo.domain.Room;
import com.dh.demo.domain.Student;
import com.dh.demo.domain.Subscription;
import com.dh.demo.domain.Teacher;
import com.dh.demo.repository.RoomRepository;
import com.dh.demo.repository.StudentRepository;
import com.dh.demo.repository.SubscriptionRepository;
import com.dh.demo.repository.TeacherRepository;
import com.dh.demo.web.SubscriptionController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Richard on 10/06/2017.
 */
@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RoomRepository roomRepository;

    public List<Subscription> getAllSubscripions(){
        return subscriptionRepository.findAll();
    }

    public void addNewSubscription(SubscriptionController.SubscriptionRequestDTO subscriptionDTO){
        Subscription newSubscription = new Subscription();
        Student newStudent = studentRepository.findOne(subscriptionDTO.getStudentId());
        Teacher newTeacher = teacherRepository.findOne(subscriptionDTO.getTeacherId());
        Room nwRoom = roomRepository.findOne(subscriptionDTO.getRoomId());

        newSubscription.setStudent(newStudent);
        newSubscription.setTeacher(newTeacher);
        newSubscription.setRoom(nwRoom);
        newSubscription.setSubscriptionDate(subscriptionDTO.getSubDate());
        //subscriptionRepository.save(subscription);
        subscriptionRepository.save(newSubscription);
    }


}
