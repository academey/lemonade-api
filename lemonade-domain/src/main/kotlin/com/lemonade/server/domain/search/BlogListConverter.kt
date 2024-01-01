package com.lemonade.server.domain.search

import com.lemonade.server.domain.blog.Blog
import com.lemonade.server.utils.JsonUtils
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter(autoApply = true)
class BlogListConverter : AttributeConverter<List<Blog>, String> {
    override fun convertToDatabaseColumn(attribute: List<Blog>): String = JsonUtils.nullSafeToJson(attribute)

    override fun convertToEntityAttribute(dbData: String) = JsonUtils.fromJson<List<Blog>>(dbData)
}
