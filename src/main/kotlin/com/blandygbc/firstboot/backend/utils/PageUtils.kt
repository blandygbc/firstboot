package com.blandygbc.firstboot.backend.utils

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import java.nio.ByteBuffer
import java.util.*

object PageUtils {
    fun fromCursor(cursor: String): Pageable {
        val decoder = Base64.getDecoder()
        val bb = ByteBuffer.wrap(decoder.decode(cursor))
        return PageRequest.of(
            bb.int,
            bb.int,
            Sort
                .by("price")
                .descending()
                .and(Sort.by("id"))
        )
    }

    fun firstPage(size: Int) =
        PageRequest.of(
            0,size,
            Sort
                .by("price")
                .descending()
                .and(Sort.by("id"))
        )

    fun createCursor(pageable: Pageable) : String {
        val bb = ByteBuffer.allocate(Int.SIZE_BYTES * 2)
        bb.putInt(pageable.pageNumber)
        bb.putInt(pageable.pageSize)
        val encoder = Base64.getEncoder()
        return encoder.encodeToString(bb.array())
    }
}