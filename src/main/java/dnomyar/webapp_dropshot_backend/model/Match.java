package dnomyar.webapp_dropshot_backend.model;

import dnomyar.webapp_dropshot_backend.enumeration.MatchStatus;
import dnomyar.webapp_dropshot_backend.enumeration.MatchType;
import dnomyar.webapp_dropshot_backend.enumeration.Sport;

import java.time.LocalDateTime;

public record Match(
        Integer id,
        String title,
        String description,
        Sport sport,
        String location,
        LocalDateTime datePlayed,
        MatchStatus matchStatus,
        MatchType matchType,
        LocalDateTime dateRecorded,
        LocalDateTime lastUpdated
) {}
