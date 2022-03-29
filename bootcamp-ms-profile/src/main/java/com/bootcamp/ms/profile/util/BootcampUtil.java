package com.bootcamp.ms.profile.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public final class BootcampUtil {

    public static LocalDateTime parseDateTime(Long millis) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.systemDefault());
    }

    public static String addLeftWildcart(String s) {
        return "%" + s;
    }

    public static String addRightWildcart(String s) {
        return s + "%";
    }

    public static String addWildcard(String s) {
        return addLeftWildcart(addRightWildcart(s));
    }
}
