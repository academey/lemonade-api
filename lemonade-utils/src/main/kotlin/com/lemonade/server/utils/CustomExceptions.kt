package com.lemonade.server.utils

object CustomExceptions {
    class EmailSignInFailedException(msg: String? = null) : RuntimeException()

    class PasswordFailedExceededException(msg: String? = null) : RuntimeException()

    class NotFoundException(msg: String? = null) : RuntimeException(msg)

    class AlreadyExistException(msg: String? = null) : RuntimeException(msg)

    class ApiException(msg: String? = null) : RuntimeException(msg)

    class UnAuthorized(msg: String? = null) : RuntimeException(msg)
}
