package hello.advanced.app.v2;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository // Component 스캔 대상
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void save(TraceId traceId, String itemId) {
        //저장 로직
        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId, "OrderRepositoryV1.save()");

            if(itemId.equals("ex")) {
                throw new IllegalStateException("exception");
            }
            sleep(1000);
            trace.end(status);
        } catch (Exception e) { // special exception throw
            trace.exception(status, e);
            throw e; // exception throw
        }


    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
