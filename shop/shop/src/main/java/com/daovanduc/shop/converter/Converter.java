package com.daovanduc.shop.converter;

import org.springframework.core.convert.ConversionException;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.*;

public interface Converter<SOURCE, TARGET> extends org.springframework.core.convert.converter.Converter<SOURCE,TARGET> {
    TARGET convert(SOURCE var1);

    SOURCE convertDataToModel(TARGET var3) throws IOException;

    TARGET convert(SOURCE var1, TARGET var2) throws ConversionException;

    default List<TARGET> convertAll(Collection<? extends SOURCE> sources) throws ConversionException {
        if (CollectionUtils.isEmpty(sources)) {
            return Collections.emptyList();
        } else {
            List<TARGET> result = new ArrayList(sources.size());
            Iterator var4 = sources.iterator();

            while(var4.hasNext()) {
                SOURCE source = (SOURCE) var4.next();
                result.add((TARGET) this.convert(source));
            }

            return result;
        }
    }
}
