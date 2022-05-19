package ea.badge.service;

import ea.badge.domain.Transaction;

public interface BadgeScanService {
    Transaction scan(Long badgeId, Long locationId);
}
