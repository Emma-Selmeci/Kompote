package kompote.data.serializer

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.LocalTime

object LocalTimeSerializer: KSerializer<LocalTime> {
    override val descriptor =
        PrimitiveSerialDescriptor("LocalTime", PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: LocalTime) {
        encoder.encodeInt(value.toInt())
    }

    override fun deserialize(decoder: Decoder): LocalTime {
        return localTimeOf(decoder.decodeInt())
    }
}

fun LocalTime.toInt(): Int {
    return hour * 100 + minute
}

fun localTimeOf(i: Int): LocalTime {
    val hour = i / 100
    val minute = i - 100 * hour
    return LocalTime.of(hour, minute)
}