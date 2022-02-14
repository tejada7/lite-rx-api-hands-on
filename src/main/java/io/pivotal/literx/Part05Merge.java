package io.pivotal.literx;

import io.pivotal.literx.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Learn how to merge flux.
 *
 * @author Sebastien Deleuze
 */
public class Part05Merge {

    //========================================================================================
    Flux<User> mergeFluxWithInterleave(Flux<User> flux1, Flux<User> flux2) {
        return flux1.mergeWith(flux2);
    }

    //========================================================================================
    Flux<User> mergeFluxWithNoInterleave(Flux<User> flux1, Flux<User> flux2) {
        return flux1.concatWith(flux2);
    }

    //========================================================================================
    Flux<User> createFluxFromMultipleMono(Mono<User> mono1, Mono<User> mono2) {
//		return Flux.from(mono1).concatWith(mono2);
        return Flux.concat(mono1, mono2);
    }

}
