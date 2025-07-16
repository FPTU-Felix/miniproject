package com.miniproject.miniproject.controller;

import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.ChapterResponse;
import com.miniproject.miniproject.service.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/library/library/chapter")
@RequiredArgsConstructor
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @GetMapping
    public ApiResponse<List<ChapterResponse>> getAllChapter(){
        return chapterService.getAllChapter();
    }
}
