package com.dang.movie_test_thudo.utils;

import java.util.List;
import java.util.Random;

public class Utils {

    public static <T> T getRandomElement(List<T> list) {
        if (list == null || list.isEmpty()) return null;
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}
