package org.example.challenge.faas

import org.example.challenge.faas.dsl.execution
import org.example.challenge.faas.dsl.step
import org.example.challenge.faas.dsl.workflow

fun main() {
    workflow.deploy()
    workflow.deploy(date = "Tue 17 Jan 23:59:00.00")
}

val workflow = workflow {
    zone("eu-west")
    provider("GCP")
    name("myFirstWorkflow")
    description("My first Workflow")
    steps(
        step {
            name("increment1")
            description("Increment the input number by one")
            context(
                execution {
                    method("GET")
                    url("https://us-central1-function-test-366510.cloudfunctions.net/function-1")
                    query("increment" to "::input.number::")
                    header("Content-Type" to "application/json")
                    result("increment1")
                }
            )
        },
        step {
            name("increment2")
            description("Increment the input number by one, second time")
            context(
                execution {
                    method("GET")
                    url("https://us-central1-function-test-366510.cloudfunctions.net/function-1")
                    query("increment" to "::increment1.body::")
                    header("Content-Type" to "application/json")
                    result("increment2")
                }
            )
        },
        step {
            name("increment3")
            description("Increment the input number by one, third time")
            context(
                execution {
                    method("GET")
                    url("https://us-central1-function-test-366510.cloudfunctions.net/function-1")
                    query("increment" to "::increment2.body::")
                    header("Content-Type" to "application/json")
                    result("increment3")
                }
            )
        }
    )
    result("increment3")
}