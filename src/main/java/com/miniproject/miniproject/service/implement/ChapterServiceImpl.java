package com.miniproject.miniproject.service.implement;

import com.miniproject.miniproject.dto.Request.ChapterRequest;
import com.miniproject.miniproject.dto.Response.ApiResponse;
import com.miniproject.miniproject.dto.Response.ChapterResponse;
import com.miniproject.miniproject.exception.AccessDeniedException;
import com.miniproject.miniproject.exception.ResourceNotFoundException;
import com.miniproject.miniproject.model.Chapter;
import com.miniproject.miniproject.model.Publisher;
import com.miniproject.miniproject.repository.*;
import com.miniproject.miniproject.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChapterServiceImpl implements ChapterService {
    private final PublisherRepository publisherRepository;
    private final ChapterRepository chapterRepository;

    @Autowired
    public ChapterServiceImpl(ChapterRepository chapterRepository, PublisherRepository publisherRepository) {
        this.chapterRepository = chapterRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<ChapterResponse> getAllChapter() {
        return chapterRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ChapterResponse getChapterById(String chapterId) {
        Chapter chapter = chapterRepository.findById(chapterId).orElseThrow(() -> new ResourceNotFoundException("Can't found Chapter with id =" + chapterId));
        return mapToResponse(chapter);
    }

    @Override
    public ChapterResponse addChapter(ChapterRequest request, String userId, String previousChapterId) {
        Publisher publisher = (Publisher)publisherRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Can't found Publisher"));
        Chapter chapter = mapToEntity(request);
        chapter.setPrevious_chapter(previousChapterId);
        Chapter saved = chapterRepository.save(chapter);
        return mapToResponse(saved);
    }

    @Override
    public ChapterResponse updateChapter(ChapterRequest request, String chapterId) {
        if(chapterRepository.existsById(chapterId)){
            Chapter c = mapToEntity(request);
            Chapter updated = chapterRepository.save(c);
            return mapToResponse(updated);
        }else throw new ResourceNotFoundException("Chapter not found");
    }

    @Override
    public void deleteChapter(String chapterId, String currentUserId) {
        Chapter c = chapterRepository.findById(chapterId).orElseThrow(() -> new ResourceNotFoundException("Chapter not found!"));
        if(!c.getBook().getPublisher().getId().equals(currentUserId)){
            throw new AccessDeniedException("You don't have permission to delete this Chapter");
        }
        chapterRepository.deleteById(chapterId);
    }

    private ChapterResponse mapToResponse(Chapter chapter) {
        ChapterResponse b = new ChapterResponse();
        b.setCreated_at(chapter.getCreatedAt());
        b.setChapter_name(chapter.getChapter_name());
        b.setNext_chapter(chapter.getPrevious_chapter());
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
        return b;
    }
}
