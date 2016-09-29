/*
 * Copyright 2016 The International Internet Preservation Consortium.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.netpreserve.resource.resolver.jaxrs;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;
import org.netpreserve.commons.cdx.SearchKeyTemplate;

/**
 *
 */
@Provider
public class UriMatchTypeParamConverterProvider implements ParamConverterProvider {

    private static final ParamConverter CONVERTER = new ParamConverter<SearchKeyTemplate.UriMatchType>() {
        @Override
        public SearchKeyTemplate.UriMatchType fromString(String value) {
            if (value == null || value.isEmpty()) {
                return SearchKeyTemplate.UriMatchType.EXACT;
            }

            return SearchKeyTemplate.UriMatchType.valueOf(value.toUpperCase());
        }

        @Override
        public String toString(SearchKeyTemplate.UriMatchType value) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    };

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if (rawType != SearchKeyTemplate.UriMatchType.class) {
            return null;
        }

        return CONVERTER;
    }

}
