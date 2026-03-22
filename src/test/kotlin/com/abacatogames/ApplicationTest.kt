package com.abacatogames

import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.testApplication
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {

    @Test
    fun `hello endpoint test`() = testApplication {
        configure("application-test.conf")
        application {
            module(
                validator = { false },
                wordGenerator = { "" },
                webView = { "" }
            )
        }
        val response = client.get("/hello")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("Hello, Wordo!", response.bodyAsText())
    }
}