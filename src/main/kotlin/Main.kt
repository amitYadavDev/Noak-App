

fun main(args: Array<String>) {
    val doctors = listOf(
        Doctor("Doctor A", 3), // Average consultation time: 3 minutes
        Doctor("Doctor B", 4),
        Doctor("Doctor C", 5)
    )

    val clinic = Clinic(doctors)

    for(patientPosition in 1 .. 20) {
        var estimatedWaitingTime = clinic.calculateWaitingTime(patientPosition)
        println("Estimated Waiting Time for Patient at position $patientPosition: $estimatedWaitingTime minutes")
    }

}