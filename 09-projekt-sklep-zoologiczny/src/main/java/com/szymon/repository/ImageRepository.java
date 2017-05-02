package com.szymon.repository;

import com.szymon.model.Image;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Szymon on 2017-03-16.
 */
public interface ImageRepository extends CrudRepository<Image, Long> {
}
