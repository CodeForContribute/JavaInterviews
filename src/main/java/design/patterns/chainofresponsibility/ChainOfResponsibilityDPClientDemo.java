package design.patterns.chainofresponsibility;


enum LogLevel{
    INFO,
    DEBUG,
    ERROR
}
abstract class LogProcessor{
    private final LogProcessor nextLogProcessor;
    public LogProcessor(LogProcessor nextLogProcessor) {
        this.nextLogProcessor = nextLogProcessor;
    }
    public void log(LogLevel logLevel,String msg){
        if (nextLogProcessor != null){
            this.nextLogProcessor.log(logLevel,msg);
        }
    }
}

class InfoLoggerProcessor extends LogProcessor{
    public InfoLoggerProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }
    @Override
    public void log(LogLevel logLevel, String msg) {
        if (logLevel == LogLevel.INFO){
            System.out.println("INFO: " + msg);
        }else{
            super.log(logLevel,msg);
        }
    }
}

class DebugLoggerProcessor extends LogProcessor{
    public DebugLoggerProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }
    @Override
    public void log(LogLevel logLevel, String msg) {
        if (logLevel == LogLevel.DEBUG){
            System.out.println("DEBUG : " + msg);
        }else{
            super.log(logLevel,msg);
        }
    }
}

class ErrorLoggerProcessor extends LogProcessor{
    public ErrorLoggerProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }
    @Override
    public void log(LogLevel logLevel, String msg) {
        if (logLevel == LogLevel.ERROR){
            System.out.println("ERROR : " + msg);
        }else{
            super.log(logLevel,msg);
        }
    }
}
public class ChainOfResponsibilityDPClientDemo {
    /*
     * Use Case
     * ATM/Vending Machine
     * Design Logger(Amazon)
     * Sender -> Request -> Rx1(if not fulfilled else send the response back)
     *                   -> Rx2(if not fulfilled) -> Rx3....
     * */
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLoggerProcessor(
                new DebugLoggerProcessor(new ErrorLoggerProcessor(null))
        );
        logProcessor.log(LogLevel.ERROR,"Oops it did not work >>>>");
        logProcessor.log(LogLevel.DEBUG,"Debug to make this work >>>>");
        logProcessor.log(LogLevel.INFO,"Wow, it Worked like a charm >>>>");
    }

}
