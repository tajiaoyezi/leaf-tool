package org.leaflei.core.tool.utils;

import lombok.experimental.UtilityClass;
import org.leaflei.core.tool.convert.LeafConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.lang.Nullable;

/**
 * @Author leaflei
 * @Date 2023/1/18 18:09
 * @Description 基于 spring ConversionService 类型转换
 */
@UtilityClass
@SuppressWarnings("unchecked")
public class ConvertUtil {

    /**
     * Convenience operation for converting a source object to the specified targetType.
     * {@link TypeDescriptor#forObject(Object)}.
     * @param source the source object
     * @param targetType the target type
     * @param <T> 泛型标记
     * @return the converted value
     * @throws IllegalArgumentException if targetType is {@code null},
     * or sourceType is {@code null} but source is not {@code null}
     */
    @Nullable
    public static <T> T convert(@Nullable Object source, Class<T> targetType) {
        if (source == null) {
            return null;
        }
        if (ClassUtil.isAssignableValue(targetType, source)) {
            return (T) source;
        }
        GenericConversionService conversionService = LeafConversionService.getInstance();
        return conversionService.convert(source, targetType);
    }

    /**
     * Convenience operation for converting a source object to the specified targetType,
     * where the target type is a descriptor that provides additional conversion context.
     * {@link TypeDescriptor#forObject(Object)}.
     * @param source the source object
     * @param sourceType the source type
     * @param targetType the target type
     * @param <T> 泛型标记
     * @return the converted value
     * @throws IllegalArgumentException if targetType is {@code null},
     * or sourceType is {@code null} but source is not {@code null}
     */
    @Nullable
    public static <T> T convert(@Nullable Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (source == null) {
            return null;
        }
        GenericConversionService conversionService = LeafConversionService.getInstance();
        return (T) conversionService.convert(source, sourceType, targetType);
    }

    /**
     * Convenience operation for converting a source object to the specified targetType,
     * where the target type is a descriptor that provides additional conversion context.
     * Simply delegates to {@link #convert(Object, TypeDescriptor, TypeDescriptor)} and
     * encapsulates the construction of the source type descriptor using
     * {@link TypeDescriptor#forObject(Object)}.
     * @param source the source object
     * @param targetType the target type
     * @param <T> 泛型标记
     * @return the converted value
     * @throws IllegalArgumentException if targetType is {@code null},
     * or sourceType is {@code null} but source is not {@code null}
     */
    @Nullable
    public static <T> T convert(@Nullable Object source, TypeDescriptor targetType) {
        if (source == null) {
            return null;
        }
        GenericConversionService conversionService = LeafConversionService.getInstance();
        return (T) conversionService.convert(source, targetType);
    }

}

