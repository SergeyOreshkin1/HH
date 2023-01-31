package com.lesson01.task03

import java.util.regex.Pattern

enum class TextPattern(val pattern: Pattern) {
    LINK(Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")),
    EMAIL(
        Pattern.compile(
            "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]{2,}"
        )
    ),
    PHONE_RU(Pattern.compile("^(\\+7|7|8)?[\\s\\-]?\\(?[489][0-9]{2}\\)?[\\s\\-]?[0-9]{3}[\\s\\-]?[0-9]{2}[\\s\\-]?[0-9]{2}\$")),
    MAP_COORDINATES(Pattern.compile("^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?)\\s*[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)\$"))
}