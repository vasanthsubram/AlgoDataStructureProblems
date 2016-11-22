package utils;

public class Stopwatch { 

    private final long start;
    Runtime rt ;
    private final long startMem;
    
    public Stopwatch() {
        start = System.nanoTime();
        rt= Runtime.getRuntime();
        startMem = rt.freeMemory();
        
    } 

    public double elapsedTime() {
    	long now = System.nanoTime();
    	return (now-start);
    }
    
 
    
    // return time (in millseconds) since this object was created
    @Deprecated
    public double elapsedTimeAndSpace() {
        long now = System.nanoTime();
        long endMem = rt.freeMemory();
        System.out.println("Elapsed time in nanoseconds = " + (now - start) );
        System.out.println("Memory used in Bytes= " + (startMem - endMem));
        return (now - start);
    } 
   
 }
