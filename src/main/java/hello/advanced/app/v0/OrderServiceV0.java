package hello.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // Component annotation이 있으므로 자동 스캔 대상
@RequiredArgsConstructor //생성자 생성
public class OrderServiceV0 {
    private final OrderRepositoryV0 orderRepository;

    public void orderItem(String itemId){
        orderRepository.save(itemId);
    }
}
