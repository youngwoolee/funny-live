package com.funnyland.funnylive.service;

import java.util.List;

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

    public void usePoints(User user, int amount) {
        //TODO: 잔액만큼 있는 사용금액인지 체크
        user.deductPoints(amount);
        userRepository.save(user);

        PointTransaction transaction = new PointTransaction(amount, user, PointTransactionType.USE);
        pointTransactionRepository.save(transaction);
    }

    public List<PointTransaction> getPointTransactions(User user) {
        return pointTransactionRepository.findAllByUserId(user.getId());
    }
}
