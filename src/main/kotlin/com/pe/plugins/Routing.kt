package com.pe.plugins

import com.pe.routes.getAllHeroes
import com.pe.routes.root
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        root()
        getAllHeroes()

        staticResources("/images", "images")
    }
}
