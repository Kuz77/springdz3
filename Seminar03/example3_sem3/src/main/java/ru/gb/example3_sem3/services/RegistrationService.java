package ru.gb.example3_sem3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.example3_sem3.domain.User;

@Service
public class RegistrationService {

    @Autowired
    private  DataProcessingService dataProcessingService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    //Поля UserService, NotificationService
    private final UserService userService;
    private final NotificationService notificationService;
    @Autowired
    public RegistrationService(DataProcessingService dataProcessingService, UserService userService, NotificationService notificationService) {
        this.dataProcessingService = dataProcessingService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    //Метод processRegistration
    public void processRegistration(String name, int age, String email) {
        User user = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(user);
        notificationService.sendNotification("Пользователь зарегистрирован: " + name);
    }
}
