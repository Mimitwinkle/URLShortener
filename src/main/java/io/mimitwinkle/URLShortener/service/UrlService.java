package io.mimitwinkle.URLShortener.service;

import io.mimitwinkle.URLShortener.model.Url;
import io.mimitwinkle.URLShortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static io.mimitwinkle.URLShortener.logic.GenerateShortUrl.getShortUrl;
import static io.mimitwinkle.URLShortener.logic.GenerateShortUrl.isUrlValid;

@Service
public class UrlService {
    @Autowired
    private UrlRepository urlRepository;
    public String getOriginalUrl(String id) {
        return urlRepository.findByShortUrl(id);
    }

    public Url generateShortUrl(String url) {
        if(!isUrlValid(url)) {
            System.out.println("URL is not valid");
            return null;
        }
        Url urlObject = new Url();
        urlObject.setOriginalUrl(url);
        urlObject.setShortUrl(getShortUrl(url));
        return urlRepository.save(urlObject);
    }
}
