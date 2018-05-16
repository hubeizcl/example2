class ChecksumAccumulator {
  private var sum = 0

  def add(b: Byte) {
    sum = sum + b
  }

  def checksum(): Int = -(sum & 0xFF) + 1
}
