package app.model.dao

import app.model.dsl.Tasks
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass


class Task(id: EntityID<Int>): IntEntity(id) {
    companion object : IntEntityClass<Task>(Tasks)

    var name by Tasks.name
    var done by Tasks.done
    var createdAt by Tasks.createdAt

    fun toDomainModel(): common.domain.Task = common.domain.Task(id.value)
}