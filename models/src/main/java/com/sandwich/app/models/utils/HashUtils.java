package com.sandwich.app.models.utils;

import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@UtilityClass
public class HashUtils {

    private static final Set<Class> CLASSES = Set.of(UUID.class, BigDecimal.class);

    public static String calculateChecksum(Object obj) {
        return calculateChecksum(obj, Set.of());
    }

    public static String calculateChecksum(Object obj, Collection<String> excludeFields) {
        try {
            excludeFields = excludeFields == null ? Set.of() : excludeFields;
            var digest = MessageDigest.getInstance("SHA-256");
            var fields = getAllFields(obj.getClass());
            fields.sort(Comparator.comparing(Field::getName));

            for (var field : fields) {
                if (excludeFields.contains(field.getName())) {
                    continue;
                }

                field.setAccessible(true);
                var value = field.get(obj);

                if (value instanceof Iterable collection) {
                    for (var item : collection) {
                        if (item.getClass().isPrimitive() || CLASSES.contains(item.getClass())) {
                            digest.update(item.toString().getBytes());
                        } else {
                            digest.update(calculateChecksum(item, excludeFields).getBytes());
                        }
                    }
                } else if (value != null) {
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
