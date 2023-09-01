package com.online.course.web.Onlinecourse.Controller;

import com.online.course.web.Onlinecourse.Dto.CourseDTO;
import com.online.course.web.Onlinecourse.Dto.VideoDTO;
import com.online.course.web.Onlinecourse.Entity.Course;
import com.online.course.web.Onlinecourse.Entity.Video;
import com.online.course.web.Onlinecourse.Execption.ResourceException;
import com.online.course.web.Onlinecourse.Mapper.VideoMapper;
import com.online.course.web.Onlinecourse.Repository.VideoRepository;
import com.online.course.web.Onlinecourse.Service.Video.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("videos")
public class VideoServiceController {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private VideoService videoService;
    @Autowired
    private VideoMapper videoMapper;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createVideo(@RequestBody VideoDTO dto){
        Video existVideo = videoRepository.findByTitle(dto.getTitle());
        if ( existVideo == null ){
            Video video = videoMapper.toVideo(dto);
            video = videoService.createVideo(video);
            return ResponseEntity.ok(video);
        }else {
            throw new ResourceException("Already exist",existVideo.getId());
        }
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateVideo(@PathVariable("id") Long id, @RequestBody VideoDTO dto){
        Video videoUpdated= videoService.updateVideo(id,videoMapper.toVideo(dto));
        return ResponseEntity.ok(videoUpdated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteVideo(@PathVariable("id") Long id){
        videoService.deleteVideo(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "filter")
    public ResponseEntity<?> pageVideo(@RequestParam Map<String,String> params){
        Page<Video> list = videoService.pageVideo(params);
        return ResponseEntity.ok(list);
    }
}
