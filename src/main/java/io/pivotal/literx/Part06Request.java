package io.pivotal.literx;

import io.pivotal.literx.domain.User;
import io.pivotal.literx.repository.ReactiveRepository;
import io.pivotal.literx.repository.ReactiveUserRepository;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static java.lang.System.out;

/**
 * Learn how to control the demand.
 *
 * @author Sebastien Deleuze
 */
public class Part06Request {

    ReactiveRepository<User> repository = new ReactiveUserRepository();

    //========================================================================================
    StepVerifier requestAllExpectFour(Flux<User> flux) {
        return StepVerifier.create(flux)
                .expectNextCount(4)
                .expectComplete();
    }

    //========================================================================================
    StepVerifier requestOneExpectSkylerThenRequestOneExpectJesse(Flux<User> flux) {
        return StepVerifier.create(flux)
                .expectNext(User.SKYLER)
                .expectNext(User.JESSE)
                .thenCancel();
    }

    //========================================================================================
    Flux<User> fluxWithLog() {
        return repository.findAll()
                .log();
    }

    //========================================================================================
    Flux<User> fluxWithDoOnPrintln() {
        return repository.findAll()
                .doOnSubscribe(subscription -> out.println("Starring:"))
                .doOnNext(user -> out.println(user.getFirstname() + " " + user.getLastname()))
                .doOnComplete(() -> out.println("The end!"));
    }

}
