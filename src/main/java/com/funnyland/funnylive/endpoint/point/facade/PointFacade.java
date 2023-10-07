package com.funnyland.funnylive.endpoint.point.facade;

import java.util.List;
import java.util.stream.Collectors;

import com.funnyland.funnylive.domain.User;
import com.funnyland.funnylive.endpoint.point.response.PointTransactionResponse;
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

    public void usePoints(Long userId, int amount) {
        User user = userService.getUser(userId);
        pointService.usePoints(user, amount);
    }

    public List<PointTransactionResponse> getPointTransactions(Long userId) {
        User user = userService.getUser(userId);
        return pointService.getPointTransactions(user).stream()
                .map(PointTransactionResponse::of).collect(Collectors.toList());
    }

    public void refundPoints(Long userId, int amount) {
        User user = userService.getUser(userId);
        pointService.refundPoints(user, amount);
    }
}
