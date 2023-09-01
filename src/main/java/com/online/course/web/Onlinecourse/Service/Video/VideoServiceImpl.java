package com.online.course.web.Onlinecourse.Service.Video;

import com.online.course.web.Onlinecourse.Entity.Video;
import com.online.course.web.Onlinecourse.Execption.ResourceException;
import com.online.course.web.Onlinecourse.Repository.VideoRepository;
import com.online.course.web.Onlinecourse.Service.Specification.CourseSpec;
import com.online.course.web.Onlinecourse.Service.Specification.VideoFilter;
import com.online.course.web.Onlinecourse.Service.Specification.VideoSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Map;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService{
    @Autowired
    private VideoRepository videoRepository;

    @Override
    public Video createVideo(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public Video getVideoById(Long id) {
        return videoRepository.findById(id).orElseThrow(()-> new ResourceException("Video not found",id));
    }


    @Override
    public Video updateVideo(Long id, Video videoUpdated) {
        Video video = getVideoById(id);
        video.setCourse(videoUpdated.getCourse());
        video.setDescription(videoUpdated.getDescription());
        video.setImageLink(videoUpdated.getImageLink());
        video.setVideoLink(videoUpdated.getVideoLink());
        return videoRepository.save(video);
    }

    @Override
    public void deleteVideo(Long id) {
        videoRepository.deleteById(id);
    }

    @Override
    public Page<Video> pageVideo(Map<String, String> params) {
        VideoFilter videoFilter = new VideoFilter();
        //sorting
        if(params.containsKey("title")) {
            String title = params.get("title");
            videoFilter.setTitle(title);
        }
        if(params.containsKey("id")) {
            String id = params.get("id");
            videoFilter.setId((long) Integer.parseInt(id));
        }
        if(params.containsKey("courseId")) {
            String courseId = params.get("courseId");
            videoFilter.setCourseId((long) Integer.parseInt(courseId));
        }

        VideoSpec videoSpec = new VideoSpec(videoFilter);
        //page
        int pageNumber = 0;
        int pageSize = 2;
        if (params.containsKey("page")){
            pageNumber= Integer.parseInt(params.get("page"));
        }
        if (params.containsKey("size")){
            pageSize = Integer.parseInt(params.get("size"));
        }
        Pageable pageable = PageRequest.of(pageNumber,pageSize);

        return videoRepository.findAll(videoSpec,pageable);
    }
}
