package com.zachklipp.captivate.util;

public final class Log
{
  private static final int DEFAULT_MIN_PRIORITY = ~0;
  
  // Should be set by an accessor by a child class if this class is pulled into a library.
  private static String sDefaultTag = "captivate";
  
  private static int sMinPriority = DEFAULT_MIN_PRIORITY;
  
  public static void setDefaultTag(String tag)
  {
    sDefaultTag = tag;
  }
  
  public static void setMinPriority(int priority)
  {
    sMinPriority = priority;
  }
  public static void resetPriority()
  {
    sMinPriority = DEFAULT_MIN_PRIORITY;
  }
  
  public static int w(String msg)
  {
    return w(null, msg);
  }
  public static int w(String tag, String msg)
  {
    return println(android.util.Log.WARN, tag, msg);
  }
  
  public static int i(String msg)
  {
    return i(null, msg);
  }
  public static int i(String tag, String msg)
  {
    return println(android.util.Log.INFO, tag, msg);
  }
  
  public static int d(String msg)
  {
    return d(null, msg);
  }
  public static int d(String tag, String msg)
  {
    return println(android.util.Log.DEBUG, tag, msg);
  }
  
  public static int v(String msg)
  {
    return v(null, msg);
  }
  public static int v(String tag, String msg)
  {
    return println(android.util.Log.VERBOSE, tag, msg);
  }
  
  public static int println(int priority, String tag, String msg)
  {
    int bytesWritten = 0;
    
    if (priority >= sMinPriority)
    {
      if (tag == null)
      {
        tag = sDefaultTag;
      }
  
      bytesWritten = android.util.Log.println(priority, tag, msg);
    }
    
    return bytesWritten;
  }
}