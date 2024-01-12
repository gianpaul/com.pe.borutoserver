package com.pe.routes

import com.pe.models.ApiResponse
import com.pe.repository.HeroRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.getAllHeroes() {
    val heroRepository: HeroRepository by inject()

    get("/boruto/heroes") {
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            require(page in 1..5) { "Heroes not Found." }

            val apiResponse = heroRepository.getAllHeroes(page = page)
            call.respond(
                message = apiResponse,
                status = HttpStatusCode.OK
            )
        } catch (e: NumberFormatException) {
            call.respond(
                message = ApiResponse(
                    success = false,
                    message = "Only numbers are allowed for page parameter",
                ),
                status = HttpStatusCode.BadRequest
            )
        } catch (e: IllegalArgumentException){
            call.respond(
                message = ApiResponse(
                    success = false,
                    message = e.message,
                ),
                status = HttpStatusCode.BadRequest
            )
        }
    }
}