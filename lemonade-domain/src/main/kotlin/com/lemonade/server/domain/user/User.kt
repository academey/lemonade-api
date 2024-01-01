package com.lemonade.server.domain.user

import com.lemonade.server.domain.BaseTimeEntity
import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
@Table(name = "lemon_user")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,
    @Column(unique = true)
    var email: String,
    @Column(length = 100, nullable = false)
    var name: String,
    var picture: String? = null,
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var role: Role,
    @Embedded
    var password: Password,
) : com.lemonade.server.domain.BaseTimeEntity(), UserDetails {
    fun update(
        name: String?,
        picture: String?,
    ): User {
        if (name != null) this.name = name
        if (picture != null) this.picture = picture
        return this
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        val auth = ArrayList<GrantedAuthority>()
        auth.add(SimpleGrantedAuthority(role.name))

        return auth
    }

    override fun getPassword(): String = password.value

    override fun getUsername(): String = email

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true
}
