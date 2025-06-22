
package com.movie.sufi.repository;

import com.movie.sufi.model.Content;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Long> {
	List<Content> findByFeaturedTrue();
    List<Content> findByTitleContainingIgnoreCase(String title);
    List<Content> findByGenresIgnoreCase(String genres);
    List<Content> findByReleaseYearGreaterThan(int year);
    List<Content> findAllByOrderByRatingsDesc();
    List<Content> findAllByOrderByReleaseYearDesc();

    @Query("SELECT c FROM Content c WHERE TYPE(c) = :clazz")
    List<Content> findByType(@Param("clazz") Class<? extends Content> clazz);

    @Query("SELECT c FROM Content c WHERE TYPE(c) = :clazz ORDER BY c.ratings DESC")
    List<Content> findTop10ByClassOrderByRatingsDesc(@Param("clazz") Class<? extends Content> clazz, Pageable pageable);

    @Query("SELECT c FROM Content c WHERE TYPE(c) = :clazz ORDER BY c.createdAt DESC")
    List<Content> findTop10ByClassOrderByCreatedAtDesc(@Param("clazz") Class<? extends Content> clazz, Pageable pageable);
}
