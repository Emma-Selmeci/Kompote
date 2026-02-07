package kompote.data.serializer

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.LocalDate

object LocalDateSerializer: KSerializer<LocalDate> {
    override val descriptor =
        PrimitiveSerialDescriptor("LocalDate", PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: LocalDate) =
        encoder.encodeInt(value.toInt())


    override fun deserialize(decoder: Decoder): LocalDate {
        return localDateOf(decoder.decodeInt())
    }
}

fun LocalDate.toInt(): Int {
    val year = year % 100
    val month = month.value
    val day = dayOfMonth
    return year*10000 + month*100 + day
}

fun localDateOf(i: Int): LocalDate {
    var rawInt = i
    val year = rawInt / 10000
    rawInt -= year * 10000
    val month = rawInt / 100
    val day = rawInt - month * 100
    return LocalDate.of(2000 + year, month, day)
}

