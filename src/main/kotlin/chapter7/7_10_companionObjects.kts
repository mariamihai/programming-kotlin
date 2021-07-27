package chapter7

class MachineOperator(val name: String) {
    fun checkin() = checkedIn++
    fun checkout() = checkedIn--

    // Named: companion object MachineOperatorFactory {
    // Used with: val ref = MachineOperator.MachineOperatorFactory
    companion object {
        var checkedIn = 0
        fun minimumBreak() = "15 minutes every 2 hours"
    }
}

MachineOperator("Mater").checkin()
println(MachineOperator.minimumBreak()) // 15 minutes every 2 hours
println(MachineOperator.checkedIn) // 1


// Accessing the Companion
val ref = MachineOperator.Companion


// The companion object can serve as a factory to create instances of
// the class they are part of.