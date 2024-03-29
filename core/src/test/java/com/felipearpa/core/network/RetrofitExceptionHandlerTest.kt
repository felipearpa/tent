package com.felipearpa.core.network

import com.felipearpa.core.emptyString
import io.mockk.clearAllMocks
import kotlinx.coroutines.test.runTest
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Response
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class RetrofitExceptionHandlerTest {
    private val retrofitExceptionHandler = RetrofitExceptionHandler()

    @Before
    fun setUp() {
        clearAllMocks()
    }

    @Test
    fun `given a success function when is handled then a success result is returned`() =
        runTest {
            val expectedResult = "expectedResult"
            val block: suspend () -> String = { expectedResult }

            val result = retrofitExceptionHandler.handle(block)

            assertTrue(actual = result.isSuccess, message = "Result isn't success")
            assertEquals(
                expected = expectedResult,
                actual = result.getOrNull(),
                message = "Result is invalid"
            )
        }

    @Test
    fun `given a HttpException failure function when is handled then a http failure result is returned`() =
        runTest {
            val expectedHttpStatusCode = 500
            val block = `http failure function`(httpStatusCode = expectedHttpStatusCode)

            val result = retrofitExceptionHandler.handle(block)

            `assert failure is http`(
                result = result,
                expectedHttpStatusCode = expectedHttpStatusCode
            )
        }

    private fun `http failure function`(httpStatusCode: Int): suspend () -> String {
        val block: suspend () -> String = {
            throw HttpException(
                Response.error<String>(
                    httpStatusCode,
                    emptyString().toResponseBody("plain/text".toMediaType())
                )
            )
        }
        return block
    }

    private fun `assert failure is http`(result: Result<String>, expectedHttpStatusCode: Int) {
        assertTrue(result.isFailure)

        assertTrue(result.exceptionOrNull() is NetworkException.Http)

        assertEquals(
            expected = expectedHttpStatusCode,
            actual = (result.exceptionOrNull() as NetworkException.Http).httpStatusCode.value,
        )
    }

    @Test
    fun `given a UnknownHostException failure function when is handled then a remote communication failure result is returned`() =
        runTest {
            val block: suspend () -> String = { throw UnknownHostException() }

            val result = retrofitExceptionHandler.handle(block)

            `assert failure is remote communication`(result = result)
        }

    @Test
    fun `given a SocketTimeoutException failure function when is handled then a remote communication failure result is returned`() =
        runTest {
            val block: suspend () -> String = { throw SocketTimeoutException() }

            val result = retrofitExceptionHandler.handle(block)

            `assert failure is remote communication`(result = result)
        }

    private fun `assert failure is remote communication`(result: Result<String>) {
        assertTrue(actual = result.isFailure)
        assertTrue(actual = result.exceptionOrNull() is NetworkException.RemoteCommunication)
    }

    @Test
    fun `given a RuntimeException failure function when is handled then the same exception is returned`() =
        runTest {
            val block: suspend () -> String = { throw RuntimeException() }

            val result = retrofitExceptionHandler.handle(block)

            `assert failure is a runtime exception`(result = result)
        }

    private fun `assert failure is a runtime exception`(result: Result<String>) {
        assertTrue(actual = result.isFailure)
        assertTrue(actual = result.exceptionOrNull() is RuntimeException)
    }
}