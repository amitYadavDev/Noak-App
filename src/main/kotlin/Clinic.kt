import java.util.*

class Clinic(private val doctors: List<Doctor>) {

    private val doctorsAvailability = PriorityQueue<DoctorAvailability>(compareBy { it.availableAt })

    init {
        for (doctor in doctors) {
            doctorsAvailability.add(DoctorAvailability(availableAt = 0, averageConsultationTime = doctor.averageConsultationTime))
        }
    }


    fun calculateWaitingTime(patientPosition: Int): Int {

        var totalWaitingTime = 0

        val doctorAvailableAt = doctorsAvailability.poll()
        totalWaitingTime = doctorAvailableAt.availableAt
        doctorsAvailability.add(doctorAvailableAt.copy(availableAt = doctorAvailableAt.availableAt + doctorAvailableAt.averageConsultationTime))

        return totalWaitingTime

    }

}