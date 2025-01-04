import java.util.*

class Clinic(private val doctors: List<Doctor>) {

    private val doctorsAvailability = PriorityQueue<DoctorAvailability>(compareBy { it.availableAt })


    /*factors that can affect the consultation time.*/

    private var otherDelayFactors = 0

    init {
        for (doctor in doctors) {
            doctorsAvailability.add(DoctorAvailability(availableAt = 0, averageConsultationTime = doctor.averageConsultationTime))
        }
    }


    fun calculateWaitingTime(patientPosition: Int): Int {
        /*factors that can affect the consultation time.*/

        var emergencies = 0
        var additionalTreatments = 0

        if(patientPosition == 11) {
            additionalTreatments += 2
        }

        val otherFactorsDelay = emergencies + additionalTreatments + otherDelayFactors

        val doctorAvailableAt = doctorsAvailability.poll()
        var totalWaitingTime = doctorAvailableAt.availableAt
        doctorsAvailability.add(doctorAvailableAt.copy(availableAt = doctorAvailableAt.availableAt + doctorAvailableAt.averageConsultationTime + otherFactorsDelay))

        return totalWaitingTime

    }

}