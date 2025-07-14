package com.miniproject.miniproject.Service.Implement;

import com.miniproject.miniproject.DTO.Request.BookRequest;
import com.miniproject.miniproject.DTO.Request.ChapterRequest;
import com.miniproject.miniproject.DTO.Response.ApiResponse;
import com.miniproject.miniproject.DTO.Response.BookResponse;
import com.miniproject.miniproject.DTO.Response.ChapterResponse;
import com.miniproject.miniproject.Model.Book;
import com.miniproject.miniproject.Model.Chapter;
import com.miniproject.miniproject.Repository.ChapterRepository;
import com.miniproject.miniproject.Service.ChapterService;
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
        b.setCreatedAt(request.getCreated_at());
        b.setUpdatedAt(request.getUpdated_at());
        return b;
    }
}
