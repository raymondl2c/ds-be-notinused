package dnomyar.webapp_dropshot_backend.repository;

import dnomyar.webapp_dropshot_backend.enumeration.MatchStatus;
import dnomyar.webapp_dropshot_backend.enumeration.MatchType;
import dnomyar.webapp_dropshot_backend.model.Match;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MatchRepository {
    private static final Logger logger = LoggerFactory.getLogger(MatchRepository.class);

    private List<Match> matches = new ArrayList<>();

    public List<Match> findAll() {
        return matches;
    }

    public Optional<Match> findById(Integer id) {
        return matches.stream().filter(match -> match.id().equals(id)).findFirst();
    }

    public void createMatch(Match match) {
        matches.add(match);
    }

    @PostConstruct
    private void init() {
        // Initialize some matches for testing
        matches.add(new Match(3, "Test Match 3", "Description 3", "BADMINTON", "Location 3", LocalDateTime.now().minusDays(1), MatchStatus.COMPLETED, MatchType.CASUAL, LocalDateTime.now(), LocalDateTime.now()));
        matches.add(new Match(2, "Test Match 2", "Description 2", "VOLLEYBALL", "Location 2", LocalDateTime.now().minusHours(1), MatchStatus.IN_PROGRESS, MatchType.CASUAL_RANKED, LocalDateTime.now(), LocalDateTime.now()));
        matches.add(new Match(1, "Test Match 1", "Description 1", "BADMINTON", "Location 1", LocalDateTime.now().minusMinutes(30), MatchStatus.PENDING, MatchType.CASUAL, LocalDateTime.now(), LocalDateTime.now()));
    }

}
