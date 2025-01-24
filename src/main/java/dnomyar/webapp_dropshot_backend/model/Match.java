package dnomyar.webapp_dropshot_backend.model;

import dnomyar.webapp_dropshot_backend.enumeration.MatchStatus;
import dnomyar.webapp_dropshot_backend.enumeration.MatchType;

import java.time.LocalDateTime;

public record Match(
        Integer id,
        String title,
        String description,
        String sport,
        String location,
        LocalDateTime datePlayed,
        MatchStatus matchStatus,
        MatchType matchType,
        LocalDateTime dateRecorded,
        LocalDateTime lastUpdated
) {}
