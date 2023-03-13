package com.lesson04.utils

import java.util.regex.Pattern

enum class TextPattern(val pattern: Pattern) {
    PLACE_NAME(Pattern.compile("[a-zA-Zа-яёА-ЯЁ\\-.,\\s]*")),
    MAP_COORDINATES(Pattern.compile("^[-+]?([1-8]?\\d(\\.\\d+)?|90(\\.0+)?)\\s*[-+]?(180(\\.0+)?|((1[0-7]\\d)|([1-9]?\\d))(\\.\\d+)?)\$"))
}
