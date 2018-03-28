package app.model.dsl

import lib.bootstrap.createTable
import org.jetbrains.exposed.dao.IntIdTable
import org.joda.time.DateTime

object Tasks: IntIdTable(name = "tasks") {
    init {
        createTable()
    }
    val name = varchar("name", 255)
    val done = bool("done").default(false)
    val createdAt = datetime("created_at").default(DateTime.now())
}