package com.miniproject.miniproject.service.implement;

import com.miniproject.miniproject.dto.Request.ChapterRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.ChapterResponse;
import com.miniproject.miniproject.model.Chapter;
import com.miniproject.miniproject.repository.ChapterRepository;
import com.miniproject.miniproject.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ChapterServiceImpl implements ChapterService {
    @Autowired
    private ChapterRepository chapterRepository;

    @Override
    public ApiResponse<List<ChapterResponse>> getAllChapter(){
        List<ChapterResponse> chapterResponses = chapterRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
        return new ApiResponse<>(String.valueOf(HttpStatus.OK), chapterResponses, null);
    }

    @Override
    public List<ChapterResponse> addNewChapter() {
        return List.of();
    }

    @Override
    public List<ChapterResponse> updateChapter() {
        return List.of();
    }

    @Override
    public void deleteChapter() {

    }


    private ChapterResponse mapToResponse(Chapter chapter) {
        ChapterResponse b = new ChapterResponse();
        b.setCreated_at(chapter.getCreatedAt());
        b.setChapter_name(chapter.getChapter_name());
        b.setNext_chapter(chapter.getNext_chapter());
        b.setPublish_at(chapter.getPublish_at());
        b.setType(chapter.getType());
        b.setUpdated_at(chapter.getUpdatedAt());
        return b;
    }

    //maping entity
    private Chapter mapToEntity(ChapterRequest request) {
        Chapter b = new Chapter();
        b.setChapter_name(request.getChapter_name());
        b.setPublish_at(request.getPublish_at());
        b.setType(request.getType());
        b.setNext_chapter(request.getNext_chapter());
        return b;
    }
}
