package io.mimitwinkle.URLShortener.service;

import io.mimitwinkle.URLShortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UrlService {
    @Autowired
    private UrlRepository urlRepository;
    public String getOriginalUrl(String id) {
        return urlRepository.findByShortUrl(id);
    }

    public String generateShortUrl() {
        return "";
    }
}
