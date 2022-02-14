package io.pivotal.literx;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;

/**
 * Learn how to create Mono instances.
 *
 * @author Sebastien Deleuze
 * @see <a href="https://projectreactor.io/docs/core/release/api/reactor/core/publisher/Mono.html">Mono Javadoc</a>
 */
class Part02MonoTest {

    Part02Mono workshop = new Part02Mono();

    //========================================================================================
    @Test
    void empty() {
        Mono<String> mono = workshop.emptyMono();
        StepVerifier.create(mono)
                .verifyComplete();
    }

    //========================================================================================
    @Test
    void noSignal() {
        StepVerifier
                .create(workshop.monoWithNoSignal())
                .expectSubscription()
                .expectTimeout(Duration.ofSeconds(1))
                .verify();
    }

    //========================================================================================
    @Test
    void fromValue() {
        StepVerifier.create(workshop.fooMono())
                .expectNext("foo")
                .verifyComplete();
    }

    //========================================================================================
    @Test
    void error() {
        StepVerifier.create(workshop.errorMono())
                .verifyError(IllegalStateException.class);
    }
}
