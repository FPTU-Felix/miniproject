package com.miniproject.miniproject.service;

import com.miniproject.miniproject.dto.Request.ChapterRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.ChapterResponse;

import java.util.List;

public interface ChapterService {
    List<ChapterResponse> getAllChapter();

    ChapterResponse getChapterById(String chapterId);

    ChapterResponse addChapter(ChapterRequest request, String userId, String previousChapterId);

    ChapterResponse updateChapter(ChapterRequest request, String chapterId);

    void deleteChapter(String chapterId, String currentUserId);
}
