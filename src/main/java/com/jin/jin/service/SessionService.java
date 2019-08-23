package com.jin.jin.service;

import com.jin.jin.model.UserOnline;

import java.util.List;

public interface SessionService {
    List<UserOnline> list();
    boolean forceLogout(String sessionId);
}