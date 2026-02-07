package kompote.data.serializer

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.Duration

object DurationSerializer: KSerializer<Duration> {
    override val descriptor =
        PrimitiveSerialDescriptor("Duration", PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: Duration) {
        encoder.encodeInt(value.toMinutes().toInt())
    }

    override fun deserialize(decoder: Decoder): Duration {
        return Duration.ofMinutes(decoder.decodeInt().toLong())
    }
}