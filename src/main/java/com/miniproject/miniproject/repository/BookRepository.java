package com.miniproject.miniproject.repository;

import com.miniproject.miniproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
//    @Query("""
//                SELECT b FROM Book b
//                WHERE (:title IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%')))
//                  AND (:author IS NULL OR LOWER(b.author) LIKE LOWER(CONCAT('%', :author, '%')))
//                  AND (:publisher IS NULL OR LOWER(b.publisher) LIKE LOWER(CONCAT('%', :publisher, '%')))
//                  AND (:language IS NULL OR LOWER(b.language) LIKE LOWER(CONCAT('%', :language, '%')))
//                  AND (:minPage IS NULL OR b.pageCount >= :minPage)
//                  AND (:maxPage IS NULL OR b.pageCount <= :maxPage)
//            """)
//    Page<Book> searchBooks(
//            @Param("title") String title,
//            @Param("author") String author,
//            @Param("publisher") String publisher,
//            @Param("language") String language,
//            @Param("minPage") Integer minPage,
//            @Param("maxPage") Integer maxPage,
//            Pageable pageable
//    );

}
