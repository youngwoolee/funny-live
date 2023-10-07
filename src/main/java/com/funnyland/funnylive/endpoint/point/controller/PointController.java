package com.funnyland.funnylive.endpoint.point.controller;

import com.funnyland.funnylive.endpoint.point.facade.PointFacade;
import com.funnyland.funnylive.endpoint.point.request.PointRequest;
import lombok.RequiredArgsConstructor;
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
}
