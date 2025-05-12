package com.castlele.otpcreator.service.notification;

import com.castlele.otpcreator.model.user.User;

public interface NotificationSender {
    void send(String message, User user);
}
