package com.online.course.web.Onlinecourse.Repository;

import com.online.course.web.Onlinecourse.Entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video,Long>, JpaSpecificationExecutor<Video> {
    Video findByTitle(String title);
}
