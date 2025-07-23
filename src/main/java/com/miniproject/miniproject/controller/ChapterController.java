package com.miniproject.miniproject.controller;

import com.miniproject.miniproject.dto.Request.ChapterRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.ChapterResponse;
import com.miniproject.miniproject.service.ChapterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/library/library")
@RequiredArgsConstructor
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    //    @GetMapping
//    public ApiResponse<List<ChapterResponse>> getAllChapter(){
//        return chapterService.getAllChapter();
//    }
    @GetMapping("chapter/{chapterId}")
    public ResponseEntity<ApiResponse<ChapterResponse>> getChapterById(@PathVariable String chapterId) {
        ChapterResponse chapter = chapterService.getChapterById(chapterId);
        ApiResponse<ChapterResponse> response = new ApiResponse<>(String.valueOf(HttpStatus.FOUND), chapter, null);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

    @PostMapping("/chapter/addChapter")
    public ResponseEntity<ApiResponse<ChapterResponse>> addChapter(@RequestBody @Valid ChapterRequest request, @PathVariable String previousChapterId, Authentication authentication) {
        String userId = authentication.getName();
        ChapterResponse chapterResponse = chapterService.addChapter(request, userId, previousChapterId);
        ApiResponse<ChapterResponse> response = new ApiResponse<>(String.valueOf(HttpStatus.CREATED), chapterResponse, null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/chapter/{postId}")
    public ResponseEntity<ApiResponse<ChapterResponse>> updateChapter(@RequestBody @Valid ChapterRequest request, @PathVariable String chapterId) {
        ChapterResponse chapterResponse = chapterService.updateChapter(request, chapterId);
        ApiResponse<ChapterResponse> response = new ApiResponse<>(String.valueOf(HttpStatus.OK), chapterResponse, null);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
