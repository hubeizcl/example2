object demo1 {
  var assertionEnabled = true

  def myAssert(predicate: => Boolean) =
    if (assertionEnabled && !predicate)
      throw new AssertionError()
}
