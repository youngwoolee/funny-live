package com.funnyland.funnylive.service;

import java.util.List;
import java.util.stream.Collectors;

import com.funnyland.funnylive.domain.CraneGame;
import com.funnyland.funnylive.endpoint.cranegame.request.CraneGameRequest;
import com.funnyland.funnylive.endpoint.cranegame.request.Position;
import com.funnyland.funnylive.endpoint.cranegame.response.CraneGameResponse;
import com.funnyland.funnylive.repository.CraneGameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CraneGameService {

    private final CraneGameRepository craneGameRepository;

    public List<CraneGameResponse> getCraneGames() {
        return craneGameRepository.findAll().stream()
                .map(CraneGameResponse::of).collect(Collectors.toList());

    }

    public CraneGameResponse createCraneGame(CraneGameRequest request) {
        CraneGame savedCraneGame = craneGameRepository.save(request.toDomain());
        return CraneGameResponse.of(savedCraneGame);
    }

    public CraneGameResponse getCraneGame(Long craneGameId) {
        CraneGame findCraneGame = craneGameRepository.findById(craneGameId)
                .orElseThrow(() -> new RuntimeException("craneGame not exist"));
        return CraneGameResponse.of(findCraneGame);
    }

    public boolean play(Long craneGameId, Position position) {
        CraneGame findCraneGame = craneGameRepository.findById(craneGameId)
                .orElseThrow(() -> new RuntimeException("craneGame not exist"));
        return findCraneGame.play(position);
    }
}
