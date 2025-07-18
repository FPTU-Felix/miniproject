package com.miniproject.miniproject.service;

import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.ChapterResponse;

import java.util.List;

public interface ChapterService {
    ApiResponse<List<ChapterResponse>> getAllChapter();

    List<ChapterResponse> addNewChapter();

    List<ChapterResponse> updateChapter();

    void deleteChapter();
}
