package com.online.course.web.Onlinecourse.Service.Video;

import com.online.course.web.Onlinecourse.Entity.Video;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface VideoService {
    Video createVideo( Video video);
    Video updateVideo( Long id , Video videoUpdated);
    Video getVideoById( Long id);
    void deleteVideo(Long id);
    Page<Video> pageVideo(Map<String,String> params);
}
