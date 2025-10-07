package com.sandwich.app.models.utils;

import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@UtilityClass
public class HashUtils {

    public static String calculateChecksum(Object obj) {
        try {
            var digest = MessageDigest.getInstance("SHA-256");
            var fields = getAllFields(obj.getClass());
            fields.sort(Comparator.comparing(Field::getName));

            for (var field : fields) {
                field.setAccessible(true);
                var value = field.get(obj);

                if (value != null) {
                    digest.update(value.toString().getBytes());
                }
            }

            return bytesToHex(digest.digest());
        } catch (Exception e) {
            throw new RuntimeException("Error calculating checksum", e);
        }
    }

    private static List<Field> getAllFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();

        while (clazz != null) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }

        return fields;
    }

    private static String bytesToHex(byte[] hash) {
        var hexString = new StringBuilder();

        for (byte b : hash) {
            var hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }
}
