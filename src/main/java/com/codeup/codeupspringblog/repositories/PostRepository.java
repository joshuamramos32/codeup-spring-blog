package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.models.Ad;
import com.codeup.codeupspringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository <Post, Long> {
    Post findById(long id);
    @Query("from Post a where a.title like %:term%")
    List<Post> SearchByTitleLike(@Param("term")String term);
}
