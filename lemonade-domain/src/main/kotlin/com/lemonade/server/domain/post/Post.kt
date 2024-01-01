package com.lemonade.server.domain.post

import com.lemonade.server.domain.BaseTimeEntity
import com.lemonade.server.domain.user.User
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "post")
class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
        name = "user_id",
        nullable = false,
        foreignKey =
            ForeignKey(
                name = "fk_user_alert_means_user",
            ),
    )
    var user: User,
    @Column
    var title: String,
    @Column
    var content: String,
) : BaseTimeEntity()
