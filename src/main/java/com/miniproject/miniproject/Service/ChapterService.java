package com.miniproject.miniproject.Service;

import com.miniproject.miniproject.DTO.Response.ApiResponse;
import com.miniproject.miniproject.DTO.Response.ChapterResponse;

import java.util.List;

public interface ChapterService {
    ApiResponse<List<ChapterResponse>> getAllChapter();
}
