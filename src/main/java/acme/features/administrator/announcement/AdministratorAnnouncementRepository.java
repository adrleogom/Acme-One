package acme.features.administrator.announcement;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.announcement.Announcement;
import acme.framework.repositories.AbstractRepository;
import acme.framework.roles.Administrator;

@Repository
public interface AdministratorAnnouncementRepository extends AbstractRepository {

	@Query("select a from Announcement a")
	List<Announcement> findAllAnnouncements();

	@Query("select a from Announcement a where a.id = :id")
	Announcement findOneAnnouncementById(int id);

	@Query("select a from Administrator a where a.userAccount.id = :masterId")
	Administrator findOneAdministratorById(int masterId);
}
