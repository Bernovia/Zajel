package com.bernovia.zajel.helpers


object StringsUtil {

    fun uppercaseFirstCharacter(string: String?): String? {
        return try {
            if (string != null) {
                val upperString = string.substring(0, 1).toUpperCase() + string.substring(1)
                upperString
            } else {
                string
            }
        } catch (e: Exception) {
            string
        }
    }


    fun validateString(string: String?): String {
        return if (string != null && string != "" && string != "null" && string != "Null") {
            string
        } else {
            ""
        }

    }
    fun getLineCount(text: String): Int {
        return text.split("[\n|\r]").toTypedArray().size
    }

    fun capitalize(str: String?): String? {
        return if (str == null || str.isEmpty()) {
            str
        } else str.substring(0, 1).toUpperCase() + str.substring(1)
    }

}