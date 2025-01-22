package dnomyar.webapp_dropshot_backend.controller;

import dnomyar.webapp_dropshot_backend.model.Match;
import dnomyar.webapp_dropshot_backend.repository.MatchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private static final Logger logger = LoggerFactory.getLogger(MatchController.class);

    private final MatchRepository matchRepository;

    public MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @GetMapping
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @GetMapping("/{id}")
    public Match getMatchById(@PathVariable Integer id) {
        Optional<Match> match = matchRepository.findById(id);
        if (match.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Match not found with id: " + id);
        }
        return match.get();
    }

//    public Match createMatch(Match match) {
//        return matchRepository.save(match);
//    }
//
//    public Match updateMatch(Match match) {
//        return matchRepository.save(match);
//    }
//
//    public void deleteMatch(Integer id) {
//        matchRepository.deleteById(id);
//    }

}
