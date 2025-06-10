package com.example.travelapp.utils.extension

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import kotlin.math.min

class PhoneNumberVisualTransformation(
    val countryCodePrefix: String = "", // Có thể rỗng
    val mask: String = "### ### ###"
) : VisualTransformation {

    private val maskChar = '#'

    override fun filter(text: AnnotatedString): TransformedText {
        // 1. Lấy phần chữ số từ text gốc, loại bỏ countryCodePrefix nếu có và nó khớp
        val digitsOnly = text.text.let {
            if (countryCodePrefix.isNotEmpty() && it.startsWith(countryCodePrefix)) {
                it.substring(countryCodePrefix.length)
            } else {
                it
            }
        }.filter { it.isDigit() }

        // 2. Xây dựng AnnotatedString đã định dạng
        val annotatedString = AnnotatedString.Builder().apply {
            var prefixLengthWithOptionalSpace = 0
            if (countryCodePrefix.isNotEmpty()) {
                append(countryCodePrefix)
                append(" ") // Thêm khoảng trắng CHỈ KHI có countryCodePrefix
                prefixLengthWithOptionalSpace = countryCodePrefix.length + 1
            }

            var maskIndex = 0
            var digitIndex = 0
            while (maskIndex < mask.length && digitIndex < digitsOnly.length) {
                if (mask[maskIndex] == maskChar) {
                    append(digitsOnly[digitIndex])
                    digitIndex++
                } else {
                    append(mask[maskIndex])
                }
                maskIndex++
            }
            // Nối thêm các ký tự cố định còn lại của mask nếu người dùng chưa nhập hết số
            if (digitIndex == digitsOnly.length) {
                while (maskIndex < mask.length) {
                    if (mask[maskIndex] != maskChar) {
                        append(mask[maskIndex])
                    }
                    maskIndex++
                }
            }
        }.toAnnotatedString()

        // 3. Tạo OffsetMapping
        val prefixLengthWithSpaceConsidered = if (countryCodePrefix.isNotEmpty()) countryCodePrefix.length + 1 else 0

        val phoneNumberOffsetTranslator = object : OffsetMapping {
            override fun originalToTransformed(originalOffset: Int): Int {
                var transformedOffset = prefixLengthWithSpaceConsidered
                var currentOriginalOffset = 0
                var maskIdx = 0

                while (currentOriginalOffset < originalOffset && maskIdx < mask.length) {
                    if (mask[maskIdx] == maskChar) {
                        transformedOffset++
                        currentOriginalOffset++
                    } else {
                        transformedOffset++ // Ký tự của mask
                    }
                    maskIdx++
                }
                // Nếu originalOffset vượt ra ngoài các chữ số đã được đưa vào mask,
                // thì transformedOffset chỉ cần cộng thêm phần chênh lệch đó.
                if (currentOriginalOffset < originalOffset) {
                    transformedOffset += (originalOffset - currentOriginalOffset)
                }
                return min(transformedOffset, annotatedString.length) // Đảm bảo không vượt quá độ dài chuỗi đã biến đổi
            }

            override fun transformedToOriginal(transformedOffset: Int): Int {
                var originalOffset = 0
                var currentTransformedOffset = 0

                // Bỏ qua phần prefix (nếu có)
                if (prefixLengthWithSpaceConsidered > 0) {
                    if (transformedOffset <= prefixLengthWithSpaceConsidered) {
                        return 0 // Con trỏ trong hoặc ngay sau prefix
                    }
                    currentTransformedOffset += prefixLengthWithSpaceConsidered
                } else {
                    // Không có prefix, nếu transformedOffset là 0, original cũng là 0
                    if (transformedOffset == 0) return 0
                }


                var maskIdx = 0
                while (currentTransformedOffset < transformedOffset && maskIdx < mask.length) {
                    if (mask[maskIdx] == maskChar) {
                        // Chỉ tăng originalOffset nếu ký tự mask là placeholder
                        // và chúng ta chưa vượt quá transformedOffset
                        if (currentTransformedOffset < transformedOffset) {
                            originalOffset++
                        }
                    }
                    currentTransformedOffset++
                    maskIdx++
                    // Nếu đã xử lý hết các ký tự trong mask mà transformedOffset vẫn còn
                    // (ví dụ: người dùng click vào cuối chuỗi dài hơn mask),
                    // thì originalOffset không nên tăng nữa.
                    if (maskIdx == mask.length && currentTransformedOffset < transformedOffset) {
                        // Có thể không cần làm gì ở đây, originalOffset đã là giá trị cuối cùng có thể
                        break
                    }
                }
                // Giới hạn originalOffset bằng số lượng chữ số thực tế đã nhập
                return min(originalOffset, digitsOnly.length)
            }
        }

        return TransformedText(annotatedString, phoneNumberOffsetTranslator)
    }
}