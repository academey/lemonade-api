package com.kakao.bank.blog.search.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.OffsetDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseTimeEntity(
    @LastModifiedDate
    @Column(nullable = false)
    @JsonIgnore
    var updatedAt: OffsetDateTime = OffsetDateTime.now(),
    @CreatedDate
    @Column(nullable = false)
    @JsonIgnore
    var createdAt: OffsetDateTime = OffsetDateTime.now(),
)
