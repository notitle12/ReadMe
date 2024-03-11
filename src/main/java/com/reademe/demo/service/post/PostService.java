package com.reademe.demo.service.post;

import com.reademe.demo.dto.requestdto.post.PostRequestDto;
import com.reademe.demo.dto.responsedto.post.PostResponseDto;
import com.reademe.demo.entity.book.Book;
import com.reademe.demo.entity.post.Post;
import com.reademe.demo.entity.users.Users;
import com.reademe.demo.repository.book.BookRepository;
import com.reademe.demo.repository.post.PostRepository;
import com.reademe.demo.repository.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    BookRepository bookRepository;

    //post 생성
    public PostResponseDto create(PostRequestDto dto) {
        Users users = usersRepository.findById(dto.getUsers_id()).orElseThrow(()-> new IllegalArgumentException("회원이 존재하지 않습니다."));
        Book book = bookRepository.findById(dto.getBook_id()).orElseThrow(()-> new IllegalArgumentException("책이 존재하지 않습니다."));
        Post post = postRepository.save(Post.createPost(users, book, dto.getTitle(), dto.getContent(), dto.getStars()));
        return new PostResponseDto(post);
    }

    public List<PostResponseDto> findAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(p->new PostResponseDto(p))
                .collect(Collectors.toList());
    }

    public PostResponseDto findOne(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다."));
        return new PostResponseDto(post);
    }

    public PostResponseDto update(Long id, PostRequestDto dto) {
        Post target = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다."));

        Users users = usersRepository.findById(dto.getUsers_id()).orElseThrow(()-> new IllegalArgumentException("회원이 존재하지 않습니다."));
        Book book = bookRepository.findById(dto.getBook_id()).orElseThrow(()-> new IllegalArgumentException("책이 존재하지 않습니다."));
        Post post = Post.createPost(users, book, dto.getTitle(), dto.getContent(), dto.getStars());

        target.patch(post);

        Post updatedPost = postRepository.save(target);
        return new PostResponseDto(updatedPost);
    }

    public PostResponseDto delete(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("회원이 존재하지 않습니다."));
        postRepository.delete(post);
        return new PostResponseDto(post);
    }
}
