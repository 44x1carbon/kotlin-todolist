package routing

import app.model.dao.Task
import app.model.dsl.Tasks
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.routing.Routing

fun Routing.api() {
    @Location("/task") data class IndexTask(val done: Boolean? = null)
    get<IndexTask> {
        val tasks = when(it.done) {
          null -> Task.all()
          else -> Task.find { Tasks.done eq it.done }
        }
        tasks.first().id.value
    }
}