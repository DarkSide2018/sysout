package ru.sysout.dao;


import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.sysout.model.Report;

@Transactional(propagation = Propagation.NOT_SUPPORTED)
@Repository
public interface ReportRepository extends CrudRepository<Report, Long> {

      @Modifying
      @Query("update report set published = 'true' where id=:id")
      void updatePublished(long id);

}
