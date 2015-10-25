package data

import java.security.MessageDigest
/**
 * Provides a hash function for calculating the hash value out of {@link Key} or
 * {@link URL} objects.
 */

object HashFunction {
  
  val messageDigest:MessageDigest = MessageDigest.getInstance("SHA-1")
    
  /**
   * Returns the length of IDs generated by this hash function.
   * @return Number of bytes of generated IDs.
   */
   def getLengthOfIDsInBytes():Int = {
    return this.messageDigest.getDigestLength();
  }

  //Calculates the hash value for a given data Key.
  def createID( testBytes:Array[Byte]):ID = {
    this.messageDigest.synchronized{
      this.messageDigest.reset();
      this.messageDigest.update(testBytes);
      return new ID(this.messageDigest.digest());
    }   
  }

  def createID( str:String):ID = {
    val testBytes = str.getBytes
    this.messageDigest.synchronized{
      this.messageDigest.reset()
      this.messageDigest.update(testBytes)
      return new ID(this.messageDigest.digest())
    }   
  }
  
  

}