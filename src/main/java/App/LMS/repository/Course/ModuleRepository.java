package App.LMS.repository.Course;

import App.LMS.model.Course.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long> {
    List<Module> findByCourseId(Long courseId);

    List<Module> findByTitleContainingIgnoreCase(String title);

    List<Module> findByCourseIdOrderByModuleOrderAsc(Long courseId);
}