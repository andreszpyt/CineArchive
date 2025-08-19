package com.cinearchive.service;

import com.cinearchive.entity.Streaming;
import com.cinearchive.repository.StreamingRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StreamingService {
    private final StreamingRespository streamingRespository;

    public List<Streaming> findAll() {
        return streamingRespository.findAll();
    }

    public Optional<Streaming> findById(Long id) {
        return streamingRespository.findById(id);
    }

    public Streaming save(Streaming streaming) {
        return streamingRespository.save(streaming);
    }

    public void deleteById(Long id) {
        streamingRespository.deleteById(id);
    }

    public Streaming update(Streaming streaming, Long id) {
        streaming.setId(id);
        return streamingRespository.save(streaming);
    }
}