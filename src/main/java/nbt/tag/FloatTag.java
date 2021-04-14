package nbt.tag;

import util.ByteArrayBuilder;

/**
 * A tag is designed to hold a single float and a name that may be associated with it. The float value follows the
 * single-precision floating-point representation and the FloatTag class follows the specification defined by the NBT
 * format.
 * @author Killerkoen
 */
public class FloatTag extends Tag<Float> {
    /**
     * The name of the tag.
     */
    private String name;

    /**
     * A single float that defines the payload of this tag.
     */
    private float payload;

    /**
     * The ID of this tag.
     */
    private final byte tagID = 5;

    /**
     * Constructs an unnamed instance of a FloatTag object from the given payload.
     * @param payload a single float that defines the payload of this tag
     */
    public FloatTag(float payload) {
        this.name = "";
        this.payload = payload;
    }

    /**
     * Constructs a named instance of a FloatTag object from the given name and payload.
     * @param name the name of this tag
     * @param payload a single float that defines the payload of this tag
     */
    public FloatTag(String name, float payload) {
        this.name = name;
        this.payload = payload;
    }

    /**
     * Get the ID of this tag.
     * @return A byte with it's value as an id that is used to identify the type of this tag.
     */
    @Override
    public byte getTagID() {
        return this.tagID;
    }

    /**
     * Get the name of this tag.
     * @return A string with this tag's name as it's value
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Get the payload of this tag.
     * @return A single float
     */
    @Override
    public Float getPayload() {
        return this.payload;
    }

    /**
     * Generates an array of bytes corresponding to the specification laid out in the NBT format.
     * @return An array of bytes corresponding to the specification laid out in the NBT format
     */
    @Override
    public byte[] toByteArray() {
        ByteArrayBuilder byteArrayBuilder = new ByteArrayBuilder();
        byteArrayBuilder.appendTagHeader(this);
        byteArrayBuilder.append(this.payload);
        return byteArrayBuilder.getByteArray();
    }

    /**
     * Compares this instance of a FloatTag object to that of another to see if contain equal values.
     * @param other the other instance of a FloatTag object to compare to
     * @return {@code true} if this tag equals the specified parameter tag; {@code false} if otherwise
     */
    @Override
    public boolean equals(Tag other) {
        if (!(other instanceof FloatTag)) {
            return false;
        }

        return (this.name.equals(other.getName()) && this.payload == ((FloatTag) other).getPayload());
    }

    /**
     * Returns a string representation of this FloatTag object.
     * @return A string representation of this FloatTag object.
     */
    public String toString() {
        return "TAG_Double('" + this.name + "'): " + this.payload + "\n";
    }
}
