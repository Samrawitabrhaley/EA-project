package ea.badge.service;

import ea.badge.domain.Transaction;

public interface BadgeScan {
    Transaction scan(Long badgeId, Long locationId);
}
