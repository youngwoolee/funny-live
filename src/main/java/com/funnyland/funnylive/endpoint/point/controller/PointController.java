package com.funnyland.funnylive.endpoint.point.controller;

import java.util.List;

import com.funnyland.funnylive.endpoint.point.facade.PointFacade;
import com.funnyland.funnylive.endpoint.point.request.PointRequest;
import com.funnyland.funnylive.endpoint.point.response.PointTransactionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/points")
public class PointController {

    private final PointFacade pointFacade;

    @PostMapping("/charge")
    public void chargePoints(@RequestBody PointRequest request) {
        Long userId = 1L;
        pointFacade.chargePoints(userId, request.getAmount());
    }

    //사용 안함
    @PostMapping("/use")
    public void usePoints(@RequestBody PointRequest request) {
        Long userId = 1L;
        pointFacade.usePoints(userId, request.getAmount());
    }

    @GetMapping("/transactions")
    public List<PointTransactionResponse> getPointTransactions() {
        Long userId = 1L;
        return pointFacade.getPointTransactions(userId);
    }

}
