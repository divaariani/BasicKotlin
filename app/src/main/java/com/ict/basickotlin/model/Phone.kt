import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Phone(
    val name: String?,
    val specsDisplay: String?,
    val specsSize: String?,
    val specsBattery: String?,
    val seller: String?,
    val value: Int?,
    val description: String?
) : Parcelable