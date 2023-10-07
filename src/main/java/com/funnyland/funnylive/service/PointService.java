package com.funnyland.funnylive.service;

import com.funnyland.funnylive.domain.PointTransaction;
import com.funnyland.funnylive.domain.PointTransactionType;
import com.funnyland.funnylive.domain.User;
import com.funnyland.funnylive.repository.PointTransactionRepository;
import com.funnyland.funnylive.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
@Transactional
public class PointService {

    private final UserRepository userRepository;
    private final PointTransactionRepository pointTransactionRepository;

    public void chargePoints(User user, int amount) {
        user.increasePoints(amount);
        userRepository.save(user);

        PointTransaction transaction = new PointTransaction(amount, user, PointTransactionType.CHARGE);
        pointTransactionRepository.save(transaction);
    }
}
