package demo.orderservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;

import java.time.Duration;

@Configuration
public class RSocketConfig {

  @Bean
  RSocketRequester rSocketRequester(RSocketStrategies strategies) {
    strategies = RSocketStrategies.builder()
        .encoders(encoders -> encoders.add(new Jackson2JsonEncoder()))
        .decoders(decoders -> decoders.add(new Jackson2JsonDecoder()))
        .build();

    return RSocketRequester.builder()
        .rsocketStrategies(strategies)
        .rsocketConnector(connector -> connector.keepAlive(Duration.ofSeconds(100),Duration.ofSeconds(5000)))
//        .tcp("localhost",7000);
        .connectTcp("localhost",7000)
        .retry()
        .cache()
        .block();
  }

}
