package com.funnyland.funnylive.endpoint.cranegame.controller;

import java.util.List;

import com.funnyland.funnylive.endpoint.cranegame.request.CraneGameRequest;
import com.funnyland.funnylive.endpoint.cranegame.response.CraneGameResponse;
import com.funnyland.funnylive.service.CraneGameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/crane-games")
public class CraneGameController {

    private final CraneGameService craneGameService;

    @GetMapping
    public List<CraneGameResponse> getCraneGames() {
        return craneGameService.getCraneGames();
    }

    @GetMapping("/{craneGameId}")
    public CraneGameResponse getCraneGames(@PathVariable Long craneGameId) {
        return craneGameService.getCraneGame(craneGameId);
    }

    @PostMapping
    public CraneGameResponse createCraneGame(@RequestBody CraneGameRequest request) {
        return craneGameService.createCraneGame(request);
    }
}
