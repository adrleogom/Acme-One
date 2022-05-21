package acme.testing.authenticated.announcements;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.announcement.Announcement;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedAnnouncementRepositoryTest extends AbstractRepository {
	@Query("select a from Announcement a where a.title = :title")
	Announcement findOneAnnouncementByTitle(String title);
	
	@Query("select a from Announcement a")
	Collection<Announcement> findAllAnnouncements();
	
}
