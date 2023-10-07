package com.funnyland.funnylive.endpoint.point.facade;

import com.funnyland.funnylive.domain.User;
import com.funnyland.funnylive.service.PointService;
import com.funnyland.funnylive.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PointFacade {

    private final PointService pointService;
    private final UserService userService;


    public void chargePoints(Long userId, int amount) {
        User user = userService.getUser(userId);
        pointService.chargePoints(user, amount);
    }

}
